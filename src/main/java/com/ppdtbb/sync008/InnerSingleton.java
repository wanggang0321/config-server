package com.ppdtbb.sync008;

/**
 * static inner class
 * 最常用、最安全的解决方案
 */
public class InnerSingleton {

    private static class Singletion {
        private static Singletion single = new Singletion();
    }

    public static Singletion getInstance() {
        return Singletion.single;
    }

}
