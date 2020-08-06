/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: CreateThreadbyExtendsThread
 * Author:   Jianf
 * Date:     2020/8/6 9:44
 * Description: 通过继承Thread类来创建线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.multithread;

/**
 * 〈一句话功能简述〉<br> 
 * 〈通过继承Thread类来创建线程〉
 *
 * @author Jianf
 * @create 2020/8/6
 * @since 1.0.0
 */
public class CreateThreadbyExtendsThread {

    public static void main(String[] args) {
        for(int i = 0;i< 50;i++)
        {
            //Thread.currentThread()方法返回当前正在执行的线程对象。GetName()方法返回调用该方法的线程的名字。
            System.out.println(Thread.currentThread().getName()+"  : "+i);
            if(i==5)
            {
                new myThread().start();
                new myThread().start();
            }
        }
    }
}


class myThread extends Thread{
    int i=0;

    @Override
    public void run(){
        for(;i<15;i++){
            System.out.println(getName()+"  "+i);
        }
    }
}