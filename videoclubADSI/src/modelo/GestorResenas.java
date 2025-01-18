package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorResenas {

    private static GestorResenas miGestorResenas = new GestorResenas();
    private ArrayList<Resena> lista;

    private GestorResenas() {
        this.lista = new ArrayList<Resena>();
    }

    public static GestorResenas getGestorResenas() {
        return miGestorResenas;
    }

    private Iterator<Resena> getItr() {
        return lista.iterator();
    }

    public void añadirResena(Resena resena) {
        lista.add(resena);
    }

    public void eliminarResena(Resena resena) {
        lista.remove(resena);
    }
}