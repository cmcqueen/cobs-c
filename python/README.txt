------------
Introduction
------------

This is a Python module providing Consistent Overhead Byte Stuffing (COBS)
encoding and decoding.

Functions are provided for encoding and decoding according to the basic COBS
method. The COBS variant "Zero Pair Elimination" (ZPE) is not implemented.

A pure Python implementation and a C extension implementation are provided.
If the C extension is not available for some reason, the pure Python version
will be used.

References:

    http://www.stuartcheshire.org/papers/COBSforSIGCOMM/
    http://www.stuartcheshire.org/papers/COBSforToN.pdf


------------
Installation
------------

The cobs package is installed using distutils.  If you have the tools
installed to build a Python extension module, run the following command::

    python setup.py install

NOTE: The version for Python 3.x is in the py3 directory.  The install process
is the same but you need to use the 3.x interpreter.

------------
Unit Testing
------------

Basic unit testing is in the ``testing`` subdirectory. To run it::

    python test_cobs.py

-------
License
-------

See LICENSE.txt.
