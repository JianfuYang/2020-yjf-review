/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main2
 * Author:   Jianf
 * Date:     2020/9/13 11:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.meituandianping;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/13
 * @since 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] beatiful = new int[n];
        for(int i=0;i<n;i++){
            beatiful[i] = scanner.nextInt();
        }

        System.out.println(helper(beatiful,n,m,k));

    }


    private static int helper(int[] beatiful,int n,int m,int k){
        int left = 0;
        int right = 0;
        int end = n;
        int res = 0;
        while(right<=(end-m)){
            boolean flag = true;
            for(int i=right;i<right+m;i++){
                if(beatiful[i]<k){
                    flag = false;
                    break;
                }
            }
            if(flag){
                right++;
                res++;
            }else{
                right ++;
            }
        }
        return res;
    }
}