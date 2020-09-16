/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main3
 * Author:   Jianf
 * Date:     2020/9/16 21:20
 * Description: 最小栈
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.tianyiyun;

import java.util.Scanner;
import java.util.Stack;

/**
 * 〈一句话功能简述〉<br> 
 * 〈最小栈〉
 *
 * @author Jianf
 * @create 2020/9/16
 * @since 1.0.0
 */
public class Main3 {


    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());


        for(int i=0;i<n;i++){
            String[] split = scanner.nextLine().split(" ");
            switch (split[0]){
                case "push":
                    int temp = Integer.valueOf(split[1]);
                    push(temp);
                    break;
                case "pop":
                    pop();
                    break;
                case "top":
                    System.out.println(top());
                    break;
                case "getMin":
                    System.out.println(getMin());
                    break;
                default:
                    break;
            }
        }
    }


    //下面为栈的操作
    //入栈
    public static void push(int x){
        //判断s2是否需要添加
        if(s2.isEmpty()||x<=s2.peek()){
            s2.push(x);
        }
        s1.add(x);
    }


    //出栈
    public static void pop(){
        if(!s1.isEmpty()&&!s2.isEmpty()&&s1.pop().equals(s2.peek())){
            s2.pop();
        }
    }

    //获取栈顶元素
    public static int top(){
        return s1.peek();
    }

    //获取最小元素
    public static int getMin(){
        return s2.peek();
    }




}