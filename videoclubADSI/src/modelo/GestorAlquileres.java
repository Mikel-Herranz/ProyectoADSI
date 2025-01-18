package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorAlquileres {

    private static GestorAlquileres miGestorAlquileres = new GestorAlquileres();
    private ArrayList<Alquiler> lista;

    private GestorAlquileres() {
        this.lista = new ArrayList<Alquiler>();
    }

    public static GestorAlquileres getGestorAlquileres() {
        return miGestorAlquileres;
    }

    private Iterator<Alquiler> getItr() {
        return lista.iterator();
    }

    public void añadirAlquiler(Alquiler alquiler) {
        lista.add(alquiler);
    }

    public void eliminarAlquiler(Alquiler alquiler) {
        lista.remove(alquiler);
    }
}