package base;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Map;

public class LoopPrincipal {
	
	private final JogoModoTexto _jogo;
	private Map<Character, BufferedImage> _mapa;
	private JogoCanvas _canvas;

	public LoopPrincipal(JogoModoTexto jogo, Map<Character, BufferedImage> cacheBitmaps) {
		_jogo = jogo; 
		_mapa = cacheBitmaps;
	}

	public void start()  {
		iniciaCapturaDeTeclas();
		
		while (true) {
			esperaUmPouquinho();
			_jogo.step();
			exibeTelaGrafica();
			imprimeTelaNoConsole();
		}
	}
	
	private void exibeTelaGrafica() {
		_canvas.atualizaTela(_jogo.tela());
	}

	private void iniciaCapturaDeTeclas() {
		JFrame frame = new JFrame();
		frame.setSize(448, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_canvas = new JogoCanvas(_mapa);
		_canvas.setFocusable(true);
		
		frame.add(_canvas);
		frame.setVisible(true);
		
		_canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					_jogo.espaco();
					break;
				case KeyEvent.VK_UP:
					_jogo.sobe();
					break;
				case KeyEvent.VK_DOWN:
					_jogo.desce();
					break;
				case KeyEvent.VK_LEFT:
					_jogo.esquerda();
					break;
				case KeyEvent.VK_RIGHT:
					_jogo.direita();
					break;
				}
			}
		});
	}
	
	private void imprimeTelaNoConsole() {
		String[] tela = _jogo.tela();

		quebraLinhas();
		
		for (String linhaAtual : tela) 
			System.out.println(linhaAtual);
		
		//_canvas.atualizaTela(tela);
	}
	
	private void quebraLinhas() {
		System.out.println("\n \n \n \n");
	}

	private void esperaUmPouquinho() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
