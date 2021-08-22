package org.geekbang.week.three;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 描述:
 * 还是不太理解这块的内容, 感觉理解不了[捂脸]
 *
 * @author lil
 */
public class ThreadMain {
    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        threadA.start();
        System.out.println("这是主线程：");

        ThreadB threadB = new ThreadB();
        new Thread(threadB).start();
        System.out.println("这是主线程：");

        ThreadC threadC = new ThreadC();
        FutureTask<String> futureTask = new FutureTask<>(threadC);
        new Thread(futureTask).start();
        System.out.println("这是主线程:begin!");
        try {
            System.out.println("得到的返回结果是:" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
