/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: 正负数稳定原地排序
 * Author:   Jianf
 * Date:     2020/9/2 17:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.leetcode;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/2
 * @since 1.0.0
 */
public class 正负数稳定原地排序 {

    public static void main(String[] args) {
        int[] nums = {-5,2,-3, 4,-8,-9, 1, 3,-10};
        int[] sort = sort(nums);
        for (int i:sort){
            System.out.print(i+" ");
        }


    }

    public static int[] sort(int[] nums){
        if(nums.length<=1){
            return nums;
        }
        int left=0;
        int right = nums.length-1;
        while(left<right){
            while(left<right && nums[right]>0){
                right--;
            }
            while(left<right && nums[left]<0){
                left++;
            }
            if(left<right){
                //left遇到正数，righ遇到负数
                int temp = nums[right];
                //将left~temp之间的数右移动一位
                System.arraycopy(nums,left,nums,left+1,right-left);
                nums[left++]=temp;
            }

        }
        return nums;
    }
}