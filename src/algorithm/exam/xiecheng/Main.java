/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.Main
 * Author:   Jianf
 * Date:     2020/9/8 19:31
 * Description: 敏感单词
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈敏感单词〉
 *
 * @author Jianf
 * @create 2020/9/8
 * @since 1.0.0
 */
public class Main {

    private static List<String> resList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String srcWord = scanner.nextLine().trim();
        String inputSegment = scanner.nextLine().trim();
        String dstWord = scanner.nextLine().trim();
       /* if(inputSegment==null){
            System.out.println(inputSegment);
            return;
        }


        if(srcWord==null||srcWord.length()==0||inputSegment.length()<srcWord.length()){
            System.out.println(inputSegment);
            return;
        }*/



        //下面对敏感单词的全排列进行替换
        //1.求全排列
        char[] src = srcWord.toCharArray();
        int[] memo = new int[src.length];
        permute(src,0,new ArrayList<>(),memo);
//        System.out.println(resList);

        for(String str:resList){
            inputSegment = inputSegment.replaceAll(str,dstWord);
        }
        System.out.println(inputSegment);
    }



    private static void permute(char[] srcWord,int index, List<Character> list,int[] memo){

        if(index==srcWord.length){
            StringBuilder temp = new StringBuilder();
            for(Character ch:list){
                temp.append(ch);
            }
            resList.add(temp.toString());
//            System.out.println(resList);
            return;
        }

        for(int i=0;i<srcWord.length;i++){
            if(memo[i]==1){
                continue;
            }
            memo[i]=1;
            list.add(srcWord[i]);
            permute(srcWord,index+1,list,memo);
            list.remove(list.size()-1);
            memo[i]=0;
        }
    }


}