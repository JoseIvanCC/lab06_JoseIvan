package usuario;


public class UsuarioFactory {
	
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
