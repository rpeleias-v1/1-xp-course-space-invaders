package com.clickbus.xpcourse;
import com.clickbus.xpcourse.jogos.Jogo;
import com.clickbus.xpcourse.jogos.SpaceOfGilver;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Main {


    private static Map<Character, BufferedImage> imagens;

    public static void main(String[] args) throws InterruptedException {
        Jogo jogo = new SpaceOfGilver();
        capturarMovimentos(jogo);
        jogar(jogo);
    }

    private static void carregarImagens() throws IOException {
        imagens = new HashMap<Character, BufferedImage>();
        imagens.put('V', ImageIO.read(new FileInputStream("pacboy.png")));
        imagens.put('M', ImageIO.read(new FileInputStream("fantasma.png")));
        imagens.put('*', ImageIO.read(new FileInputStream("food.png")));
        imagens.put('|', ImageIO.read(new FileInputStream("neon.png")));
    }

    private static void jogar(Jogo jogo) throws InterruptedException {
        while (true) {
            System.out.println("-----");
            jogo.tick();
            String tela = jogo.tela();
            System.out.println(tela);
            limparTela();
            if (tela.equals("Game over")) {
                break;
            }

            Thread.sleep(300);
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
                if(e.getKeyCode() == KeyEvent.VK_LEFT)  jogo.esquerda();
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) jogo.direita();
                if(e.getKeyCode() == KeyEvent.VK_SPACE) jogo.tiro();
            }
        });
    }
}