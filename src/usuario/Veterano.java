package usuario;

import jogo.Jogo;

/**
 * Classe do usuário veterano, executando as suas compras de acordo com seu desconto e calculando seu x2pPontos.
 * @author joseiscj
 *
 */
public class Veterano extends Usuario {
	
	private final double DESCONTO = 0.20;
	private final int PONTOS = 15;
	
/**
 * Construtor que inicializa o desconto e os pontos. 
 * @param nome Nome do usuario veterano.
 * @param nomeLogin Login do usuario veterano.
 * @throws Exception Nao permite a criacao de um usuario noob com nome ou login vazios ou nulos.
 */
	public Veterano(String nome, String nomeLogin) throws Exception {
		super(nome, nomeLogin);
		
		super.x2pPontos = 1000;
		
	}
	
/**
 * Metodo que compra o jogo pelo usuario, levando em consideracao o desconto respectivo.
 */
	public boolean comprarJogo(Jogo jogo, double preco) throws Exception {
		x2pPontos += PONTOS * (int) preco;
		double desconto = preco * DESCONTO;
		double novoPreco = preco - desconto; 

		setQntDinheiro(novoPreco);

		this.meusJogos.add(jogo);

		return true;
		
		}

	/**
	 * Representacao da mensagem de veterano.
	 */
	public String toString() {
		
		double precoTotal = 0;
	
		String mensagem = super.getNomeLogin() + "\n" + super.getNome() + " - Jogador Veterano";
		for (Jogo jogo : super.meusJogos) {
			mensagem += jogo.toString();
			precoTotal += jogo.getPreco();
		}
		
		mensagem += "\nTotal de preço dos jogos: R$ " + precoTotal + "\n--------------------------------------------";
		
		return mensagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Veterano))
			return false;
		Veterano other = (Veterano) obj;
		if (Double.doubleToLongBits(DESCONTO) != Double
				.doubleToLongBits(other.DESCONTO))
			return false;
		if (PONTOS != other.PONTOS)
			return false;
		return true;
	}

}
