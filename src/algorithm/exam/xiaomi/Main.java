/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.Main
 * Author:   Jianf
 * Date:     2020/8/31 20:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.xiaomi;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/8/31
 * @since 1.0.0
 */
import java.util.*;


public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        String string = PrintMinNumber(nums);
        System.out.println(string);
    }

    public static String PrintMinNumber(int [] numbers) {
       Integer[] integers = new Integer[numbers.length];
       for(int i=0;i<numbers.length;i++){
           integers[i]=numbers[i];
       }
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String strO1 = String.valueOf(o1);
                String strO2 = String.valueOf(o2);
                int xy = Integer.valueOf(strO1+strO2);
                int yx = Integer.valueOf(strO2+strO1);
                return xy-yx;
            }
        });
        return integers.toString();
    }

}