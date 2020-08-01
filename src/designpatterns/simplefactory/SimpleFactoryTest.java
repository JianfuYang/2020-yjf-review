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
package designpatterns.simplefactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈工厂方法模式〉
 *
 * @author Jianf
 * @create 2020/7/31
 * @since 1.0.0
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Application application = new Application();
        Product product = application.getObject("0");
        product.method1();

        Product product1 = application.getObject("1");
        product1.method1();
    }
}


interface Product{
    public void method1();
}

class ProductA implements Product{

    @Override
    public void method1(){
        System.out.println("ProdyctA.method 1 executed.");
    }

}


class ProductA1 implements Product{

    @Override
    public void method1(){
        System.out.println("ProdyctA1.method 1 executed.");
    }

}


//简单工厂模式：简单工厂模式并不是一种设计模式，只能说它是一种编程实现思想
class SimpleFactory{
    public static Product createProduct(String type){
        if(type.equals("0")){
            return new ProductA();
        }else if(type.equals("1")){
            return new ProductA1();
        }else{
            return null;
        }
    }
}


class Application{
    private Product createProduct(String type){
        //省略其他业务处理....
        return SimpleFactory.createProduct(type);
    }


    Product getObject(String type){
        Product product = createProduct(type);
        //省略其他业务处理...
        return product;
    }

}