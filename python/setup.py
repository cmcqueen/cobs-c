
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

setup(
    name='cobs',
    version='0.9',
    description='Consistent Overhead Byte Stuffing (COBS)',
    author='Craig McQueen',
    author_email='python@craig.mcqueen.id.au',
    url='http://bitbucket.org/cmcqueen1975/cobs/',
    packages=['cobs'],
    ext_modules=[ 
        Extension('cobs._cobsext', [extension_filename, ]),
    ],

    cmdclass={ 'build_py' : build_py },
)
