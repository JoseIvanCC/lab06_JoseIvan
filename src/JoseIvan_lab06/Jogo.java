package JoseIvan_lab06;

import java.util.HashSet;

import enums.Jogabilidade;

public abstract class Jogo {
	
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
	
	public abstract int registraJogada(int score, boolean zerouJogo);
		
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maiorScore;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (maiorScore != other.maiorScore)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
			return false;
		return true;
	}

	public int getQntVezesZerou() {
		return qntVezesZerou;
	}
	
	
}
