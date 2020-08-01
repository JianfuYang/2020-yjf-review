/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: LazySingletonTest
 * Author:   Jianf
 * Date:     2020/7/30 21:50
 * Description: 单例模式-懒汉模式实现及其测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.singleton.lazysingleton;

/**
 * 〈一句话功能简述〉<br> 
 * 〈单例模式-懒汉模式实现及其测试〉
 *
 * @author Jianf
 * @create 2020/7/30
 * @since 1.0.0
 */
public class LazySingletonTest {
    public static void main(String[] args) {

//        LazySingleton instance = LazySingleton .getInstance();
//        LazySingleton instance1 = LazySingleton.getInstance();
//        System.out.println(instance==instance1);

        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

/**
 * 1、单例模式定义：
 *     保证一个类只有一个实例，并且提供一个全局访问点。
 *
 * 2、场景:
 *     重量级的对象，不需要多个实例，如线程池，数据库连接池。
 */

/**
 * 3、单例模式的经典实现：
 * 3.1、懒汉模式：延时加载，只有在真正使用的时候，才开始实例化。
 * （1）线程安全问题；多线程下出现重复创建问题。
 * （2）doble check 加锁优化(防止多线程情况下重复创建)
 * （3）编译器(JIT)，CPU有可能对指令进行重排序，导致使用到尚未初始化的实例，可以通过添加volatile关键字进行修饰，
 *     对应volatile修饰的字段，可以防止指令重排。
 */
class LazySingleton{
    private volatile static LazySingleton instance;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if(instance==null){
            synchronized(LazySingleton.class){
                if(instance==null){
                    instance = new LazySingleton();
                    //字节码层面
                    //JIT,CPU指令重排
                    //1.分配空间
                    //2.初始化
                    //3.引用赋值
                }
            }

        }
        return instance;
    }
}