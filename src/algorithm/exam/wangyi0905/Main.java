/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.Main
 * Author:   Jianf
 * Date:     2020/9/5 15:23
 * Description: 自动售货机
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.wangyi0905;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自动售货机〉
 *
 * @author Jianf
 * @create 2020/9/5
 * @since 1.0.0
 */
public class Main {


    static Vector<Stack<Integer>> stacks = new Vector<>(5);
    static {
        for(int k=0;k<5;k++) {
            Stack<Integer> temp = new Stack<Integer>();
            stacks.add(temp);
        }
    }

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        String[] string = scanner.nextLine().split(" ");
        int N =Integer.valueOf(string[0]);
        int M = Integer.valueOf(string[1]);
        //N个槽的物品单价
        String[] s = scanner.nextLine().split(" ");
        int[] prices = new int[N];
        for(int i=0;i<N;i++){
            prices[i]=Integer.valueOf(s[i]);
        }

        //M个人的操作记录
        for(int i=0;i<M;i++){
            int Ki = Integer.valueOf(scanner.nextLine());
            int count = 0;
            String[][] operations = new String[Ki][3];
            for(int j=0;j<Ki;j++){
                //本次操作情况
                String[] curOp = scanner.nextLine().split(" ");
                if(curOp.length==3){
                    operations[j][0] = curOp[0];
                    operations[j][1] = curOp[1];
                    operations[j][2] = curOp[2];
                }else{
                    operations[j][0] = curOp[0];
                    operations[j][1] = curOp[1];
                    operations[j][2] = "0";
                }


            }
            //使用栈来存储中间

            int leftHand = 0;
            int rightHand = 0;
            //计算这个人的花费
            System.out.println(helper(operations,prices,leftHand,rightHand));
        }

    }


    private static int helper(String[][] operations,int[] prices,int leftHand,int rightHand){

        int tSum = 0;
        /*int leftHand = 0;
        int rightHand = 0;*/
        for(String[] strings:operations) {
            if (strings[1].equals("keep")) {
                //将货物放回背包，现在结算
                if (strings[0].equals("left")) {
                    tSum += leftHand;
                    leftHand = 0;
//                    System.out.println("-----"+tSum);
                } else {
                    tSum += rightHand;
                    rightHand = 0;
//                    System.out.println("---"+tSum);
                }
            } else {
                int slotN = Integer.valueOf(strings[2]) - 1; //槽编号
                if (strings[1].equals("take")) {
                    //重新设置左右手上的价值，并且将相应的货架pop

                    int originPrices = 0;
                    Stack<Integer> stack = stacks.get(slotN);
                    if (stack.isEmpty()) {
                        originPrices = prices[slotN]; //原价
                    } else {
                        originPrices = stacks.get(slotN).pop(); //更新
                    }

                    if (strings[0].equals("left")) {
                        leftHand = originPrices; //放在左手
                    } else {
                        rightHand = originPrices;//放在右手
                    }
                } else if (strings[1].equals("return")) {
                    //重新设置左右手上的价值，并且将相应的货架push
                    if (strings[0].equals("left")) {
                        stacks.get(slotN).push(leftHand);
                        System.out.println(stacks);
                        leftHand = 0;
                    } else {
//                        stacks.get(slotN).push(rightHand);
                        stacks.get(slotN).push(rightHand);
                        System.out.println(stacks);
                        rightHand = 0;
                    }
                }
            }
            //
        }
        //完成操作之后，结算手中的货物
        tSum += leftHand+rightHand;
        return tSum;
    }


}