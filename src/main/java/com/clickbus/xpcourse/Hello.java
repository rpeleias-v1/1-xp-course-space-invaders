package com.clickbus.xpcourse;

import java.io.IOException;
import java.util.List;

public class Hello {

    public static void main(String[] args) throws InterruptedException, IOException {
        Space space = new Space();
        List<String> spaceLines = space.renderThreeLines();

        //while (true) {
            for (String line: spaceLines) {
                System.out.println(line);
            }
            clearScreen();
            Thread.sleep(3000);

        //}
    }

    public static void clearScreen() throws IOException {
        Runtime.getRuntime().exec("clear");
    }


    public String greeting() {
        return "Hello world!";
    }
}
