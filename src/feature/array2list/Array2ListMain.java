/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Array2ListMain
 * Author:   Jianf
 * Date:     2020/8/5 11:29
 * Description: 数组转list的方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.array2list;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈数组转list的方法〉
 *
 * @author Jianf
 * @create 2020/8/5
 * @since 1.0.0
 */
public class Array2ListMain {

    public static void main(String[] args) {
        int[] intArrays = {1,2,3,4,5,6,7,8};
        Integer[] integerArrays = {8,7,6,5,4,3,2,1};

        List<Integer> mannual2List = mannual2List(intArrays);
        System.out.println("手动将数组转换成list："+mannual2List);

        List<Integer> useAsList2List = useAsList2List(integerArrays);
        System.out.println("使用Arrays.asList()方法将数组转换成List:"+useAsList2List);

        List<Integer> list = useCollectionUtils2List(intArrays);
        System.out.println("使用CollectionUtils将数组转换成List："+list);
    }


    /**
     * 手动将数组元素逐个放入list中，进行转换
     * @param arrays
     * @return
     */
    public static List<Integer> mannual2List(int[] arrays){
        List<Integer> list = new ArrayList<>();
        for(int array:arrays){
            list.add(array);
        }
        return list;
    }

    /**
     * 注意Arrays.asList的入参要是对象类型，不能是基本类型，基本类型要转换成对象类型才可以
     * @param arrays 对象数组
     * @return
     */
    public static List<Integer> useAsList2List(Integer[] arrays){
        List<Integer> list = new ArrayList<>(Arrays.asList(arrays));
        return list;
    }

    /**
     * 这里同样也是要使用对象类型，不能直接使用基本类型
     * @param arrays
     * @return
     */
    public static List<Integer> useArraysStream2List(Integer[] arrays){
        List<Integer> list = Arrays.stream(arrays).collect(Collectors.toList());
        return list;
    }

    /**使用CollectionUtils将数组转换成List,也可以使用基本数据类型。
     *
     * @param arrays
     * @return
     */
    public static List<Integer> useCollectionUtils2List(int[] arrays){
        List<Integer> list = CollectionUtils.arrayToList(arrays);
        return list;
    }

}