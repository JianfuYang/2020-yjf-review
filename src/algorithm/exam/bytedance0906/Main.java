/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.Main
 * Author:   Jianf
 * Date:     2020/9/6 10:11
 * Description: 走楼梯问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.bytedance0906;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈走楼梯问题〉
 *
 * @author Jianf
 * @create 2020/9/6
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        helper(15);
    }

    public static int helper(int n){
        if(n<=0){
            return 0;
        }
        int[][] dp = new int[n+1][2];
        dp[0][0]=1;
        dp[0][1]=0;

        dp[1][0]=1;
        dp[1][1]=0;

        for(int i=2;i<=n;i++){
            //这次走一步的情况
            dp[i][0] = dp[i-1][0]+dp[i-1][1];
            //这次走两步的情况
            dp[i][1] = dp[i-2][0];
//            System.out.println("i:"+i+"; 这次走一步："+dp[i][0]+";这次走两步："+dp[i][1]);
        }
        System.out.println(dp[n][0]+dp[n][1]);
        return dp[n][0]+dp[n][1];
    }
}