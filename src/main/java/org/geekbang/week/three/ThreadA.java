package org.geekbang.week.three;

/**
 * 描述:
 *
 * @author lil
 */
public class ThreadA extends Thread {

    public void run() {
        super.run();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程A");
    }
}