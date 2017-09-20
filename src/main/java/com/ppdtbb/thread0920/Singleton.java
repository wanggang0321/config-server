package com.ppdtbb.thread0920;

/**
 * 懒汉式单例
 * 在第一次调用的时候实例化自己
 *
 * http://blog.csdn.net/jason0539/article/details/23297037/
 */
public class Singleton {

    private Singleton() {

    }

    private static Singleton single = null;

    //静态工厂方法
    public static Singleton getInstance() {
        if(single == null) {
            synchronized (Singleton.class) {
                if(single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance().hashCode());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance().hashCode());
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance().hashCode());
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
