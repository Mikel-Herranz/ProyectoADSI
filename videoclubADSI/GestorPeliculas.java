package modelo;

import java.util.ArrayList;

public class GestorPeliculas {

	
	private static GestorPeliculas miGestorPelis = new GestorPeliculas();
	private ArrayList<Pelicula> lista;
	
	
	private GestorPeliculas() {
		this.lista = new ArrayList<Pelicula>();
	}
	public static GestorPeliculas getGestorPeliculas() {
		
		return miGestorPelis;
	}
}
