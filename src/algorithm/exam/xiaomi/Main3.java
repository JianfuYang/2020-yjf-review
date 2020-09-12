/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main3
 * Author:   Jianf
 * Date:     2020/8/31 19:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.xiaomi;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/8/31
 * @since 1.0.0
 */
import java.util.*;


public class Main3 {


    public static void main(String[] args) {
        long l = nextNarcissisticNumber(100);
        System.out.println(l);
    }
    /**
     * 找到比输入的整数大的下一个水仙花数
     * @param n int整型 输入的整数
     * @return long长整型
     */
    public static long nextNarcissisticNumber (int n) {
        // write code here
        if(n<9){
            return n+1;
        }

        while(true){
            if(isShuiNums(n,String.valueOf(n).length())){
                return n;
            }
            n++;
        }
    }


    private static boolean isShuiNums(int num,int len){

        long a =num;
        int sum =0;
        while(num>0){
            int temp = (int)(num%10);
            sum += Math.pow(temp,len);
            num = num/10;
        }
        return sum == a?true:false;

    }
}