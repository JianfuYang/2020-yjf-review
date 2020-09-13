/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.Main
 * Author:   Jianf
 * Date:     2020/8/21 19:55
 * Description: 第二题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈第二题〉
 *
 * @author Jianf
 * @create 2020/8/21
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] res = fiboNaQ(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static int[][] fiboNaQ(int n){
        Integer[] dp = new Integer[n*n];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n*n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        Arrays.sort(dp,(o1,o2)->o2-o1);
        int row = 0;
        int col = 0;
        int[][] res = new int[n][n];
        int index = 0;

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        while(index<n*n){
            //先行
            while(col<=right){
                if(index==n*n){
                    return res;
                }
//                System.out.print("row:"+row+" col:"+col+ " "+dp[index]+" ");
                res[row][col] = dp[index++];
                col++;
            }
            top++;
//            System.out.println();
            //再列
            col--;
            row++;
            while(row<=bottom){
                if(index==n*n){
                    return res;
                }
//                System.out.print("row:"+row+" col:"+col+ " "+dp[index]+" ");
                res[row][col] = dp[index++];
                row++;
            }
            right--;
//            System.out.println();

            //再行反向
            row--;
            col--;
            while(col>=left){
                if(index==n*n){
                    return res;
                }
//                System.out.print("row:"+row+" col:"+col+ " "+dp[index]+" ");
                res[row][col]=dp[index++];
                col--;
            }
            left++;
//            System.out.println();

            //列，自下而上
            col++;
            row--;
            while (row>=top){
                if(index==n*n){
                    return res;
                }
//                System.out.print("row:"+row+" col:"+col+ " "+dp[index]+" ");
                res[row][col] = dp[index++];
                row--;
            }
            bottom--;
//            System.out.println();

            row++;
            col++;
        }
        return res;
    }
}