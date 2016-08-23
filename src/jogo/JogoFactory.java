package jogo;

/**
 * Classe que cria o jogo.
 * @author joseiscj
 *
 */
public class JogoFactory {
	/**
	 * Construtor que cria os jogos respectivos ao seu tipo.
	 * @param nome Nome do jogo.
	 * @param preco Preco do jogo.
	 * @param tipo Tipo do jogo.
	 * @return Retorno Retorna o jogo criado.
	 * @throws Exception Nao permite a criacao de um jogo diferente de RPG, plataforma ou luta.
	 */
	public Jogo criaJogo(String nome, double preco, String tipo) throws Exception{
		
		Jogo jogo;
		if (tipo.equalsIgnoreCase("RPG")) {
			jogo = new RPG(nome, preco);
		}

		else if (tipo.equalsIgnoreCase("Plataforma")) {
			jogo = new Plataforma(nome, preco);
		}

		else if (tipo.equalsIgnoreCase("Luta")) {
			jogo = new Luta(nome, preco);
		}

		else {
			throw new Exception("Jogo precisa ser do tipo RPG, plataforma, luta.");
		}
		
		return jogo;
		
	}

}
