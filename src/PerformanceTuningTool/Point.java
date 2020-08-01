/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Point
 * Author:   Jianf
 * Date:     2020/7/21 20:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package PerformanceTuningTool;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/7/21
 * @since 1.0.0
 */
class Point {
    private int x;
    private int y;
    private String name;

    Point(int x,int y,String name){
        this.x=x;
        this.y=y;
        this.name=name;
    }

    public void add(int dx,int dy){
        x +=dx;
        y +=dy;
    }

    public void sub(int dx,int dy){
        x -=dx;
        y -=dy;
    }

    public void print(){
        System.out.println(x+" "+y+" "+name);
    }
}