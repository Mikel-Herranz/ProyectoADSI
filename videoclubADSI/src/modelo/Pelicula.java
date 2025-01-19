 package modelo;

import java.awt.Image;

public class Pelicula {
    
    private Usuario aceptadaPor;
    private String desc;
    private String trailer;//en url
    private double puntMedia;
    private double precioAlq;
    private String titulo;
	
    
    
    
    public Pelicula(Usuario quien,int codPelicula, String desc, String trailer, double precioAlq, String titulo) {

		
		this.desc = desc;
		this.trailer = trailer;
		this.puntMedia = 0;
		this.precioAlq = precioAlq;
		this.titulo = titulo;
        this.aceptadaPor = quien;
	}




	public String obtenerInfo() {
		return "Descripcion" + desc + "Trailer" + trailer + "Precio" + precioAlq + "Titulo" + titulo;
		
	}




	public boolean esEsta(String pTitulo) {
		boolean es=false;
		if (this.titulo.equals(pTitulo)) {
			es=true;
		}
		return es;
	}
	
	public String getTitilo() {
		return this.titulo;
	}




	public void actualizarPuntPromedio(double res) {
		this.puntMedia=res;
		
	}




	public double getPunt() {
		// TODO Auto-generated method stub
		return this.puntMedia;
	}
    
    
    
    




















}