package com.codeup.springblog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBlogApplication.class, args);
    }

}

//<!--<h1>The number guessed was : <span th:text ="${n}"></span></h1>-->
//<!--<h1>The random number was : <span th:text="${randomNumber}"></span></h1>-->
//<!--<h2 th:if="${check}">You guessed right!!</h2>-->
//<!--<h2 th:if="${!check}">Wrong number!!</h2>-->
//<!--<h3><a href="/roll-dice">Try again</a></h3>-->