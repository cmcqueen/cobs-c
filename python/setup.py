from distutils.core import setup
from distutils.extension import Extension

setup(
name='cobs',
version='0.9',
description='Consistent Overhead Byte Stuffing',
author='Craig McQueen',
author_email='pub@craig.mcqueen.id.au',
url='http://bitbucket.org/cmcqueen1975/cobs/',
packages=['cobs'],

ext_modules=[ 
    Extension('cobs._cobsext', ['src/_cobsext.c', ],
    ),
],
)
