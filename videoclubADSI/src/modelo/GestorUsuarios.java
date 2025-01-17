package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class GestorUsuarios {

	
	private static GestorUsuarios miGestorUsuarios = new GestorUsuarios();
	private ArrayList<Usuario> lista;
	
	
	
	private GestorUsuarios() {
		this.lista = new ArrayList<Usuario>();

	}
	public static GestorUsuarios getGestorUsuarios() {
		
		return miGestorUsuarios;
	}
	
	private Iterator<Usuario> getItr(){
		return lista.iterator();
	}
	public Usuario iniciarSesion(String pMail, String pContraseña) {
		Iterator<Usuario> itr = getItr();
		boolean encontrado = false;
		Usuario unUsuario = null;
		while (itr.hasNext() || encontrado){
			unUsuario = itr.next();
			encontrado = unUsuario.coincide(pMail, pContraseña);
		}
		if (encontrado == false) {
			unUsuario = null;
		}
		return unUsuario;
	}
	
	public Usuario buscarUsuarioPorMail(String pMail) {
		Iterator<Usuario> itr = getItr();
		boolean encontrado = false;
		Usuario unUsuario = null;
		while (itr.hasNext() || encontrado){
			unUsuario = itr.next();
			encontrado = unUsuario.getMail().equals(pMail);
		}
		if (encontrado == false) {
			unUsuario = null;
		}
		return unUsuario;
	}
	public void anadirUsuario(String pContraseña, String pNombre, String pApellido, String pMail, int pTelefono,
			Date pFechaNacimiento) {
		lista.add(new Usuario(pContraseña,pNombre,pApellido,pMail,pTelefono,pFechaNacimiento));
		
	}
	
}
