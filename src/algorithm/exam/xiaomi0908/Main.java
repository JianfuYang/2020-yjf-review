package algorithm.exam.xiaomi0908; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.Main
 * Author:   Jianf
 * Date:     2020/9/8 18:28
 * Description: 小米1
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈小米1〉
 *
 * @author Jianf
 * @create 2020/9/8
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String[] inputs = inputString.trim().split(" ");
        for(String string:inputs){
            System.out.println(helper(string));
        }
    }

    public static int helper(String str){
        char[] array = str.toCharArray();
        int len = array.length;
        if(len<8||len>120){
            return 1;
        }
        //数字
        boolean numFlag = false;
        //符号
        boolean SymbolFlag = false;
        //小写字母
        boolean lowerCharFlag = false;
        //大写字母
        boolean upperCharFlag = false;
        for(char ch:array){
            if(ch>='0'&&ch<='9'){
                numFlag =true;
                continue;
            }
            if(ch>='a'&&ch<='z'){
                lowerCharFlag =true;
                continue;
            }
            if(ch>='A'&&ch<='Z'){
                upperCharFlag =true;
                continue;
            }
            SymbolFlag =true;
        }
        if(numFlag&&SymbolFlag&&lowerCharFlag&&upperCharFlag){
            return 0;
        }else{
            return 2;
        }
    }

}