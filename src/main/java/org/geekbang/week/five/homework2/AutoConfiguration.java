package org.geekbang.week.five.homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 描述:
 * 自动装配
 *
 * @author lil
 */
@Configuration
@Import({KlassConfiguration.class, SchoolConfiguration.class, StudentConfiguration.class})
public class AutoConfiguration {
    @Autowired
    private KlassConfiguration klassConfiguration;

    @Autowired
    private SchoolConfiguration schoolConfiguration;

    @Autowired
    private StudentConfiguration studentConfiguration;

    @Bean
    public StudentInfo studentInfo() {
        return new StudentInfo(schoolConfiguration.getName(), klassConfiguration.getName(), studentConfiguration.getName());
    }
}
