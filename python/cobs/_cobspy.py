"""
Consistent Overhead Byte Stuffing
"""

def encode(in_bytes):
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

def decode(in_bytes):
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
