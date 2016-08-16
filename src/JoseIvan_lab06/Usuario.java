package JoseIvan_lab06;

import java.util.HashSet;

public class Usuario {

	private String nome;
	private String nomeLogin;
	protected HashSet<Jogo> meusJogos;
	protected double qntDinheiro;
	protected int x2pPontos;

	public Usuario(String nome, String nomeLogin) {

		this.nome = nome;
		this.nomeLogin = nomeLogin;
		this.meusJogos = new HashSet<>();
		this.qntDinheiro = 0;
		this.x2pPontos = 0;
	}

	public void depositaDinheiro(double valor) {
		this.qntDinheiro += valor;
	}

	public boolean comprarJogo(Jogo jogo, double preco) throws Exception {
		
			this.qntDinheiro -= preco;

			this.meusJogos.add(jogo);

			return true;
	}

	public void registraJogada(String nomeDoJogo, int score, boolean zerouJogo) {

		for (Jogo jogo : meusJogos) {
			if (jogo.getNome().contains(nomeDoJogo)) {
				this.x2pPontos += jogo.registraJogada(score, zerouJogo);
			}
		}

	}
	
	public double getQntDinheiro() {
		return qntDinheiro;
	}

}
