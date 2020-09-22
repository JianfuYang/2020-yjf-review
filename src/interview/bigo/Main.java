package interview.bigo; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/9/18 16:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/18
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        String string = "aabccaabbc";
        System.out.println(helper(string));
    }


    public static String helper(String input){
        char[] chars = input.toCharArray();
        if(chars.length<=1){
            return input;
        }

        //双指针
        int slow = 0;
        int fast = 1;
        StringBuilder res = new StringBuilder();
        res.append(chars[0]);

        int sameNums = 1;
        while(fast<chars.length){

            if(chars[fast]==chars[slow]){
                //相等
                sameNums++;
                fast++;
            }else{
                //不等时，需要更新指针，同时保存结果,字符数>1时才需要数字
                if(sameNums>1){
                    res.append(sameNums);
                }

                //新一个不同字符
                res.append(chars[fast]);
                sameNums=1;
                slow=fast;
                fast++;
            }
        }
        if(sameNums>1){
            res.append(sameNums);
        }
        return res.toString();
    }


}