package feature.lockorcommunicate; /**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: DeadLockTest
 * Author:   Jianf
 * Date:     2020/7/17 15:06
 * Description: 死锁例程测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈死锁例程测试〉
 *
 * @author Jianf
 * @create 2020/7/17
 * @since 1.0.0
 */

class lock1 implements Runnable {
    @Override
    public void run() {
        synchronized (DeadLock.l1) { // 拿到了第一个锁
            System.out.println("1：我获得了第一个锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLock.l2) { // 拿到了第一个锁的时候，不释放自己的锁，继续去获取第二个锁
                System.out.println("1：我获得了第二个锁");
            }
        }
    }
}

class lock2 implements Runnable {
    @Override
    public void run() {
        synchronized (DeadLock.l2) { // 拿到了第一个锁
            System.out.println("2：我获得了第一个锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLock.l1) { // 拿到了第一个锁的时候，不释放自己的锁，继续去获取第二个锁
                System.out.println("2：我获得了第二个锁");
            }
        }
    }
}

class DeadLock {
    public static String l1 = "feature.lockorcommunicate.lock1"; // 资源1
    public static String l2 = "feature.lockorcommunicate.lock2"; // 资源2

    public static void main(String[] args) {
        Thread lo1 = new Thread(new lock1());
        Thread lo2 = new Thread(new lock2());
        lo1.start();
        lo2.start();
        Runnable runnable = () -> { // 用来为接口生成一个实现类
            System.out.println("test");
        };
        runnable.run();
    }

}