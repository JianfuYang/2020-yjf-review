/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Solution
 * Author:   Jianf
 * Date:     2020/9/5 20:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.wangyi0905;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/5
 * @since 1.0.0
 */
import java.lang.reflect.Array;
import java.util.*;
public class Solution {

    public static void main(String[] args) {
        System.out.println(StrToInt("-1a23"));

        ArrayList<Integer> list = new ArrayList<Integer>();

    }

    public static int StrToInt(String str) {
        char[] array = str.trim().toCharArray();
        int sum = 0;
        boolean sign = true;
        for(int i=0;i<array.length;i++){
            if(array[i]=='+'||array[i]=='-'){
                if(i!=0){
                    return 0;
                }
                if(array[i]=='+'){
                    sign = true;
                }else{
                    sign = false;
                }
                continue;
            }
            if(array[i]<'0'|| array[i]>'9'){
                return 0;
            }
            sum = sum*10 + Integer.parseInt(String.valueOf(array[i]));

        }
        return sign?sum:-sum;
    }
}