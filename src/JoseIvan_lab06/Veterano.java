package JoseIvan_lab06;

public class Veterano extends Usuario {
	
	private final double DESCONTO;
	private final int PONTOS;
	
	public Veterano(String nome, String nomeLogin) {
		super(nome, nomeLogin);
		DESCONTO = 0.20;
		super.x2pPontos = 1000;
		PONTOS = 15;
	}
	
	public boolean comprarJogo(Jogo jogo, double preco) throws Exception {
		preco -= preco * DESCONTO;
		x2pPontos += PONTOS * (int) preco;
		return super.comprarJogo(jogo, preco);
		
		}

}
