/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: LeetCodeTest
 * Author:   Jianf
 * Date:     2020/7/25 13:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.leetcode;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/7/25
 * @since 1.0.0
 */
public class LeetCodeTest {



    public static void main(String[] args) {
        int[] nums ={-4,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);


    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res;
        res = new ArrayList<List<Integer>>();
        threeSumHelper2(nums,res);
        return res;
    }

    //不使用双指针，使用多重循环+剪枝来完成
    private static void threeSumHelper2(int[] nums,List<List<Integer>> res){

        //先进行排序
        Arrays.sort(nums);
        int len = nums.length;
        //i代表第一个元素，下面的continue均用于去重
        for(int i=0;i<len-2;i++){
            System.out.println("i: "+i);
            if(nums[i]>0){
                return; //剪枝，所有的数均大于0.
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            
            for(int j=i+1;j<len-1;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                if(nums[i]+nums[j]>0){
                    break;
                }
                for(int k=len-1;k>j;k--){
                    if(k<len-1 &&nums[k]==nums[k+1]){
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[k]==0){
                        //满足条件，将其放置到结果数组中
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
            System.out.println("i2: "+i);
        }
    }





}