package JoseIvan_lab06;

import java.util.HashSet;

public class Usuario {
	
	private String nome;
	private String nomeLogin;
	private HashSet<Jogo> meusJogos;
	private int qntDinheiro;
	
	public Usuario(String nome, String nomeLogin) {
		
		this.nome = nome;
		this.nomeLogin = nomeLogin;
		this.meusJogos = new HashSet<>();
		this.qntDinheiro = 0;
	}
	
	public void depositaDinheiro(int valor) {
		this.qntDinheiro += valor;
	}
	
	public void comprarJogo(double qntDinheiro, String nome, double preco) throws Exception {
		Jogo jogo = new Jogo(nome, preco);
		meusJogos.add(jogo);
		
	}
	
	

}
