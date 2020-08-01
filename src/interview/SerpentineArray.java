package interview; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: MyTest
 * Author:   Jianf
 * Date:     2020/7/3 10:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */


/**
 * 〈算法题：蛇形数组，左三角右三角〉<br>
 *     斜行蛇形遍历数组
 * 〈〉
 *
 * @author Jianf
 * @create 2020/7/3
 * @since 1.0.0
 */
public class SerpentineArray {


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String S=sc.nextLine();
        /*构造测试数组*/
        int m = 3;
        int n = 4;
        int[][] nums = new int[m][n];
        int k=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nums[i][j]=k++;
            }
        }

        /*解题思路：以斜行角度看待矩阵
        *  分为左三角（包括第n斜行）：分别从第i=0行第j列开始，往左下角移动（j--,i++），如果移动到了m-1行或者n=0列了，则结合本次移动，添加本次斜行结果到结果数组中；
        *   令j++,重复上述过程，直到j=n行结束。
        *   右三角的情况：
        *       每次都从i行（i=1起始）j=n-1列开始，往右下角移动（i++,j--),直到移动到到i=m-1行，结束本次移动，添加本次斜行结果到结果数组中；
        *       令i++;继续上述过程，知道i=m-1,即遍历完毕。
        *
        * 注意点：需要注意添加斜行数据的方向，本题使用flag=true表示偶数斜行（从0开始)的移动方向,flase表示奇数斜行的数据添加方向，两者方向相反。
        * */
        int[] res = new int[m*n];
        int index=0;
        boolean flag=true;

        //分两种情况：左三角和右三角
        for(int j=0;j<n;j++){
            int tempJ=j;
            //分两种情况，偶数行（从0行开始）：顺，奇数行:反
            int tempLen = tempJ+1>m? m:tempJ+1;
            int[] temp=new int[tempLen];
            if(flag){

                for(int i=0;i<m && i<=j;){
                    temp[tempLen-1-i]=nums[i][tempJ];
                    i++;
                    tempJ--;
                }
                flag=false;
            }else{
                for(int i=0;i<m && i<=j;){
//                    System.out.println(nums[i][tempJ]);
                    temp[i]=nums[i][tempJ];
                    i++;
                    tempJ--;
                }
                flag=true;
            }

            for(int i=0;i<tempLen;i++){
                System.out.print(temp[i]+" ");
                res[index++] = temp[i];
            }
            System.out.println("");
        }

        for(int i=1;i<m;i++){
            int tempI=i;
            //分两种情况，偶数行（从0行开始）：顺，奇数行:反
            int tempLen = m - i;
            int[] temp=new int[tempLen];
            int tempJ = n-1;
            if(flag){
                for(tempI=i;tempI<m;){
                    tempLen--;
                    temp[tempLen]=nums[tempI][tempJ];
                    tempI++;
                    tempJ--;
                }
                flag=false;
            }else{
                for(tempI=i;tempI<m;){
//                    System.out.println(nums[i][tempJ]);
                    temp[tempI-i]=nums[tempI][tempJ];
                    tempI++;
                    tempJ--;
                }
                flag=true;
            }

            for(int x=0;x<m-i;x++){
                System.out.print(temp[x]+" ");
                res[index++] = temp[x];
            }
            System.out.println("");
        }


    }
}