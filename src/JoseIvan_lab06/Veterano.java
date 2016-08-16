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
	
	public void comprarJogo(String nome, double preco) throws Exception {
		Jogo jogo = new Jogo(nome, preco);
		super.qntDinheiro -= preco * DESCONTO;
		x2pPontos += PONTOS * (int) preco;
		super.meusJogos.add(jogo);
	}
	

}
