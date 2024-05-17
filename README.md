# find-distance-on-earth

Hello, this is a project which utalizes API access aswell as Java resources and several imported projects in order to find the distance 
between 2 areas on earth. It is not just a simple distance formula. It formulates in regards to the earths curvature and utalizes longituide
and latitude of each point to create a reliable distance that correctly feeds back the distance to the user! This project also uses
javas most reliable GUI platform SWING to create a GUI a user can interact with and actually use. This project is fully built in java.

# The API

For this specific project I used OpenWeatherApps API. Although it may sound irrelevant because of it being a weather app, it does contain data 
to the Latitudes and Longtitudes of each location since it feeds of locations. You can sign up here ---> https://openweathermap.org/ 
Just click sign up and it is fully free usage (differs between consistency and intensity of use). It provides you with an API key that is directly
what this project is built on and provides all the import information.

![image](https://github.com/emiliofigueroa1/find-distance-on-earth/assets/157066769/686f3c72-f86e-4ee5-8c6d-2d2505c3f8b4)

# The BASICS

For this project I used Java Swing which is Javas main GUI program.

Therfore, of course JAVA is needed for this project and can be found for download 
here ---> https://www.java.com/en/

![image](https://github.com/emiliofigueroa1/find-distance-on-earth/assets/157066769/9fbff34a-2be0-4c91-824b-2a17d95f59c0)

After downloading Java USUALLY it comes included with JDK (Java Development Kit). BUT it is a quick check.

1) open your code editor and create a java file
2) put the following on top of the file ---> import javax.swing.*;

![image](https://github.com/emiliofigueroa1/find-distance-on-earth/assets/157066769/b5d7f2be-2eb8-4278-b548-b2308c28ba26)

3) compile the file and if NO ERRORS occur then your good!

If the process did create an error follow these steps.

1) follow this link ---> https://jdk.java.net/
2) restart your computer just in case so everything is correctly downloaded
3) check again and you should be good!

Now you can use Java Swing and the GUI interface!

# Getting It Started

Now that you have all of the basics downloaded for the program to get up and running you can know start getting it to work!

The first step is to take the 4 java files that are uploaded here on this github repository and add them to the folder that
contains the contents of the project.

![image](https://github.com/emiliofigueroa1/find-distance-on-earth/assets/157066769/8944bf59-611d-48de-881e-396cdc1b8f23)

After this you can look over all of the files and make sure that everything is working good and no errors.
If all is good then the first thing that is needed is to add your API key from OpenWeather. This addition is in the file
GeoInformation.java. 

Here is an image with the exact location you need to put in the key.

![image](https://github.com/emiliofigueroa1/find-distance-on-earth/assets/157066769/f0b23f81-8869-454a-bea0-bf781d57b3ff)

This is attached to a String variable so it will stay an error until you implement it in WITH quotations aroud the key.
Once this occurs ALL of the aspects of the java files are going to be able to run because of these key componet.

MAKE SURE TO KEEP COMPILING AND ERROR CHECKING ALL FOUR FILES!!

# Getting It Running

Now that you have all of the files in the right areas and creating the correct enviroment for the program to run you can actually run it.
The main interface this project runs on is the Java Swing GUI. This all can be found in the file ---> FindDistance.java. In here you will
find all of the componets that create the look and functionality of the Swing GUI. After looking this over you should be able to get it started.
At the bottom of this java file you will see a main method which is very small but a quick run on the project will get it active!

![image](https://github.com/emiliofigueroa1/find-distance-on-earth/assets/157066769/662cd295-479b-4031-a5a3-e42a5c8d52f8)

# Using The Program

You will now be confronted with the GUI in full effect! it will be a 600x400 box that prompts you, the user, for a start city and an end city.

![image](https://github.com/emiliofigueroa1/find-distance-on-earth/assets/157066769/37b24a9e-39e4-49da-86a2-e3eedb631768)

Before sumbitting the 2 cities, please read the warning sign which says that this data may be slightly unrelable due to the math used to calculate the distances.

I used haversines formula to calculate the distance between 2 locations in regards to the earth and its curvature. It is very close as you can see by the label 
but it will not always be 100% so please keep that in mind.

![image](https://github.com/emiliofigueroa1/find-distance-on-earth/assets/157066769/90a4b5ee-624b-4c42-8921-24106d1bcbb0)

Now you are ready to press sumbit and at the BOTTOM you will see the results! 
It will be available to you in Kilometers AND Miles due to me calculating it in kilometers first and then converting to miles.
Whilst also adding a more broader interperation for the project!


Now you are able to use this project freely and enjoy my project!

# EXAMPLE (London --> Hartford)

![image](https://github.com/emiliofigueroa1/find-distance-on-earth/assets/157066769/41579de0-c01d-4aa3-99b0-8a7e2e285c03)




