cmake_minimum_required(VERSION 3.20)
project(code_c C)

set(CMAKE_C_STANDARD 11)

include_directories(.)
include_directories(include)

add_executable(code_c
        include/parm.h
        main.c)
