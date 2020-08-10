package algorithm.exam.wangyileihuo; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.wangyileihuo.algorithm.exam.tiger.Main
 * Author:   Jianf
 * Date:     2020/8/8 14:57
 * Description: 网易笔试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈网易笔试〉
 *
 * @author Jianf
 * @create 2020/8/8
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        int count = 0;
        for(int i=0;i<n;i++){
            count += helper(nums[i]);
        }
        System.out.println(count);
    }

    public static int helper(int num){
        if(num<=1){
            return 0;
        }
        int temp = num/2;
        int temp2 = num%2;

        if(temp2==0){
            //num为2的倍数
            return temp;
        }else{
            //
            return temp;
        }
    }

}


