package modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public void anadirAlquiler(Alquiler alquiler) {
        lista.add(alquiler);
    }

    public void eliminarAlquiler(Alquiler alquiler) {
        lista.remove(alquiler);
    }

	public void crearAlquiler(Usuario unUsuario, Pelicula unaPelicula) {
		LocalDate hoy= LocalDate.now();
		Date fecha = Date.valueOf(hoy);
				
		Alquiler alq = new Alquiler(unUsuario, unaPelicula, fecha);
		anadirAlquiler(alq);
		Timer48Horas temporizador= new Timer48Horas();
		temporizador.start();
		
	}
}