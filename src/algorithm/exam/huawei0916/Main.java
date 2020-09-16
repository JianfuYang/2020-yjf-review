/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main
 * Author:   Jianf
 * Date:     2020/9/16 19:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.huawei0916;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈倒车〉
 *
 * @author Jianf
 * @create 2020/9/16
 * @since 1.0.0
 */
public class Main {

    private static List<String> queue = new ArrayList<>();

    static {
        queue.add("0");
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("3");
        queue.add("2");
        queue.add("1");
        queue.add("5");
        queue.add("6");
        queue.add("5");
        queue.add("7");
        queue.add("8");
        queue.add("9");
        queue.add("8");
        queue.add("7");
        queue.add("5");
        queue.add("1");
        queue.add("0");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String[] inputS = inputString.split(",");

        String[] nums = new String[inputS.length];
        for(int i=0;i<inputS.length;i++){
//            System.out.println(inputS[i]+" ");
            nums[i] = inputS[i];
        }



        List<String> merge = merge(nums);
//        System.out.println(merge);
        System.out.println(isSuccess(merge));

    }


    private static String isSuccess(List<String> myInput){
        int templatIndex = 0;

        boolean isFinish = false;
        for( int i=0;i<myInput.size();i++){
            if(templatIndex==queue.size()){
                isFinish=true;
                break;
            }


            if(myInput.get(i).equals("-1")){
                //越界了
                return "Out of path";

            }else if(myInput.get(i).charAt(0)<'0'||myInput.get(i).charAt(0)>'9'){
                //撞到杆子了
                return "Collision";
            }else if(!myInput.get(i).equals(queue.get(templatIndex))){
//                System.out.println(myInput.get(i)+" : "+queue.get(templatIndex));
//                System.out.println(i);
                return "Bad path";
            }else{
                templatIndex++;
            }
        }
        return "Success";

    }




    private static List<String> merge(String[] nums){
        List<String> characterList = new ArrayList<>();

        //下面处理是将其相同的字符进行合并
        int left = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[left].equals(nums[i])){
                continue;
            }else{
                characterList.add(nums[left]);
                left = i;
            }
        }
        characterList.add(nums[nums.length-1]);
        return characterList;
    }

}