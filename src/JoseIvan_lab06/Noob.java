package JoseIvan_lab06;

public class Noob extends Usuario {
	
	private final double DESCONTO;
	private final int PONTOS;
	
	public Noob(String nome, String nomeLogin) {
		super(nome, nomeLogin);
		DESCONTO = 0.10;
		super.x2pPontos = 0;
		PONTOS = 10;
	}
	
	public void comprarJogo(String nome, double preco) throws Exception {
		Jogo jogo = new Jogo(nome, preco);
		super.qntDinheiro -= preco * DESCONTO;
		x2pPontos += PONTOS * (int) preco;
		super.meusJogos.add(jogo);
	}

}
