package org.geekbang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * 配置类中声明Bean
 *
 * @author lil
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public LogService logService() {
        return new LogService();
    }
}

class LogService {
    public void print() {
        System.out.println("配置类中声明Bean");
    }
}
