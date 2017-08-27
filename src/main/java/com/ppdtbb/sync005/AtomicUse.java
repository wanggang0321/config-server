package com.ppdtbb.sync005;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicUse {

    private static AtomicInteger count = new AtomicInteger(0);

    /** synchronized */
    public synchronized int multiAdd() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.addAndGet(1);
        count.addAndGet(2);
        count.addAndGet(3);
        count.addAndGet(4);
        return count.get();
    }

    public static void main(String[] args) {
        final AtomicUse au = new AtomicUse();

        List<Thread> ts = new ArrayList<Thread>();
        for(int i=0;i<100;i++) {
            ts.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(au.multiAdd());
                }
            }));
        }

        for(Thread t : ts) {
            t.start();
        }
    }

}
