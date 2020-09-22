package algorithm.exam.qianxin; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.jingdong.algorithm.exam.wangyileihuo.algorithm.exam.tiger.algorithm.exam.beike.algorithm.exam.xiaomi0908.algorithm.exam.didi0913.interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/8/1 15:38
 * Description: kao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈kao〉
 *
 * @author Jianf
 * @create 2020/8/1
 * @since 1.0.0
 */

/**
 * 题目描述，输入一个数组，求数组组成的数是亲7数的个数==》全排列问题+求排列出的数组对应的数是亲7数的个数
 */
public class Main2 {

//    private static int count=0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[]{1,1,2};

        int count = permute(nums);
        System.out.println(count);
    }


    //全排列：题目给定的方法
    public int reletive_7 (int[] digit) {
        // write code here
        int count = permute(digit);
        return count;
    }

    //全排列
    public static int permute(int[] nums){

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num:nums){
            output.add(num);
        }
        int n= nums.length;
        return backtrack(n,output,0,0);

    }

    //使用回溯法进行全排列
    public static int backtrack(int n,ArrayList<Integer> output,int count,int first){
        //一次回溯完成条件
        if(first==n){

            //下面直接判断本次排列出的数是不是亲7数；如果这里要求的是全排列，将output保存到输出数组即可。
            int len = output.size();
            int temp=0;
            for(int j=0;j<len;j++){
                temp = temp*10+output.get(j);
            }
            //判断是不是亲7数
            if(temp%7==0){
                count++;
            }
        }
        //递归回溯
        for(int i=first;i<n;i++){
            Collections.swap(output,first,i);
            count = backtrack(n,output,count,first+1);
            Collections.swap(output,first,i);
        }
        return count;
    }




}