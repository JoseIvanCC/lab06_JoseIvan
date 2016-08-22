package jogo;


public class Luta extends Jogo {
	
	private final int SCORE_POR_PONTO;
	protected int x2pPontos;
	
	public Luta(String nome, double preco) throws Exception{
		super(nome, preco);
		SCORE_POR_PONTO = 1000;
		x2pPontos = 0;
	}

	
	public int registraJogada(int score, boolean zerouJogo) {
		if (score > super.maiorScore) {
			super.maiorScore = score;
			x2pPontos = score / SCORE_POR_PONTO;
		}
		
		if (zerouJogo) {
			 super.incrementaQntQueZerou();
		}
		
		return x2pPontos;
	}
	
public String toString() {
		
		return "+ " + super.getNome() + " - Luta%n" + "==> Jogou " + super.getQntVezesQueJogou() + " vez(es)%n" +
	"==> Zerou " + super.getQntVezesZerou() + " vez(es)%n" + "==> Maior score: %n" + super.getMaiorScore();
	}


}
