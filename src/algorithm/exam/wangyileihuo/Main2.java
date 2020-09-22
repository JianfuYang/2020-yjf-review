package algorithm.exam.wangyileihuo; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.wangyileihuo.algorithm.exam.tiger.algorithm.exam.beike.algorithm.exam.xiaomi0908.algorithm.exam.didi0913.interview.bigo.Main
 * Author:   Jianf
 * Date:     2020/8/8 14:57
 * Description: 网易笔试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈网易笔试〉
 *
 * @author Jianf
 * @create 2020/8/8
 * @since 1.0.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //输入的t序列
        int[] tNums = new int[m];
        for(int i=0;i<m;i++){
            tNums[i]=scanner.nextInt();
        }

        int[] res = helper(tNums,n,m);

        for(int i=0;i<n-1;i++){
            System.out.print(res[i]+" ");
        }
        System.out.print(res[n-1]);
    }


    public static int[] helper(int[] t,int n,int m){

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i:t){
            queue.add(i);
        }
        int currentNum=1;
        Queue<Integer> res = new ArrayDeque<>();
        int index=0;
        int[] ret = new int[n];
        while(index<n){
            if(queue.isEmpty()){
                ret[index]=currentNum++;
//                res.add(currentNum++);

                index++;
                continue;
            }

            if(!queue.contains(currentNum)&&currentNum<queue.peek()){
                ret[index]=currentNum++;
//                res.add(currentNum++);
                index++;
            }else if(queue.contains(currentNum)) {
                currentNum++;
            }else{
                //找到了一个元素，那么就把它添加到
                ret[index]=queue.removeFirst();
//                res.add(queue.removeFirst());
                index++;
            }

        }


//        for(int i=0;i<n;i++){
//            ret[i]=res.remove();
//        }
        return ret;
    }

}


