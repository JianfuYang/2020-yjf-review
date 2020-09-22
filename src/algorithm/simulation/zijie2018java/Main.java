/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/8/20 9:20
 * Description: 往年真题：字节2018后端-Java
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.simulation.zijie2018java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈往年真题：字节2018后端-Java〉
 *
 * @author Jianf
 * @create 2020/8/20
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //用户个数
        int userNums = sc.nextInt();
        //用户的喜好度啊
        int[] favoriteNums = new int[userNums+1];
        for(int i=1;i<=userNums;i++){
            favoriteNums[i] = sc.nextInt();
        }

        //查询的组数
        int queryNums = sc.nextInt();
        for(int i=0;i<queryNums;i++){
            //左右区间及喜好值k
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(howFavorite(favoriteNums,l,r,k));
        }
    }

    public static int howFavorite(int[] favoriteNums,int l,int r,int k){
        Arrays.sort(favoriteNums);
        int res = 0;
        for(int i=l;i<=r;i++){
            if(favoriteNums[i]==k){
                res++;
            }
        }
        return res;
    }

}