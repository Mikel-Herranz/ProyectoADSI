package modelo;

import java.util.ArrayList;

public class GestorUsuarios {

	
	private static GestorUsuarios miGestorUsuarios = new GestorUsuarios();
	private ArrayList<Usuario> lista;
	
	
	
	private GestorUsuarios() {
		this.lista = new ArrayList<Usuario>();

	}
	public static GestorUsuarios getGestorUsuarios() {
		
		return miGestorUsuarios;
	}
}
