package com.ppdtbb.thread0820;

/**
 * 1 多个对象多把锁
 * 2 被static表示类级别的锁
 */
public class MultiThread {

    private static int num = 0;

    private static synchronized void printNum(String type) {
        try {
            if ("a".equals(type)) {
                num = 200;
                System.out.println(Thread.currentThread().getName() + " is coming! type is :" + type);
                Thread.sleep(1000);
            } else {
                num = 100;
                System.out.println(Thread.currentThread().getName() + " is coming! type is :" + type);
                Thread.sleep(1000);
            }
            System.out.println("type is :" + type + ", num is :" + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                m1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }

}
