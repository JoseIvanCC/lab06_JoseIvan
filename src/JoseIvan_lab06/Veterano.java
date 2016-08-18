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
		x2pPontos += PONTOS * (int) preco;
		preco -= preco * DESCONTO;
		
		super.qntDinheiro -= preco;

		this.meusJogos.add(jogo);

		return true;
		
		}
	
	public String toString() {
		
		return super.getNomeLogin() + "%n" + super.getNome() + " - Jogador Veterano";
		
	}

}
