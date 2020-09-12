/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Solution
 * Author:   Jianf
 * Date:     2020/8/31 17:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.huawei;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/8/31
 * @since 1.0.0
 */
import java.util.*;


public class Solution {


    public static void main(String[] args) {
        int[] a = new int[]{1,2,4,4,5};
        int i = upper_bound_(5, 4, a);
        System.out.println(i);
    }
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_ (int n, int v, int[] a) {


        // write code here
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)>>2;
            if(a[mid]>v){
                right = mid-1;
            }else if(a[mid]<v){
                left = mid+1;
            }else{
                if(mid-1 >=0 && a[mid-1]<v){
                    return a[mid];
                }else{
                    right = mid-1;
                }
            }
        }
        return a.length+1;
    }
}