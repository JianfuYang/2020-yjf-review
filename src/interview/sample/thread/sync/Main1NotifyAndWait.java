/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main1NotifyAndWait
 * Author:   Jianf
 * Date:     2020/8/21 16:19
 * Description: 使用notify和wait来实现线程同步
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package interview.sample.thread.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈使用notify和wait来实现线程同步〉
 *
 * @author Jianf
 * @create 2020/8/21
 * @since 1.0.0
 */
public class Main1NotifyAndWait {

    //使用volatile以保证线程之间的可见性
    volatile List lists = new ArrayList();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }


    public static void main(String[] args) {

        Main1NotifyAndWait c = new Main1NotifyAndWait();
        final Object lock = new Object();
        //需要注意先启动在启动t1
        new Thread(()->{
            synchronized (lock){
                System.out.println("t2 启动");
                if(c.size()!=5){
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
                //通知t1继续执行
                lock.notify();
            }
        },"t2").start();

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //线程t1
        new Thread(()->{
            System.out.println("t1 启动");
            synchronized (lock){
                for(int i=0;i<10;i++){
                    c.add(new Object());
                    System.out.println("add "+i);
                    if(c.size()==5){
                        lock.notify();
                        //释放锁，让t2得以执行
                        try{
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"t1").start();
    }
}