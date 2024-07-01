# Java Survey Application (tendable)

## Description

This Java application allows users to participate in a survey consisting of Yes/No questions. After each run of the survey, it calculates ratings based on user responses and provides an average rating across all runs at the end

## Approach

### Design and Implementation Strategy

The Java Survey Application is designed to handle survey operations efficiently using object-oriented principles and modern Java features.
Design principles that has influenced this approach:
YAGNI, KISS and SOLID

Here's a breakdown of the main components and their functionalities:

- **Questionnaire**: Dynamically loads survey questions from a `questions.properties` file using Java's `Properties` class. This approach allows easy customization and localization of survey questions without altering the Java code.

- **Survey**: Orchestrates the survey process by iterating through loaded questions, prompting users for answers, and calculating ratings. It utilizes Java 8 features such as streams and lambda expressions for concise and readable code.

- **AnswerStorage**: Manages user answers during the survey and provides methods to retrieve stored answers and calculate ratings. The `getAnswers()` method facilitates access to collected data, enabling further analysis or processing. This storage can be upgraded to store Question-Submitted Answer as well. 

### Features

- **Dynamic Question Loading**: Questions are loaded from a `questions.properties` file, supporting easy customization and localization.
  
- **Rating Calculation**: After each survey run, the application calculates a rating based on the number of "Yes" answers provided by the user, displaying immediate feedback.

- **Average Rating**: Across multiple survey runs, the application computes and displays an average rating, giving users an overview of their overall responses.

## Requirements

- Java 8 or higher.
- `questions.properties` file containing survey questions.

## Usage

 **Run application in IDE**: 
1. Open your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
2. Import the project into the IDE.
3. Navigate to the Application.java file and run it as a Java application (main method in Application class).
4. Follow the on-screen prompts to answer each survey question with "y", "n", "Yes" or "No" (case-insensitive).
5. View Results: After each answer, the application will display the rating for that run. Upon completion, it will show the average rating across all runs

 **Run application in IDE**: 
1. Navigate to the directory containing your Dockerfile and Java source code.
2. Build the Docker image:
	"docker build -t java-survey-app ."
	You can change the name of image according to requirement. Replace "java-survey-app" with your desired name.
3. Run the Docker container:
	"docker run -it --rm java-survey-app"
	'-it' runs the container in interactive mode.
	'--rm' removes the container automatically when it exits.
	'java-survey-app' should match the image name specified in the docker build command.
4. Follow the on-screen prompts to interact with the Java Survey Application running inside the Docker container.	
**Notes**
Ensure you have Docker installed and running on your machine.
Modify the Dockerfile as needed to accommodate specific requirements of your Java application/Environment.

