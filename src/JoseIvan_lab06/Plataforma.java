package JoseIvan_lab06;

public class Plataforma extends Jogo{
	
	protected int x2pPontos;
	
	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
		x2pPontos = 0;
	}
	
	public int registraJogada(int score, boolean zerouJogo) {
		if (zerouJogo) {
			x2pPontos += 20;
		}
		
		return x2pPontos;
		
	}

}
