# Quiz Spring Boot Application #

### Project Overview ###

To build a simple quiz microservice using SpringBoot ,running on the JVM that creates  questionnaire and multiple choice answer for the 
registered user

### Application structure ###

The application is implemented as a Spring Boot application using an in memory H2 Database Engine to store the data. 

The application is structured in a controller package with an UserController,AnswerController and ResultController, 
that exposes multiple REST endpoints. A model package with the data model and its associated enums and classes. This data 
model contains entity class - User,Quiz,Question,Answer,CorrectAnswer,Result.

A repository package with UserRepository,QuestionRepository,AnswerRepository,ResultRepository,QuizRepository to access the database.

The main class in the application is com.quiz.cloud.skel.SkelApplication. Running this class will start the application 
and insert in database new user with a quiz set containing 5 question with 4 multiple choise answer for each question and also set correct answer 
for each question.


### Task ###
1) User Login
URL- http://localhost:9443/app/api/1.0/user/login/abc/abc     HTTP.POST 

http://localhost:9443/app/api/1.0/user/login/{username}/{password}

2) Get quiz by user
Sample URL- http://localhost:9443/app/api/1.0/user/getUserQuiz/abc/abc    HTTP.GET

http://localhost:9443/app/api/1.0/user/getUserQuiz/{username}/{password}

	
3) Get list of all users ,their set of quiz questions and answers options
Sample URL- http://localhost:9443/app/api/1.0/user/allUsers    HTTP.GET  

4) Get list of answers for user questions and also correct answer
Sample url- http://localhost:9443/app/api/1.0/answer/allAnswer  HTTP.GET

5)  Submit answer for user set of quiz question with time 15 seconds 
Sample url- http://localhost:9443/app/api/1.0/user/submitAnswer/abc/abc/5/Oslo  HTTP.GET

http://localhost:9443/app/api/1.0/user/submitAnswer/{username}/{password}/{question_order}/{Answer}

5)  Submit answer for user set of quiz question with extra  timeline 25 seconds 
Sample url- http://localhost:9443/app/api/1.0/user/submitAnswerTimeLifeline/abc/abc/5/Oslo   HTTP.GET

http://localhost:9443/app/api/1.0/user/submitAnswerTimeLifeline/{username}/{password}/{question_order}/{Answer}


6) Get user score:
Sample url- http://localhost:9443/app/api/1.0/result/allResult HTTP.GET


  
### Installation ###

Clone or download the repository from https://github.com/partha20in/Quiz

The project is prepared to be used with Gradle and Eclipse IDE. (Gradle plugin buildship is by default included in Eclipse). You can of course use any other IDE if you like.

Project is configured to use JavaSE-11.

Project is tested using Eclipse IDE for Enterprise Java Developers Version: 2020-06 (4.16.0) but you can use other version.


This is how you import the project into Eclipse:

1. Choose File->Import..., select Existing Gradle Project.
1. Set Project root directory to where you cloned the repository.
1. Import Options, choose Gradle Wrapper.


### Starting application ###

Right click on com.wallet.cloud.skel.SkelApplication and select Run As -> Java Application

