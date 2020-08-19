/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: TemplateMethodTest
 * Author:   Jianf
 * Date:     2020/8/19 9:42
 * Description: 模板方法模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.templatemethod;

/**
 * 〈一句话功能简述〉<br> 
 * 〈模板方法模式〉
 *
 * @author Jianf
 * @create 2020/8/19
 * @since 1.0.0
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass abstractClass = new SubClass();
        abstractClass.operation();
    }
}


abstract class AbstractClass{
    public void operation(){
        System.out.println("pre...");
        System.out.println("step1...");
        System.out.println("step2...");

        templateMethod();

        //...
        System.out.println("end....");
    }

    abstract protected void templateMethod();
}


class SubClass extends AbstractClass{
    @Override
    protected void templateMethod() {
        System.out.println("SubClass executed....");
    }
}











