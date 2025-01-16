package modelo;

import java.util.ArrayList;

public class GestorPropuestas {

	
	private static GestorPropuestas miGestorPropuestas = new GestorPropuestas();
	private ArrayList<Propuesta> lista;
	
	
	private GestorPropuestas() {
		this.lista = new ArrayList<Propuesta>();

	}
	public static GestorPropuestas getGestorPropuestas() {
		
		return miGestorPropuestas;
	}
}