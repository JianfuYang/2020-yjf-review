/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.jingdong.algorithm.exam.wangyileihuo.algorithm.exam.tiger.algorithm.exam.beike.algorithm.exam.xiaomi0908.algorithm.exam.didi0913.interview.bigo.Main
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
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        int[] distance = new int[k];
        for(int i=0;i<n;i++){
            distance[i]=scanner.nextInt();
        }

        int[] res = helper(distance,k,n);
        if(res[0]==0&&res[1]==0){
            System.out.println("paradox");
        }else{
            System.out.println(res[0]+" "+res[1]);
        }
    }


    public static int[] helper(int[] distance,int k,int n){

        int backNums = 0;
        for(int i=0;i<n;i++){
            if(k>distance[i]){
                k = k- distance[i];
            }else if(k<distance[i]){
                k = distance[i]-k;
                backNums++;
            }else{
                //满足终止添加
                return new int[]{0,0};
            }
        }
        return new int[]{k,backNums};
    }
}