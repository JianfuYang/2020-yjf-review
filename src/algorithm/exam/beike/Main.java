package algorithm.exam.beike; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.beike.algorithm.exam.xiaomi0908.algorithm.exam.didi0913.Main
 * Author:   Jianf
 * Date:     2020/8/11 19:01
 * Description: 贝壳笔试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈贝壳笔试〉
 *
 * @author Jianf
 * @create 2020/8/11
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String string = scanner.nextLine();
//        System.out.println(string);
        char[] charArray = string.trim().toCharArray();
        int res = helper(charArray,n);
        System.out.println(res);
    }

    public static int helper(char[] chars,int n){
        if(n==1){
            return 0;
        }
        int count = 0;
        int left = 0;
        int right = n-1;
        while (left<right){
            if(chars[left] != chars[right]){
                count++;
            }
            left++;
            right--;
        }
        return count;
    }
}