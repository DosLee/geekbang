package org.geekbang.week.two.nio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * 描述:
 *
 * @author lil
 */
@SpringBootTest
class HttpServer01Test {

    @Autowired
    private HttpServer01ForSpring server01;
    
    @Test
    void testSocket01() throws IOException {
        server01.main();
    }
}