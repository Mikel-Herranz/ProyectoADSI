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

    

    public void eliminarIncorporamiento(Incorporamiento incorporamiento) {
        lista.remove(incorporamiento);
    }

	public void crearIncorporamiento(Usuario unUsuario, String pTitulo, String pTrailer, String pDescr,
			double pPrecio) {
		Pelicula unaPeli = new Pelicula(unUsuario, pDescr, pTrailer, pPrecio, pTitulo);
		Incorporamiento nuevo = new Incorporamiento(unUsuario, unaPeli);
		lista.add(nuevo);
	}

	public String[] obtenerIncorporamientos() {
		
		String[] json = new String[lista.size()];
		
		int pos=0;
		
		while(pos<lista.size()) {
			
			json[pos]=lista.get(pos).obtenerInfo();
			pos++;
		}
		return json;
	}
	public Incorporamiento buscarInc(Usuario unUsuario, String pTitulo) {
		Incorporamiento unInc =null;
		Iterator<Incorporamiento> itr=getItr();
		boolean encontrada=false;
		while(itr.hasNext() && !encontrada) {
			unInc=itr.next();
			if(unInc.getUsuario().equals(unUsuario)) {
				if(unInc.getTituloPeli().equals(pTitulo)) {
					encontrada=true;
				}
			}
		}
		return unInc;
	}

	public void aceptarInc(Usuario unUsuario, String pTitulo) {
		Incorporamiento unInc = buscarInc(unUsuario, pTitulo);
		lista.remove(unInc);
		Pelicula unaPeli=unInc.getPeli();
		GestorPeliculas.getGestorPeliculas().añadirPelicula(unaPeli);
		
	}

	public void rechazarInc(Usuario unUsuario, String pTitulo) {
		Incorporamiento unInc = buscarInc(unUsuario, pTitulo);
		lista.remove(unInc);
	}
}