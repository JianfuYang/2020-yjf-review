package algorithm.backpack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 多重背包问题：
 * 有 N 种物品和一个容量是 V 的背包。
 *
 * 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
 *
 * 接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N,V≤100
 * 0<vi,wi,si≤100
 * 输入样例
 * 4 5
 * 1 2 3
 * 2 4 1
 * 3 4 3
 * 4 5 2
 * 输出样例：
 * 10
 */
public class MainMultipleBackpack {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //物品数量
        int x = sc.nextInt();  //背包体积

        int[] vi = new int[n]; //每个物品体积
        int[] wi = new int[n]; //每个物品价值
        int[] si = new int[n]; //每种物品的数量

        for(int i=0;i<n;i++){
            vi[i] = sc.nextInt();
            wi[i] = sc.nextInt();
            si[i] = sc.nextInt();
        }
        int res = helper(vi,wi,si,n,x);
        System.out.println(res);
    }

    /**
     * 适用于小数据量：100*100*100
     * @param vi
     * @param wi
     * @param si
     * @param n
     * @param x
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

    /**
     * 扩展：两种优化方法
     * （1）：多重背包的二进制优化方法
     * 适用数据量：1000*1000*1000
     */
    /**
     * 将多重背包问题转换到0-1背包问题：二进制拆分
     */

}