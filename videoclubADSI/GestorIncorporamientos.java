package modelo;

import java.util.ArrayList;

public class GestorIncorporamientos {

	
	private static GestorIncorporamientos miGestorIncoporamientos = new GestorIncorporamientos();
	private ArrayList<Incorporamiento> lista;
	
	
	private GestorIncorporamientos() {
		this.lista = new ArrayList<Incorporamiento>();

	}
	public static GestorIncorporamientos getGestorIncorporamientos() {
		
		return miGestorIncoporamientos;
	}
}