package algorithm.exam.kedaxunfei; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.jingdong.algorithm.exam.wangyileihuo.algorithm.exam.tiger.algorithm.exam.beike.Main
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
public class Exam1 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] moneyNums = new int[5];
        for(int i=0;i<5;i++){
            moneyNums[i]=sc.nextInt();
        }

        int moneySum = sc.nextInt();

        int count=counMinTimes2(moneySum,moneyNums);

        System.out.println(count);


    }




    private static int counMinTimes2(int sum,int[] array) {
        int[] coinsNum = new int[]{1, 5, 10, 50, 100};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(coinsNum[i], array[i]);
        }

        int count = 0;
        while (sum > 0) {
            if (sum >= 100) {
                if (map.get(100) > 0) {
                    map.put(100, map.get(100) - 1);
                    count++;
                    //System.out.println(count);
                    sum = sum - 100;
                    continue;
                }

            }
            if (sum >= 50) {
                if (map.get(50) > 0) {
                    map.put(50, map.get(50) - 1);
                    count++;
                    sum = sum - 50;
                    //System.out.println(count);
                    continue;
                }
            }
            if (sum >= 10) {
                if (map.get(10) > 0) {
                    map.put(10, map.get(10) - 1);
                    count++;
                    sum = sum - 10;
                    //System.out.println(count);
                    continue;
                }
            }
            if (sum >= 5) {
                if (map.get(5) > 0) {
                    map.put(5, map.get(5) - 1);
                    count++;
                    sum = sum - 5;
                    //System.out.println(count);
                    continue;
                }
            }
            {
                if (map.get(1) > 0) {
                    map.put(1, map.get(1) - 1);
                    count++;
                    sum = sum - 1;
                    //System.out.println(count);
                    continue;
                } else {
                    return -1;
                }

            }

        }
        return count;

    }
}