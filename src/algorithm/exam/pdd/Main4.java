/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.jingdong.Main
 * Author:   Jianf
 * Date:     2020/8/2 18:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.pdd;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/8/2
 * @since 1.0.0
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int t = scanner.nextInt();

        int[][]  array = new int[6][6];
        for(int i=0;i<6;i++){
            for(int j=0;i<6;j++){
                array[i][j]=scanner.nextInt();
            }
        }



    }

    public static void helper(int[][] array){
        int[] feed = new int[]{1,2,3,4,5,6};

        int[][] memo = new int[8][8];

        for(int i=1;i<8;i++){
            for(int j=1;j<8;j++){
                if(((char)array[i][j])=='#'){
                    //判断四个
                }
            }
        }

    }



}