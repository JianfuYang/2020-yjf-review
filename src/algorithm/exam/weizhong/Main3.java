/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main3
 * Author:   Jianf
 * Date:     2020/9/27 19:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.weizhong;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/27
 * @since 1.0.0
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] Ai = new int[n];
        for(int i=0;i<n;i++){
            Ai[i]=scanner.nextInt();
        }
        System.out.println(helper(n,Ai));

    }


    private static int helper(int n,int[] nums){
        if(nums.length<3){
            return 0;
        }
        int res = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]<=nums[j]&& nums[j]<=nums[k]){
                        res++;
                    }
                }
            }
        }
        return res;
    }


}