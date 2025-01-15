package modelo;

import java.util.ArrayList;

public class getGestorPropuestas {

	
	private static getGestorPropuestas miGestorPropuestas = new getGestorPropuestas();
	private ArrayList<Propuesta> lista;
	
	
	private getGestorPropuestas() {
		this.lista = new ArrayList<Propuesta>();

	}
	public static getGestorPropuestas getgetGestorPropuestas() {
		
		return miGestorPropuestas;
	}
}