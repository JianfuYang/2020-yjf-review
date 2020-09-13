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
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(helper(m,n));
        }

    }

    public static int helper(int m,int n){
        if(m==1&&n==1){
            return 1;
        }
        if(m==1){
            if(n%2==0){
                return 2;
            }
            return n;
        }

        if(n==1){
            if(m%2==0){
                return 2;
            }
            return m;
        }
        if(m%2==0||n%2==0){
            return 2;
        }

        int mSqrt = mysqrt(m);
        int nSqrt = mysqrt(n);
        return Math.min(mSqrt,nSqrt);
    }


    //求一个数的开平方
    private static int mysqrt(int num){
        int sqrt = (int)Math.sqrt(num);
        if(sqrt*sqrt == num){
            return mysqrt(sqrt);
        }
        return num;
    }

}