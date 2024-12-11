package modelo;
import java.util.ArrayList;
import java.util.Date;


public class Usuario {

    private String codUsuario ;
    private String contraseña ;
    private String nombre ;
    private String apellido ;
    private String mail ;
    private int telefono;
    private Date fechaNacimiento;
    private double saldo;
    private boolean admin ;
    private ArrayList<Pelicula> alquiladas;
    private ArrayList<Pelicula> reseñadas;

	public Usuario(String codUsuario, String contraseña, String nombre, String apellido, String mail, int telefono,
			Date fechaNacimiento) {
		
		this.codUsuario = codUsuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.saldo = 0.0;
		this.admin = false;
		this.alquiladas = new ArrayList<Pelicula>();
		this.reseñadas = new ArrayList<Pelicula>();
	}
	
	public void hacerAdmin() {
		this.admin = true;
	}

	
}