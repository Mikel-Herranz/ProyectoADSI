 package modelo;

import java.awt.Image;

public class Pelicula {
    
    private Usuario aceptadaPor;
    private String desc;
    private Image trailer;
    private double puntMedia;
    private double precioAlq;
    private String titulo;
	
    
    
    
    public Pelicula(Usuario quien,int codPelicula, String desc, Image trailer, double precioAlq, String titulo) {

		
		this.desc = desc;
		this.trailer = trailer;
		this.puntMedia = 0;
		this.precioAlq = precioAlq;
		this.titulo = titulo;
        this.aceptadaPor = quien;
	}
    
    
    
    




















}