# backend-technology-course
A repo for homework of SE418 and SE420.

## Technology used
- Spring Boot
- Junit
- Maven
- Thymeleaf
- bootstrap
- jquery

## File architecture
- index.html: the only page
- WordladderController.java: control the actions
- Wordladder.java: the Wordladder objects' definition
- WordLadderApplicationTests.java: the unit test

## How to run
```
mvn install
```

- run: 
```
cd word-ladder
mvn spring-boot:run
```
- test:
```
cd word-ladder
mvnw clean test
```

## Use postman to get word-ladder from this backend.

- url: http://127.0.0.1:8080/word-ladder?word1=code&word2=data
- method: GET

## Congregated with the frontend

```
cd word-ladder-frontend
npm install
npm start
```

Make sure that the backend is on port 8080.

## Input two word and generate a word ladder!

After running the project, get to the url printed on the console in your browser.

You will see the page. Just enter two words, and you will get the result.

The two words should obey following rules:

- Having the same length
- Be different
- Should be words in the dictionary

## Final result
![result](./src/main/resources/static/img/result.png)



## Using actuator to monitor apis

### Actuator url：localhost:8080/monitor/**:

Since the spring security is added, you need to login as the "ADMIN" role. (username and password are provided in the next section.)

-  /health: to check whether this app is "healthy".
- /info: to get self-defined information of this app.
- /beans: to get the information of beans.
- /conditions: to check when a configuration is applied.
- /shutdown: to shutdown this app gracefully (amazing! use post method!).
- /mappings: to get the mapping information of urls and controllers. 



## Spring Security

I defined two users:

- username: user 	password: 123456
- username: admin     password: 654321

Log in as "user" to get permission to the word-ladder api, and admin to get permission to the "actuator" pages.

If you haven't logged in and access the protected urls, the window will display "Hello Spring Security".

p.s: Thanks to the help from tx19980520.

## Integrated with the frontend

Run the backend and the frontend. Firstly you need to log in in "http://localhost:3000" as the user role. After that the window will be directed to "http://localhost:3000/word-ladder", and you can generate a word ladder as you wish.