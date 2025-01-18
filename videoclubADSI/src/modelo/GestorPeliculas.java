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

	

	public void mostrarPeliculas() {
		Pelicula unaPeli = null;
		Iterator<Pelicula> itr = getItr();
		
		while (itr.hasNext()) {
			unaPeli = itr.next();
			unaPeli.obtenerInfo();
			
		}
		
	}

	public Pelicula obtenerPelicula(String pTitulo) {
		Pelicula unaPeli = null;
		Iterator<Pelicula> itr = getItr();
		boolean encontrado = false;
		
		while (itr.hasNext() || encontrado) {
			unaPeli = itr.next();
			encontrado=unaPeli.esEsta(pTitulo);
			
		}
		if (encontrado==false) {
			unaPeli=null;
		}
		return unaPeli;
			
	}
}