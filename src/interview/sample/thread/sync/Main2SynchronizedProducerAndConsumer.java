/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main2SynchronizedProducerAndConsumer
 * Author:   Jianf
 * Date:     2020/8/21 16:58
 * Description: 使用synchronied+notify/wait实现生产者消费者线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package interview.sample.thread.sync;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈使用synchronied+notify/wait实现生产者消费者线程〉
 *
 * @author Jianf
 * @create 2020/8/21
 * @since 1.0.0
 */
public class Main2SynchronizedProducerAndConsumer<T> {
    //生产者消费使用的队列
    final private LinkedList<T> lists = new LinkedList<>();
    //队列中元素总数最大大小
    final private int MAX = 10;
    //当前队列中元素个数
    private int count = 0;

    public int getCount(){
        return count;
    }
    //生产者:生产者生产馒头
    public synchronized void put(T t){
        while (lists.size()==MAX){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        //通知消费者线程进行消费
        this.notifyAll();
    }

    //消费者方法
    public synchronized T get(){
        T t = null;
        while (lists.size()==0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //消费馒头
        t = lists.removeFirst();
        count--;
        //通知生产
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        Main2SynchronizedProducerAndConsumer<String> c = new Main2SynchronizedProducerAndConsumer<>();

        //启动10个消费者线程
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<5;j++){
                    //每个线程消费5个馒头
                    System.out.println(Thread.currentThread().getName()+"消费了"+c.get());
                }
            },"c"+i).start();
        }

        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //启动生产者线程
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                    c.put(Thread.currentThread().getName()+"生产的馒头"+j);
                    System.out.println(Thread.currentThread().getName()+"生产了馒头"+j);
                }
            },"p"+i).start();
        }
    }
}