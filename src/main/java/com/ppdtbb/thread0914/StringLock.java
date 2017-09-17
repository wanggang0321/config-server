package com.ppdtbb.thread0914;

public class StringLock {

    public void method() {

        String str = new String("字符串常量");
        System.out.println(Thread.currentThread().getName() + " 线程执行了：" + str);

        //String str = "字符串常量";
        //1. 如果使用str作为锁，t1 和 t2 会并行执行
        //2. 如果使用 "字符串常量" 作为锁，t1 和 t2 会串行执行
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
            public void run() {
                sl.method();
            }
        }, "t11");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                sl.method();
            }
        }, "t22");

        t2.start();
        t1.start();
    }

}
