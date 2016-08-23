package jogo;

/**
 * Classe do jogo de luta que calcula o x2pPontos respectivo ao tipo de jogo e registra a jogada no mesmo.
 * @author joseiscj
 *
 */


public class Luta extends Jogo {
	
	private final int SCORE_POR_PONTO;
	protected int x2pPontos;
	
	/**
	 * O construtor de luta inicializa o x2pPontos do jogo e passa a informacao da quantidade de score por ponto.
	 * @param nome Nome do jogo de luta.
	 * @param preco Preco do respectivo jogo.
	 * @throws Exception Protege a criacao do meu jogo contra nome vazio e preço menor ou igual a zero.
	 */
	public Luta(String nome, double preco) throws Exception{
		super(nome, preco);
		SCORE_POR_PONTO = 1000;
		x2pPontos = 0;
	}

	/**
	 * Metodo que registra a jogada. Conta quantas vezes o jogo foi jogado, zerado e faz o calculo do seu x2pPontos.
	 */
	public int registraJogada(int score, boolean zerouJogo) {
		
		super.setQntVezesQueJogou();
		if (score > super.maiorScore) {
			super.setMaiorScore(score);
			x2pPontos = score / SCORE_POR_PONTO;
		}
		
		if (zerouJogo) {
			 super.incrementaQntQueZerou();
		}
		
		return x2pPontos;
	}
	
	/**
	 * Representacao da mensagem do jogo.
	 */
public String toString() {
		
		return "\nLista de Jogos: \n+ " + super.getNome() + " - Luta:\n" + "==> Jogou " + super.getQntVezesQueJogou() + " vez(es)\n" +
	"==> Zerou " + super.getQntVezesZerou() + " vez(es)\n" + "==> Maior score: " + super.getMaiorScore();
	}


}
