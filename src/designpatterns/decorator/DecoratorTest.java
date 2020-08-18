/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: DecoratorTest
 * Author:   Jianf
 * Date:     2020/8/18 19:28
 * Description: 装饰者模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.decorator;

/**
 * 〈一句话功能简述〉<br> 
 * 〈装饰者模式〉
 *
 * @author Jianf
 * @create 2020/8/18
 * @since 1.0.0
 */
public class DecoratorTest {

    public static void main(String[] args){
        //原始功能测试
        Component component = new ConcreteComponent();
        component.operation();

        //装饰者功能测试:测试美颜功能
        Component component1 = new ConcreteDecorator(new ConcreteComponent());
        component1.operation();

        //装饰者功能测试：添加滤镜功能
        ConcreteDecorator2 concreteDecorator2 = new ConcreteDecorator2(new ConcreteDecorator(new ConcreteComponent()));
        concreteDecorator2.operation();


    }
}

//接口
interface Component{
    void operation();
}

//原始功能
class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("拍照");
    }
}


//使用装饰者模式添加新功能
abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component){
        this.component = component;
    }
}


//添加美颜功能
class ConcreteDecorator extends Decorator{
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        component.operation();
        System.out.println("添加美颜.");
    }
}

//添加滤镜功能
class ConcreteDecorator2 extends Decorator{
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        component.operation();
        System.out.println("添加滤镜.");
    }
}