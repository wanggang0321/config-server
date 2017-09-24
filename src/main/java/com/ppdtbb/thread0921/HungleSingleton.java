package com.ppdtbb.thread0921;

public class HungleSingleton {

    private static HungleSingleton hungleSingleton = new HungleSingleton();

    private HungleSingleton() {

    }

    public HungleSingleton getInstance() {
        return hungleSingleton;
    }

}
