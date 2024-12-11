package modelo;

import java.util.ArrayList;

public class GestorReseñas {

	
	private static GestorReseñas miGestorResenas = new GestorReseñas();
	private ArrayList<Resena> lista;
	
	
	private GestorReseñas() {
		this.lista = new ArrayList<Resena>();

	}
	public static GestorReseñas getGestorReseñas() {
		
		return miGestorResenas;
	}
}
