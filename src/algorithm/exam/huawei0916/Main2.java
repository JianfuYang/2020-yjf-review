/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main2
 * Author:   Jianf
 * Date:     2020/9/16 20:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.huawei0916;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/16
 * @since 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end =scanner.nextInt();

        int N = scanner.nextInt();


        Set<Integer> set = new HashSet<Integer>();

        for(int i=0;i<N;i++){
            set.add(scanner.nextInt());
            set.add(scanner.nextInt());
        }

        set.remove(start);
        set.remove(end);

        int res = 0;
        for(Integer temp:set){
            res += temp;
        }

        System.out.println(res);
    }
}