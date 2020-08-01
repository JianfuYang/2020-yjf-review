/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: InnerClassSingletonTest
 * Author:   Jianf
 * Date:     2020/7/30 22:27
 * Description: 单例模式：静态内部类的实现形式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.singleton.innerclasssingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈单例模式：静态内部类的实现形式〉
 *
 * @author Jianf
 * @create 2020/7/30
 * @since 1.0.0
 */
public class InnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        InnerClassSingleton instance = InnerClassSingleton.getInstance();
//        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
//        System.out.println(instance==instance1);

        /*new Thread(()->{
            InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
            System.out.println(instance2);
        }).start();

        new Thread(()->{
            InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
            System.out.println(instance2);
        }).start();*/

        //测试反射实例化存在的问题：
        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();

        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton==instance);

    }

}

/**
 * 3.3、静态内部类模式：
 * （1）本质上是利用类的加载机制来保证线程安全；
 * （2）只有在实际使用的时候，才会触发类的初始化，所以也是懒加载的一种形式；
 */
class InnerClassSingleton{
    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton(){
        if(InnerClassHolder.instance!=null){
            throw new RuntimeException("单例不允许创建多个实例");
        }
    }

    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }
}