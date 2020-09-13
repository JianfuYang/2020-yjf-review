/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main5
 * Author:   Jianf
 * Date:     2020/9/13 11:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.meituandianping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/13
 * @since 1.0.0
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][3];
        for(int i=0;i<n;i++){
            nums[i][0]=i+1;
            nums[i][1]=scanner.nextInt();
            nums[i][2]=scanner.nextInt();
        }
        if(n==1){
            System.out.println(1);
            return;
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2]){
                    return o2[1]-o1[1];
                }else{
                    return o2[2]-o1[2];
                }
            }
        });
        for(int i=0;i<n-1;i++){
            System.out.print(nums[i][0]+" ");
        }
        System.out.println(nums[n-1][0]);
    }
}