package com.ppdtbb.thread0924;

public class InnerSingleton {

    private InnerSingleton() {

    }

    private static class Singleton {
        private static Singleton singleton = new Singleton();
    }

    public Singleton getInstance() {

        return Singleton.singleton;
    }

}
