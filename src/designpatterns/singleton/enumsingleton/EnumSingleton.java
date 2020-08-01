/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: EnumSingletonTest
 * Author:   Jianf
 * Date:     2020/7/31 9:42
 * Description: 单例模式-枚举实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.singleton.enumsingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈单例模式-枚举实现〉
 *
 * @author Jianf
 * @create 2020/7/31
 * @since 1.0.0
 */
public enum EnumSingleton{
    INSTANCE;
    public void print(){
        System.out.println(this.hashCode());
    }
}


class EnumSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        /*EnumSingleton instance=EnumSingleton.INSTANCE;
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        System.out.println(instance==instance1);*/

        //反射测试
        /*Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        //执行报错，Enum类型不允许通过反射创建
        EnumSingleton instance=declaredConstructor.newInstance("INSTANCE",0);*/

        //测试数据的持久化
        //1.持久化到磁盘
        EnumSingleton instance = EnumSingleton.INSTANCE;
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("enumsingleton"));
//        objectOutputStream.writeObject(instance);
//        objectOutputStream.close();

        //从磁盘读取出来
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("enumsingleton"));
        EnumSingleton object = ((EnumSingleton)objectInputStream.readObject());
        System.out.println(instance==object) ;
    }
}


