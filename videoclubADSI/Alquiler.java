package modelo;

public class Alquiler {
	
	private Usuario quien;
	private Pelicula que;
    private Date cuando;
	
	
	
	
	
	public Alquiler(Usuario quienLaAlquila,Pelicula queAlquila, Date fecha ) {

		this.quien=quienLaAlquila;
		this.que=queAlquila;
        this.cuando=fecha;
		
	}
	
	
	
	
	
}