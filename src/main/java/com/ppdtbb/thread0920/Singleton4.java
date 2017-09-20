package com.ppdtbb.thread0920;

/**
 * 懒汉式
 */
public class Singleton4 {

    private static Singleton4 instance = null;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if(instance==null) {
            instance = new Singleton4();
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton4.getInstance().hashCode());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton4.getInstance().hashCode());
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton4.getInstance().hashCode());
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
