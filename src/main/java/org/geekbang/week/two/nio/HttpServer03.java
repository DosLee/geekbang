package org.geekbang.week.two.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.geekbang.week.two.nio.service.HttpServices.service;

/**
 * 描述:
 * 线程池Socket
 *
 * @author lil
 */
public class HttpServer03 {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 4);
        final ServerSocket serverSocket = new ServerSocket(8803);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> service(socket, "hello, nio3"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
