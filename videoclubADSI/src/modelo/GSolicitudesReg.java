package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class GSolicitudesReg {
	private static GSolicitudesReg miGSolicitudesReg = new GSolicitudesReg();
	private ArrayList<SolicitudReg> lista;
	
	
	private GSolicitudesReg() {
		this.lista = new ArrayList<SolicitudReg>();
	}
	public static GSolicitudesReg getGSolicitudReg() {
		
		return miGSolicitudesReg;
	}
	
	private Iterator<SolicitudReg> getItr(){
		return lista.iterator();
	}
	public void insertarSolicitud(String contraseña, String nombre, String apellido, String mail, int telefono,Date fechaNacimiento) {
		lista.add(new SolicitudReg(contraseña, nombre, apellido, mail, telefono, fechaNacimiento));
	}
	public String[] mostrarSolicitudes() {
		String[] json = new String[lista.size()];
		
		int pos=0;
		
		while(pos<lista.size()) {
			
			json[pos]=lista.get(pos).obtenerInfo();
			pos++;
		}
		return json;
	}
	public void rechazarSolicitud(String pMail) {
        SolicitudReg unaSolicitud = null;
        Iterator<SolicitudReg> itr = getItr();
        int pos=0;
        boolean encontrada=false;
        while (itr.hasNext() && !encontrada) {
            unaSolicitud=itr.next();
            encontrada=unaSolicitud.esEsta(pMail);
            if  (encontrada==false) {
                pos=pos++;
            }
        }
        if (encontrada==false) {
            System.out.println("error , solicitud no encontrada");
        }
        else {

            lista.remove(pos);
        }
    } 

	public void aceptarSolicitud(String pMail) {
		SolicitudReg unaSolicitud = null;
		Iterator<SolicitudReg> itr = getItr();
		int pos=0;
		boolean encontrada=false;
		while (itr.hasNext() && !encontrada) {
			unaSolicitud=itr.next();
			encontrada=unaSolicitud.esEsta(pMail);
			if  (encontrada==false) {
				pos=pos++;
			}
		}
		if (encontrada==false) {
			System.out.println("error , solicitud no encontrada");
		}
		else {
			unaSolicitud.aceptar();
			lista.remove(pos);
		}
	}
}
