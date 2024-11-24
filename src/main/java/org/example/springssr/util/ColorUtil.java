package org.example.springssr.util;

import java.util.Random;

public class ColorUtil {
    public static String randomColor() {
        String zeros = "000000";
        Random rnd = new Random();
        String s = Integer.toString(rnd.nextInt(0X1000000), 16);

        return zeros.substring(s.length()) + s;
    }
}
