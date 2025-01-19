package modelo;

public class Incorporamiento{

    private Usuario quien;
    private Pelicula que;

    public Incorporamiento(Usuario usuario,Pelicula peli){
        this.quien=usuario;
        this.que=peli;
    }

	public String obtenerInfo() {
		return quien.obtenerInfo() + que.obtenerInfo();
	}

	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return this.quien;
	}

	public String getTituloPeli() {
		// TODO Auto-generated method stub
		return this.que.getTitilo();
	}

	public Pelicula getPeli() {
		return this.que;
	}

}