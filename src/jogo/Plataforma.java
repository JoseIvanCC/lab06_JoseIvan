package jogo;


public class Plataforma extends Jogo{
	
	protected int x2pPontos;
	
	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
		x2pPontos = 0;
	}
	
	public int registraJogada(int score, boolean zerouJogo) {
		if (zerouJogo) {
			x2pPontos += 20;
		}
		
		return x2pPontos;
		
	}
	
	public String toString() {
		
		return "+ " + super.getNome() + " - Plataforma%n" + "==> Jogou " + super.getQntVezesQueJogou() + " vez(es)%n" +
	"==> Zerou " + super.getQntVezesZerou() + " vez(es)%n" + "==> Maior score: %n" + super.getMaiorScore();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + x2pPontos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Plataforma))
			return false;
		Plataforma other = (Plataforma) obj;
		if (x2pPontos != other.x2pPontos)
			return false;
		return true;
	}


}
