/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main1
 * Author:   Jianf
 * Date:     2020/9/17 19:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.jingdong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/17
 * @since 1.0.0
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int leishu = 3; //道具的种类
        int price = 10;  //总价值的上限

        int[] si = {2,1,2}; //每种物品的数量
        int[] vi = {2,5,4}; //每个物品价格
        int[] wi = {3,10,12}; //每个物品魅力值
        int helper = helper(vi, wi, si, leishu, price);

        System.out.println(helper);
    }

    /**
     *
     * @param vi //每个物品价格
     * @param wi //每个物品魅力值
     * @param si //每种物品的数量
     * @param n //道具的种类
     * @param x //总价值的上限
     * @return
     */
    public static int helper(int[] vi,int[] wi,int[] si,int n,int x){
        /**
         * 多重背包:
         * f[i]总体积是i的情况下，最大价值是多少？
         * 多重背包问题相对于0-1背包问题的解法：0-1背包只能选择物品1次，多重背包可以选择si[i]次，
         * 在0-1背包问题的循环中增加多重循环判断即可
         */
        int[] dp = new int[x+1];
        for(int i=0;i<n;i++){
            //只有选择和不选择，不是无限选择问题，这里需要从大到小
            for(int j=x;j>=0;j--){
                //在此进行多次选择和不选择
                for(int k=1;k<=si[i]&&k*vi[i] <= j;k++){
                    dp[j] = Math.max(dp[j],dp[j-k*vi[i]]+k*wi[i]);
                }
            }
        }
        return dp[x];
    }

}


