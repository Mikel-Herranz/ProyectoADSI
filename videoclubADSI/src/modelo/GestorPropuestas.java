package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorPropuestas {

    private static GestorPropuestas miGestorPropuestas = new GestorPropuestas();
    private ArrayList<Propuesta> lista;

    private GestorPropuestas() {
        this.lista = new ArrayList<Propuesta>();
    }

    public static GestorPropuestas getGestorPropuestas() {
        return miGestorPropuestas;
    }

    private Iterator<Propuesta> getItr() {
        return lista.iterator();
    }

    public void añadirPropuesta(Propuesta propuesta) {
        lista.add(propuesta);
    }

    public void eliminarPropuesta(Propuesta propuesta) {
        lista.remove(propuesta);
    }
}