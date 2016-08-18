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

	public boolean comprarJogo(Jogo jogo, double preco) throws Exception {
		x2pPontos += PONTOS * (int) preco;
		preco -= preco * DESCONTO;
		
		super.descontaDinheiro(preco);

		this.meusJogos.add(jogo);

		return true;

	}
	
	public String toString() {
		
		return super.getNomeLogin() + "%n" + super.getNome() + " - Jogador Noob";
		
	}
	
}
