----------------------------------------------------------------------------
Copyright (c) 2010 Craig McQueen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
----------------------------------------------------------------------------

The software in this package is a Python module for encoding and decoding
strings using Consistent Overhead Byte Stuffing.  There is no attempt in this
package to explain how COBS works.

------------
Installation
------------

The cobs package is installed using distutils.  If you have the tools
installed to build a Python extension module, run the following command.

python setup.py install

If you don't have the tools to build an extension module, you will need to
install the pure Python version using the following command.

python setup_py.py install

NOTE: The version for Python 3.x is in the py3 directory.  The install process
is the same but you need to use the 3.x interpreter.

------------
Unit Testing
------------


------
Timing
------

