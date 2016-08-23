package loja;

/* 115210700 - José Ivan Silva da Cruz Júnior: LAB 06 - Turma 3 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import exceptions.LoginVazioException;
import exceptions.NuloVazioException;
import jogo.Jogo;
import jogo.JogoFactory;
import jogo.Luta;
import jogo.RPG;
import jogo.Plataforma;
import usuario.Usuario;
import usuario.UsuarioFactory;
import usuario.Veterano;

/**
 * Classe da loja, que recebe o dinheiro do usuário e vende os jogos de acordo
 * com os respectivos dencontoos pros mesmos. A loja também faz o upgrade do
 * usuário se o mesmo atingir os critérios exigidos.
 * 
 * @author joseiscj
 *
 */
public class Fachada {

	protected HashMap<String, Usuario> usuarios;
	protected UsuarioFactory usuario;
	protected JogoFactory jogo;

	/**
	 * Construtor da loja que inicializa a lista de jogos e o mapa de usuarios.
	 */
	public Fachada() {
		usuarios = new HashMap<>();
		usuario = new UsuarioFactory();
		jogo = new JogoFactory();
	}

	public UsuarioFactory getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioFactory usuario) {
		this.usuario = usuario;
	}

	public JogoFactory getJogo() {
		return jogo;
	}

	public void setJogo(JogoFactory jogo) {
		this.jogo = jogo;
	}

	public HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * Metodo que cadastra o usuario na loja..
	 * 
	 * @param nomeLogin
	 *            Login do usuario para cadastra-lo.
	 * @param nome
	 *            Nome do usuario para cadastra-lo
	 * @param tipoUsuario
	 *            Tipo do usuario
	 * @return Retorno true se o usuario foi adicionado com sucesso e retorno
	 *         false se o mesmo nao foi aicionado (login passado ja existe).
	 * @throws Exception
	 *             Nao permite adicao de nomes vazios e logins ja existententes.
	 */
	public boolean adicionaUsuarios(String nomeLogin, String nome, String tipoUsuario) throws Exception {
		try {
			if (usuarios.containsKey(nomeLogin)) {
				return false;
			} else {

				Usuario jogador = usuario.criaUsuario(nomeLogin, nome, tipoUsuario);

				this.usuarios.put(nomeLogin, jogador);

				return true;
			}

		} catch (NuloVazioException e) {
			throw new NuloVazioException("Nome nao pode ser vazio ou nulo");

		} catch (LoginVazioException e) {
			throw new LoginVazioException("Login nao pode ser vazio nem ja ser cadastrado");
		} catch (Exception e) {
			throw new Exception("Erro: " + e.getMessage());
		}
	}

	public Usuario getUsuario(String nomeLogin) throws Exception {
		if (usuarios.containsKey(nomeLogin)) {
			return usuarios.get(nomeLogin);
		}
		throw new Exception("Usuario não existe");
	}

	/**
	 * Metodo que verifica se o usuario esta cadastrado
	 * 
	 * @param nomeLogin
	 *            Login do usuario a ser verificado
	 * @return Retorna o usuario se sim e nada, se não.
	 */
	public Usuario contemUsuario(String nomeLogin) {
		if (usuarios.containsKey(nomeLogin)) {
			return usuarios.get(nomeLogin);
		}
		return null;
	}

	public boolean adicionaJogo(String nomeLogin, String nome, double preco, String tipo) throws Exception {
		try {
			Jogo jogo;
			Usuario usuario = getUsuario(nomeLogin);
			if(tipo.equals("RPG")){
				jogo = new RPG(nome, preco);
			} else if (tipo.equals("Luta")){
				jogo = new Luta(nome, preco);
			} else {
				jogo = new Plataforma(nome, preco);
			}
			usuario.addJogo(jogo);
			return true;

		} catch (NuloVazioException e) {
			throw new NuloVazioException("Nome nao pode ser vazio ou nulo");

		} catch (Exception e) {
			throw new Exception("Erro: " + e.getMessage());
		}

	}

	/**
	 * Metodo que adiciona dinheiro (credito) pro usuario para compras de jogos.
	 * 
	 * @param nomeLogin
	 *            Login do comprador de credito.
	 * @param Dinheiro
	 *            Dinheiro da compra.
	 * @return Retorno true se o dinheiro foi adicionado com sucesso e false se
	 *         não foi.
	 * @throws Exception
	 *             Nao permite a adicao de dinheiro em um nome vazio.
	 */
	public boolean adicionaDinheiro(String nomeLogin, double dinheiro) throws Exception {
		try {

			if (usuarios.containsKey(nomeLogin)) {
				usuarios.get(nomeLogin).depositaDinheiro(dinheiro);
				return true;
			}
			return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	/**
	 * Metodo que vende os jogos para o usuario.
	 * 
	 * @param nomeLogin
	 *            Login do usuario a quem vai ser vendido o jogo.
	 * @param valor
	 *            Valor do jogo a as er vendido.
	 * @param nomeJogo
	 *            Nome do jogo a ser vendido.
	 * @return Retorno true se foi vendido com sucesso e false se não foi.
	 * @throws Exception
	 *             nao permite a venda de jogos para nome e login vazios.
	 */
	public boolean venderJogos(String nomeLogin, double valor, String nomeJogo, String tipoJogo) throws Exception {
		try {
			Jogo jogo = new Luta(nomeJogo, valor);
			if (this.usuarios.containsKey(nomeLogin)) {
				if (this.usuarios.get(nomeLogin).getQntDinheiro() >= valor) {
					usuarios.get(nomeLogin).comprarJogo(jogo, valor);
					return true;
				}
				return false;
			}
			return false;

		} catch (NuloVazioException e) {
			throw new NuloVazioException("Nome nao pode ser vazio ou nulo");
		} catch (LoginVazioException e) {
			throw new LoginVazioException("Login nao pode ser vazio nem ja ser cadastrado");
		} catch (Exception e) {
			throw new Exception("Erro: " + e.getMessage());
		}

	}

	/**
	 * Metodo que faz o upgrade do usuario noob para veterano.
	 * 
	 * @param loginUsuario
	 *            Login do usuario para o upgrade.
	 * @throws Exception
	 *             Não permite o upgrade de usuario com x2pPontos menor que 1000
	 *             e se o mesmo ja for veterano.
	 */
	public void upgrade(String loginUsuario) throws Exception {

		Usuario usuario = usuarios.get(loginUsuario);

		if (usuario.getX2pPontos() < 1000) {
			throw new Exception("Numero de x2pPontos precisa ser maior ou igual a 1000.");
		}

		if (usuario.getClass() == Veterano.class) {
			throw new Exception("Usuario precisa ser Noob.");
		}

		Veterano usuarioVeterano = new Veterano(usuario.getNome(), usuario.getNomeLogin());
		usuarioVeterano.setMeusJogos(usuario.getMeusJogos());
		usuarioVeterano.setX2pPontos(usuario.getX2pPontos());
		usuarioVeterano.setQntDinheiro(usuario.getQntDinheiro());
		usuarios.remove(loginUsuario);
		usuarios.put(loginUsuario, usuarioVeterano);

	}

	/**
	 * Representacao da mensagem da loja.
	 */
	public String toString() {
		String mensagem = "=== Central P2-CG ===\n";

		Set<String> chaves = usuarios.keySet();

		for (String chave : chaves) {
			mensagem += usuarios.get(chave).toString();
		}

		return mensagem;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fachada) {
			Fachada loja = (Fachada) obj;
			if (loja.getUsuarios().equals(this.getUsuarios())) {
				return true;

			}
			return false;

		} else {
			return false;
		}
	}

}
