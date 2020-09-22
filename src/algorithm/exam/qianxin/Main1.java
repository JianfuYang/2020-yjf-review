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

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈奇安信第一题：完全背包问题〉
 *
 * @author Jianf
 * @create 2020/8/1
 * @since 1.0.0
 */
public class Main1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int allCount = scanner.nextInt();
        int n = scanner.nextInt();

        int[] money = new int[n];
        int[] values = new int[n];

        for(int i=0;i<n;i++){
            money[i]=scanner.nextInt();
            values[i]=scanner.nextInt();
        }

        int[] dp = new int[allCount+1];
        for(int i=0;i<n;i++){
            for(int j=money[i];j<=allCount;j++){
                dp[j]=Math.max(dp[j],dp[j-money[i]]+values[i]);
            }
        }
        System.out.println(dp[allCount]);
    }

}