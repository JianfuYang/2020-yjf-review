package algorithm.exam.duxiaoman; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: interview.bigo.Mainduxiaoman
 * Author:   Jianf
 * Date:     2020/9/20 21:13
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
 * @create 2020/9/20
 * @since 1.0.0
 */
public class Mainduxiaoman {
    //测试示例
    public static void main(String[] args) {
        String own = "AAB";
        String need = "ABC";
        System.out.println(helper(own,need));
    }
    //解题函数
    public static int helper(String own,String need){
        char[] owns = own.toCharArray();
        char[] needs = need.toCharArray();
        //统计已有的颜料数
        int[] memo = new int[26];
        Arrays.fill(memo,0);
        for(char ch:owns){
            memo[ch-'A']++;
        }
        //消除颜料
        for(char ne:needs){
            if(memo[ne-'A']>0){
                memo[ne-'A']--;
            }
        }
        //统计剩下多少颜料
        int count=0;
        for(int i:memo){
            count = count+i;
        }
        //返回他们的差即是已涂的颜料
        return owns.length-count;
    }






}