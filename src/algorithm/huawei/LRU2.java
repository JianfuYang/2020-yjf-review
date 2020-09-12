/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: LRU1
 * Author:   Jianf
 * Date:     2020/8/31 15:43
 * Description: LRU算法实现1
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.huawei;

import java.util.*;


public class LRU2 {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */

    public int[] LRU (int[][] operators, int k) {
        // write code here
        //使用LinkedList+HashMap来实现
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        LinkedList<Integer> linkedlist = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<operators.length;i++){
            int opt = operators[i][0];
            int key = operators[i][1];

            if(opt==1){
                int value = operators[i][2];
                if(hashmap.containsKey(key)){
                    hashmap.remove(key);
                    hashmap.put(key,value);
                    linkedlist.remove(key);
                    linkedlist.addFirst(key);
                }else{
                    if(hashmap.size()==k){
                        int key1 = linkedlist.removeLast();
                        hashmap.remove(key1,hashmap.get(key1));
                    }
                    linkedlist.addFirst(key);
                    hashmap.put(key,value);
                }
            }else if(opt == 2){
                if(hashmap.containsKey(key)){
                    linkedlist.remove(key);
                    linkedlist.addFirst(key);
                    result.add(hashmap.get(key));
                }else{
                    result.add(-1);
                }
            }
        }
        return result.stream().mapToInt((Integer i)->i).toArray();
    }
}