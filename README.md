CityBuilder Application for Android
=====================================

Overview
--------
The github repository for a new Android game project.

Dependencies
--------
the Libgdx framwork
Gradle
Java

Installation instructions
--------------------------
	This project is made to work on Anroid and it is created with Java. Make sure you have Java installed and that it is up to date (tested with Java 1.8).
	It uses an Mobile development framework called LibGDX, this allows for cross platform programming also between desktop and android. So I can test how the application looks in a normal desktop java application.
	For IDE use Intellij or Android studio.

	Developing and testing on Desktop
	---------------------------------
		Make sure you have Android studio, Gradle and Java all installed and working.
		Clone or download this github project.
		Open the project using Android Studio
		file -> project from existing source
		click build.gradle in the project folder
		open the DesktopLauncher java file in the desktop project and run it as a java application
		Make sure that in the run configuration the working directory is ...\android\assets
		You should see a desktop application. 

	Testing on Android phone
	------------------------
		In the run configuration click add->Gradle
		in Gradle project choose the android project
		in tasks fill in "assemble"
		when you run this it will create a apk file in the build folder. You can install the app on your phone using this apk.

Author
------
Sander Kools


