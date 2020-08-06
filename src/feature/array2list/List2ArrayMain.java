/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: List2ArrayMain
 * Author:   Jianf
 * Date:     2020/8/5 16:22
 * Description: list转换成数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.array2list;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈list转换成数组〉
 *
 * @author Jianf
 * @create 2020/8/5
 * @since 1.0.0
 */
public class List2ArrayMain {

    public static void main(String[] args) {
        int[] intArrays = {1,2,3,4,5,6,7,8};
        Integer[] integerArrays = {8,7,6,5,4,3,2,1};

        List<Integer> mannual2List = mannual2List(intArrays);
        System.out.println("手动将数组转换成list："+mannual2List);

        int[] mannualList2Array = mannualList2Array(mannual2List);
        System.out.println("手动将list转换成数组："+mannualList2Array);
        for(int i:mannualList2Array){
            System.out.print(i+" ");
        }
        System.out.println();

        Integer[] integers = list2Array(mannual2List);
        System.out.println("1.toArray默认方法将array转换成list：");
        for(int i:integers){
            System.out.print(i+" ");
        }
        System.out.println();

        int[] ints = useStreamlist2Array(mannual2List);
        System.out.println("2.使用stream将list转换成array：");
        for(int i:ints){
            System.out.print(i+" ");
        }
        System.out.println();

        //测试二维数组
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{1,2});
        res.add(new int[]{3,4});
        int[][] ints1 = twoDimensionList2Array(res);
        System.out.println("2.使用stream将list转换成array：");
        for(int[] i:ints1){
            for(int i1:i){
                System.out.print(i1+" ");
            }
        }
        System.out.println();


    }

    /**
     * 手动创建数组，将list中的元素逐个添加到int[]数组中
     * @param list
     * @return
     */
    public static int[] mannualList2Array(List<Integer> list){
        int[] res = new int[list.size()];
        int i=0;
        for(int num:list){
            res[i++]=num;
        }
        return res;
    }

    //直接使用List的toArray方法，该类型参数传入引用类型
    public static Integer[] list2Array(List<Integer> list){
        Integer[] integers = list.toArray(new Integer[0]);//传入参数，表示强转
        return integers;
    }

    //使用stream将list转换成数组
    public static int[] useStreamlist2Array(List<Integer> list){
        //下面三行代码都可以完成这个操作
//        int[] arrays = list.stream().mapToInt(Integer::intValue).toArray();
        //使用lambda表达式
//        int[] arrays = list.stream().mapToInt((Integer i)->i).toArray();
        //使用lambda表达式；先使用filter过滤
        int[] arrays = list.stream().filter(integer -> integer!=null).mapToInt(i->i).toArray();
        return arrays;
    }

    //二维list转换成list
    public static int[][] twoDimensionList2Array(List<int[]> list){
        int[][] res = list.toArray(new int[0][0]);
        return res;
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


}