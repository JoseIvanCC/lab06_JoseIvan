package jogo;


public class RPG extends Jogo {
	
	protected int x2pPontos;

	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
		x2pPontos = 0;
	}
	
	public int registraJogada(int score, boolean zerouJogo){
	if (score > maiorScore) {
		this.maiorScore = score;
	}
	
	if (zerouJogo) {
		 super.incrementaQntQueZerou();
	}
	return 10;
	
	}
	
	public String toString() {
		
		return "+ " + super.getNome() + " - RPG%n" + "==> Jogou " + super.getQntVezesQueJogou() + " vez(es)%n" +
	"==> Zerou " + super.getQntVezesZerou() + " vez(es)%n" + "==> Maior score: %n" + super.getMaiorScore();
	
	}

	public int getX2pPontos() {
		return x2pPontos;
	}

	public void setX2pPontos(int x2pPontos) {
		this.x2pPontos = x2pPontos;
	}
	

}
