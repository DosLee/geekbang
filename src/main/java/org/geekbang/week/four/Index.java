package org.geekbang.week.four;

import java.util.concurrent.*;


/**
 * 描述:
 *
 * @author lil
 */
public class Index {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();

            // 在这里创建一个线程或线程池，
            ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 100,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(100),
                    new ThreadPoolExecutor.AbortPolicy());
            CompletionService<Integer> service = new ExecutorCompletionService<>(executor);
            // 异步执行 下面方法
            service.submit(Index::sum);
            int result = 0;//这是得到的返回值
            result = service.take().get();
            // 确保  拿到result 并输出
            System.out.println("异步计算结果为：" + result);
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
            // 然后退出main线程
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
