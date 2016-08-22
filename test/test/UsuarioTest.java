package test;

import jogo.Jogo;
import jogo.Luta;
import jogo.RPG;

import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.Test;

import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class UsuarioTest {
	private Usuario veterano;
	private Usuario noob;
	private Jogo RPG;
	private Jogo luta;

	@Before
	public void setUp() throws Exception {
		this.veterano = new Veterano("Jose Ivan", "jose.ivan");
		this.noob = new Noob("Luan Rocha", "luan.rocha");
		this.RPG = new RPG("LOL", 200.0);
		this.luta = new Luta("Teken 3",100.0);
	}

	@Test
	public void testCompraERegistroJogada() throws Exception {
		veterano.depositaDinheiro(1000.0);
		noob.depositaDinheiro(2000.0);

		veterano.comprarJogo(luta, 100.0);
		noob.comprarJogo(RPG, 200.0);

		assertEquals(920.0, veterano.getQntDinheiro(), 0);
		assertEquals(1820.0, noob.getQntDinheiro(), 0);

		noob.registraJogada("LOL", 100, true);
		
		
		assertEquals(1, RPG.getQntVezesZerou());
		assertEquals(1, RPG.getQntVezesQueJogou());
		assertEquals(100, RPG.getMaiorScore());

		veterano.registraJogada("Teken 3", 80, false);
		assertEquals(0, luta.getQntVezesZerou());
		assertEquals(1, luta.getQntVezesQueJogou());
		assertEquals(80, luta.getMaiorScore());

	}

	@Test
	public void testX2pPontos() throws Exception {
		Jogo jogo = new Luta("Jackie Chan", 100);
		assertEquals(0, noob.getX2pPontos());
		noob.comprarJogo(jogo, 100.0);
		assertEquals(1000, noob.getX2pPontos());
		assertEquals(1000, veterano.getX2pPontos());
		veterano.comprarJogo(jogo, 100.0);
		assertEquals(2500, veterano.getX2pPontos());

	}

	@Test
	public void testExceptionUsuario() {
		try {

			Usuario usuarioInvalido = new Noob(" ", "log.login");
			fail();

		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser vazio ou nulo.",
					e.getMessage());

		}

		try {

			Usuario usuarioInvalido2 = new Veterano("Henrique Souza", " ");
			fail();

		} catch (Exception e) {
			assertEquals("Login do usuario nao pode ser vazio ou nulo.", e.getMessage());

		}

		try {

			Usuario usuarioInvalido3 = new Noob("  ", "carlos.silva");
			fail();
		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}

		try {

			Usuario usuarioInvalido4 = new Veterano("Luiz Antonio", " ");
			fail();

		} catch (Exception e) {
			assertEquals("Login do usuario nao pode ser vazio ou nulo.", e.getMessage());

		}

	}

}
