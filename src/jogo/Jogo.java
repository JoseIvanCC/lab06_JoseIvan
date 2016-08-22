package jogo;

import java.util.HashSet;

import enums.Jogabilidade;
import exceptions.NuloVazio;
/**
 * A classe passa as informacoes do jogo e define qual o comportamento de registrar a jogada para o objeto.
 * @author joseiscj
 *
 */
public abstract class Jogo {
	
	private String nome;
	private double preco;
	protected int maiorScore;
	private int qntVezesQueJogou;
	private int qntVezesZerou;
	private HashSet<Jogabilidade> modalidades;
	
	/**
	 * O construtor Jogo inicializa os atributos nome, preço, maior score, quantas vezes jogou e quantas vezes zerou do objeto.
	 * @param nome Define o nome do jogo.
	 * @param preco Define o preco do jogo.
	 * @throws Exception Protege a criacao do meu objeto contra nome vazio e preço menor ou igual a zero.
	 */
	public Jogo(String nome, double preco) throws Exception{
		
		if (nome.trim().isEmpty()) {
			throw new NuloVazio("Nome nao pode ser vazio ou nulo.");
		}
		
		if (preco <= 0) {
			throw new Exception("Preco nao pode ser menor ou igual a zero.");
		}
		
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qntVezesQueJogou = 0;
		this.qntVezesZerou = 0;
		this.modalidades = new HashSet<>(); 
	}
	/**
	 * Registra a jogada que o usuario der.
	 * @param score Define a quantidade de score do usuario.
	 * @param zerouJogo Define se o usuario zerou ou nao o jogo.
	 * @return
	 */
	public abstract int registraJogada(int score, boolean zerouJogo);
	
	public boolean addJogabilidade(Jogabilidade modo){
		return this.modalidades.add(modo);
	}
	
	public HashSet<Jogabilidade> getModalidades() {
		return modalidades;
	}
	public void setModalidades(HashSet<Jogabilidade> modalidades) {
		this.modalidades = modalidades;
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
		return this.qntVezesZerou;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((modalidades == null) ? 0 : modalidades.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo) {
			Jogo jogo = (Jogo) obj;
			if (jogo.getNome().equalsIgnoreCase(this.getNome())) {
				if (jogo.getPreco() == this.getPreco()) {
					return true;
				}

			}
			return false;

		} else {
			return false;
		}
	}
	
	
	
}

