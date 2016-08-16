package JoseIvan_lab06;

public class RPG extends Jogo {

	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	public registraJogada(int score, boolean zerouJogo){
	if (score > maiorScore) {
		this.maiorScore = score;
	}
	
	if (zerouJogo) {
		 return incrementaQntQueZerou();
	}
	
	}
	

}
