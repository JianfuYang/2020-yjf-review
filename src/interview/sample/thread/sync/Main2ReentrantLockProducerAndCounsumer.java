/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main2ReentrantLockProducerAndCounsumer
 * Author:   Jianf
 * Date:     2020/8/21 20:56
 * Description: 用ReentrantLock实现生产者与消费者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package interview.sample.thread.sync;

import com.sun.jdi.connect.spi.TransportService;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用ReentrantLock实现生产者与消费者〉
 *
 * @author Jianf
 * @create 2020/8/21
 * @since 1.0.0
 */
public class Main2ReentrantLockProducerAndCounsumer<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int Max = 10;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    //使用ReentrantLock的多路通知功能
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public int getCount(){
        return count;
    }

    public void put(T t){
        try{
            lock.lock();
            while(lists.size()==Max){
                producer.await();
            }
            lists.add(t);
            ++count;
            //通知所有消费者线程进行消费
            consumer.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try{
            lock.lock();
            while (lists.size()==0){
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            //通知生产者进行生产
            producer.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }


    public static void main(String[] args){
        Main2ReentrantLockProducerAndCounsumer c = new Main2ReentrantLockProducerAndCounsumer();
        //启动消费者线程
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<5;j++){
                    System.out.println(Thread.currentThread().getName()+"线程消费了"+c.get());
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
                    c.put(Thread.currentThread().getName()+" "+j);
                    System.out.println(Thread.currentThread().getName()+"生产了一个馒头");
                }
            },"p"+i).start();
        }
    }

}