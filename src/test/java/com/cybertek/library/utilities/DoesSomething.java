package com.cybertek.library.utilities;

public class DoesSomething {

    public void run() {
        try {
            System.out.println("heelo");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
