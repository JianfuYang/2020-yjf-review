/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.didi0913.interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/9/12 19:36
 * Description: 去掉字符串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.jianxinjinrong;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈去掉字符串〉
 *
 * @author Jianf
 * @create 2020/9/12
 * @since 1.0.0
 */
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  string = sc.nextLine();
        System.out.println(helepr(string));

    }


    private static String helepr(String input){
        StringBuilder res = new StringBuilder();

        char[] array = input.toCharArray();

        for(int i=0;i<array.length;i++){
            if((i<array.length-2)&&(array[i]=='c'||array[i]=='C')&&(array[i+1]=='o'||array[i+1]=='O')&&
                    (array[i+2]=='c'||array[i+2]=='C')){
                //判断接下来的两位是否相同
                i = i+2;
            }else{
                res.append(array[i]);
            }
        }
        return res.toString();
    }
}