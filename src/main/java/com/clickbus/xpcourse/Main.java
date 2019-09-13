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
        startCapturingButtons(jogo);

        loopPrincipal(jogo);
    }

    private static void loopPrincipal(Jogo jogo) throws IOException, InterruptedException {
        while (true) {
            System.out.println("-----");
            jogo.tick();
            System.out.println(jogo.tela());
            clearScreen();
            Thread.sleep(1000);
        }
    }

    public static void clearScreen() {
        System.out.println("\n\n\n\n\n");
    }

    public static void startCapturingButtons(final Jogo jogo) {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        frame.add(button);
        frame.setVisible(true);
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_LEFT:
                        jogo.esquerda();
                        break;

                    case KeyEvent.VK_RIGHT:
                        jogo.direita();
                        break;
                }
            }
        });
    }
}