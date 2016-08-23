package jogo;

/**
 * Classe do jogo de plataforma que calcula o x2pPontos respectivo ao tipo do jogo e registra a jogada no mesmo.
 * @author joseiscj
 *
 */

public class Plataforma extends Jogo{
	
	protected int x2pPontos;
	
	/**
	 * O construtor de luta inicializa o x2pPontos do jogo e passa a informação da quantidade de score por ponto.
	 * @param nome Nome do jogo de plataforma.
	 * @param preco Preco do respectivo jogo.
	 * @throws Exception Protege a criacao do meu jogo contra nome vazio e preço menor ou igual a zero.
	 */
	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
		x2pPontos = 0;
	}
	
	/**
	 * Metodo que registra a jogada. Conta quantas vezes o jogo foi jogado, zerado e faz o calculo do seu x2pPontos.
	 */
	public int registraJogada(int score, boolean zerouJogo) {
		super.setQntVezesQueJogou();
		
		if (zerouJogo) {
			x2pPontos += 20;
			super.incrementaQntQueZerou();
		}
		
		return x2pPontos;
		
	}
	/**
	 * Representacao da mensagem do jogo.
	 */
	public String toString() {
		
		return "\nLista de Jogos: \n+ " + super.getNome() + " - Plataforma:\n" + "==> Jogou " + super.getQntVezesQueJogou() + " vez(es)\n" +
	"==> Zerou " + super.getQntVezesZerou() + " vez(es)\n" + "==> Maior score: " + super.getMaiorScore();
	}

}
