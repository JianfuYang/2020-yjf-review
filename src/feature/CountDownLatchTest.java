package feature; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: feature.CountDownLatchTest
 * Author:   Jianf
 * Date:     2020/7/11 11:04
 * Description: CountDownLatch类测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈CountDownLatch类测试〉
 *
 * @author Jianf
 * @create 2020/7/11
 * @since 1.0.0
 */
public class CountDownLatchTest {


    //创建模拟任务内部类
    static class TaskPortion implements Runnable {

        private static int counter = 0;

        //编号
        private final int id = counter++;

        private static Random random = new Random(47);

        //通过构造器指定CountDownLatch对象
        private final CountDownLatch latch;

        public TaskPortion(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                //模拟任务的执行
                doWork();
                //任务执行完，将CountDownLatch对象的count值减一
                latch.countDown();
                //打印当前的count值
                System.out.println("Count of Latch:" + latch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void doWork() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
            System.out.println(id + " completed!");
        }

        @Override
        public String toString() {
            return String.format("%1$-3d", id);
        }
    }


    //创建一个调用countDownLatch的await方法的任务
    /**
     * 等待任务
     */
    static class WaitingTask implements Runnable {

        private static int counter = 0;

        //编号
        private final int id = counter++;

        //通过构造器指定CountDownLatch对象
        private final CountDownLatch latch;

        public WaitingTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                //如果count>0阻塞,count=0直接执行
                latch.await();
                System.out.println("Count of Latch:" + latch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    /*测试代码如下：*/
    private static int COUNT = 5;
    private static int LOOP = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建一个count=5的CountDownLatch对象
        CountDownLatch latch = new CountDownLatch(COUNT);
        //10个WaitingTask阻塞
        for (int i = 0; i < 10; i++) {
            executorService.execute(new WaitingTask(latch));
        }
        /**
         * 如果LOOP<COUNT,latch的countDown方法只会调用4次，程序会阻塞
         */
        for (int i = 0; i < LOOP; i++) {
            executorService.execute(new TaskPortion(latch));
        }
        System.out.println("Latched all tasks!");
        executorService.shutdown();
    }



}