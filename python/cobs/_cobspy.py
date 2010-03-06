"""
Consistent Overhead Byte Stuffing (COBS)
"""


class DecodeError(Exception):
    pass


def encode(in_bytes):
    """Encode a string using Consistent Overhead Byte Stuffing (COBS).
    
    Input is any byte string. Output is also a byte string.
    
    Encoding guarantees no zero bytes in the output. The output
    string will be expanded slightly, by a predictable amount.
    
    An empty string is encoded to '\\x01'"""
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

def decode(in_bytes):
    """Decode a string using Consistent Overhead Byte Stuffing (COBS).
    
    Input should be a byte string that has been COBS encoded. Output
    is also a byte string.
    
    A cobs.DecodeError exception may be raised if the encoded data
    is invalid."""
    out_bytes = bytearray()
    idx = 0

    if len(in_bytes) > 0:
        while True:
            length = ord(in_bytes[idx])
            if length == 0:
                raise DecodeError("Zero byte found in input")
            idx += 1
            end = idx + length - 1
            out_bytes += in_bytes[idx:end]
            idx = end
            if idx > len(in_bytes):
                raise DecodeError("Not enough input bytes for length code")
            if idx < len(in_bytes):
                if length < 0xFF:
                    out_bytes.append(0)
            else:
                break
    return str(out_bytes)
