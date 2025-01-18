package modelo;

import java.util.Date;

public class Alquiler {
	
	private Usuario quien;
	private Pelicula que;
    private Date cuando;
	
	public Alquiler(Usuario quienLaAlquila, Pelicula queAlquila, Date fecha) {
		this.quien = quienLaAlquila;
		this.que = queAlquila;
        this.cuando = fecha;
	}

    // Getters
    public Usuario getQuien() {
        return quien;
    }

    public Pelicula getQue() {
        return que;
    }

    public Date getCuando() {
        return cuando;
    }

    // Setters
    public void setQuien(Usuario quien) {
        this.quien = quien;
    }

    public void setQue(Pelicula que) {
        this.que = que;
    }

    public void setCuando(Date cuando) {
        this.cuando = cuando;
    }

    // Métodos para añadir y eliminar alquileres en el gestor
    public void añadirAlquiler() {
        GestorAlquileres.getGestorAlquileres().añadirAlquiler(this);
    }

    public void eliminarAlquiler() {
        GestorAlquileres.getGestorAlquileres().eliminarAlquiler(this);
    }
}