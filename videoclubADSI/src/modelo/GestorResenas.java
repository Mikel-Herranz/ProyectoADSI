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

    public void anadirResena(Resena resena) {
        lista.add(resena);
    }

    public void eliminarResena(Resena resena) {
        lista.remove(resena);
    }

	public void crearResena(Usuario unUsuario, Pelicula unaPelicula, String pComent, Double pPunt) {
		Resena unaResena = new Resena(unUsuario, unaPelicula, pPunt, pComent);
		anadirResena(unaResena);
		
	}

	public double obtenerPuntPromedio(Pelicula unaPelicula) {
		Iterator<Resena> itr =getItr();
		boolean es=false;
		Resena unaResena=null;
		double total =0.0;
		double numresenas=0.0;
		while (itr.hasNext()) {
			unaResena= itr.next();
			es=unaResena.esDe(unaPelicula);
			if (es==true) {
				total=total+unaResena.getPuntuacion();
				numresenas=numresenas+1;
			}
			
		}
		return total/numresenas;
	}

	public void modificarResena(Pelicula unaPelicula, Usuario unUsuario, String pComent, double pPunt) {
		Iterator<Resena> itr =getItr();
		boolean terminado=false;
		Resena unaResena=null;
		boolean b1=false;
		boolean b2=false;
		
		while (itr.hasNext() || terminado) {
			unaResena= itr.next();
			b1=unaResena.esDe(unaPelicula);
			b2=unaResena.laHaHecho(unUsuario);
			if(b1==true && b2==true) {
				terminado=true;
				unaResena.modificar(pComent,pPunt);
				}
		}
	}

	public void actaulizarPuntPromedio(Pelicula unaPelicula) {
		Iterator<Resena> itr =getItr();
		boolean es=false;
		Resena unaResena=null;
		double total =0.0;
		double res=0.0;
		double numresenas=0.0;
		while (itr.hasNext()) {
			unaResena= itr.next();
			es=unaResena.esDe(unaPelicula);
			if (es==true) {
				total=total+unaResena.getPuntuacion();
				numresenas=numresenas+1;
			}
			
		}
		res= total/numresenas;
		unaPelicula.actualizarPuntPromedio(res);
		
	}
}