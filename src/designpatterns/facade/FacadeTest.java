/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: FacadeTest
 * Author:   Jianf
 * Date:     2020/8/18 13:06
 * Description: 门面模式/外观模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.facade;

/**
 * 〈一句话功能简述〉<br> 
 * 〈门面模式/外观模式〉
 *
 * @author Jianf
 * @create 2020/8/18
 * @since 1.0.0
 */
public class FacadeTest {

    public static void main(String[] args) {
        FacadeClient1 client1 = new FacadeClient1();
        FacadeClient2 client2 = new FacadeClient2();
        client1.doSomething1();
        client2.doSomething2();
    }
}

//客户端1
class Client1{
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomething1(){
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

//客户端n
class Client2{
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomething2(){
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

//子系统1
class SubSystem1{
    public void method1(){
        System.out.println("SubSystem1.method1 executed. ");
    }
}

//子系统2
class SubSystem2{
    public void method2(){
        System.out.println("Subsystem2.method2 executed.");
    }
}

//子系统3
class SubSystem3{
    public void method3(){
        System.out.println("SubSystem3.method3 executed.");
    }
}


//引入外观模式
class Facade{
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomethingFacade(){
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}


//门面模式下客户端1
class FacadeClient1{
    Facade facade = new Facade();

    public void doSomething1(){
        facade.doSomethingFacade();
    }
}

//门面模式下客户端n
class FacadeClient2{
    Facade facade = new Facade();

    public void doSomething2(){
        facade.doSomethingFacade();
    }
}




