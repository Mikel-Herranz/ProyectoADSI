package modelo;

public class Resena {
	
	private Usuario quien;
	private Pelicula que;
	private double punt;
	private String comentario;
	
	
	
	
	public Resena(Usuario quienLaResena,Pelicula queResena, double punt, String comentario) {

		this.quien=quienLaResena;
		this.que=queResena;
		this.punt = punt;
		this.comentario = comentario;
		
	}




	public boolean esDe(Pelicula unaPelicula) {
		boolean es=false;
		if(que.equals(unaPelicula)) {
			es=true;
		}
		return es;
	}




	public double getPuntuacion() {
		// TODO Auto-generated method stub
		return this.punt;
	}




	public boolean laHaHecho(Usuario unUsuario) {
		boolean es=false;
		if(this.quien.equals(unUsuario)) {
		es =true;
		}
		return es;
	}




	public void modificar(String pComent, double pPunt) {
		this.comentario=pComent;
		this.punt=pPunt;
		
	}
	
	
	
}
