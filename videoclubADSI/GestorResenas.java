package modelo;

import java.util.ArrayList;

public class GestorResenas {

	
	private static GestorResenas miGestorResenas = new n();
	private ArrayList<Resena> lista;
	
	
	private GestorResenas() {
		this.lista = new ArrayList<Resena>();

	}
	public static GestorResenas getGestorReseñas() {
		
		return miGestorResenas;
	}
}
