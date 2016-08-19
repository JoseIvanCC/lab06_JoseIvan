package loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import jogo.Jogo;
import jogo.JogoFactory;
import usuario.Usuario;
import usuario.UsuarioFactory;
import usuario.Veterano;

public class Fachada {

	private HashMap<String, Usuario> usuarios;
	private ArrayList<Jogo> jogos;
	private UsuarioFactory usuario;
	private JogoFactory jogo;

	public Fachada() {
		usuarios = new HashMap<>();
		usuario = new UsuarioFactory();
		jogos = new ArrayList<Jogo>();
		jogo = new JogoFactory();
	}

	public boolean adicionaUsuarios(String nomeLogin, String nome, String tipoUsuario) {
		try{
		if (usuarios.containsKey(nomeLogin)) {
			return false;
		} else {
			
			Usuario jogador = usuario.criaUsuario(nomeLogin, nome, tipoUsuario);
			
			this.usuarios.put(nomeLogin, jogador);
			
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
			
			Jogo game = jogo.criaJogo(nome, preco, tipo);
			this.jogos.add(game);
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
	
	public void upgrade(String loginUsuario) throws Exception{
		
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fachada other = (Fachada) obj;
		if (jogos == null) {
			if (other.jogos != null)
				return false;
		} else if (!jogos.equals(other.jogos))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	
	}
