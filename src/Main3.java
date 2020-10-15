/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main3
 * Author:   Jianf
 * Date:     2020/9/27 10:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/27
 * @since 1.0.0
 */
public class Main3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());
        String input = scanner.nextLine();


        System.out.println(helper(n,input));

    }


    private static int helper(int n,String string){
        char[] input = string.toCharArray();
        //表示考虑从字符串的第i为到第j为的长度时的最大差值
        int[][] memo = new int[n][n];
        memo[0][0] = 0;
        //i,j分别表示起始和终止字符位置
        for(int i=0;i<n;i++){
            if(input[i]=='E'){
                memo[i][0]=1;
            }else{
                memo[i][0]=0;
            }
            for(int j=i+1;j<n;j++){
                if(input[j]=='E'){
                    memo[i][j]=memo[i][j-1]+1;
                }else if(input[j]=='F'){
                    memo[i][j]=memo[i][j-1]-1;
                }
            }
        }
        //遍历找最大
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                res = Math.max(res,memo[i][j]);
            }
        }
        return res;
    }


}