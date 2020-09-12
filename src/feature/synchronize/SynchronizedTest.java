/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: SynchronizedTest
 * Author:   Jianf
 * Date:     2020/8/21 14:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.synchronize;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/8/21
 * @since 1.0.0
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<20;i++){
            arrayList.add(i+1);
        }

        int size = arrayList.size();
        int threadNums = 5;
        ArrayList resList = new ArrayList(size);
        for(int i=0;i<5;i++){
            new Thread(new MyThread(arrayList,i,5,resList)).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("处理后的list: "+resList);
        System.out.println("主线程结束");
    }
}

/**
 * arrayList:原始数组
 * integer:线程编号
 * threadNums:本次处理的总线程数
 */
class MyThread implements Runnable {

    private ArrayList arrayList;
    private Integer integer;
    private Integer threadNums;
    private ArrayList totalList;


    public MyThread(ArrayList arrayList,Integer integer,Integer threadNums,ArrayList totalList) {
        this.arrayList = arrayList;
        this.integer = integer;
        this.threadNums = threadNums;
        this.totalList = totalList;
    }

    @Override
    public void run() {
        int size = arrayList.size();
        int nums = size/threadNums;
        int startIndex =nums*integer;
        List list = arrayList.subList(startIndex, startIndex + nums);
        System.out.println("线程"+integer+": "+list);
        //todo:对list区间的处理

        synchronizedAddAll(totalList,list);
    }


    public synchronized boolean synchronizedAddAll(ArrayList dstList,List list){
        return dstList.addAll(list);
    }

}