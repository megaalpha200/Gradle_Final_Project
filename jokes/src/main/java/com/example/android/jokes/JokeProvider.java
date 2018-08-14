package com.example.android.jokes;

import java.lang.String;
import java.util.Random;

public class JokeProvider {
    //Source: https://www.dcslsoftware.com/20-one-liners-only-software-developers-understand/
    private static final String[] JOKES = {
            "I went to a street where the houses were numbered 8k, 16k, 32k, 64k, 128k, 256k and 512k. It was a trip down Memory Lane.",
            "If doctors were like software engineers, they would say things like \"Have you tried killing yourself and being reborn?\"",
            "//be nice to the CPU\nThread_sleep(1);",
            "\"Debugging\" is like being the detective in a crime drama where you are also the murderer.",
            "!false\n(It\'s funny because it\'s true.)",
            "A programmer puts two glasses on his bedside table before going to sleep. A full one, in case he gets thirsty, and an empty one, in case he doesn\'t.",
            "An SQL query goes into a bar, walks up to two tables and asks: \"Can I join you?\""
    };

    public static String tellJoke() {
        Random rand = new Random();
        int randomNum = rand.nextInt(JOKES.length);
        return JOKES[randomNum];
    }
}
