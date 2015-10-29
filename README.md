# Nite2.2-Test-Application
This project holds all of the dependencies needed to utilize Openni 2.22 and Nite 2.22 in Java. It also shows how one can use Nite for skeleton tracking with the Kinect.

I got the code and dependencies from a bitbucket repository. The repo has some Nite installers that contain the dependencies and a directory of sample projects for Nite/OpenNi.
https://bitbucket.org/kaorun55/openni-2.2/src/2f54272802bfd24ca32f03327fbabaf85ac4a5c4/NITE%202.2%20%CE%B1/?at=master

## Pre-requisites

Note: I'm not sure if I'm listing all of the required prerequisites. I'm working on Windows 10 (64-bit) and I installed all of the required
dependencies for a separate OpenNi2 project that I was looking into, https://github.com/occipital/OpenNI2. So if you need more dependencies than
what is listed below, I'd check that github page out and install some additional dependencies.

1. Microsoft SDK or libfreenect

(Note: libfreenect should be compatible with this project if it has been installed properly. The libfreenect2 people were able to get
use the same Nite and Openni with their project and it seems to work. https://github.com/OpenKinect/libfreenect2/issues/243)

2. JDK 1.6 or higher

## Caveats

1. The dependencies for the openni and nite jars have to be in the same directory as the project's jar and the project's jar needs to be executed using that directory as the working directory.
We may be able to find a work around for this or we can just alter the OpenNi and Nite code to make it work differently.
