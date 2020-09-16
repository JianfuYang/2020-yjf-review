/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main
 * Author:   Jianf
 * Date:     2020/9/16 21:01
 * Description: 丑数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.tianyiyun;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈丑数〉
 *
 * @author Jianf
 * @create 2020/9/16
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(nUglyNum(n));
    }

    private static int nUglyNum(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int a2 = 0;
        int b3 = 0;
        int c5 = 0;

        for(int i=1;i<n;i++){
            int m2 = dp[a2]*2;
            int m3 = dp[b3]*3;
            int m5 = dp[c5]*5;

            int min=Math.min(m2,Math.min(m3,m5));

            dp[i]=min;
            if(m2==min){
                a2++;
            }
            if(m3==min){
                b3++;
            }
            if(m5==min){
                c5++;
            }
        }
        return dp[n-1];
    }
}