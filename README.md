# University Assistant

University Assistant is a convenient tool for retrieving information about lecturers in various departments. With this program, you can access information such as:

- **Head of Department**: Find out who is the head of a specific department by using the command: `Who is head of department {department_name}`

- **Lecturer Statistics**: Get statistics about the lecturers in a department with the command: `Show {department_name} statistics.`

- **Average Lecturer Salary**: Discover the average salary of lecturers in a department using the command: `Show the average salary for the department {department_name}.`

- **Lecturer Count**: Find out the count of lecturers in a department with the command: `Show count of employees for {department_name}.`

- **Global Search**: Search for lecturers by providing a partial name or surname using the command: `Global search by {template}.`


### Technologies
* Java 17
* Spring Boot 3.1.3
* Postgres 14
* Liquibase 4.22.0
* Lombok
### Prerequisites

Before running the program, make sure you have the following prerequisites installed:

- [Java 17](https://www.java.com/en/download/)
- [Git](https://git-scm.com/)
- [PostgreSQL](https://www.postgresql.org/)

## Getting Started

1. Clone remote repository to your local machine
2. In the src/main/resources/application.properties set your credentials to database
3. Build The application by running the Maven package command: mvn clean package
4. Run this program
5. In terminal send same message