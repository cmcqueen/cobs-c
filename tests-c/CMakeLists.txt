cmake_minimum_required(VERSION 3.16)
project("tests-c"
LANGUAGES C
DESCRIPTION "Consistent Overhead Byte Stuffing encoding/decoding unit tests"
VERSION 0.6.0)

include(CTest)

add_library(Unity STATIC unity/unity.c)
target_compile_definitions(Unity PUBLIC UNITY_INCLUDE_PRINT_FORMATTED)
target_include_directories(Unity PUBLIC unity)

# Test of COBS
add_executable(test_cobs test-cobs.c)
target_include_directories(test_cobs PRIVATE ..)
target_link_libraries(test_cobs Unity cobs)
add_test(test_cobs test_cobs)

# Test of COBS/R
add_executable(test_cobsr test-cobsr.c)
target_include_directories(test_cobsr PRIVATE ..)
target_link_libraries(test_cobsr Unity cobs)
add_test(test_cobsr test_cobsr)
