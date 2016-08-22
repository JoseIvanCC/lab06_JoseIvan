package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import enums.Jogabilidade;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

public class JogoTest {
	private Jogo RPG;
	private Jogo plataforma;
	private Jogo luta;
	
	
	@Before
	public void setUp() throws Exception {
		this.RPG = new RPG("Skyrim", 30.0);
		this.plataforma = new Plataforma("Crash", 10.0);
		this.luta = new Luta("Mortal Combat", 20.0);
	}
	
	
	@Test
	public void testRegistraJogada(){
		RPG.registraJogada(10, true);
		assertEquals(10, RPG.getMaiorScore());
		assertEquals(1, RPG.getQntVezesZerou());
		assertEquals(1, RPG.getQntVezesQueJogou());
		RPG.registraJogada(9, false);
		assertEquals(10, RPG.getMaiorScore());
		
		luta.registraJogada(20, true);
		assertEquals(20, luta.getMaiorScore());
		assertEquals(1, luta.getQntVezesZerou());
		assertEquals(1, luta.getQntVezesQueJogou());
		luta.registraJogada(8, false);
		assertEquals(20, luta.getMaiorScore());
	}
	
	@Test
	public void testJogabilidade() throws Exception{
		plataforma.addJogabilidade(Jogabilidade.OFFLINE);
		assertTrue(plataforma.getModalidades().contains(Jogabilidade.OFFLINE));
	}
	
	@Test
	public void testExcepion() throws Exception{
		try{
			Jogo RPG = new RPG("", 20.0);
			fail();
		}catch (Exception e) {
			assertEquals("Nome nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		try{
			Jogo luta = new Luta("Street Fighter", 0.0);			
			fail();
		}catch (Exception e) {
			assertEquals("Preco nao pode ser menor ou igual a zero.", e.getMessage());
		}
		
		try{
			Jogo plataforma = new Plataforma("", 15.0);						
			fail();
		}catch (Exception e) {
			assertEquals("Nome nao pode ser vazio ou nulo.", e.getMessage());
		}

	}

}
