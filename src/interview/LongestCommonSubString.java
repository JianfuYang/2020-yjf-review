/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: LongestCommonSubString
 * Author:   Jianf
 * Date:     2020/7/29 15:36
 * Description: 求字符串的最长公共子串题解
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package interview;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈求字符串的最长公共子串题解〉
 *
 * @author Jianf
 * @create 2020/7/29
 * @since 1.0.0
 */
public class LongestCommonSubString {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        //求两个字符串的最长公共子串长度
        int res = Lcss2(str1,str2);
        System.out.println(res);

    }


    /**
     * 方法1：r如果str1的长度为M,str2的长度为N,生成大小为M*N的数组dp,dp[i][j]表示str[0...i]与str2[0....j]的
     * 最长公共子串的长度(以i,j最右边结尾的)；
     * 计算dp[i][j]的方法如下：
     * (1) 特判情况：
     * 对于第一列dp[0...m-1][0],对于某个位置(i,0)，如果str1[i]=str2[0],则dp[i][0]=1,否则dp[i][0]=0;
     * 对于第一行dp[0][0...n-1],对于某个位置(0,j),如果str1[0]=str2[j],则dp[0][i]=1,否则dp[0][j]=0;
     * (2)其他情况：从左到右，从上到下计算：
     * 如果str1[i]=str2[j],则dp[i][j]=dp[i-1][j-1]+1;
     * 如果str1[i]!=str2[j],则dp[i][j]=0;
     * 空间复杂度：O(M*N);时间复杂度O(M*N)
     */
    public static int Lcss(String firstString,String secondString){
        char[] str1 = firstString.toCharArray();
        char[] str2 = secondString.toCharArray();
        int m = str1.length;
        int n = str2.length;
        if(m==0||n==0){
            return 0;
        }

        //创建辅助矩阵dp,利用动态规划算法解题
        int dp[][] = new int[m][n];

        //特判情况
        for(int i=0;i<m;i++){
            if(str1[i]==str2[0]){
                dp[i][0]=1;
            }else{
                dp[i][0]=0;
            }
        }
        for(int j=0;j<n;j++){
            if(str1[0]==str2[j]){
                dp[0][j]=1;
            }else{
                dp[0][j]=0;
            }
        }
        //其他情况，动态规划
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(str1[i]==str2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
            }
        }
        //遍历结果集合，找最大的数即是
        int max = dp[0][0];
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    //方法2：和方法1一样，优化空间复杂
    //思路：计算每一个dp[i][j]的时候只需要计算dp[i-1][j-1],所以按照斜线方向计算所有的值，只需要一个变量就可计算出
    public static int Lcss2(String firstString,String secondString) {
        char[] str1 = firstString.toCharArray();
        char[] str2 = secondString.toCharArray();
        int m = str1.length;
        int n = str2.length;
        if(m==0||n==0){
            return 0;
        }
        int len=0,max=0;
        int row=0;
        int col=n-1;
        //计算矩阵中的每一条斜对角线上的值
        while(row<m){
            int i=row;int j=col;
            while(i<m && j<n){
                if(str1[i]==str2[j]){
                    len++;
                    max = Math.max(max,len);
                }else{
                    len=0;
                }
                i++;
                j++;
            }
            if(col>0){
                col--;
            }else{
                row++;
            }
        }
        return max;
    }

}