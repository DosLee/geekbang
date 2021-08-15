package org.geekbang.week.two.nio.service;

import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 描述:
 * 通用的发送报文类
 *
 * @author lil
 */
public class HttpServices {

    private HttpServices() {
    }

    /**
     * 输出报文
     */
    public static void service(Socket accept, String body) {
        try {
            PrintWriter print = new PrintWriter(accept.getOutputStream(), true);
            print.println("HTTP/1.1 200 OK");
            print.println("Content-Type:text/html;charset=utf-8");
            print.println("Content-Length:" + body.getBytes(StandardCharsets.UTF_8).length);
            print.println();
            print.write(body);
            print.close();
            accept.close();
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
