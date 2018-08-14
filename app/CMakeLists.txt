# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.


add_library( native-lib
             SHARED
             src/main/cpp/native-lib.cpp )


include_directories(libs/include)
set(DIR ../../../../libs)


MESSAGE("打印")
MESSAGE("路径 " ${DIR})
add_library(avcodec-56
            SHARED
            IMPORTED)
set_target_properties(avcodec-56
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi/libavcodec-56.so)
add_library(avdevice-56
            SHARED
            IMPORTED)
set_target_properties(avdevice-56
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi/libavdevice-56.so)
add_library(avformat-56
            SHARED
            IMPORTED)
set_target_properties(avformat-56
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi/libavformat-56.so)
add_library(avutil-54
            SHARED
            IMPORTED)
set_target_properties(avutil-54
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi/libavutil-54.so)
 add_library(swresample-1
             SHARED
             IMPORTED)
 set_target_properties(swresample-1
                       PROPERTIES IMPORTED_LOCATION
                       ${DIR}/armeabi/libswresample-1.so)
  add_library(swscale-3
              SHARED
              IMPORTED)
  set_target_properties(swscale-3
                        PROPERTIES IMPORTED_LOCATION
                        ${DIR}/armeabi/libswscale-3.so)
  add_library(avfilter-5
              SHARED
              IMPORTED)
  set_target_properties(avfilter-5
                        PROPERTIES IMPORTED_LOCATION
                        ${DIR}/armeabi/libavfilter-5.so)

find_library( log-lib
              log )
target_link_libraries( native-lib
                       avcodec-56
                       avdevice-56
                       avformat-56
                       avutil-54
                       swresample-1
                       swscale-3
                       -landroid # Add this.
                       ${log-lib} )