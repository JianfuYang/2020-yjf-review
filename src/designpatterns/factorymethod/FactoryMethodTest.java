/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: FactoryMethod
 * Author:   Jianf
 * Date:     2020/7/31 21:49
 * Description: 工厂方法模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.factorymethod;

/**
 * 〈一句话功能简述〉<br> 
 * 〈工厂方法模式〉
 *
 * @author Jianf
 * @create 2020/7/31
 * @since 1.0.0
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        FactoryMethod A = new ConcreteProductAFactory();
        Product product = A.getObject();
        product.method1();

        FactoryMethod A1 = new ConcreteProductA1Factory();
        Product productA1 = A1.getObject();
        productA1.method1();
    }
}


interface Product{
    public void method1();
}

class ProductA implements Product {

    @Override
    public void method1(){
        System.out.println("ProdyctA.method 1 executed.");
    }

}


class ProductA1 implements Product {

    @Override
    public void method1(){
        System.out.println("ProdyctA1.method 1 executed.");
    }

}


abstract class FactoryMethod{
    //工厂方法
    abstract Product createProduct();//交由子类来实现

    Product getObject(){
        Product product = createProduct();
        //省略其他业务处理...
        return product;
    }
}

//具体工厂的实现
class ConcreteProductAFactory extends FactoryMethod{

    @Override
    Product createProduct() {
        //实例化的其他过程
        //...
        return new ProductA();
    }
}

class ConcreteProductA1Factory extends FactoryMethod{

    @Override
    Product createProduct() {
        //实例化的其他过程
        //...
        return new ProductA1();
    }
}