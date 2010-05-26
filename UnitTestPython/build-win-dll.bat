@echo off

rem gcc -c -fPIC -I.. ../cobs.c -o libcobs.o
rem gcc -shared libcobs.o -o libcobs.dll

gcc -shared -I.. ../cobs.c -o libcobs.dll
gcc -shared -I.. ../cobsr.c -o libcobsr.dll