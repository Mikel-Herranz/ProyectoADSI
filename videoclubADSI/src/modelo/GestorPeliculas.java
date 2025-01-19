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

	

	public String[] mostrarPeliculas() {
		String[] json = new String[lista.size()];
		
		int pos=0;
		
		while(pos<lista.size()) {
			
			json[pos]=lista.get(pos).obtenerInfo();
			pos++;
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

	public String[] mostrarPeliculasOrdenadas() {
		ArrayList<Pelicula> listaaux= this.lista;
		Pelicula unaPeli = null;
		Pelicula maxima=null;
		Iterator<Pelicula> itr = listaaux.iterator();
		String[] json=new String[lista.size()];
		String actual= null;
		
		while (!listaaux.isEmpty()) {
			int pos=0;
			while(itr.hasNext()) {
				unaPeli=itr.next();
				if(unaPeli.getPunt()>=maxima.getPunt()) {
					maxima=unaPeli;
					
				}
			}
			actual=maxima.obtenerInfo();
			json[pos]=actual;
			listaaux.remove(maxima);
			
		}
		return json;
		
	}
}