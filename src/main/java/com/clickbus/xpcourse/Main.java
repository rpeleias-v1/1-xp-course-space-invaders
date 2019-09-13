package com.clickbus.xpcourse;
import com.clickbus.xpcourse.jogos.Jogo;
import com.clickbus.xpcourse.jogos.SpaceOfGilver;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Jogo jogo = new SpaceOfGilver();
        capturarMovimentos(jogo);
        jogar(jogo);
    }

    private static void jogar(Jogo jogo) throws InterruptedException {
        while (true) {
            System.out.println("-----");
            jogo.tick();
            System.out.println(jogo.tela());
            limparTela();
            Thread.sleep(1000);
        }
    }

    public static void limparTela() {
        System.out.println("\n\n\n\n\n");
    }

    public static void capturarMovimentos(final Jogo jogo) {
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