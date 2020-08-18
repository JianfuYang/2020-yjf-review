package algorithm.backpack;

import java.util.Scanner;

/**
 * 混合背包问题：
 *
 */
public class MainMixingBackpack {

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
    public static int helper(int[] vi,int[] wi,int[] si,int n,int x) {

        return 0;
    }
}