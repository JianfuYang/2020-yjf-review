package algorithm.backpack;

import java.util.Scanner;

/**
 * 二维背包问题：
 * 解题方法：和0-1背包、完全背包类似，
 *  需要多嵌套一次循环，进行第二个条件的判断选择
 *  对于如果是0-1背包类型的二维背包问题，循环内需要从大到小进行选择判断；
 *  对于如果是完全背包（可以有无限个）的二维背包问题，循环内需要从小到大进行选择判断。
 *
 */

/**
 * 有 N 件物品和一个容量是 V 的背包，背包能承受的最大重量是 M。
 *
 * 每件物品只能用一次。体积是 vi，重量是 mi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使物品总体积不超过背包容量，总重量不超过背包可承受的最大重量，且价值总和最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V,M，用空格隔开，分别表示物品件数、背包容积和背包可承受的最大重量。
 *
 * 接下来有 N 行，每行三个整数 vi,mi,wi，用空格隔开，分别表示第 i 件物品的体积、重量和价值。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N≤1000
 * 0<V,M≤100
 * 0<vi,mi≤100
 * 0<wi≤1000
 * 输入样例
 * 4 5 6
 * 1 2 3
 * 2 4 4
 * 3 4 5
 * 4 5 6
 * 输出样例：
 * 8
 */
public class Main2DimensionalBackpack {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //物品数量
        int v = sc.nextInt();  //背包体积
        int m = sc.nextInt();  //背包可承受的最大重量

        int[] vi = new int[n]; //每个物品体积
        int[] mi = new int[n]; //每个物品重量
        int[] wi = new int[n]; //每个物品价值


        for(int i=0;i<n;i++){
            vi[i] = sc.nextInt();
            mi[i] = sc.nextInt();
            wi[i] = sc.nextInt();
        }
        int res = helper(vi,mi,wi,n,v,m);
        System.out.println(res);
    }


    public static int helper(int[] vi,int[] mi,int[] wi,int n,int v,int m) {

        int[][] dp = new int[110][110];

        for(int i=0;i<n;i++){
            for(int j=v;j>=vi[i];j--){
                for(int k=m;k>=mi[i];k--){
                    dp[j][k] = Math.max(dp[j][k],dp[j-vi[i]][k-mi[i]]+wi[i]);
                }
            }
        }
        return dp[v][m];
    }
}