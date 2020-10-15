/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main
 * Author:   Jianf
 * Date:     2020/10/14 16:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/10/14
 * @since 1.0.0
 */
import java.util.*;

class Main {
    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";

        System.out.println(compareVersion(version1,version2));
    }


    public static int compareVersion(String version1, String version2) {

        //字符串切割
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        System.out.println(ver1.length);
        System.out.println(ver2.length);

        int index = 0;
        while(index<ver1.length&&index<ver2.length){
            //进行比较
            int v1 = Integer.parseInt(ver1[index]);
            int v2 = Integer.parseInt(ver2[index]);

            if(v1>v2){
                return 1;
            }else if(v1<v2){
                return -1;
            }else{
                //相等时需要进行下一步的判断
                index++;
            }
        }
        //判断版本号长度
        if(index==ver1.length&&index==ver2.length){
            return 0;
        }else if(index <ver1.length){
            return 1;
        }else{
            return -1;
        }
    }

}