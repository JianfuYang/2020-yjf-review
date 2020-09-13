/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main1
 * Author:   Jianf
 * Date:     2020/9/13 10:12
 * Description: 照镜子
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.meituandianping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈照镜子〉
 *
 * @author Jianf
 * @create 2020/9/13
 * @since 1.0.0
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] inputMatrix = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                inputMatrix[i][j] = scanner.nextInt();
            }
        }

        int[][] mixMatrix = findMixMatrix(inputMatrix, n, m);
        if(mixMatrix.length==0){
            return;
        }


        for(int i=0;i<mixMatrix.length;i++){
            for(int j=0;j<mixMatrix[0].length;j++){
                if(j!=mixMatrix[0].length-1){
                    System.out.print(mixMatrix[i][j]+" ");
                }else{
                    System.out.println(mixMatrix[i][j]);
                }
            }
//            System.out.println();
        }

    }

    public static int[][] findMixMatrix(int[][] matrix1,int n,int m){
        int[][] matrix = new int[n][m];
        System.arraycopy(matrix1,0,matrix,0,matrix1.length);

        if(n%2==1){ //奇数行的时候不用二分
            System.out.println(n);
            return matrix;
        }
        if(n<2){
            System.out.println(n);
            return matrix;
        }
        //将矩阵进行二分
        int n1 = n/2;
        int half = n1*m;
        int[][] top = new int[n1][m];
        int[][] bottom = new int[n1][m];

        //上半部分矩阵
        for(int i=0;i<n1;i++){
            for(int j=0;j<m;j++){
                top[i][j] = matrix[i][j];
            }
        }

        //下半部分矩阵
        for(int i=0;i<n1;i++){
            for(int j=0;j<m;j++){
                bottom[i][j] = matrix[i+n1][j];
            }
        }

        //比较上下两个数组是否相等，如果不相等，返回这个数组，如果相等，返回这个数据的一半
        boolean isEqual = true;
        for(int i=0;i<n1;i++){
            for(int j=0;j<m;j++){
//                System.out.println(i+":"+j+" top:"+top[i][j]+" bot:"+bottom[i][j]);
//                System.out.println(isEqual);
                if(top[i][j]!=bottom[n1-i-1][j]){

                    isEqual=false;
//                    System.out.println("n:"+n+" i:"+i+" j:"+j+isEqual);
                    break;
                }
            }
            if(!isEqual){
                break;
            }
        }

        if(isEqual){
            return findMixMatrix(top,n1,m);
        }else{
//            System.out.println(isEqual);
            return matrix;
        }

    }


}