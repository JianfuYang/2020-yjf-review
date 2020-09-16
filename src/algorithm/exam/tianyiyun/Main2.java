/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main2
 * Author:   Jianf
 * Date:     2020/9/16 21:11
 * Description: 删除字符
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.tianyiyun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈删除字符〉
 *
 * @author Jianf
 * @create 2020/9/16
 * @since 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(deleteChar(input));

    }


    private static String deleteChar(String string){
        char[] chars = string.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        for(char ch:chars){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int lessest = Integer.MAX_VALUE;

        for(char c:chars){
            //得到出现次数最少的次数
            lessest = Math.min(lessest,map.get(c));
        }


        StringBuilder res = new StringBuilder();
        for(char ch:chars){
            if(map.get(ch)==lessest){
                continue;
            }
            res.append(ch);
        }
        return res.toString();
    }
}