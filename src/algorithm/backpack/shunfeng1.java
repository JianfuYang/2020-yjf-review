package algorithm.backpack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题特征描述：每件物品只能选或不选，只能选择一次。
 * 0-1背包问题：
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 * 第 i 件物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 *
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
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
 * 8
 */
public class shunfeng1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int[][] money = new int[m][2];
        for(int i=0;i<m;i++){
            money[i][0]=sc.nextInt();
            money[i][1]=sc.nextInt();
        }


    }



    public static int helper(int[] vi,int[] wi,int n,int x){


        int[][] dp = new int[n+1][x+1];
        //初始化，对于0体积0物品，最大总价值为0
        dp[0][0] = 0;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=x;j++){
                if(j>=vi[i]){ //当前背包体积大于该物品的体积,可以选和不选择
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-vi[i]]+wi[i]);
                }else{ //背包体积过小，不能选择该物品
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        //找到对于n个物品，体积不大于x的最大总价值
        int maxValue = 0;
        for(int k=0;k<=x;k++){
//            System.out.println(dp[n][k]);
            maxValue = Math.max(maxValue,dp[n][k]);
        }
        return maxValue;
    }


    //对动态规划的优化：二维优化成一维:只需考虑上当考虑前i-1个物品(体积为j)时的总价值大小，用来更新考虑前i个物品时(体积为j)的总价值大小
    //0-1背包从大到小枚举，完全背包从小到大枚举
    public static int helper2(int[] vi,int[] wi,int n,int x){
        int[] dp = new int[x+1];
        Arrays.fill(dp,0); //需要全部初始化成0
        //初始化，对于0体积0物品，最大总价值为0
        for(int i=0;i<=n;i++){
            //这里从大到小的原因是：保存dp[j]在这里使用的是dp[i-1][j]来更新状态，即是前一个物品的，还没有被当前物品修改过
            for(int j=x;j>=vi[i];j--){
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