/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main
 * Author:   Jianf
 * Date:     2020/9/21 18:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/21
 * @since 1.0.0
 */
public class Main {

    public static int i=0;

    public static void main(String[] args) {

    }


}


class myThread implements Runnable{

    @Override
    public void run() {
        
    }


    public synchronized void addI(int x){
        if(x<100){
            System.out.println(x);
            x++;
        }
    }

}