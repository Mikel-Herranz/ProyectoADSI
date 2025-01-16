package modelo;

import java.util.Date;

public class SolicitudReg {
	private String contraseña ;
	private String nombre ;
	private String apellido ;
	private String mail ;
	private int telefono;
	private Date fechaNacimiento;
	
	public SolicitudReg(String contraseña, String nombre, String apellido, String mail, int telefono,Date fechaNacimiento) {
		
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
}
