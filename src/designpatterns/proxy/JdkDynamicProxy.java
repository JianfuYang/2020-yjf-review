/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: JdkDynamicProxy
 * Author:   Jianf
 * Date:     2020/8/3 11:07
 * Description: JDK动态代理测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈JDK动态代理测试〉
 *
 * @author Jianf
 * @create 2020/8/3
 * @since 1.0.0
 */
public class JdkDynamicProxy {
    public static void main(String[] args) {
        //测试动态代理
        IDUserDao target = new DUserDao();
        //打印原始类型
        System.out.println(target.getClass());

        //设置生成动态代理类时的文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
        //给目标对象，创建代理对象
        IDUserDao proxy = (IDUserDao)new ProxyFactory(target).getProxyInstance();
        //内存中生成的动态代理对象
        System.out.println(proxy.getClass());
        proxy.save();
    }
}

/**
 * 动态代理有以下特点:
 * 1.代理对象,不需要实现接口
 * 2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
 * 3.动态代理也叫做:JDK代理,接口代理
 *
 * JDK中生成代理对象的API
 * 代理类所在包:java.lang.reflect.Proxy
 * JDK实现代理只需要使用newProxyInstance方法,但是该方法需要接收三个参数,完整的写法是:
 * static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
 * 注意该方法是在Proxy类中是静态方法,且接收的三个参数依次为:
 *
 * ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
 * Class<?>[] interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
 * InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
 *
 * 总结：代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 * */


/**
* 场景代码示例:
 * 接口类IUserDao.java以及接口实现类,目标对象UserDao是一样的,没有做修改.在这个基础上,增加一个代理工厂类(ProxyFactory.java),
 * 将代理类写在这个地方,然后在测试类(需要使用到代理的代码)中先建立目标对象和代理对象的联系,然后代用代理对象的中同名方法
* */

//接口
interface IDUserDao{
    void save();
}

//目标对象
class DUserDao implements IDUserDao{
    @Override
    public void save() {
        System.out.println("已经保存对象数据....");
    }
}

/**
 * 创建动态代理对象
 * 动态代理对象不需要实现接口，但是需要指定接口类型
 */
class ProxyFactory{
    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("JDK动态代.业务执行之前的一系列操作...");
                        Object returnValue = method.invoke(target,args);
                        System.out.println("JDK动态代理..业务执行之后的一系列操作...");
                        return returnValue;
                    }
                }
        );
    }
}