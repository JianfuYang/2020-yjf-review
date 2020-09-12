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

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈LRU算法实现1〉
 *
 * @author Jianf
 * @create 2020/8/31
 * @since 1.0.0
 */
public class LRU1 {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        LinkedHashMap<Integer,Integer> linkedmap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<operators.length;i++){
            int opt = operators[i][0];
            int key = operators[i][1];
            if(opt==1){
                if(linkedmap.containsKey(key)){
                    linkedmap.remove(k);
                }else if(linkedmap.size()==k){
                    linkedmap.remove(linkedmap.keySet().toArray()[0]);
                }
                linkedmap.put(key,operators[i][2]);
            }else if(opt==2){
                if(linkedmap.containsKey(key)){
                    int val = linkedmap.remove(key);
                    linkedmap.put(key,val);
                    list.add(val);
                }else{
                    list.add(-1);
                }
            }
        }
        return list.stream().mapToInt((Integer i)->i).toArray();
    }
}