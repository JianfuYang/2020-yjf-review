/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.Main
 * Author:   Jianf
 * Date:     2020/8/20 9:20
 * Description: 往年真题：字节2018后端-Java
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.simulation.zijie2018java;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈往年真题：字节2018后端-Java〉
 *
 * @author Jianf
 * @create 2020/8/20
 * @since 1.0.0
 */
public class Main2 {

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] s = str.split(" ");
        //串珠个数
        int n =Integer.valueOf(s[0]);
        //连续长度
        int m = Integer.valueOf(s[1]);
        //手串颜色种树
        int c = Integer.valueOf(s[2]);

        //使用一个Map容器来保存每种颜色所在的串珠集合
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=1;i<=n;i++){
            String input = sc.nextLine();
            String[] s1 = input.trim().split(" ");
//            System.out.println("S1 length:"+s1.length);
            int curNum = Integer.valueOf(s1[0]);
            if(curNum==0){
                continue;
            }
            for(int j=1;j<s1.length;j++){
//                System.out.println("j:"+j);
                int currentColor =Integer.valueOf(s1[j]);
                if(map.get(currentColor)==null){
                    //容器中还没有保存该种颜色,则将该颜色及其存在的串珠号保存至容器中
                    List list = new ArrayList();
                    list.add(i);
                    map.put(currentColor,list);
                }else{
                    //已经存在容器中
                    List<Integer> integerList = map.get(currentColor);
                    //将该串珠保存到所在颜色对应的串珠集合中
                    integerList.add(i);
                    map.put(currentColor,integerList);
                }
            }
        }
        //接下来遍历所有的串珠，找出不满足条件的个数
        System.out.println(isFill(map,n,m,c));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] s = str.split(" ");
        //串珠个数
        int n =Integer.valueOf(s[0]);
        //连续长度
        int m = Integer.valueOf(s[1]);
        //手串颜色种树
        int c = Integer.valueOf(s[2]);

        //使用一个Map容器来保存每种颜色所在的串珠集合
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=1;i<=n;i++){
            int curNum = sc.nextInt();
            if(curNum==0){
                continue;
            }
            for(int j=1;j<=curNum;j++){
//                System.out.println("j:"+j);
                int currentColor =sc.nextInt();
                if(map.get(currentColor)==null){
                    //容器中还没有保存该种颜色,则将该颜色及其存在的串珠号保存至容器中
                    List list = new ArrayList();
                    list.add(i);
                    map.put(currentColor,list);
                }else{
                    //已经存在容器中
                    List<Integer> integerList = map.get(currentColor);
                    //将该串珠保存到所在颜色对应的串珠集合中
                    integerList.add(i);
                    map.put(currentColor,integerList);
                }
            }
        }
        //接下来遍历所有的串珠，找出不满足条件的个数
        System.out.println(isFill(map,n,m,c));
    }

    public static int isFill(Map<Integer,List<Integer>> map,int n,int m,int c){
        int res = 0;
        for(int i=1;i<=c;i++){
            //获取该颜色对应的串珠集合
            List<Integer> circleList = map.get(i);
//            circleList.addAll(circleList);
            System.out.println("第"+i+"颜色集合："+circleList.toString());

            for(int k=1;k<circleList.size();k++){
                if((circleList.get(k)%n-circleList.get(k-1)%n)<m){

                    System.out.println("颜色："+i+"不满足条件");
                    res++;
                    break;
                }
            }
        }
        return res;
    }

}