"""
Consistent Overhead Byte Stuffing
"""

def cobs_encode_1(in_bytes):
    """Encode a string using Consistent Overhead Byte Stuffing."""
    final_zero = True
    out_bytes = bytearray()
    collect_bytes = bytearray()
    for in_char in in_bytes:
        try:
            in_char = ord(in_char)
        except TypeError:
            pass
        if in_char == 0:
            final_zero = True
            out_bytes.append(len(collect_bytes) + 1)
            out_bytes += collect_bytes
            del collect_bytes[:]
        else:
            collect_bytes.append(in_char)
            if len(collect_bytes) == 0xFE:
                final_zero = False
                out_bytes.append(0xFF)
                out_bytes += collect_bytes
                del collect_bytes[:]
    if collect_bytes or final_zero:
        out_bytes.append(len(collect_bytes) + 1)
        out_bytes += collect_bytes
    return str(out_bytes)

def cobs_encode_2(in_bytes):
    """Encode a string using Consistent Overhead Byte Stuffing."""
    final_zero = True
    out_bytes = bytearray()
    collect_bytes = bytearray()
    idx = 0
    while True:
        length = in_bytes.find('\x00', idx, idx + 0xFE)
        if length < 0:
            remaining_length = len(in_bytes) - idx
            if remaining_length > 0xFE:
                length = 0xFE
            else:
                length = remaining_length
                out_bytes.append(length + 1)
                out_bytes += in_bytes[idx:idx + length]
                break
        else:
            length = length - idx
        if length == 0xFE:
            new_idx = idx + length
        else:
            new_idx = idx + length + 1
        out_bytes.append(length + 1)
        out_bytes += in_bytes[idx:idx + length]
        idx = new_idx
    return str(out_bytes)

# Choose which implementation to use
cobs_encode = cobs_encode_2


def cobs_decode(in_bytes):
    """Decode a string that was encoded using Consistent Overhead Byte Stuffing."""
    out_bytes = bytearray()
    idx = 0

    if len(in_bytes) > 0:
        while True:
            length = ord(in_bytes[idx])
            if length == 0:
                raise Exception("Zero found in input")
            idx += 1
            end = idx + length - 1
            out_bytes += in_bytes[idx:end]
            idx = end
            if idx > len(in_bytes):
                raise Exception("Not enough input bytes")
            if idx < len(in_bytes):
                if length < 0xFF:
                    out_bytes.append(0)
            else:
                break
    return str(out_bytes)


test_strings = [
    "",
    "1",
    "12345",
    "12345\x006789",
    "\x0012345\x006789",
    "12345\x006789\x00",
    "\x00",
    "\x00\x00",
    str(bytearray(xrange(1, 254))),
    str(bytearray(xrange(1, 255))),
    str(bytearray(xrange(1, 256))),
    str(bytearray(xrange(0, 256))),
]


if __name__ == "__main__":
    # Basic unit testing
    for test_string in test_strings:
        encoded = cobs_encode(bytearray(test_string))
        print(repr(encoded))
        if 1:
            decoded = cobs_decode(encoded)
            if decoded != test_string:
                raise Exception("Original doesn't match with decoded. Original %s, decoded %s" % (repr(test_string), repr(decoded)))
