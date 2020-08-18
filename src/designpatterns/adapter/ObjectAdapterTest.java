/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: AdapterTest1
 * Author:   Jianf
 * Date:     2020/8/18 15:54
 * Description: 适配器模式示例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.adapter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈适配器模式示例:对象适配器模式〉
 *
 * @author Jianf
 * @create 2020/8/18
 * @since 1.0.0
 */
public class ObjectAdapterTest {

    public static void main(String[] args) {
        //将原始的输出电压进行适配输出5v电压
        Adaptee adaptee = new Adaptee();

        Target target = new Adapter(adaptee);
        target.output5v();
    }
}

//原始输出
class Adaptee{
    public int output220V(){
        return 220;
    }
}


//目标接口
interface Target{
    int output5v();
}


//对象适配器，通过组合关系来实现
class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220V();
        //...一系列转换操作
        System.out.println(String.format("原始电压：%d v -> 输出电压：%d v",i,5));
        return 5;
    }
}
