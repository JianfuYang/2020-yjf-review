/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: ObServerTest
 * Author:   Jianf
 * Date:     2020/8/19 10:16
 * Description: 观察者模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈观察者模式〉
 *
 * @author Jianf
 * @create 2020/8/19
 * @since 1.0.0
 */
public class ObServerTest {
    public static void main(String[] args) {
        //测试用例：
        //定义主题
        Subject subject = new Subject();
        //定义观察者并添加观察者对象
        Task1 observer1 = new Task1();
        Task2 observer2 = new Task2();
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        //进行事件通知
        subject.notifyObserver("xxx");

        //移除一个事件
        subject.remove(observer1);
        //再次发布一个事件
        subject.notifyObserver("yyy");
    }
}


//主题者对象
class Subject{
    //保存观察者的容器
    private List<Observer> container = new ArrayList<>();

    //添加观察者
    public void addObserver(Observer observer){
        container.add(observer);
    }

    //删除观察者
    public void remove(Observer observer){
        container.remove(observer);
    }

    //更新通知
    public void notifyObserver(Object object){
        //将更新消息通知到每一个观察者
        for(Observer item:container){
            item.update(object);
        }
    }
}


interface Observer{
    //接收更新接口
    void update(Object object);
}

//定义一个观察者实体
class Task1 implements Observer{
    @Override
    public void update(Object object) {
        System.out.println("task1 received: "+object);
    }
}

class Task2 implements Observer{
    @Override
    public void update(Object object) {
        System.out.println("task2 received: "+object);
    }
}