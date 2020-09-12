package algorithm.exam.xiaomi0908; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.Solution2
 * Author:   Jianf
 * Date:     2020/9/8 18:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.Random;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/8
 * @since 1.0.0
 */
public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);


        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        String word = scanner.nextLine();
        System.out.println(isExist(board,word));

    }

    public static boolean isExist(char[][] board,String word){
        //使用回溯方法
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board,int i,int j,int index,String word){
        if(index==word.length()){
            return true;
        }
        if(i<0||i==board.length||j<0||j==board[0].length){
            return false;
        }

        if(board[i][j] != word.charAt(index)){
            return false;
        }

        char temp = board[i][j];
        board[i][j]='*';

        boolean res = helper(board,i+1,j,index+1,word)||
                helper(board,i-1,j,index+1,word)||
                helper(board,i,j-1,index+1,word)||
                helper(board,i,j+1,index+1,word);
        board[i][j]=temp;
        return res;
    }
}