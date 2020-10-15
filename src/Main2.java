/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main2
 * Author:   Jianf
 * Date:     2020/9/24 16:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/24
 * @since 1.0.0
 */
import java.util.*;


public class Main2 {

    public static void main(String[] args) {
        encode("AA");

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 字符串编码
     * @param srcStr string字符串 ASCII码字符串，不涉及中文
     * @return string字符串
     */
    public static void encode (String srcStr) {
        // write code here\
        char[] str2Char = srcStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(char ch:str2Char){
            stringBuilder.append(Integer.toBinaryString(ch));
        }

        System.out.println(stringBuilder.toString());

    }


}