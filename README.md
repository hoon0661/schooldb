
# School Database API
This project is to utilize my knowledge of Spring MVC & JPA & data entity relationships to create a REST API for a simple school database management.
 



## Technology Used

- Java 
- Spring Web
- MySQL
- JPA 
- Lombok 
- JUnit 
- AWS RDS 
- AWS EC2
- Gradle
- IntelliJ


## Features

- CRUD student, instructor and course.
- Enroll/drop student & instructor in course.
- Unit testing has been performed on each entity.
- This server has been deployed using AWS RDS and EC2.


## API Reference
- Entity Relationship Diagram:
![App Screenshot](https://github.com/hoon0661/schooldb/blob/main/schooldbERD.png?raw=true)

- Please use this as a prefix for all API endpoints

```http
  http://schooldb.hoonkim.link/api
```

#### Get all students

```http
  GET /students
```

#### Get all instructors

```http
  GET /instructors
```

#### Get a courses

```http
  GET /courses/{course ID}
```

#### Get a student

```http
  GET /students/{student ID}
```

#### Get a instructor

```http
  GET /instructors/{instructor ID}
```

#### Get all courses in Page (For Pagination)

```http
  GET /courses/pages?page={page}&size={size}&sortBy={EntityField}&isAsc={boolean}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `page`      | `int` | **Required**. Page number for pagination |
| `size`      | `int` | **Required**. # of data to fetch in one page |
| `sortBy`      | `String` | **Optional**. sort by field in course entity, default is "id" |
| `isASC`      | `boolean` | **Optional**. true = ASC or false = DESC, default is true |


#### Get all instructors in Page (For Pagination)

```http
  GET /instructors/pages?page={page}&size={size}&sortBy={EntityField}&isAsc={boolean}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `page`      | `int` | **Required**. Page number for pagination |
| `size`      | `int` | **Required**. # of data to fetch in one page |
| `sortBy`      | `String` | **Optional**. sort by field in instructor entity, default is "id" |
| `isASC`      | `boolean` | **Optional**. true = ASC or false = DESC, default is true |


#### Get all students in Page (For Pagination)

```http
  GET /students/pages?page={page}&size={size}&sortBy={EntityField}&isAsc={boolean}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `page`      | `int` | **Required**. Page number for pagination |
| `size`      | `int` | **Required**. # of data to fetch in one page |
| `sortBy`      | `String` | **Optional**. sort by field in student entity, default is "id" |
| `isASC`      | `boolean` | **Optional**. true = ASC or false = DESC, default is true |

#### Get all search suggestions based on prefix of input query

```http
  GET /search?category={entity name}&searchParam={search param}&str={prefix}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `entity name`      | `String` | **Required**. Entity to search - "course", "student", "instructor" |
| `search param`      | `int` | **Required**.  parameter to search - "courseName"(for course only), "firstName", "lastName" (for student, instructor only)|
| `prefix`      | `String` | **Required**. prefix to search data. ex) "Am" to return "Amanda" |


#### Create a course (All fields in course entity are required in request body)

```http
  POST /courses 
```

#### Create an instructor (All fields in instructor entity are required in request body)

```http
  POST /instructors 
```

#### Create a student (All fields in student entity are required in request body)

```http
  POST /students 
```

#### Enroll a student in a course

```http
  PUT /courses/{course ID}/students/{student ID} 
```

#### Enroll an instructor in a course

```http
  PUT /courses/{course ID}/instructors/{instructor ID} 
```

#### Update a course (All fields in course entity are required in request body)

```http
  PUT /courses/{id}
```

#### Update a course (All fields in instructor entity are required in request body)

```http
  PUT /instructors/{id}
```

#### Update a course (All fields in student entity are required in request body)

```http
  PUT /students/{id}
```

#### Delete a course

```http
  DELETE /courses/{id}
```

#### Delete an instructor

```http
  DELETE /instructors/{id}
```

#### Delete a student

```http
  DELETE /students/{id}
```





## Input Validation

#### All inputs must be not null nor empty. If any input doesn't meet its validation, IllegalArgumentException is thrown with its corresponding message.

| Parameter | Type     | validation                       |
| :-------- | :------- | :-------------------------------- |
| `coursename, firstname, lastname`      | `String` | not less than 2 letters, must be alphabetical |
| `state`      | `String` | must be one of states as well as its full name("new york", not "ny") |
| `zipcode`      | `String` | must be 5 digits, cannot be mixture of number and other characters / non digits only |
| `major`      | `String` | must be longer than 3 letters |
| `email`      | `String` | must include @ |
| `phone`      | `String` | must be 10 digits, cannot be mixture of number and other characters / non digits only |
| `capacity`      | `int` | must be greater than 0 |
