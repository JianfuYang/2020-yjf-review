/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.jingdong.algorithm.exam.wangyileihuo.algorithm.exam.tiger.Main
 * Author:   Jianf
 * Date:     2020/8/2 18:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.pdd;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/8/2
 * @since 1.0.0
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int t = scanner.nextInt();

        int[] xi = new int[n];
        int[] yi = new int[n];

        int[] xj = new int[m];
        int[] yj = new int[m];

        for(int i=0;i<n;i++){
            xi[i]=scanner.nextInt();
            yi[i]=scanner.nextInt();
        }

        for(int i=0;i<m;i++){
            xj[i]=scanner.nextInt();
            yj[i]=scanner.nextInt();
        }

        int ret = helper(n,xi,yi,m,xj,yj,t);
        System.out.println(ret);
    }


    public static int helper(int n,int[] xi,int[] yi,int m,int[] xj,int[] yj,int k){
        if(k==0){
            return 0;
        }

        int[] dp = new int[k];
        dp[0]=0;

        //计算早餐
        int[][] morning = new int[n][2];
        for(int i=0;i<n;i++){
            morning[i][0]=xi[i];
            morning[i][1]=yi[i];
        }

        //计算吃午餐的美味值
        int[][] nood =new int[m][2];
        for(int j=0;j<m;j++){
            nood[j][0]=xj[j];
            nood[j][1]=yj[j];
        }

        int[] maxMemo = new int[2];
        maxMemo[0]=Integer.MAX_VALUE;

        boolean flag = false;

        //只吃早上的
        for(int i=0;i<n;i++){
            if(morning[i][1]>=k){
                flag = true;
                if(morning[i][0]<maxMemo[0]){
                    maxMemo[0]=morning[i][0];
                }
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((morning[i][1]+nood[j][1])>=k){
                    flag=true;
                    if((morning[i][0]+nood[j][0])<maxMemo[0]){
                        maxMemo[1] = morning[i][1]+nood[j][1];
                        maxMemo[0] = morning[i][0]+nood[j][0];
                    }

                }
            }
        }

        //只吃下午的
        for(int i=0;i<m;i++){
            if(nood[i][1]>=k){
                if(nood[i][0]<maxMemo[0]){
                    maxMemo[0]=nood[i][0];
                }
            }
        }
        if(!flag){
            return -1;
        }

        if(maxMemo[0]!=Integer.MAX_VALUE){
            return maxMemo[0];
        }

        return -1;
    }



}