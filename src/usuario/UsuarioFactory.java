package usuario;

/**
 * Classe que cria o usuario.
 * @author joseiscj
 *
 */
public class UsuarioFactory {
	/**
	 * Construtor que cria os usuarios respectivos ao seu tipo.
	 * @param nomeLogin Login do usuario.
	 * @param nome Nome do usuario.
	 * @param tipoUsuario Tipo do usuario.
	 * @return Retorna o usuario criado.
	 * @throws Exception Nao permite a criacao de um usuario que nao seja noob ou veterano.
	 */
	
	public Usuario criaUsuario(String nomeLogin, String nome, String tipoUsuario) throws Exception{
		
		Usuario usuario;
		
		if (tipoUsuario.equalsIgnoreCase("Noob")) {
			usuario = new Noob(nome, nomeLogin);
		}
		
		else if (tipoUsuario.equalsIgnoreCase("Veterano")) {
			usuario = new Veterano(nome, nomeLogin);
			
		}else{
			throw new Exception("Nao pode ser um usuario diferente de noob ou veterano.");
		}
		
		return usuario;
	}
	

}
