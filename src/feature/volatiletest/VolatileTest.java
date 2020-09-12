/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: VolatileTest
 * Author:   Jianf
 * Date:     2020/8/25 16:27
 * Description: 测试volatile关键字在并发情况下的安全性
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.volatiletest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试volatile关键字在并发情况下的安全性〉
 *
 * @author Jianf
 * @create 2020/8/25
 * @since 1.0.0
 */
public class VolatileTest {
    public static volatile int race = 0;
    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
//            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println(race);
    }
}