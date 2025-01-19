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

	

	public ArrayList<String> mostrarPeliculas() {
		Pelicula unaPeli = null;
		Iterator<Pelicula> itr = getItr();
		ArrayList<String> json=new ArrayList<String>();
		String actual= null;
		
		while (itr.hasNext()) {
			unaPeli = itr.next();
			actual=unaPeli.obtenerInfo();
			json.add(actual);
			
		}
		return json;
		
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

	

	public String mostrarUnaPelicula(String pTitulo) {
		Pelicula unaPeli=obtenerPelicula(pTitulo);
		String res=unaPeli.obtenerInfo();
		return res;
	}

	public ArrayList<String> mostrarPeliculasOrdenadas() {
		ArrayList<Pelicula> listaaux= this.lista;
		Pelicula unaPeli = null;
		Pelicula maxima=null;
		Iterator<Pelicula> itr = listaaux.iterator();
		ArrayList<String> json=new ArrayList<String>();
		String actual= null;
		
		while (!listaaux.isEmpty()) {
			while(itr.hasNext()) {
				unaPeli=itr.next();
				if(unaPeli.getPunt()>=maxima.getPunt()) {
					maxima=unaPeli;
				}
			}
			actual=maxima.obtenerInfo();
			json.add(actual);
			listaaux.remove(maxima);
			
		}
		return json;
		
	}
}