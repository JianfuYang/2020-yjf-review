package algorithm.exam.didi0913; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.didi0913.interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/9/13 19:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/13
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nLine = Integer.valueOf(scanner.nextLine());

        for(int i=0;i<nLine;i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] nums = new int[m][3];
            for(int j=0;j<m;j++){
                nums[j][0] = scanner.nextInt();
                nums[j][1] = scanner.nextInt();
                nums[j][2] = scanner.nextInt();
            }
            System.out.println(helper(nums,n,k));
        }
    }


    public static String helper(int[][] nums,int n,int k){
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i][2]>k){
                continue;
            }
            //将关联的到放入set中
            if(!set.contains(nums[i][0])){
                set.add(nums[i][0]);
            }
            if(!set.contains(nums[i][1])){
                set.add(nums[i][1]);
            }
        }
//        System.out.println(set.size());
        return set.size()==n?"YES":"NO";
    }
}