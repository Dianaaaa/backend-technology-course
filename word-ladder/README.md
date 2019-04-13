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

!You should log in to get access to these information since I have added these pages to Spring Security.

- /health: to check whether this app is "healthy".
- /info: to get self-defined information of this app.
- /beans: to get the information of beans.
- /conditions: to check when a configuration is applied.
- /shutdown: to shutdown this app gracefully (amazing! use post method!).
- /mappings: to get the mapping information of urls and controllers. 



## Spring Security

I defined two users:

- username: user 	password: 123456
- username: admin     password: 654321

You can check the login functionality on the url "localhost:8080/user". Once you successfully log in, the window will display "Hello Spring Security".

I also add a login page in the front end. You can also log in from the front-end. It will get and store the session.

