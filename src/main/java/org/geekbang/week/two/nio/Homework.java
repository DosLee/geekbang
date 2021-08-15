package org.geekbang.week.two.nio;

import org.geekbang.week.two.nio.util.HttpClientTool;

import java.io.IOException;

/**
 * 描述:
 * 第二周作业
 *
 * @author lil
 */
public class Homework {

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8801/";
        String text = HttpClientTool.httpGet(url);
        System.out.println("url: " + url + " ; response: \n" + text);
    }
}
