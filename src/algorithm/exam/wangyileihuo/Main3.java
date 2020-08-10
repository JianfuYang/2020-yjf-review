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

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈网易笔试〉
 *
 * @author Jianf
 * @create 2020/8/8
 * @since 1.0.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        if(t<1){
            return;
        }

        for(int i=1;i<t;i++){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int j=0;j<n;j++){
                a[j]= scanner.nextInt();
            }
            //下面进行数据的处理
            System.out.println(helper(a,n));
        }


    }


    public static int helper(int[] t,int n){
        Arrays.sort(t);

        int firstPerson = 0;
        int secondPerson = 0;

        int left = 0;
        int right = n-1;
        int max = 0;
        while(left<right){
            firstPerson += t[left++];
            secondPerson += t[left++];

            firstPerson += t[right--];
            secondPerson += t[right];

            if(left<right && firstPerson==secondPerson){
                max = Math.max(max,firstPerson);
            }
        }

        int sum=0;
        for(int nu:t){
            sum += nu;
        }
        return sum-max*2;
    }



}


