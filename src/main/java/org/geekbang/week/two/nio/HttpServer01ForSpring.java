package org.geekbang.week.two.nio;

import org.geekbang.week.two.nio.service.HttpServices;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 描述:
 * 单线程Socket程序
 *
 * @author lil
 */
@Component
public class HttpServer01ForSpring {

    /**
     * 单线程Socket
     *
     * 参见Test包里的测试类
     */
    public void main() throws IOException {
        ServerSocket socket = new ServerSocket(8801);
        while (true) {
            try {
                Socket accept = socket.accept();
                HttpServices.service(accept, "hello, nio1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
