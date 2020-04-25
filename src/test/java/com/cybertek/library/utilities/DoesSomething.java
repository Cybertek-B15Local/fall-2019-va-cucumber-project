package com.cybertek.library.utilities;

public class DoesSomething extends Thread {

    public void run() {
        try {
            System.out.println("Thread " +
                    Thread.currentThread().getId() +
                    " is running");
            System.out.println("heelo");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
