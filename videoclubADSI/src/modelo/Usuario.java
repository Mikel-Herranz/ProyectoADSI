package modelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class Usuario {

    
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

	public Usuario( String contraseña, String nombre, String apellido, String mail, int telefono,
			Date fechaNacimiento) {
		
		
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
	
	public boolean coincide(String pMail, String pContraseña) {
		 boolean coincide = false;
		 if (pMail == this.mail) {
			 if (pContraseña == this.contraseña) {
				 coincide = true;
			 }
		 } 
		 return coincide;
	 }

	public String getMail() {
		return this.mail;
	}

	public void actualizarDatos(String pContraseña, String pNombre, String pApellido,  int pTelefono,
			Date pFechaNacimiento) {
		this.contraseña=pContraseña;
		this.nombre=pNombre;
		this.apellido=pApellido;
		this.telefono=pTelefono;
		this.fechaNacimiento=pFechaNacimiento;
		
	}

	public void anadirAAlquiladas(Pelicula pPeli) {
		this.alquiladas.add(pPeli);
		
	}
	
	 
	
	public void eliminarDeAlquiladas(Pelicula pPeli) {
		int j=-1;
		boolean encontrada=false;
		while(!encontrada) {
			j=j+1;
			if(alquiladas.get(j).equals(pPeli)) {
				encontrada=true;
				alquiladas.remove(j);
			}
			
		}
		
			
	}
	
}