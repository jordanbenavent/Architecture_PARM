# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.20

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/matthieu/Documents/CLion/clion-2021.2.1/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/matthieu/Documents/CLion/clion-2021.2.1/bin/cmake/linux/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/code_c.dir/depend.make
# Include the progress variables for this target.
include CMakeFiles/code_c.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/code_c.dir/flags.make

CMakeFiles/code_c.dir/main.c.o: CMakeFiles/code_c.dir/flags.make
CMakeFiles/code_c.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/code_c.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/code_c.dir/main.c.o -c /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/main.c

CMakeFiles/code_c.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/code_c.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/main.c > CMakeFiles/code_c.dir/main.c.i

CMakeFiles/code_c.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/code_c.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/main.c -o CMakeFiles/code_c.dir/main.c.s

# Object files for target code_c
code_c_OBJECTS = \
"CMakeFiles/code_c.dir/main.c.o"

# External object files for target code_c
code_c_EXTERNAL_OBJECTS =

code_c: CMakeFiles/code_c.dir/main.c.o
code_c: CMakeFiles/code_c.dir/build.make
code_c: CMakeFiles/code_c.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable code_c"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/code_c.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/code_c.dir/build: code_c
.PHONY : CMakeFiles/code_c.dir/build

CMakeFiles/code_c.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/code_c.dir/cmake_clean.cmake
.PHONY : CMakeFiles/code_c.dir/clean

CMakeFiles/code_c.dir/depend:
	cd /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/cmake-build-debug /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/cmake-build-debug /home/matthieu/Documents/Architecture_PARM/edge-team-leat-parm_public-d2cb56fdcae6/code_c/cmake-build-debug/CMakeFiles/code_c.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/code_c.dir/depend
