/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: QuickSort
 * Author:   Jianf
 * Date:     2020/7/29 16:34
 * Description: 快速排序算法实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈快速排序算法实现〉
 *
 * @author Jianf
 * @create 2020/7/29
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        int[] SortedArray = new int[strings.length];
        for(int i=0;i<strings.length;i++){
            SortedArray[i]=Integer.valueOf(strings[i]);
        }

        //排序
        quickSort(SortedArray,0,SortedArray.length-1);
        //输出结果
        for(int i=0;i<strings.length;i++){
            System.out.print(SortedArray[i]+" ");
        }
    }

    /**
     * 快速排序原理：如果要排序数组中下标区间为[p,r]之间的一组数据，我们选择p到r之间的任意一个数据作为分区点privot(分区点),
     * 遍历p~r的数据，将小于privot的放左边,将大于privot的放右边，privot为中间；用递归排序下标p~q-1的数据和q+1~r的数据。
     * 直到区间缩小为1，说明所有的数据都有序了。
     * 时间复杂度O(logn),最坏情况时间复杂度O(n^2),空间复杂度O(1)
     */
    //a表示待排序数组，p表示待排序区间起始索引，r表示待排序区间终止索引
    public static void quickSort(int[] a,int p,int r){
        if(p>=r){
            return;
        }
        int q = partition(a,p,r); //获取分区点
        quickSort(a,p,q-1);
        quickSort(a,q+1,r);
        //输出结果
    }


    //将数据分区，返回分区点索引
    private static int partition(int[] a,int p,int r){

        int privot = a[p]; //选择分区值
        int start = p;
        int end = r;

        while (p<r){
            while(p<r&&a[r]>privot){
                r--;
            }
            while(p<r&&a[p]<=privot){
                p++;
            }
            //交换
            int tmp = a[r];
            a[r]=a[p];
            a[p]=tmp;
        }

        //因为每次都是拿第一位（a[p)作为分区值，所有第一位的值都是分区值，需要把该位置放到分区位置间隔线的位置
        //即循环退出时左指针p的位置
        int temp2=a[start];
//        System.out.println(temp2);
        a[start]=a[p];
        a[p]=temp2;

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

        return p;
    }

}