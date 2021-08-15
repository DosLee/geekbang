package org.geekbang.week.two.nio;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.geekbang.week.two.nio.service.HttpServices.service;

/**
 * 描述:
 * 单线程Socket程序
 *
 * @author lil
 */
@Component
public class HttpServer01 {

    /**
     * 单线程Socket
     *
     * 参见Test包里的测试类
     */
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket, "hello, nio1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
