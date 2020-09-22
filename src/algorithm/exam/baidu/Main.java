/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/9/3 19:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.baidu;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/3
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        System.out.println(helper(nums,n));
    }

    public static long helper(int[] nums,int n){
        //分别统计5和0的个数
        int num0 =0;
        int num5 = 0;
        for(int num:nums){
            if(num==0){
                num0++;
            }else if(num==5){
                num5++;
            }
        }
        if(num0==0||num5==0||num5==1){
            return -1;
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<num5;i++){
            stringBuilder.append('5');
        }
        for(int i=0;i<num0;i++){
            stringBuilder.append('0');
        }

        String string= stringBuilder.toString();
        int len =string.length();
        for(int i=0;i<len-1;i++){
            long temp = Long.valueOf(string.substring(i));
            if(temp%90==0){
                return temp;
            }
        }

        return -1;
    }
}