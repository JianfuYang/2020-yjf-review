/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: CreateThreadByCallable
 * Author:   Jianf
 * Date:     2020/8/6 10:01
 * Description: 通过Callable和Future创建线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 〈一句话功能简述〉<br> 
 * 〈通过Callable和Future创建线程〉
 *
 * @author Jianf
 * @create 2020/8/6
 * @since 1.0.0
 */
public class CreateThreadByCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallableThread myCallableThread = new MyCallableThread();
        FutureTask<Integer> ft = new FutureTask<>(myCallableThread);

        for(int i=0;i<15;i++){
            System.out.println(Thread.currentThread().getName()+"的循环变量i的值："+i);
            if(i==5){
                new Thread(ft,"有返回值的线程").start();
            }
        }
        //获取线程的返回值
        System.out.println("子线程的返回值："+ft.get());
    }
}


class MyCallableThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int i=0;
        for(;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i;
    }
}