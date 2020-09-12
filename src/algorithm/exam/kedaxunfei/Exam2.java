package algorithm.exam.kedaxunfei; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.jingdong.algorithm.exam.wangyileihuo.algorithm.exam.tiger.algorithm.exam.beike.algorithm.exam.xiaomi0908.Main
 * Author:   Jianf
 * Date:     2020/7/10 20:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/7/10
 * @since 1.0.0
 */

public class Exam2{
    static int[] data;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        data = new int[num];
        for(int i=0;i<num;i++){
            data[i]=sc.nextInt();
        }
        sort(0,num-1);
    }

    public static void sort(int left,int right){
        if (left>=right) return;
        int start = left;
        int end = right;
        int now = data[left];
        while (left<right){
            int n;
            int m;
            while (left<right&&data[right]>now){
                right--;
            }
            while(left<right&&data[left]<=now){
                left++;
            }
            int tmp = data[right];
            data[right] =data[left];
            data[left] =tmp;
        }
        int p = data[start];
        data[start] = data[left];
        data[left] = p;
        print();
        sort(start,left-1);
        sort(left+1,end);
    }

    public static void print(){
        for(int i=0;i<data.length;i++){
            if (i==data.length-1){
                System.out.println(data[i]);
                return;
            }
            System.out.print(data[i]+" ");
        }
    }
}