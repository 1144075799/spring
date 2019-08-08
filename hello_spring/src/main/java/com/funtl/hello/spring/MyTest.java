package com.funtl.hello.spring;

import com.funtl.hello.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService= (UserService) applicationContext.getBean("userService");
        userService.sayHi();
    }
}
