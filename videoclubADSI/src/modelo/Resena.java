package modelo;

public class Resena {
	
	private Usuario quien;
	private Pelicula que;
	private float punt;
	private String comentario;
	
	
	
	
	public Resena(Usuario quienLaResena,Pelicula queResena, float punt, String comentario) {

		this.quien=quienLaResena;
		this.que=queResena;
		this.punt = punt;
		this.comentario = comentario;
		
	}
	
	
	
	
	
}
