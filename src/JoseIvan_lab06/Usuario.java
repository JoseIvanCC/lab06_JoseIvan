package JoseIvan_lab06;

import java.util.HashSet;

public class Usuario {
	
	private String nome;
	private String nomeLogin;
	protected HashSet<Jogo> meusJogos;
	protected int qntDinheiro;
	protected int x2pPontos;
	
	public Usuario(String nome, String nomeLogin) {
		
		this.nome = nome;
		this.nomeLogin = nomeLogin;
		this.meusJogos = new HashSet<>();
		this.qntDinheiro = 0;
		this.x2pPontos = 0;
	}
	
	public void depositaDinheiro(int valor) {
		this.qntDinheiro += valor;
	}
	
	public void comprarJogo(double qntDinheiro, String nome, double preco) throws Exception {
		Jogo jogo = new Jogo(nome, preco);
		meusJogos.add(jogo);
		
	}
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) {
		
		for (Jogo jogo : meusJogos) {
			if (jogo.getNome().contains(nomeDoJogo)){
				this.x2pPontos +=  jogo.registraJogada(score, zerouJogo);
			}
		}
		
		}
	
	

}
