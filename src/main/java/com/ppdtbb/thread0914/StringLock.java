package com.ppdtbb.thread0914;

public class StringLock {

    public void method() {
        String str = new String("字符串常量");
        //String str = "字符串常量";
        synchronized (str) {
            try {
                while (true) {
                    System.out.println("当前线程 " + Thread.currentThread().getName() + " 开始");
                    Thread.sleep(1000);
                    System.out.println("当前线程 " + Thread.currentThread().getName() + " 结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        StringLock sl = new StringLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sl.method();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sl.method();
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}
