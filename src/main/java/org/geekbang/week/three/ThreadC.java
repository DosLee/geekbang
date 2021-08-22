package org.geekbang.week.three;

import java.util.concurrent.Callable;

/**
 * 描述:
 *
 * @author lil by 2021-08-22 21:51
 */
public class ThreadC implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println("线程C");
        return "线程C";
    }
}