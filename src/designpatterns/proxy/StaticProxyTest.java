/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: StaticProxyTest
 * Author:   Jianf
 * Date:     2020/8/3 10:59
 * Description: 静态代理类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.proxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈静态代理类〉
 *
 * @author Jianf
 * @create 2020/8/3
 * @since 1.0.0
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        //测试静态代理
        //目标对象
        UserDao target = new UserDao();
        //代理对象，将目标对象传给代理对象，建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        //执行的是代理的方法
        proxy.save();
    }
}

/**
 * 静态代理总结:
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * 如何解决静态代理中的缺点呢?答案是可以使用动态代理方式
 */

/**
 *  静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
 * */
/*
* 场景说明：模拟保存动作,定义一个保存动作的接口:IUserDao.java,然后目标对象实现这个接口的方法UserDao.java,此时如果使用静态代理方式,就需要在代理对象(UserDaoProxy.java)中也实现IUserDao接口.调用的时候通过调用代理对象的方法来调用目标对象.
需要注意的是,代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来调用目标对象的方法
* */

//接口
interface IUserDao{
    void save();
}

//目标对象
class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("已经保存对象数据....");
    }
}

//代理对象
class UserDaoProxy implements IUserDao{
    private IUserDao target;

    public UserDaoProxy(IUserDao target){
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("保存对象数据之前的一系列操作....");
        target.save(); //执行目标对象的方法
        System.out.println("保存对象数据之后的一系列操作....");
    }
}
