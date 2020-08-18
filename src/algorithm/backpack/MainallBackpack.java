package algorithm.backpack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题特征描述：每件物品只能选或不选，可以选择无限次
 * 完全背包问题：
 * 有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。
 *
 * 第 i 种物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
 *
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 种物品的体积和价值。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N,V≤1000
 * 0<vi,wi≤1000
 * 输入样例
 * 4 5
 * 1 2
 * 2 4
 * 3 4
 * 4 5
 * 输出样例：
 * 10
 */
public class MainallBackpack {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //物品数量
        int x = sc.nextInt();  //背包体积

        int[] vi = new int[n+1]; //每个物品体积
        int[] wi = new int[n+1]; //每个物品价值

        for(int i=0;i<n;i++){
            vi[i] = sc.nextInt();
            wi[i] = sc.nextInt();
        }
        int res = helper(vi,wi,n,x);
        System.out.println(res);
    }

    //思路0-1背包问题一样，不过完全背包从小到大枚举
    public static int helper(int[] vi,int[] wi,int n,int x){
        int[] dp = new int[x+1];
        Arrays.fill(dp,0); //需要全部初始化成0
        //初始化，对于0体积0物品，最大总价值为0
        for(int i=0;i<=n;i++){
            //这里从小到大的原因是可以重复选择，每次更新时使用的dp[j]是上次刚更新过的；对于就j<vi[i]的情况，不需要更新跌打，直接跳过。
            for(int j=vi[i];j<=x;j++){
                dp[j] = Math.max(dp[j],dp[j-vi[i]]+wi[i]);
            }
        }
        return dp[x];
    }
    /**
     *  问题扩展，求总体积恰好为x时的总价值最大为多少？
     *  解题：在初始化dp时，只初始化dp[0]=0,其他全部初始化为Integer.MIN_VALUE,这样可确保所有的状态都是从dp[0]转移过来，从其他状态转移过来的全部都是负无穷。
     */

}