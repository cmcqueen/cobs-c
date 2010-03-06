
# Which to test:
# Default
#import cobs
# C extension
import cobs._cobsext as cobs
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
    str(bytearray(xrange(1, 254))),
    str(bytearray(xrange(1, 255))),
    str(bytearray(xrange(1, 256))),
    str(bytearray(xrange(0, 256))),
]

def test():
    # Basic unit testing
    for test_string in test_strings:
        encoded = cobs.encode(str(test_string))
        print(repr(encoded))
        if 1:
            decoded = cobs.decode(encoded)
            if decoded != test_string:
                raise Exception("Original doesn't match with decoded. Original %s, decoded %s" % (repr(test_string), repr(decoded)))

if __name__ == "__main__":
    test()
