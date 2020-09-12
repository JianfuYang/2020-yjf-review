/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: StringSort
 * Author:   Jianf
 * Date:     2020/8/31 11:25
 * Description: 字符串排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.huawei;

import java.util.*;

public class StringSort{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(helper(str));
        }


    }

    /**
     * 解题思路：使用辅助容器分别记录英文字母的位置，使用Map容器记录其他字符及其位置
     */
    private static String helper(String str){

        if(str == null || str.length() == 1){
            return str;
        }

        char[] charArray = str.toCharArray();
        int len = charArray.length;

        ArrayList<Character> charArrayList = new ArrayList<>();
        //非英文字母的辅助容器，Integer表示出现位置
        Map<Integer,Character> othersMap = new HashMap<>();
        for(int i=0;i<len;i++){
            if(('A'<= charArray[i] && charArray[i] <= 'Z')||
                    ('a'<= charArray[i] && charArray[i] <= 'z')){
                //英文字符，将其放入容器中
                charArrayList.add(charArray[i]);
            }else{
                //非英文字符
                othersMap.put(i,charArray[i]);
            }
        }

        //结果辅助字符数组
        char[] resChar = new char[len];
        Arrays.fill(resChar,'A');
        //变量OtherMap，首先填充非英文字母
        for(Map.Entry<Integer,Character> entry:othersMap.entrySet()){
            resChar[entry.getKey()]=entry.getValue();
        }

        //对charArrayList进行排序
        Collections.sort(charArrayList, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                //排序规则
                if(Character.toLowerCase(o1)== Character.toLowerCase(o2)){
                    //如果转换成小写之后相等，则按出现位置排序
                    if((Character.isLowerCase(o1)&&Character.isLowerCase(o2))||
                            (Character.isUpperCase(o1)&&Character.isUpperCase(o2))){
                        return 0;
                    }
                    return 1;
                }else{
                     return (Character.toLowerCase(o1) - Character.toLowerCase(o2));
                }

            }
        });

//        System.out.println(charArrayList);

        //遍历，将charArrayList中的英文元素添加到结果数组中
        int index = 0;
        for(Character chara:charArrayList){
            while(resChar[index] != 'A'){
                //说明已经存在非英文字符了
                index++;
            }
            resChar[index++]=chara;
        }

        String resString = String.valueOf(resChar);

        return resString;
    }


}
