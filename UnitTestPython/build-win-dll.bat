@echo off

gcc -c -fPIC -I.. ../cobs.c -o libcobs.o
gcc -shared libcobs.o -o libcobs.dll
