# Rev-Overcharge
Project 3 for 210607 Reston Batch.

## Project Description

Revature Overcharge is a full-stack web applicaiton. It is a study system for Revature employees. Users of the application will be able to create their own flashcard sets and use flashcard sets created by other users to study. When running through a flashcard set a user will be able to type an answer before viewing the answer to a flashcard, giving them the ability to compare their answer with the real one. Flashcards can be marked as studied to prevent requestioning. Flashcard sets can be rated. A timer is also provided to coordinate study and break sessions. Daily and weekly objectives are measured to award points to users.


## Technologies Used

Development technologies:
* H2
* Java
* Spring
* Angular
* AWS
    - EC2
    - S3 Bucket

Testing technologies:
* Log4J
* JUnit
* Mockito
* Postman
* Selenium
* Cucumber

## Features

List of features ready
* Login functionality
* Study flashcard sets by answering flashcards and marking cards as studied
* Create, edit, and rate flashcard sets
* Timer functionality including modes and custom time
* Objectives displayed and measured

To-Do List:
* Ranked flashcard sets on the home page.
* User profile page to 
    - display and edit profile
    - display favorite flashcard set, and public stats for contributions
* Admin authorization of new flash card sets
* Categorize flashcard sets by tech stack

## Getting Started

> This project was developed in Spring Tool Suite 4 and Visual Studio Code.
> This project was tested with Google Chrome version 92 and Firefox version ??
> No other environments have been tested or confirmed.

* Clone this repository: `git clone `.
* Open the Spring project in your IDE.
* **Configuration chages for setting up h2 DB**
* Compile and run the project to establish the Spring Tomcat server.
    - The port is preset to `8081`
* In your CLI, navigate to `rev-Overcharge/OverchargeNG`.
* Install *node_modules* and run the server with:
    - Node is assumed to be on your device
    - `npm install`
    - **specific packages**
    - `ng serve`
* Open `localhost:4200` in your browser.

## Usage

To demo this application, you can use the following login information:
| Role | Username | Password |
| :--- | :---: | :---: |
| User | user | pass |

## Contributors

[Ahmed Elhewazy](https://github.com/elhewazy), [Cao Mai](https://github.com/caocmai), [Chris Nowalk](https://github.com/ChristopherNowalk), [Deyondre Beale](https://github.com/DeyondreBeale), [Dwayne Fraser](https://github.com/dwayne-revature), [Jenine Clay](https://github.com/jeninec), [Joe La Macchia](https://github.com/JosephLamacchia), [Jordan Hupp](https://github.com/jhupprevature), [Jugue Nkuzu](https://github.com/juguenkuzu), [Kevin Leader](https://github.com/kileader), [Nicolis Miller](https://github.com/nicxm), [Sean Guo](https://github.com/SeanGRev), [Stuart Kruze](https://github.com/stukruze), [Tony Bahner](https://github.com/abahner)
