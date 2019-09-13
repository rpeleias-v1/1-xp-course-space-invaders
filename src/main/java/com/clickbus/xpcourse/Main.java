package com.clickbus.xpcourse;
import com.clickbus.xpcourse.jogos.Jogo;
import base.JogoCanvas;
import com.clickbus.xpcourse.jogos.SpaceOfGilver;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {


    private static Map<Character, BufferedImage> imagens;
    private static JogoCanvas canvas;

    public static void main(String[] args) throws InterruptedException, IOException {
        carregarImagens();
        Jogo jogo = new SpaceOfGilver();
        capturarMovimentos(jogo);
        jogar(jogo);
    }

    private static void carregarImagens() throws IOException {
        imagens = new HashMap<Character, BufferedImage>();
        imagens.put('V', ImageIO.read(new FileInputStream("nave_inimiga.png")));
        imagens.put('A', ImageIO.read(new FileInputStream("gilvers_space_ship.jpg")));
        imagens.put('|', ImageIO.read(new FileInputStream("tiro.png")));
        imagens.put(' ', ImageIO.read(new FileInputStream("blank.png")));
        imagens.put('X', ImageIO.read(new FileInputStream("explosion.png")));
    }

    private static void jogar(Jogo jogo) throws InterruptedException {
        while (true) {
            System.out.println("-----");
            jogo.tick();
            String tela = jogo.tela();
            canvas.atualizaTela(tela.split("\n"));
            System.out.println(tela);

            limparTela();
            if (tela.equals("Game over")) {
                break;
            }

            Thread.sleep(1000);
        }
    }

    public static void limparTela() {
        System.out.println("\n\n\n\n\n");
    }

    public static void capturarMovimentos(final Jogo jogo) {
        canvas = new JogoCanvas(imagens);
        canvas.setFocusable(true);
        JFrame frame = new JFrame();
        JButton button = new JButton();
        frame.add(button);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(340, 340));
        frame.add(canvas);
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT)  jogo.esquerda();
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) jogo.direita();
                if(e.getKeyCode() == KeyEvent.VK_SPACE) jogo.tiro();
            }
        });
    }
}