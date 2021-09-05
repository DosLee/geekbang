package org.geekbang.week.five.homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 描述:
 *
 * @author lil
 */
@SpringBootApplication
public class AppBoot {

    public static void main(String[] args) {
        SpringApplication.run(AppBoot.class, args);
    }

    @Autowired
    StudentInfo studentinfo;

    @Bean
    public void printInfo(){
        System.out.println(studentinfo);
    }
}
