package base;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.Map;


public class JogoCanvas extends JPanel {
	private String[] _tela;
	private static final long serialVersionUID = 1L;
	private final Map<Character, BufferedImage> _sprites;

	public JogoCanvas(Map<Character, BufferedImage> sprites) {
		_sprites = sprites;
		setSize(new Dimension(448, 448));
		setBackground(Color.BLACK);
	}

	public void paint(Graphics g) {
		if (_tela == null) return; 
		
		Graphics2D g2d = (Graphics2D) g;
		for (int linha = 0; linha < _tela.length; linha++) {
			String conteudoLinha = _tela[linha];
			for (int coluna = 0; coluna < conteudoLinha.length(); coluna++) {
				RenderedImage bufferedImage = getSprite(coluna, conteudoLinha);
				g2d.drawRenderedImage(bufferedImage, AffineTransform.getTranslateInstance(coluna*64, linha*64));
			}
		}
	}

	private RenderedImage getSprite(int coluna, String conteudoLinha) {
		char caractere = conteudoLinha.charAt(coluna);
		RenderedImage bufferedImage = _sprites.get(caractere);
		if (bufferedImage == null) System.out.println("Sprite nao registrada para caracter: '" + caractere +"'");
		return bufferedImage;
	}

	public void atualizaTela(String[] pTela) {
		_tela = pTela;
		repaint();
	}

}