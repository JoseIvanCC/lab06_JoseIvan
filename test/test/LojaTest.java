package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loja.Fachada;
import usuario.*;

public class LojaTest {
	
	private Fachada loja;
	
	@Before
	public void test(){
		this.loja = new Fachada();
		
	}
	
	@Test
	public void testVendaEAdicionaDinheiro() throws Exception{
		loja.adicionaUsuarios("wesley.anibal", "Wesley", "Noob");
		loja.adicionaDinheiro("wesley.anibal", 100.0);
		assertEquals(100.0, loja.contemUsuario("wesley.anibal").getQntDinheiro(), 0);
		loja.adicionaJogo("wesley.anibal", "Homem Aranha", 80.0, "Luta");
		loja.venderJogos("wesley.anibal", 80.0, "Homem Aranha", "Luta");
		assertEquals(28.0, loja.contemUsuario("wesley.anibal").getQntDinheiro(), 0);
		
		loja.adicionaUsuarios("jose.benardi.monitor.peso", "Benardi", "Veterano");
		loja.adicionaDinheiro("jose.benardi.monitor.peso", 1000.0);
		assertEquals(1000.0, loja.contemUsuario("jose.benardi.monitor.peso").getQntDinheiro(), 0);
		loja.adicionaJogo("jose.benardi.monitor.peso", "Fisica - Pagar por media - a saga", 100.0, "Luta");
		loja.venderJogos("jose.benardi.monitor.peso", 100.0, "Fisica - Pagar por media - a saga", "Luta");
		assertEquals(920.0, loja.contemUsuario("jose.benardi.monitor.peso").getQntDinheiro(), 0);
		
	}
	@Test
	public void testUpgrade() throws Exception{
		loja.adicionaUsuarios("seu.madruga", "Madrugov", "Noob");
		loja.getUsuarios().get("seu.madruga").setX2pPontos(5000);
		assertEquals(5000, loja.getUsuarios().get("seu.madruga").getX2pPontos());
		
		loja.upgrade("seu.madruga");
		assertEquals("Veterano", loja.getUsuarios().get("seu.madruga").getClass().getSimpleName());
	}
	
	@Test
	public void testException() throws Exception{
		try{
			Usuario usuarioTest = new Veterano("Jonas", "jonas.ppp");
			loja.adicionaUsuarios("jonas.ppp", "Jonas", "Veterano");
			loja.upgrade("jonas.ppp");
			fail();
			
		}catch (Exception e) {
			assertEquals("Usuario precisa ser Noob.", e.getMessage());
		}
		
		try{
			Usuario usuarioTest2 = new Noob("Chico", "chico.maradona");
			loja.adicionaUsuarios("chico.maradona", "Chico", "Noob");
			loja.getUsuarios().get("chico.maradona").setX2pPontos(999);
			loja.upgrade("chico.maradona");
			fail();
		}catch (Exception e) {
			assertEquals("Numero de x2pPontos precisa ser maior ou igual a 1000.", e.getMessage());
		}
		
		
	}
	
	@Test
	public void testToString() throws Exception{
		
		Fachada loja = new Fachada();
		loja.adicionaUsuarios("carlos.jj", "Carlos", "Noob");
		loja.adicionaJogo("carlos.jj","GTA", 100.0, "Luta");
		assertEquals(loja.toString(), "=== Central P2-CG ===\ncarlos.jj\nCarlos - Jogador Noob\nLista de Jogos: \n"
				+ "+ GTA - Luta:\n==> Jogou 0 vez(es)\n==> Zerou 0 vez(es)\n==> Maior score: 0\nTotal de preço dos jogos: R$ 100.0\n"
				+ "--------------------------------------------");
	}
	
}
