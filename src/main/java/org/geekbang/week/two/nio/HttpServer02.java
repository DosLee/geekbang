package org.geekbang.week.two.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.geekbang.week.two.nio.service.HttpServices.service;

/**
 * 描述:
 * 多线程Socket
 *
 * @author lil
 */
public class HttpServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8802);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                new Thread(() -> service(socket, "hello, nio2")).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
