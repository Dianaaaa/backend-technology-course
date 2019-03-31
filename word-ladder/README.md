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

## Input two word and generate a word ladder!
After running the project, get to the url printed on the console in your browser.

You will see the page. Just enter two words, and you will get the result.

The two words should obey following rules:

- Having the same length
- Be different
- Should be words in the dictionary

## Final result
![result](./src/main/resources/static/img/result.png)

