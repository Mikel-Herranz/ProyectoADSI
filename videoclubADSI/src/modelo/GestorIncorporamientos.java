package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorIncorporamientos {

    private static GestorIncorporamientos miGestorIncorporamientos = new GestorIncorporamientos();
    private ArrayList<Incorporamiento> lista;

    private GestorIncorporamientos() {
        this.lista = new ArrayList<Incorporamiento>();
    }

    public static GestorIncorporamientos getGestorIncorporamientos() {
        return miGestorIncorporamientos;
    }

    private Iterator<Incorporamiento> getItr() {
        return lista.iterator();
    }

    public void añadirIncorporamiento(Incorporamiento incorporamiento) {
        lista.add(incorporamiento);
    }

    public void eliminarIncorporamiento(Incorporamiento incorporamiento) {
        lista.remove(incorporamiento);
    }
}