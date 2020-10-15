/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Solution
 * Author:   Jianf
 * Date:     2020/9/24 16:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/24
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);

        String version = scanner.nextLine();

        String version1 = version.substring(1,version.length()-1);
        String string = sortVersion(version);

        System.out.println(string);
    }


    /**
     * 给N个软件版本号的输入，按照字典序降序排序后输出。
     * @param versions string字符串 N个软件版本号
     * @return string字符串
     */
    public static String sortVersion (String versions) {



        // write code here
       String[] strings = versions.split(" ");

       Arrays.sort(strings, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               return o2.compareTo(o1);
           }
       });
        StringBuilder res = new StringBuilder();
        res.append("\"[");

        for(String string:strings){
            res.append(string+",");
        }
        res.deleteCharAt(res.length()-1);
        res.append("]\"");

        return res.toString();

    }




}