
import sys

from distutils.core import setup
from distutils.extension import Extension
try:
    from distutils.command.build_py import build_py_2to3 as build_py
except ImportError:
    if sys.version_info >= (3, 0):
        raise ImportError("build_py_2to3 not found in distutils - it is required for Python 3.x")
    from distutils.command.build_py import build_py

if sys.version_info[0] == 2:
    extension_filename = 'src/_cobsext2.c'
elif sys.version_info[0] == 3:
    extension_filename = 'src/_cobsext3.c'

long_description = """
========================================
Consistent Overhead Byte Stuffing (COBS)
========================================

Python functions for encoding and decoding COBS.

-----
Intro
-----

Functions are provided for encoding and decoding according to
the basic COBS method.  The COBS variant "Zero Pair Elimination" (ZPE)
is not implemented.

A pure Python implementation and a C extension implementation
are provided. If the C extension is not available for some reason,
the pure Python version will be used.

This is fully implemented for Python 2.6. It is partially
implemented for Python 3.1--the C extension is working, but the
pure Python code is not.


References
``````````

    http://www.stuartcheshire.org/papers/COBSforSIGCOMM/

    http://www.stuartcheshire.org/papers/COBSforToN.pdf

"""

setup(
    name='cobs',
    version='0.5',
    description='Consistent Overhead Byte Stuffing (COBS)',
    author='Craig McQueen',
    author_email='python@craig.mcqueen.id.au',
    url='http://bitbucket.org/cmcqueen1975/cobs/',
    packages=['cobs'],
    ext_modules=[
        Extension('cobs._cobsext', [extension_filename, ]),
    ],
    cmdclass={ 'build_py' : build_py },

    long_description=long_description,

    license="MIT",
    classifiers=[
        'Development Status :: 3 - Alpha',
        'Intended Audience :: Developers',
        'License :: OSI Approved :: MIT License',
        'Programming Language :: Python',
        'Programming Language :: Python :: 2.6',
        'Topic :: Communications',
    ],
)
