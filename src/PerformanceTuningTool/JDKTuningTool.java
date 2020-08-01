/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: JDKTuningTool
 * Author:   Jianf
 * Date:     2020/7/21 17:42
 * Description: 对JDK中涉及的若干性能调优及监测工具进行简单使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package PerformanceTuningTool;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈对JDK中涉及的若干性能调优及监测工具进行简单使用〉
 *
 * @author Jianf
 * @create 2020/7/21
 * @since 1.0.0
 */


/**
 * 测试思路：主函数里启动两个线程，每个线程都执行死循环，循环内部对一个Point对象坐标进行随机更新，当循环指定次数后向List中追加新的对象，使得堆空间不断增长
 */
class JDKTuningTool {

    public static List<BigClass> l1 = new ArrayList<>();
    public static List<BigClass> l2 = new ArrayList<>();

    public static void main(String[] args) {
        Thread t1=new Thread(new MyThread());
        t1.start();
        Thread t2 = new Thread(new MyThread2());
        t2.start();
    }
}