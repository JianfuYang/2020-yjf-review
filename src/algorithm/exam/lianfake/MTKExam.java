/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Test
 * Author:   Jianf
 * Date:     2020/7/22 15:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.lianfake;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Jianf
 * @create 2020/7/22
 * @since 1.0.0
 */





public class MTKExam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        Integer n = Integer.valueOf(string);

        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int[] nums = new int[strings.length];
        for(int i=0;i<strings.length;i++){
            nums[i]=Integer.valueOf(strings[i]);
        }

        System.out.println(countMinNums(nums));
        /*int maxArea = findMaxArea(nums);
        System.out.println(maxArea);
*/
    }


    //第一题
    private static int findMaxArea(int[] nums){
        int len = nums.length;
        if(len<4){
            return -1;
        }
        Arrays.sort(nums);

        //先找第一个最大数
        int max = 0;
        int second = 0;
        int index=len-1;
        for(index = len-2;index>=0;index--){
            if(nums[index] == nums[index+1]){
                max = nums[index];
                break;
            }
        }

        //找第二个最大数
        for(index--;index>=0;index--){
            if(nums[index]==nums[index+1]){
                second = nums[index];
                break;
            }
        }
        int res = second*max>0?second*max:-1;
        return res;
    }

    private static int findMaxArea2(int[] nums){
        int len = nums.length;
        if(len<4){
            return -1;
        }
        Arrays.sort(nums);

        //先找第一个最大数
        int max = 0;
        int second = 0;
        int index=len-1;
        for(index = len-2;index>0;index--){
            if(nums[index] == nums[index+1]){
                max = nums[index];
                break;
            }
        }

        //找第二个最大数
        for(--index;index>=0;index--){
            if(nums[index]==nums[index+1]){
                second = nums[index];
                break;
            }
        }
        int res = second*max>0?second*max:-1;
        return res;
    }

    //第二题
    private static int countMinNums(int[] arr){
        int result = 0;
        int len = arr.length;
        if(len<1){
            return -1;
        }
        int end = len-1;
        for(int i=0;i<len;i++){
            int maxIndex = findMax(arr,0,end);
            if(maxIndex==end){
                //已经在升序顺序中了
            }else{

                //将它们移动到数组最左中
                int max = arr[maxIndex];

                for(int x=maxIndex;x<end;x++){
                    arr[x]=arr[x+1];
                }
                arr[end]= max;
                result++;

                /*//先交换到第一位
                if(maxIndex != 0){
                    int firstTemp = arr[0];
                    arr[0]=arr[maxIndex];
                    arr[maxIndex] = firstTemp;
                    result++;
                }

                //把第一位交换到倒序n位
                int temp = arr[end];
                arr[end]=arr[0];
                arr[0]=temp;
                result++;*/

                /*int temp = arr[end];
                arr[end]=arr[maxIndex];
                arr[maxIndex]=temp;
                result++;*/

                /*for(int j=0;j<arr.length;j++){
                    System.out.print(arr[j] + " ");
                }
                System.out.println("");*/
            }
            end--;

            //

        }
        return result;
    }

    //max最大值，最大值的索引
    private static int findMax(int[] arr,int startIndex,int endIndex){
        int index = startIndex;
        int max = arr[index];
        for(int i=startIndex+1;i<=endIndex;i++){
            if(arr[i]>max){
                max = arr[i];
                 index = i;
            }
        }
//        System.out.println("最大："+index);
        return index;
    }

}
