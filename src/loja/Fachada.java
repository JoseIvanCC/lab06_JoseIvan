package loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import jogo.Jogo;
import jogo.JogoFactory;
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

	private HashMap<String, Usuario> usuarios;
	private ArrayList<Jogo> jogos;
	private UsuarioFactory usuario;
	private JogoFactory jogo;

	/**
	 * Construtor da loja que inicializa a minha lista de jogos e o meu mapa de
	 * usuarios.
	 */
	public Fachada() {
		usuarios = new HashMap<>();
		usuario = new UsuarioFactory();
		jogos = new ArrayList<Jogo>();
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

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(ArrayList<Jogo> jogos) {
		this.jogos = jogos;
	}

	/**
	 * Metodo que cadastra o usuario na loja.. 
	 * @param nomeLogin Login do usuario para cadastra-lo.
	 * @param nome Nome do usuario para cadastra-lo
	 * @param tipoUsuario Tipo do usuario
	 * @return Retorno true se o usuario foi adicionado com sucesso e retorno false se o mesmo nao foi aicionado (login passado ja existe).
	 */
	public boolean adicionaUsuarios(String nomeLogin, String nome, String tipoUsuario) {
		try {
			if (usuarios.containsKey(nomeLogin)) {
				return false;
			} else {

				Usuario jogador = usuario.criaUsuario(nomeLogin, nome,
						tipoUsuario);

				this.usuarios.put(nomeLogin, jogador);

				return true;
			}

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/**
	 * Metodo que verifica se um jogo existe na minha loja.
	 * @param nome Nome do jogo a ser comprado.
	 * @return Retorno true se o jogo existe e false se o mesmo não existe.
	 */
	public boolean contemJogo(String nome) {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Metodo que verifica a existencia do jogo na loja.
	 * @param nome Nome do jogo a ser verificado.
	 * @return Se o jogo existir, retorna o respectivo jogo.
	 */
	public Jogo getJogo(String nome) {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equalsIgnoreCase(nome)) {
				return jogo;
			}
		}
		return null;
	}

	public boolean adicionaJogo(String nome, double preco, String tipo) {
		try {

			Jogo game = jogo.criaJogo(nome, preco, tipo);
			this.jogos.add(game);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return false;

	}
	/**
	 * Metodo que adiciona dinheiro (credito) pro usuario para compras de jogos.
	 * @param nomeLogin Login do comprador de credito.
	 * @param Dinheiro Dinheiro da compra.
	 * @return Retorno true se o dinheiro foi adicionado com sucesso e false se não foi.
	 */
	public boolean adicionaDinheiro(String nomeLogin, double dinheiro) {
		try {

			if (usuarios.containsKey(nomeLogin)) {
				usuarios.get(nomeLogin).depositaDinheiro(dinheiro);
				return true;
			}
			return false;

		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

	}
	
	/**
	 * Metodo que vende os jogos para o usuario.
	 * @param nomeLogin Login do usuario a quem vai ser vendido o jogo.
	 * @param valor Valor do jogo a as er vendido.
	 * @param nomeJogo Nome do jogo a ser vendido.
	 * @return Retorno true se foi vendido com sucesso e false se não foi.
	 */
	public boolean venderJogos(String nomeLogin, double valor, String nomeJogo) {
		try {
			if (this.usuarios.containsKey(nomeLogin) && this.contemJogo(nomeJogo)) {
				if (this.usuarios.get(nomeLogin).getQntDinheiro() >= valor) {
					Jogo jogo = this.getJogo(nomeJogo);
					usuarios.get(nomeLogin).comprarJogo(jogo, valor);
					return true;
				}
				return false;
			}
			return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
	/**
	 * Metodo que faz o upgrade do usuario noob para veterano.
	 * @param loginUsuario Login do usuario para o upgrade.
	 * @throws Exception Não permite o upgrade de usuario com x2pPontos menor que 1000 e se o mesmo ja for veterano.
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
		String mensagem = "=== Central P2-CG ===%n";

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
		result = prime * result + ((jogos == null) ? 0 : jogos.hashCode());
		result = prime * result
				+ ((usuarios == null) ? 0 : usuarios.hashCode());
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
