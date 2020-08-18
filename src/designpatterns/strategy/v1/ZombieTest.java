/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: ZombieTest
 * Author:   Jianf
 * Date:     2020/8/18 20:34
 * Description: 僵尸大战
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package designpatterns.strategy.v1;


/**
 * 〈一句话功能简述〉<br> 
 * 〈僵尸大战〉
 *
 * @author Jianf
 * @create 2020/8/18
 * @since 1.0.0
 */
public class ZombieTest {
    public static void main(String[] args) {
        AbstractZombie normalZombie = new NormalZombie();
        AbstractZombie flagZombie = new FlagZombie();

        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();
        System.out.println("-----------------------------");
        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
    }
}

//僵尸抽象类
abstract class AbstractZombie{
    public abstract void display();

    public void attack(){
        System.out.println("咬。");
    }
    public void move(){
        System.out.println("一步一步移动。。");
    }
}

//普通僵尸类
class NormalZombie extends AbstractZombie{
    @Override
    public void display() {
        System.out.println("我是普通僵尸");
    }
}

class FlagZombie extends AbstractZombie{
    @Override
    public void display() {
        System.out.println("我是旗手僵尸。。");
    }
}


//假设后来又多了一些种类的僵尸，他们的这些行为不全部一样

//大头僵尸
class BigHeadZombie extends AbstractZombie{
    @Override
    public void display() {
        System.out.println("我是大头僵尸。");
    }

    @Override
    public void attack() {
        //...
        System.out.println("头撞。");
    }
}

class XxxZombie extends BigHeadZombie{
    @Override
    public void move() {

        System.out.println("xxx...");
    }
}

//按照上面的逻辑，假设增加很多种类的僵尸，每次都需要继承或重写另一个僵尸类以实现其功能，代码将变得复杂难读