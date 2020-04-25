package com.cybertek.library.utilities;

import java.time.Duration;
import java.time.Instant;

public class MakeItDoSomething {

    public static void main(String[] args) {

        Instant start = Instant.now();


        for (int i = 0; i < 5; i++) {
            DoesSomething doesSomething = new DoesSomething();
            doesSomething.start();
        }


        Instant finish = Instant.now();

        long time = Duration.between(start, finish).toMillis();  //in millis

        System.out.println("Total time: "+time);

    }
}
