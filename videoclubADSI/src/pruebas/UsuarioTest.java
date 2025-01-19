package pruebas;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Usuario;

class UsuarioTest {
	Usuario usu1;
	@BeforeEach
	void setUp() throws Exception {
		 usu1= new Usuario("pi", "po", "pol", "gmail", 34, null);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testHacerAdmin() {
		fail("Not yet implemented");
	}

	@Test
	void testCoincide() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMail() {
		fail("Not yet implemented");
	}

	@Test
	void testActualizarDatos() {
		fail("Not yet implemented");
	}

	@Test
	void testAnadirAAlquiladas() {
		fail("Not yet implemented");
	}

	@Test
	void testEliminarDeAlquiladas() {
		fail("Not yet implemented");
	}

	@Test
	void testEstaEnSusAlquiladas() {
		fail("Not yet implemented");
	}

	@Test
	void testAnadirAResenadas() {
		fail("Not yet implemented");
	}

	@Test
	void testObtenerInfo() {
		
		System.out.println(usu1.obtenerInfo());
	}

}
