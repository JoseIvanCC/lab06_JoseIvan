package usuario;

import java.util.HashSet;

import jogo.Jogo;

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
	
	public void setQntDinheiro(double qntDinheiro) {
		this.qntDinheiro = qntDinheiro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((meusJogos == null) ? 0 : meusJogos.hashCode());
		result = prime * result
				+ ((nomeLogin == null) ? 0 : nomeLogin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (meusJogos == null) {
			if (other.meusJogos != null)
				return false;
		} else if (!meusJogos.equals(other.meusJogos))
			return false;
		if (nomeLogin == null) {
			if (other.nomeLogin != null)
				return false;
		} else if (!nomeLogin.equals(other.nomeLogin))
			return false;
		return true;
	}


	public abstract String toString();

}
