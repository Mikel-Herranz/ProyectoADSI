package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Usuario;

class UsuarioTest {
	Usuario usu1;
	
	// String que representa la fecha
    String fechaStr = "1995-06-24";

    // Definir el formato de la fecha
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Convertir la cadena a LocalDate (sin hora)
    LocalDate localDate = LocalDate.parse(fechaStr, formatter);

    // Convertir LocalDate a Date (si es necesario)
    Date fecha = java.sql.Date.valueOf(localDate);

	@BeforeEach
	void setUp() throws Exception {
		 usu1= new Usuario("pi", "po", "pol", "gmail", 69258180, fecha);
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
		
		System.out.println(usu1.obtenerDatos());
	}

}
