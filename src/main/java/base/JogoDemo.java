package base;

public class JogoDemo implements JogoModoTexto {
	
	private String _ultimaAcao;

	@Override
	public void sobe() {
		_ultimaAcao = "Sobe";
	}

	@Override
	public void desce() {
		_ultimaAcao = "Desce";
	}

	@Override
	public void esquerda() {
		_ultimaAcao = "Esquerda";
	}

	@Override
	public void direita() {
		_ultimaAcao = "Direita";
	}

	@Override
	public void espaco() {
		_ultimaAcao = "Espaço";
	}
	
	public String getUltimaAcao() {
		return _ultimaAcao;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] tela() {
		return new String[] { 
				umaLinhaComODesenhoDaVez(),
				umaLinhaComODesenhoDaVez(),
				umaLinhaComODesenhoDaVez(),
				umaLinhaComODesenhoDaVez(),
				umaLinhaComODesenhoDaVez(),
				umaLinhaComODesenhoDaVez(),
				umaLinhaComODesenhoDaVez(),
		};
	}

	private String umaLinhaComODesenhoDaVez() {
		String retorno = "";
		for (int i = 0; i < 7; i++)
			retorno += desenhoDaVez();
		return retorno;
	}

	private long desenhoDaVez() {
		return ((System.nanoTime() % 4) + 1);
	}

}
