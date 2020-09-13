/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main3
 * Author:   Jianf
 * Date:     2020/9/13 11:13
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
public class Main3 {

    private static volatile long count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        helper1(n,0,k,d,false);
        System.out.println(count%998244353);
    }


    private static void helper(int n,int k,int d,boolean flag){

        if(n<0){
            return;
        }
        if(n==0){
            if(flag){
                //满足最大的数大于等于d
                count++;
                return;
            }else{
                return;
            }
        }

        for(int i=1;i<=k;i++){
            if(i>=d){
                flag=true;
            }
            helper(n-i,k,d,flag);
        }
    }


    public static void helper1(int n,int sum,int k,int d,boolean bigThanD){
        if(sum>n){
            return;
        }

        if(sum==n&&bigThanD){
            count++;
            count = count%998244353;
            return;
        }

        for(int i=1;i<=k;i++){
            if(bigThanD){
                helper1(n,sum+i,k,d,true);
            }else if(i>=d){
                helper1(n,sum+i,k,d,true);
            }else{
                helper1(n,sum+i,k,d,false);
            }
        }
    }
}