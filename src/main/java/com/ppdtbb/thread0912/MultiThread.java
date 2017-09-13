package com.ppdtbb.thread0912;

public class MultiThread {

    private static int num = 0;

    public static synchronized void printNum(String tag) {

        try {
            if(tag.equals("a")) {
                num = 100;
                System.out.println("tag a, set num over!");

                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over!");
            }

            System.out.println("tag " + tag + ", num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        final MultiThread mu1 = new MultiThread();
        final MultiThread mu2 = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                mu1.printNum("a");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                mu2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }

}
