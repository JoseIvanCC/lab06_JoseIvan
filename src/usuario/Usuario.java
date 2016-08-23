package usuario;

/* 115210700 - José Ivan Silva da Cruz Júnior: LAB 06 - Turma 3 */

import java.util.HashSet;

import exceptions.LoginVazioException;
import exceptions.NuloVazioException;
import jogo.Jogo;

/**
 * Classe que passa todas as informacoes do usuario, bem como seus metodos de compra e deposito.
 * @author joseiscj
 *
 */
public abstract class Usuario {

	private String nome;
	private String nomeLogin;
	protected HashSet<Jogo> meusJogos;
	protected double qntDinheiro;
	protected int x2pPontos;

	/**
	 * Construtor que inicializa os atributos de usuario.
	 * @param nome Nome do usuario.
	 * @param nomeLogin Login do usuario.
	 * @throws Exception Nao permite a criacao de um usuario com nome ou login vazio ou nulo.
	 */
	public Usuario(String nome, String nomeLogin) throws NuloVazioException,LoginVazioException{
		if (nome.trim().isEmpty()){
			throw new NuloVazioException("Nome do usuario nao pode ser vazio ou nulo.");
		}
		
		if (nomeLogin.trim().isEmpty()){
			throw new LoginVazioException("Login do usuario nao pode ser vazio ou nulo.");
		}

		this.nome = nome;
		this.nomeLogin = nomeLogin;
		this.meusJogos = new HashSet<>();
		this.qntDinheiro = 0;
		this.x2pPontos = 0;
	}
/**
 * Metodo que deposita dinheiro na conta do usuario.
 * @param valor Dinheiro a ser adicionado.
 */
	public void depositaDinheiro(double valor) {
		this.qntDinheiro += valor;
	}
	
	/**
	 * Metodo que verifica a existencia do jogo na loja.
	 * @param nome Nome do jogo a ser verificado.
	 * @return Se o jogo existir, retorna o respectivo jogo.
	 */
	public Jogo getJogo(String nome) {
		for (Jogo jogo : meusJogos) {
			if (jogo.getNome().equalsIgnoreCase(nome)) {
				return jogo;
			}
		}
		return null;
	}
	
	/**
	 * Metodo que verifica se um jogo existe na minha loja.
	 * @param nome Nome do jogo a ser comprado.
	 * @return Retorno true se o jogo existe e false se o mesmo não existe.
	 */
	public boolean contemJogo(String nome) {
		for (Jogo jogo : meusJogos) {
			if (jogo.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}
/**
 * Metodo que compra o jogo pelo usuario. 
 * @param jogo Jogo a ser comprado.
 * @param preco Preco do respectivo jogo.
 * @return Retorno true se o jogo foi comprado e false se não.
 * @throws Exception Nao permite a compra de um jogo vazio ou nulo ou de um preco menor ou igual a zero.
 */
	public abstract boolean comprarJogo(Jogo jogo, double preco) throws Exception;
	
	public void addJogo(Jogo jogo){
		meusJogos.add(jogo);
	}
	
	/** 
	 * Metodo que desconta dinheiro do usuario.
	 * @param preco
	 */
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
/**
 * Metodo que registra a jogada feita pelo usuario.
 * @param nomeDoJogo Jogo que foi jogado.
 * @param score Quantidade de score do jogo.
 * @param zerouJogo Verifica se zerou o jogo ou não.
 */
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
		this.qntDinheiro -= qntDinheiro;
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
		if (obj instanceof Usuario){
			Usuario usuario = (Usuario) obj;
			if (usuario.getNome().equalsIgnoreCase(this.getNome())){
				if (usuario.nomeLogin.equalsIgnoreCase(this.nomeLogin)){
					return true;
				}
				
			}
			return false;
				
		}else{
			return false;
		}
}

/**
 *  Representacao da mensagem do usuario.
 */
	public abstract String toString();

}
