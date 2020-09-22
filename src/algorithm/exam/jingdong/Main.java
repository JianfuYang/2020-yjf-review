package algorithm.exam.jingdong; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.jingdong.algorithm.exam.wangyileihuo.algorithm.exam.tiger.algorithm.exam.beike.algorithm.exam.xiaomi0908.algorithm.exam.didi0913.interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/8/6 19:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 〈数列求和〉<br>
 * 〈〉
 *
 * @author Jianf
 * @create 2020/8/6
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n==0){
            return;
        }
        DecimalFormat df = new DecimalFormat( "0.0000 ");
        System.out.println();
        double sum = 0;
        for(int i=1;i<=n;i++){
            double temp = 1/(5.0*(2*i-1))-1/(5.0*2*i);
//            System.out.println(temp);
            sum += temp;
        }

        System.out.println(df.format(sum));


    }


}