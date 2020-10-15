/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main1
 * Author:   Jianf
 * Date:     2020/9/27 19:36
 * Description: 近似值查询
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.weizhong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈近似值查询〉
 *
 * @author Jianf
 * @create 2020/9/27
 * @since 1.0.0
 */
public class Main1 {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int q = Integer.valueOf(s[1]);

        int[] nums = new int[n];

        String[] strings = scanner.nextLine().split(" ");
        for(int i=0;i<n;i++){
            nums[i] = Integer.valueOf(strings[i]);
        }
        for(int i=0;i<q;i++){

            int input = scanner.nextInt();
            //int helper = helper(n, nums, input);
            //System.out.println(helper);
            int[] left = helper3(n, nums, input);
            int[] right = helper2(n, nums, input);

            if(left[0]==0){
                System.out.println(left[1]);
                continue;
            }

            if(left[0]<=right[0]){
                System.out.println(left[1]);
                continue;
            }else{
                System.out.println(right[1]);
                continue;
            }

        }
*/
        int value = 2;

       int[] nums = new int[]{1,2,3,4,5};
        Arrays.sort(nums);


        int[] left = helper3(5, nums, value);
        int[] right = helper2(5, nums, value);

        if(left[0]==0){
            System.out.println(left[1]);
            return;
        }

        if(left[0]<=right[0]){
            System.out.println(left[1]);
            return;
        }else{
            System.out.println(right[1]);
            return;
        }

    }


    private static int helper(int n,int[] nums,int value){

        int lastestValue = nums[0];
        int minCha = Math.abs(nums[0]- value);

        for(int i=1;i<n;i++){
            if (Math.abs(nums[i] - value)> minCha) {
                continue;
            }else if(Math.abs(nums[i] - value) == minCha){
                if(nums[i]<lastestValue){
                    lastestValue = nums[i];
                }
            }else{
                minCha = Math.abs(nums[i]-value);
                lastestValue = nums[i];
            }
        }
        return lastestValue;
    }


    //使用二分法来查找大于等于它的值
    private static int[] helper2(int n,int[] nums,int value){

        if(nums[n-1]<value){
//            System.out.println("test。。。");
            return new int[]{Math.abs(nums[n-1]-value),nums[n-1]};
        }
        if(n==1){
            return new int[]{Math.abs(nums[0]-value),nums[0]};
        }

        //二分法查找大于等于它的值
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left<right){
            mid = (right+left)/2;
            if(nums[mid]>value){
                right = mid;
            }else if(nums[mid]==value){
                return new int[]{0,nums[mid]};
            }else{
                left = mid+1;
            }

        }
        return new int[]{Math.abs(nums[right]-value),nums[right]};
    }


    private static int[] helper3(int n,int[] nums,int value){

        if(nums[n-1]<value){
//            System.out.println("test。。。");
            return new int[]{Math.abs(nums[n-1]-value),nums[n-1]};
        }

        if(n==1){
            return new int[]{Math.abs(nums[0]-value),nums[0]};
        }

        if(nums[0]>value){
            System.out.println(nums[0]);
            return new int[]{Math.abs(nums[0]-value),nums[0]};
        }

        //二分法查找大于等于它的值
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left<right){
            mid = (right+left)/2;
            if(nums[mid]>value){
                right = mid-1;
            }else if(nums[mid]==value){
                return new int[]{0,nums[mid]};
            }else{
                left = mid;
            }

        }
        return new int[]{Math.abs(nums[right]-value),nums[right]};
    }





}