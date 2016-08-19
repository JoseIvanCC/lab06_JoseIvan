package jogo;


public class JogoFactory {
	
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
