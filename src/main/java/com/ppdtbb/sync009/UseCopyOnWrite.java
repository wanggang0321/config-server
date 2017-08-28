package com.ppdtbb.sync009;

import java.util.concurrent.CopyOnWriteArrayList;

public class UseCopyOnWrite {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> cow1 = new CopyOnWriteArrayList<String>();

        cow1.add("");
    }

}
