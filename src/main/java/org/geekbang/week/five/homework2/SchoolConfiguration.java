package org.geekbang.week.five.homework2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * 学生类装配
 *
 * @author lil
 */
@Configuration
@ConfigurationProperties(prefix = "school")
public class SchoolConfiguration {


    private String name = "ExperimentalPrimarySchool";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
