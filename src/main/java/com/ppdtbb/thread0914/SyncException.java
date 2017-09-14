package com.ppdtbb.thread0914;

public class SyncException {

    private int i = 0;

    public synchronized void operation() {

        while (true) {
            try {
                i++;
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " i = " + i);
                if (i == 4) {
                    Integer.parseInt("a");
                }
            } catch (Exception e) {
                e.printStackTrace();
                //记录日志
                System.out.println("log info：error occured at i = " + i);
                throw new RuntimeException();
            }
        }

    }

    public static void main(String[] args) {

        SyncException se = new SyncException();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.operation();
            }
        });

        t1.start();
    }

}
