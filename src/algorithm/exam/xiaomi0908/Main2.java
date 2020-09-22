package algorithm.exam.xiaomi0908; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/8/22 19:54
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
 * @create 2020/8/22
 * @since 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] iChange = new int[M];
        for(int i=0;i<M;i++){
            iChange[i] = scanner.nextInt();
        }

        Map<Integer,Integer> map = new HashMap<Integer, Integer>() ;
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>(16,0.75f,true);

        Queue<Integer> queue = new ArrayDeque<>();






        int[] nums = new int[N];
        for(int i=0;i<N;i++){
            nums[i]=i+1;
        }

        for(int i=0;i<M;i++){

            if(iChange[i]==1){
                change1(nums);
            }else if(iChange[i]==2){
                if((i+1 <M) && iChange[i+1]==2) {
                    i++;
                    continue;
                }else{
                    change2(nums);
                }
            }
        }
        for(int nu:nums){
            System.out.print(nu+" ");
        }
    }


    public static void change1(int[] arr){
        int firstNum = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }

        arr[arr.length-1] = firstNum;
    }



    public static void change2(int[] arr){
        for(int i=0;i<arr.length-1;i+=2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }


}