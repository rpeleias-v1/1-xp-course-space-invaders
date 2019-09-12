package com.clickbus.xpcourse;

import java.io.IOException;
import java.util.List;

public class Hello {

    public static void main(String[] args) throws InterruptedException, IOException {
        Space space = new Space();
        List<String> spaceLines = space.renderThreeLines();

        while (true) {
            for (String line: spaceLines) {
                System.out.println(line);
            }
            clearScreen();
            Thread.sleep(1000);
        }
    }

    public static void clearScreen() throws IOException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//        System.out.flush();
    }


    public String greeting() {
        return "Hello world!";
    }
}
