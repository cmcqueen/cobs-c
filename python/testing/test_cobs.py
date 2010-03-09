
# Which to test:
# Default
import cobs
# C extension
#import cobs._cobsext as cobs
# Pure Python
#import cobs._cobspy as cobs

test_strings = [
    "",
    "1",
    "12345",
    "12345\x006789",
    "\x0012345\x006789",
    "12345\x006789\x00",
    "\x00",
    "\x00\x00",
    bytes(bytearray(xrange(1, 254))),
    bytes(bytearray(xrange(1, 255))),
    bytes(bytearray(xrange(1, 256))),
    bytes(bytearray(xrange(0, 256))),
]

decode_error_test_strings = [
    "\x00",
    "\x05123",
]

def test():
    # Basic unit testing
    for test_string in test_strings:
        encoded = cobs.encode(str(test_string))
#        print(repr(encoded))
        if 1:
            decoded = cobs.decode(encoded)
            if decoded != test_string:
                raise Exception("Original doesn't match with decoded. Original %s, decoded %s" % (repr(test_string), repr(decoded)))

    # Test decode errors
    for test_string in decode_error_test_strings:
        try:
            cobs.decode(test_string)
        except cobs.DecodeError:
            pass
        else:
            raise Exception("Didn't raise a DecodeError exception for string %s" % repr(test_string))

    print("All tests passed")

if __name__ == "__main__":
    test()
