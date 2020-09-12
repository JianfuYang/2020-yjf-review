/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.Main
 * Author:   Jianf
 * Date:     2020/9/6 20:06
 * Description: 链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.tengxun0906;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈链表〉
 *
 * @author Jianf
 * @create 2020/9/6
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        for(int i=0;i<n1;i++){
            nums1[i] = scanner.nextInt();
        }
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        for(int i=0;i<n2;i++){
            nums2[i]=scanner.nextInt();
        }
    }
}