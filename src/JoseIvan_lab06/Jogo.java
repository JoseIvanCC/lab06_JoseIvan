package JoseIvan_lab06;

import java.util.HashSet;
import enums.Jogabilidade;

public class Jogo {
	
	private String nome;
	private double preco;
	private int maiorScore;
	private int qntVezesQueJogou;
	private int qntVezesZerou;
	private HashSet<Jogabilidade> modalidades;
	
	public Jogo(String nome, double preco) throws Exception{
		
		if (nome.trim().isEmpty()) {
			throw new Exception("Nome nao pode ser vazio ou nulo.");
		}
		
		if (preco <= 0) {
			throw new Exception("Preco não pode ser menor oui igual a zero.");
		}
		
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qntVezesQueJogou = 0;
		this.qntVezesZerou = 0;
		this.modalidades = new HashSet<>(); 
	}
	
	public void registraJogada(int score, boolean zerouJogo) {
		if (score > maiorScore) {
			this.maiorScore = score;
		}
		
		if (zerouJogo) {
			incrementaQntQueZerou();
		}
	}
	
	public void incrementaQntQueZerou() {
		this.qntVezesZerou +=1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	public int getQntVezesQueJogou() {
		return qntVezesQueJogou;
	}

	public void setQntVezesQueJogou() {
		this.qntVezesQueJogou += 1;
	}

	public int getQntVezesZerou() {
		return qntVezesZerou;
	}
	
	
}
