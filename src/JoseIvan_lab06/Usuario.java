package JoseIvan_lab06;

import java.util.HashSet;

public abstract class Usuario {

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

	public abstract boolean comprarJogo(Jogo jogo, double preco) throws Exception;
	
	public void descontaDinheiro(double preco) {
		this.qntDinheiro -= preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeLogin() {
		return nomeLogin;
	}

	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}

	public HashSet<Jogo> getMeusJogos() {
		return meusJogos;
	}

	public void setMeusJogos(HashSet<Jogo> meusJogos) {
		this.meusJogos = meusJogos;
	}

	public int getX2pPontos() {
		return x2pPontos;
	}

	public void setX2pPontos(int x2pPontos) {
		this.x2pPontos = x2pPontos;
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
