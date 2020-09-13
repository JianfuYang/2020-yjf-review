/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.Main
 * Author:   Jianf
 * Date:     2020/9/8 19:31
 * Description: 敏感单词
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.xiecheng;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈敏感单词〉
 *
 * @author Jianf
 * @create 2020/9/8
 * @since 1.0.0
 */
public class Main2 {


    private static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] input = string.trim().split(" ");

        if(string==null||string.length()==0){
            return;
        }

        helper(input,0,new ArrayList<Character>(),false);

        String[] resString = new String[res.size()];
        for(int i=0;i<res.size();i++){
            resString[i]=res.get(i);
        }
        Arrays.sort(resString);
        for(String reStr:resString){
            System.out.println(reStr);
        }

    }


    public static void helper(String[] strings,int index,ArrayList<Character> temp,boolean isCircle){
        if(index==strings.length){
            StringBuilder stringBuilder = new StringBuilder();
            for(Character c:temp){
                stringBuilder.append(c);
            }

            if(isCircle){
                res.add(stringBuilder.toString()+"--circular dependency");
            }else{
                res.add(stringBuilder.toString());
            }
            return;
        }
        //还没有到最后一个字符
        char[] charArray = strings[index].toCharArray();
        for(char ch:charArray){
            boolean flag = isCircle;
            if(temp.contains(ch)){
                //s说明存在循环
                flag=true;
            }
            temp.add(ch);
            helper(strings,index+1,temp,flag);
            temp.remove(temp.size()-1);
        }

    }



}