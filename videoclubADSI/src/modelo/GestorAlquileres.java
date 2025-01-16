package modelo;

import java.util.ArrayList;

public class GestorAlquileres {

	
	private static GestorAlquileres miGestorAlquileres = new GestorAlquileres();
	private ArrayList<Alquiler> lista;
	
	
	private GestorAlquileres() {
		this.lista = new ArrayList<Alquiler>();
	}
	public static GestorAlquileres getGestorAlquileres() {
		
		return miGestorAlquileres;
	}
}