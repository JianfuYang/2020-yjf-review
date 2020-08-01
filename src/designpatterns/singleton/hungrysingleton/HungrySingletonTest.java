/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: HungrySingletonTest
 * Author:   Jianf
 * Date:     2020/7/30 22:12
 * Description: 单例模式：饿汉模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.singleton.hungrysingleton;

/**
 * 〈一句话功能简述〉<br> 
 * 〈单例模式：饿汉模式〉
 *
 * @author Jianf
 * @create 2020/7/30
 * @since 1.0.0
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1=HungrySingleton.getInstance();
        System.out.println(instance==instance1);
    }

}

/**
 * 3.2、饿汉模式：类加载的初始化阶段就完成了实例的初始化。本质上就是借助jvm类加载机制，保证实例的唯一性；
 * （1）类加载的过程：
 *     ①加载二进制数据到内存中，生成对应的class数据结构，
 *     ②连接：验证，准备（给类的静态成员变量赋默认值），解析
 *     ③初始化：给类的静态变量赋初值。
 * （2）只有在真正使用对应的类是，才会触发初始化
 */
class HungrySingleton{
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}