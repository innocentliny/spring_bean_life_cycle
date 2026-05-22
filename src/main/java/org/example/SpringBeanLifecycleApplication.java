package org.example;

import org.example.domain.model.Cat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBeanLifecycleApplication {

    static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBeanLifecycleApplication.class, args);
        Cat cat = context.getBean(Cat.class);
        cat.sayHello();
    }

}
