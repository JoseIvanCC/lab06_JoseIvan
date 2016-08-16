package JoseIvan_lab06;

import java.util.ArrayList;
import java.util.HashMap;

public class Fachada {

	private HashMap<String, Usuario> usuarios;
	private ArrayList<Jogo> jogos;

	public Fachada() {
		usuarios = new HashMap<>();
	}

	public boolean adicionaUsuarios(String nomeLogin, String nome, String loginUsuario) {
		try{
		if (usuarios.containsKey(nomeLogin)) {
			return false;
		} else {
			Usuario usuario = new Usuario(nome, loginUsuario);
			usuarios.put(nomeLogin, usuario);
			return true;
		}
		
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean contemJogo(String nome) {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public Jogo getJogo(String nome) {
		for (Jogo jogo : jogos) {
			if (jogo.getNome().equalsIgnoreCase(nome)) {
				return jogo;
			}
		}
		return null;
	}

	public boolean adicionaJogo(String nome, double preco, String tipo) {
		try{
			
			Jogo jogo = null;
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
				return false;
			}
			
			this.jogos.add(jogo);
			return true;
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			
		}
		return false;

	}

	public boolean adicionaDinheiro(String nomeLogin, double dinheiro) {
		try{
			
		if (usuarios.containsKey(nomeLogin)) {
			usuarios.get(nomeLogin).depositaDinheiro(dinheiro);
			return true;
		}
		return false;
		
	}catch (Exception e){
		
		System.out.println(e);
		return false;
	}
			
		}

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
}
