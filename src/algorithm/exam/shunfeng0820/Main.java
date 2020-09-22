/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/8/21 9:57
 * Description: 顺丰笔试第一题：出租服务器问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.shunfeng0820;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈顺丰笔试第一题：出租服务器问题(楼主有n个服务器，每个服务器有带宽，有m个客户，每个客户有需求带宽
 * 和可以付出的金钱，求最大收益)〉
 *
 * @author Jianf
 * @create 2020/8/21
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n个服务器
        int n = scanner.nextInt();
        //m个客户
        int m = scanner.nextInt();
        //服务器的带宽
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        //客户的购买需求，[0]表示需求的带宽，[1]表示可以付出的金钱
        int[][] clients = new int[m][2];
        for(int i=0;i<m;i++){
            clients[i][0] = scanner.nextInt();
            clients[i][1] = scanner.nextInt();
        }
        int res = maxIncome(n,nums,m,clients);
        System.out.println(res);

    }

    /**
     * 解题思路：对服务器按带宽升序排序，对客户按金钱降序排序，在金钱相等时，按带宽大小升序排序；
     * 贪心：尽量用最小的带宽获得最大的金钱收益（对应客户金钱多，带宽小的情况）
     * @param n 服务器数量
     * @param nums 服务器带宽信息
     * @param m 客户数
     * @param clients 客户信息：需求带宽信息和付出金钱数
     * @return 最大收益
     */
    public static int maxIncome(int n,int[] nums,int m,int[][] clients){
        //对客户需求排序，按金钱降序排序，在金钱相等时按带宽升序排序
        Arrays.sort(clients, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]){
                    //金钱数不等的情况，按照金钱降序排序
                    return o2[1]-o1[1];
                }else{
                    //金钱相等的情况，按照带宽升序排序
                    return o1[0]-o2[0];
                }
            }
        });
        //对服务器排序，按带宽升序排序即可
        Arrays.sort(nums);

        int ans=0; //收益
        int n_temp = n; //剩余的满足的客户数
        //对客户进行贪心遍历
        for(int i=0;i<m;i++){
            if(n_temp == 0){
                break;//客户已经全部满足了
            }
            for(int j=0;j<n;j++){ //对服务器进行遍历
                //给客户安排带宽刚刚够的服务器，将更大的服务器留给后面的客户
                if(nums[j]>=clients[i][0]){
                    n_temp--; //未满足的客户数减一
                    ans += clients[i][1]; //收益加成
                    nums[j] = -1; //将用过的服务器标记为-1
                    break;
                }
            }
        }
        return ans;
    }
}