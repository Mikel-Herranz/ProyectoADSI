package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorPeliculas {

    private static GestorPeliculas miGestorPelis = new GestorPeliculas();
    private ArrayList<Pelicula> lista;

    private GestorPeliculas() {
        this.lista = new ArrayList<Pelicula>();
    }

    public static GestorPeliculas getGestorPeliculas() {
        return miGestorPelis;
    }

    private Iterator<Pelicula> getItr() {
        return lista.iterator();
    }

    public void añadirPelicula(Pelicula pelicula) {
        lista.add(pelicula);
    }

    public void eliminarPelicula(Pelicula pelicula) {
        lista.remove(pelicula);
    }
}