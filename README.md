# MOvie Booking and LIsting Management Application (MOBLIMA)

## Problem Statement

Application to computerize the process of making online booking of Cinemas.

## How to Run the App

MOBLIMA is coded on Visual Studio Code using Java from the Visual Studio Code Extension. Steps to run:
1. Open the folder in Visual Studio Code
2. Navigate to .vscode 
3. Open settings.json
4. Set the path to "../lib/**/*.jar", which contains the POI library for reading for documents (Skip this step if you are using Linux or Mac OS)
5. Navigate to MOBLIMA.java 
6. Press on run -> "Start Debugging"
7. Enjoy the masterpiece

## Structure

.vscode - Settings for vscode <br />
bin - Contains .class files <br />
lib - Contains the poi-binary for reading of xlsx files which consists of all the movie data <br />
database - Consists of all the xlxs files which consists of our data <br />
src - all of our source codes <br />
    |___ Model - Consists of all Entity Classes <br />
    |___ View - Consists of all Boundary Classes <br />
    |___ Controller - Consists of all Control Classes <br />
    |___ MOBLIMA.java - Main app file <br />


