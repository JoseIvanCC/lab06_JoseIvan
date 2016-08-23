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
		Usuario usuario = new Noob("Neto", "neto.francisco");
		
	}
}
