package com.ppdtbb.thread0924;

public class DoubleSingleton {

    private static DoubleSingleton ds;

    public static DoubleSingleton getDs() {

        if(ds == null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DoubleSingleton.class) {
                if(ds == null) {
                    ds = new DoubleSingleton();
                }
            }
        }

        return ds;
    }

}
