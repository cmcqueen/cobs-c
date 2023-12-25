cmake_minimum_required(VERSION 3.16)
project("cobs"
LANGUAGES C
DESCRIPTION "Consistent Overhead Byte Stuffing encoding/decoding library"
VERSION 0.6.0)

include(CTest)

add_library(cobs SHARED "")
target_sources(cobs PUBLIC cobs.c cobsr.c)

configure_file(cobs.pc.in cobs.pc @ONLY)

add_subdirectory(tests-c)
