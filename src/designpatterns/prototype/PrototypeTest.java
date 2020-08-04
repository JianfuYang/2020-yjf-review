/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: PrototypeTest
 * Author:   Jianf
 * Date:     2020/8/4 10:48
 * Description: 原型模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.prototype;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈原型模式〉
 *
 * @author Jianf
 * @create 2020/8/4
 * @since 1.0.0
 */
public class PrototypeTest {
    public static void main(String[] args) {

        //测试示例：通过ShapeTable来获取存储在Map中的形状的克隆
        ShapeTable.loadCache();

        Shape cloneCircle = ShapeTable.getShape("1");
        System.out.println("Shape : " + cloneCircle.getType()+" "+cloneCircle.hashCode());
        cloneCircle.draw();

        Shape cloneSquare = ShapeTable.getShape("2");
        System.out.println("Shape : " + cloneSquare.getType()+" "+cloneSquare.hashCode());
        cloneCircle.draw();

        Shape cloneRectangle = ShapeTable.getShape("3");
        System.out.println("Shape : " + cloneRectangle.getType()+" "+cloneRectangle.hashCode());
        cloneRectangle.draw();

    }
}


/**
 * 场景需求说明：创建一个抽象类Shape和其具体子类；定义一个类ShapeCache，用于吧shape对象存储在散列表中，并在请求的时候返回他们的克隆。
 */
abstract class Shape implements Cloneable{
    private String id;
    //使用defalut使其在其子类中可以访问
    protected String type;

    abstract void draw();

    public String getType(){
        return type;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    //必须要用克隆方法，通过克隆来实现对象的原型复制
    @Override
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}

//下面为三个扩展类上述抽象类的子类实体
class Rectangle extends Shape{
    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square extends Shape{
    public Square(){
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle extends Shape{
    public Circle(){
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

//创建一个类，将实体类存储在一个散列表中
class ShapeTable{
    private static Map<String,Shape> shapeHashMap = new HashMap<String, Shape>();

    //根据id获取一个原型实例
    public static Shape getShape(String shapeId){
        Shape shape = shapeHashMap.get(shapeId);
        return (Shape)shape.clone();
    }

    //下面模拟数据操作，假设从数据库中获取数据，并创建该形状，假设要添加三种形状
    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeHashMap.put(circle.getId(),circle);
        System.out.println("origin Circle hascode:"+circle.hashCode());

        Square square = new Square();
        square.setId("2");
        shapeHashMap.put(square.getId(),square);
        System.out.println("origin Square hascode:"+square.hashCode());

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeHashMap.put(rectangle.getId(),rectangle);
        System.out.println("origin Rectangle hascode:"+rectangle.hashCode());
    }
}


















