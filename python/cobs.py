"""
Consistent Overhead Byte Stuffing
"""

def cobs_encode(in_bytes):
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

def cobs_decode(in_bytes):
    """Decode a string that was encoded using Consistent Overhead Byte Stuffing."""
    out_bytes = bytearray()
    idx = 0

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
    "\x00",
    "\x00\x00",
    str(bytearray(xrange(1, 254))),
    str(bytearray(xrange(1, 255))),
    str(bytearray(xrange(1, 256))),
    str(bytearray(xrange(0, 256))),
]

for test_string in test_strings:
    encoded = cobs_encode(bytearray(test_string))
    print(repr(encoded))
    decoded = cobs_decode(encoded)
    if decoded != test_string:
        raise Exception("No match for %s" % repr(test_string))
