/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: ClassAdapterTest
 * Author:   Jianf
 * Date:     2020/8/18 16:04
 * Description: 类适配器模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.adapter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈类适配器模式〉
 *
 * @author Jianf
 * @create 2020/8/18
 * @since 1.0.0
 */
public class ClassAdapterTest {

    public static void main(String[] args) {
        Adapter2 adapter2 = new Adapter2();
        adapter2.output5v();
    }
}

//原始输出
class Adaptee2{
    public int output220V(){
        return 220;
    }
}

//目标输出接口
interface Target2{
    int output5v();
}

//类的适配器模式：通过继承关系来实现
class Adapter2 extends Adaptee2 implements Target2{
    @Override
    public int output5v() {
        int i = output220V();
        //...一系列转换操作
        System.out.println(String.format("原始电压：%d v -> 输出电压：%d v",i,5));
        return 5;
    }
}