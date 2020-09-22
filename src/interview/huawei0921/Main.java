/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main
 * Author:   Jianf
 * Date:     2020/9/21 10:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package interview.huawei0921;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/21
 * @since 1.0.0
 */
public class Main {
    private  static Map<Character,Character> map = new HashMap<>();
    static {
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        //使用栈来存储
        Stack<Character> stack = new Stack<>();
        for(char ch:chars){
            //先判断是否为左符号
            if(!map.containsKey(ch)){
                stack.add(ch);
            }else{
                //不是左符号，需要与栈顶元素进行匹配
                if(stack.isEmpty()){
                    System.out.println("false");
                    return;
                }
                if(map.get(ch).equals(stack.peek())){
                    //和栈顶元素相等
                    stack.pop();
                }else{
                    System.out.println("false");
                    return;
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("true");
            return;
        }
        System.out.println("false");
        return;
    }
}