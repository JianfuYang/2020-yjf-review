package algorithm.exam.jingdong; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.jingdong.algorithm.exam.wangyileihuo.algorithm.exam.tiger.algorithm.exam.beike.algorithm.exam.xiaomi0908.algorithm.exam.didi0913.Main
 * Author:   Jianf
 * Date:     2020/8/6 19:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 〈回文素数问题〉<br>
 * 〈〉
 *
 * @author Jianf
 * @create 2020/8/6
 * @since 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int count=0;
        for (int i = m; i <= n; i++) {
            boolean flag =false;
            if (i<10)
                continue;
            for (int j = 0; j < String.valueOf(i).length(); j++) {
                StringBuilder s = new StringBuilder(String.valueOf(i));
                int newi = Integer.parseInt(s.deleteCharAt(j).toString());
//                System.out.println(newi);
                if (isReverse(newi)&&isPrime(newi))
                {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);

    }

//    public static boolean primePalindrome(int N) {
//        boolean isPrime = true, isPalindrome = true;
//        // 判断是否为素数
//        for(int i=2, len = (int) Math.sqrt(N); i <= len; ++i) {
//            if(N % i == 0) {
//                isPrime = false;
//                break;
//            }
//        }
//        // 判断是否为回文数
//        String cs = String.valueOf(N);
//        for(int j=0, len = cs.length() >> 1; j < len; ++j) {
//            if(cs.charAt(j) != cs.charAt(cs.length() - j - 1)) {
//                isPalindrome = false;
//                break;
//            }
//        }
//        // 是回文数和素数
//        return isPrime && isPalindrome;
//    }


    //判断一个数是不是回文串
    private static boolean isReverse(int i){
        String s = String.valueOf(i);
        for(int j=0;j<s.length()/2;j++){
            if(s.charAt(j)!=s.charAt(s.length()-1-j)){
                return false;
            }
        }
        return true;
    }

    //判断一个数是不是素数
    private static boolean isPrime(int i){
        if(i<2){
            return false;
        }
        for(int j=2;j<=Math.sqrt(i);j++){
            if(i%j==0){
                return  false;
            }
        }
        return true;
    }


}