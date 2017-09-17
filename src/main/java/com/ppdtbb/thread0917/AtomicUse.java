package com.ppdtbb.thread0917;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicUse {

    private static AtomicInteger ai = new AtomicInteger(0);

    //多个addAndGet在一个方法内是非原子性的，需要加synchronized进行修饰，保证4个addAndGet整体原子性
    private synchronized void multiAdd() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ai.addAndGet(1);
        ai.addAndGet(2);
        ai.addAndGet(3);
        ai.addAndGet(4);

        System.out.println("ai is : " + ai);
    }

    public static void main(String[] args) {

        final AtomicUse au = new AtomicUse();

        List<Thread> tt = new ArrayList<Thread>();
        for(int i=0;i<100;i++) {
            tt.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    au.multiAdd();
                }
            }));
        }

        for(Thread t : tt) {
            t.start();
        }
    }

}
