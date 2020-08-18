/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: FlyWeightPatternTest
 * Author:   Jianf
 * Date:     2020/8/18 10:28
 * Description: 享元模式示例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈享元模式示例〉
 *
 * @author Jianf
 * @create 2020/8/18
 * @since 1.0.0
 */
public class FlyWeightPatternTest {

    public static void main(String[] args) {
        //使用示例：
        TreeNode treeNode1 = new TreeNode(3,4,TreeFactory.getTree("xxx","tree data"));
        TreeNode treeNode2 = new TreeNode(5,4,TreeFactory.getTree("xxx","tree data"));
        TreeNode treeNode3 = new TreeNode(1,4,TreeFactory.getTree("xxx","tree data"));
        TreeNode treeNode4 = new TreeNode(7,4,TreeFactory.getTree("xxx","tree data"));
        //从结果输出，只创建了一次

        TreeNode treeNode5 = new TreeNode(3,4,TreeFactory.getTree("yyy","tree data"));
        TreeNode treeNode6 = new TreeNode(5,4,TreeFactory.getTree("yyy","tree data"));
        TreeNode treeNode7 = new TreeNode(1,4,TreeFactory.getTree("yyy","tree data"));
        TreeNode treeNode8 = new TreeNode(7,4,TreeFactory.getTree("yyy","tree data"));
    }
}


//定义一个树的类
class Tree{
    private final String name;
    private final String data;

    public Tree(String name, String data) {
        this.name = name;
        this.data = data;
        System.out.println("name: "+name+" tree created！");
    }

    public String getName() {
        return name;
    }


    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}

//坐标类，用来表示树的位置,定义成节点
class TreeNode{
    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}



//定义一个工厂来创建树
//每次创建树时先从Map容器中查找存不存在，若存在，直接获取返回；若不存在，先创建，然后再放入容器中，并返回。
class TreeFactory{
    private static Map<String,Tree> map = new ConcurrentHashMap<>();
    public static Tree getTree(String name,String data){
        if(map.containsKey(name)){
            //存在则从容器中获取返回
            return map.get(name);
        }
        //不存在则创建，并放入容器，再返回
        Tree tree = new Tree(name, data);
        map.put(name,tree);
        return tree;
    }
}
