package algorithm.exam.kedaxunfei; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.jingdong.algorithm.exam.wangyileihuo.algorithm.exam.tiger.algorithm.exam.beike.algorithm.exam.xiaomi0908.algorithm.exam.didi0913.interview.bigo.Main
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
public class Exam3 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y1 = sc.nextInt();
        int y2 = sc.nextInt();
        int y3 = sc.nextInt();
        int y4 = sc.nextInt();

        int count=helper(x1,y1,x2,y2,x3,y3,x4,y4);

        System.out.println(count);


    }

    private static int helper(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4){
        //考虑x的情况



        if(y1<y3&&y3<y2){
            return 1;
        }

        return 0;

    }




}