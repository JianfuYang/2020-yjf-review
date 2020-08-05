package algorithm.exam.kedaxunfei; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main
 * Author:   Jianf
 * Date:     2020/7/10 20:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/7/10
 * @since 1.0.0
 */
public class Exam4 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputStr = sc.nextLine();


        System.out.println(helper(inputStr));




    }

    private static int helper(String string){

        char[] charArray = string.toCharArray();
        StringBuilder res = new StringBuilder();

        boolean flag = false;

        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='-'){
                flag=true;
            }else{
                if(charArray[i]>='0'&&charArray[i]<='9'){
                    res.append(charArray[i]);
                }
            }
        }
        int count = Integer.valueOf(res.toString());
        if(flag){
            count = -count;
        }
        return count;
    }




}