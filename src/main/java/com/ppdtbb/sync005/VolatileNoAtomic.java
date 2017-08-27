package com.ppdtbb.sync005;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileNoAtomic extends Thread {

//    private static volatile int count;
    private static AtomicInteger count = new AtomicInteger(0);

    private static void addCount() {
        for(int i=0;i<1000;i++) {
            //count++;
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    public void run(){
        addCount();
    }

    public static void main(String[] args) {
        VolatileNoAtomic vna[] = new VolatileNoAtomic[10];
        for(int i=0;i<10;i++) {
            vna[i] = new VolatileNoAtomic();
        }
        for(VolatileNoAtomic v : vna) {
            v.start();
        }
    }

}
