package com.clickbus.xpcourse;

import com.clickbus.xpcourse.jogos.Jogo;
import com.clickbus.xpcourse.jogos.SpaceOfGilver;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Jogo jogo = new SpaceOfGilver();

        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println(jogo.tela());
            jogo.tick();
            clearScreen();
            Thread.sleep(3000);
        }
    }

    public static void clearScreen() throws IOException {
        System.out.println("\n\n\n\n\n");
//        System.out.flush();
    }
}
