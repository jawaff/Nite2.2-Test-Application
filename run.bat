@echo off

cd lib
REM Don't forget to build the NiteTest.jar with Intellij! The project is setup to create that Artifact after you make the project.
java -cp NiteTest.jar com.lcsc.hackathon.kinectcontroller.UserViewerApplication
cd ..

@echo on