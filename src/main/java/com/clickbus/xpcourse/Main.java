package com.clickbus.xpcourse;
import com.clickbus.xpcourse.jogos.Jogo;
import com.clickbus.xpcourse.jogos.SpaceOfGilver;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Jogo jogo = new SpaceOfGilver();
        shipMovement(jogo);
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
    }
    public static void shipMovement(final Jogo jogo) {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        frame.add(button);
        frame.setVisible(true);
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    jogo.esquerda();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    jogo.direita();
                }
            }
        });
    }
}