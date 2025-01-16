package modelo;

import java.util.ArrayList;
import java.util.Date;

public class GSolicitudesReg {
	private static GSolicitudesReg miGSolicitudesReg = new GSolicitudesReg();
	private ArrayList<SolicitudReg> lista;
	
	
	private GSolicitudesReg() {
		this.lista = new ArrayList<SolicitudReg>();
	}
	public static GSolicitudesReg getGSolicitudReg() {
		
		return miGSolicitudesReg;
	}
	public void insertarSolicitud(String contraseña, String nombre, String apellido, String mail, int telefono,Date fechaNacimiento) {
		lista.add(new SolicitudReg(contraseña, nombre, apellido, mail, telefono, fechaNacimiento));
	}
}
