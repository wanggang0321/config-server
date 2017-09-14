package com.ppdtbb.thread0914;

/**
 * synchronized的重入，父子类
 */
public class SyncDubbo2 {

    static class Main {
        protected int i = 10;
        public void operationSup() {
            try {
                i--;
                System.out.println(Thread.currentThread().getName() + " Main print i = " + i);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Main {
        public synchronized void operationSub() {
            try {
                while (i>0) {
                    i--;
                    System.out.println(Thread.currentThread().getName() + " Sub print i = " + i);
                    Thread.sleep(100);
                    this.operationSup();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Sub sub = new Sub();

        Thread t1 = new Thread(new Runnable() {
            public void run() {

                sub.operationSub();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                sub.operationSub();
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}
