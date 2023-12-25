cmake_minimum_required(VERSION 3.20)
project("cobs"
LANGUAGES C
DESCRIPTION "Consistent Overhead Byte Stuffing encoding/decoding library"
VERSION 0.6.0)

include(GNUInstallDirs)
include(CTest)

add_library(cobs SHARED "")
target_sources(cobs PUBLIC cobs.c cobsr.c cobs.h cobsr.h)
target_include_directories(cobs PUBLIC .)
set_target_properties(cobs PROPERTIES
    PUBLIC_HEADER "cobs.h;cobsr.h"
    VERSION 2.0.0
    SOVERSION 2
)

configure_file(cobs.pc.in cobs.pc @ONLY)

add_subdirectory(tests-c)

install(TARGETS cobs
    LIBRARY
    PUBLIC_HEADER DESTINATION ${CMAKE_INSTALL_INCLUDEDIR}/${PROJECT_NAME}
)
install(FILES ${CMAKE_CURRENT_BINARY_DIR}/${PROJECT_NAME}.pc
    DESTINATION ${CMAKE_INSTALL_LIBDIR}/pkgconfig
)
