/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: ClassLoaderMain
 * Author:   Jianf
 * Date:     2020/8/31 9:08
 * Description: 类加载器测试示例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package feature.customclassloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈类加载器测试示例〉
 *
 * @author Jianf
 * @create 2020/8/31
 * @since 1.0.0
 */
public class ClassLoaderMain {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        //这个类class的路径
        String classPath = "F:\\研_项目资料\\6.Work\\MyWork\\myReview\\src\\feature\\customclassloader\\Log.class";

        MyClassLoader myClassLoader = new MyClassLoader(classPath);
        //类的全称
        String packageNamePath = "feature.customclassloader.Log";

        //加载Log这个class文件；
        // 注意这里如果使用的是loadClass方法，在自动编译下，并没有打破双亲委派模式，loadClass还是委托其父类其加载；
        //这里直接调用findClass调用我们自定义的类加载器去加载
        Class<?> Log = myClassLoader.findClass(packageNamePath);

        System.out.println("类加载器是:" + Log.getClassLoader());

        //利用反射获取main方法
        Method method = Log.getDeclaredMethod("main", String[].class);
        Object object = Log.newInstance();
        String[] arg = {"ad"};
        method.invoke(object, (Object) arg);
    }


}