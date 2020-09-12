package algorithm.exam.tiger; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.tiger.algorithm.exam.beike.algorithm.exam.xiaomi0908.Main
 * Author:   Jianf
 * Date:     2020/8/9 16:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/8/9
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
//        int[][] nums = {{2,1,4},{4,2,6}};
        int x = 2;
        int level=1;
        int[][] tasks=new int[][]{{0,1},{1,2},{1,3}};

        int max = maxLevel(2,1,tasks);

        System.out.println(max);
    }

    //第二题
    public static int maxLevel (int x, int level, int[][] tasks) {
        // write code here
        Arrays.sort(tasks,(o1,o2)->o2[1]-o1[1]);
        int[] dp = new int[x+1];
        dp[0]=level;

        int length = tasks.length;

        for(int i=0;i<x;i++){

            //找奖励最多且符合初始等级要求
            for(int j=0;j<length;j++){
                //是否满足初始等级要求
                if(tasks[j][0]<=level && tasks[j][1]>0){
                    level += tasks[j][1];
                    tasks[j][1] = 0;
                    break;
                }
            }
        }
        return level;
    }


    //第一题
    public static int helper(int[][] trips,int capacity){
//        Arrays.sort(trims,(o1,o2)->o1[2]-o2[2]);
        int stattionNums = trips[trips.length-1][2];

        int[] dp = new int[stattionNums+1];
        //初始站点的人数：
        dp[0]=0;
        int maxPerson = dp[0];
        for(int i=1;i<=stattionNums;i++){
            dp[i] = dp[i-1];
            for(int j=0;j<trips.length;j++){

                if(trips[j][1]==i){//在i站点上车
                    dp[i] += trips[j][0];
                }
            }
            for(int k=0;k<trips.length;k++){
                if(trips[k][2]==i){//在i站点下车
                    dp[i] -= trips[k][0];
                }
            }

            maxPerson = Math.max(dp[i],maxPerson);
            System.out.println("站点"+i+"人数："+dp[i]+";最大人数："+maxPerson);
        }
        return maxPerson%capacity==0?maxPerson/capacity:maxPerson/capacity+1;
    }


}