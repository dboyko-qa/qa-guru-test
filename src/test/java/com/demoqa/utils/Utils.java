package com.demoqa.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static String getRandomGender() {
        return "Male";
    }

    public static String getRandomSubject() {
        return "Maths";
    }

    public static String getRandomFromArray(String[] array){

        int index = ThreadLocalRandom.current().nextInt(0, array.length);
        return array[index];
    }
}
