/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: CglibDynamicProxy
 * Author:   Jianf
 * Date:     2020/8/3 11:24
 * Description: cglib动态代理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈cglib动态代理〉
 *
 * @author Jianf
 * @create 2020/8/3
 * @since 1.0.0
 */
public class CglibDynamicProxy {
    public static void main(String[] args) {
        //目标对象
        CglibUserDao target = new CglibUserDao();
        //代理对象
        CglibUserDao proxy = (CglibUserDao)new CglibProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
        proxy.save();
    }
}

/**
 * cglib动态代理描述：上面的静态代理和动态代理模式都是要求目标对象是实现一个接口的目标对象,
 * 但是有时候目标对象只是一个单独的对象,并没有实现任何的接口,这个时候就可以使用以目标对象子类的方式类实现代理,
 * 这种方法就叫做:Cglib代理
 * Cglib代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展.
 *
 * JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,
 * 就可以使用Cglib实现.
 * Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.它广泛的被许多AOP的框架使用,例如Spring AOP和synaop,为他们提供方法的interception(拦截)
 * Cglib包的底层是通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类.不鼓励直接使用ASM,
 * 因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉.
 *
 * Cglib子类代理实现方法:
 * 1.需要引入cglib的jar文件,但是Spring的核心包中已经包括了Cglib功能,所以直接引入spring-core-3.2.5.jar即可.
 * 2.引入功能包后,就可以在内存中动态构建子类
 * 3.代理的类不能为final,否则报错
 * 4.目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
 */


//代码示例

//目标对象，没有实现任何接口
class CglibUserDao{
    public void save(){
        System.out.println("cglib...已保存数据");
    }
}

//cglib代理工厂：子类代理工厂，在内存东动态构建一个子类对象
class CglibProxyFactory implements MethodInterceptor {
    //维护目标对象
    private Object target;
    public CglibProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类（代理对象）
        return en.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib..在保存数据之前的增强操作...");

        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);

        System.out.println("cglib..在保存数据之后的增强操作...");

        return returnValue;
    }
}