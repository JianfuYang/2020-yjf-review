/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main4
 * Author:   Jianf
 * Date:     2020/9/6 21:03
 * Description: 播放音乐问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.tengxun0906;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈播放音乐问题〉
 *
 * @author Jianf
 * @create 2020/9/6
 * @since 1.0.0
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();

        int res = helpr(n,nums,m);
        System.out.println(res);
    }

    public static int helpr(int n,int[] nums,int m){
        Arrays.sort(nums);//为了找到最大的元素，剔除出去
        int max = nums[nums.length-1];
        int x = m-1;

        int[] dp = new int[x+1];
        Arrays.fill(dp,0);
        for(int i=0;i<nums.length-1;i++){
            for(int j=x;j>=nums[i];j--){
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
            System.out.println("考虑前面："+i+" 首歌："+ dp[x]);
        }
        return dp[x]+max;
    }


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
}