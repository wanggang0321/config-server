package com.ppdtbb.thread0920;

/**
 * static inner class
 * http://blog.csdn.net/jason0539/article/details/23297037/
 */
public class Singleton3 {

    private static class SingletonInner {
        private static final Singleton3 instance = new Singleton3();
    }

    private Singleton3() {

    }

    public static final Singleton3 getInstance() {

        return SingletonInner.instance;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton3.getInstance().hashCode());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton3.getInstance().hashCode());
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton3.getInstance().hashCode());
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
