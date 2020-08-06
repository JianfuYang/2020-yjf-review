/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: CreateThreadByImpRunnable
 * Author:   Jianf
 * Date:     2020/8/6 9:53
 * Description: 通过实现Runnable接口来创建线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.multithread;

import javax.swing.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈通过实现Runnable接口来创建线程〉
 *
 * @author Jianf
 * @create 2020/8/6
 * @since 1.0.0
 */
public class CreateThreadByImpRunnable {

    public static void main(String[] args) {
        for(int i = 0;i < 20;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==5)
            {
                myRunnableThread rtt = new myRunnableThread();
                new Thread(rtt,"新线程1").start();
                new Thread(rtt,"新线程2").start();
            }
        }
    }
}

class myRunnableThread implements Runnable{
    private int i;
    @Override
    public void run() {
        for(i = 0;i <20;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}