package usuario;

import jogo.Jogo;

public class Noob extends Usuario {

	private final double DESCONTO;
	private final int PONTOS;

	public Noob(String nome, String nomeLogin) {
		super(nome, nomeLogin);
		DESCONTO = 0.10;
		super.x2pPontos = 0;
		PONTOS = 10;
	}

	public boolean comprarJogo(Jogo jogo, double preco) throws Exception {
		x2pPontos += PONTOS * (int) preco;
		preco -= preco * DESCONTO;

		super.descontaDinheiro(preco);

		this.meusJogos.add(jogo);

		return true;

	}

	public String toString() {
		
		double precoTotal = 0;
		
		String mensagem = super.getNomeLogin() + "%n" + super.getNome() + " - Jogador Noob";
		for (Jogo jogo : super.meusJogos) {
			mensagem += jogo.toString();
			precoTotal += jogo.getPreco();
		}
		
		mensagem += "Total de preço dos jogos: R$ %n" + precoTotal + "--------------------------------------------";

		return mensagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(DESCONTO);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + PONTOS;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Noob))
			return false;
		Noob other = (Noob) obj;
		if (Double.doubleToLongBits(DESCONTO) != Double
				.doubleToLongBits(other.DESCONTO))
			return false;
		if (PONTOS != other.PONTOS)
			return false;
		return true;
	}

}
