/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.didi0913.Main2
 * Author:   Jianf
 * Date:     2020/9/12 19:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.jianxinjinrong;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/12
 * @since 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dictInput = scanner.nextLine();
        String userInput = scanner.nextLine();
        if((dictInput==null&&userInput==null)||(dictInput.length()==0&&userInput.length()==0))
        {
            System.out.println("[]");
            return;
        }
        dictInput = dictInput.substring(1,dictInput.length()-1);
        userInput = userInput.substring(1,userInput.length()-1);

        List<String> helper = helper(dictInput, userInput);
        System.out.print("[");
        for(int i=0;i<helper.size()-1;i++){
            System.out.print(helper.get(i)+",");
        }
        System.out.print(helper.get(helper.size()-1)+"]");
    }

    private static List<String> helper(String dictInput,String userInput){
        List<String> res = new ArrayList<>();

        String[] dictSplit = dictInput.split(" ");
        String[] userSplit = userInput.split(" ");
        if(dictSplit.length==0&&userSplit.length==0){
            return new ArrayList<>();
        }

        List<String> dict = new ArrayList<>();
        Map<String,Integer> dictMap = new HashMap<String,Integer>();
        for(String string:dictSplit){
            dict.add(string);
            dictMap.put(string,dictMap.getOrDefault(string,0)+1);
        }

        List<String> user = new ArrayList<>();
        Map<String,Integer> userMap = new HashMap<>();
        for(String s:userSplit){
            user.add(s);
            userMap.put(s,userMap.getOrDefault(s,0)+1);
        }

        //找出在用户输入语句中未出现的单词
        for(String useInputWord:userSplit){
            if(dict.contains(useInputWord)){
                dict.remove(useInputWord);//将其从文本库中删掉
                user.remove(useInputWord); //将其同时从用户输入中删掉
            }
        }


        for(String d:dict){
            if(dictMap.getOrDefault(d,0)==1){
                res.add("\""+d+"\"");
            }
        }

        for(String u:user){
            if(userMap.getOrDefault(u,0)==1){
                res.add("\""+u+"\"");
            }
        }

        return res;
    }
}