@echo off

gcc -c -fPIC -I.. ../cobs.c
gcc -shared cobs.o -o cobs.dll
