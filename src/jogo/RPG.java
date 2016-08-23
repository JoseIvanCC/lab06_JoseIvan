package jogo;

/**
 * Classe do jogo de RPG que calcula o x2pPontos respectivo ao tipo do jogo e registra a jogada no mesmo.
 * @author joseiscj
 *
 */

public class RPG extends Jogo {

	protected int x2pPontos;
	
	/**
	 * O construtor de RPG inicializa o x2pPontos do jogo e passa a informação da quantidade de score por ponto.
	 * @param nome Nome do jogo de RPG.
	 * @param preco Preco do respectivo jogo.
	 * @throws Exception Protege a criacao do meu jogo contra nome vazio e preço menor ou igual a zero.
	 */
	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
		x2pPontos = 0;
	}

	/**
	 *  Metodo que registra a jogada. Conta quantas vezes o jogo foi jogado, zerado e faz o calculo do seu x2pPontos.
	 */
	public int registraJogada(int score, boolean zerouJogo) {
		super.setQntVezesQueJogou();
		if (score > maiorScore) {
			this.maiorScore = score;
			
		}

		if (zerouJogo) {
			super.incrementaQntQueZerou();
		}
		return 10;

	}
	/**
	 * Representacao da mensagem do jogo.
	 */
	public String toString() {

		return "+ " + super.getNome() + " - RPG:%n" + "==> Jogou " + super.getQntVezesQueJogou() + " vez(es)%n"
				+ "==> Zerou " + super.getQntVezesZerou() + " vez(es)%n" + "==> Maior score: %n"
				+ super.getMaiorScore();

	}

	public int getX2pPontos() {
		return x2pPontos;
	}

	public void setX2pPontos(int x2pPontos) {
		this.x2pPontos = x2pPontos;
	}

}
