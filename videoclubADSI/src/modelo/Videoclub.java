package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
public class Videoclub extends Observable{

    private static Videoclub miVideoclub = new Videoclub();
    
    private Videoclub(){
    }
	public static Videoclub getVideoclub(){
        return miVideoclub;
    }
	
	
	public void iniciarSesion(String pMail, String pContraseña ) {
		Usuario elUsuario= GestorUsuarios.getGestorUsuarios().iniciarSesion(pMail,pContraseña);
		if (elUsuario == null) {
			System.out.println("usuario no encontrado, introduce otra vez los datos, si no ha iniciado sesion, registrase");
			setChanged();
			notifyObservers(null);
		}
		else {
			if (elUsuario.esAdmin()) {
				
			}
			else{
				System.out.println("se ha iniciado sesion");
				mostrarPeliculas();
			}
			
		}
	}
	
	public void solicitarRegistro(String pContraseña, String pNombre, String pApellido, String pMail, Integer pTelefono, Date pFechaNacimiento) {
		Usuario elUsuario= GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
		if (elUsuario != null) {
			System.out.println("usuario ya existente");
			setChanged();
			notifyObservers(null);
		}
		else {
			GSolicitudesReg.getGSolicitudReg().insertarSolicitud(pContraseña, pNombre, pApellido, pMail, pTelefono, pFechaNacimiento);
			System.out.println("se ha enviado una solicitud de registro, pronto sera verificada");
			int num = 1;
			setChanged();
			notifyObservers(num);
		}
	}
	
	public String[] mostrarSolicitudes() {
		String[] res=GSolicitudesReg.getGSolicitudReg().mostrarSolicitudes();
		return res;
	}
	
	public void aceptarSolicitudReg(String pMail) {
		GSolicitudesReg.getGSolicitudReg().aceptarSolicitud(pMail);
	}
	
	public void eliminarCuenta(String pMail) {
		GestorUsuarios.getGestorUsuarios().eliminarUsuario(pMail);
	}
	
	public void actualizarDatosUsurio(String pNombre, String pApellido, String pMail, Integer pTelefono, Date pFechaNacimiento) {
		GestorUsuarios.getGestorUsuarios().actualizarDatos(pNombre,pApellido,pMail,pTelefono,pFechaNacimiento);
		mostrarPeliculas();
		
	}
	

	public String[] mostrarPeliculas() {
		String[] res=GestorPeliculas.getGestorPeliculas().mostrarPeliculas();
		setChanged();
		notifyObservers(res);
		return res;
	}
	
	public void alquilarPelicula(String pMail, String pTitulo) {
		Pelicula unaPelicula =GestorPeliculas.getGestorPeliculas().obtenerPelicula(pTitulo);
		GestorUsuarios.getGestorUsuarios().alquilarPeliPara(pMail,unaPelicula);
		Usuario unUsuario= GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
		GestorAlquileres.getGestorAlquileres().crearAlquiler(unUsuario,unaPelicula);
	}
	public String buscarPelicula(String pTitulo) {
		String res=GestorPeliculas.getGestorPeliculas().mostrarUnaPelicula(pTitulo);
		return res;
	}
	
	public void resenarPelicula(String pMail,String pTitulo , String pComent , Double pPunt) {
		boolean laTiene= false;
		Pelicula unaPelicula =GestorPeliculas.getGestorPeliculas().obtenerPelicula(pTitulo);
		laTiene=GestorUsuarios.getGestorUsuarios().comprobarSiLaTieneAlquilada(pMail,unaPelicula);
		if(laTiene == true) {
			Usuario unUsuario= GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
			GestorUsuarios.getGestorUsuarios().resenarPeliPara(pMail,unaPelicula);
			GestorResenas.getGestorResenas().crearResena(unUsuario,unaPelicula,pComent,pPunt);
			GestorResenas.getGestorResenas().actaulizarPuntPromedio(unaPelicula);
			
		}
		
	}
	public double verPuntPromedio(String pTitulo) {
		Pelicula unaPelicula =GestorPeliculas.getGestorPeliculas().obtenerPelicula(pTitulo);
		double punt =GestorResenas.getGestorResenas().obtenerPuntPromedio(unaPelicula);
		
		return punt;
	}
	
	public String[] obtenerPelisOrdenadasPorPunt() {
		String[] resultado = GestorPeliculas.getGestorPeliculas().mostrarPeliculasOrdenadas();
		return resultado;
		
	}
	public void cambiarResena(String pMail,String pTitulo,String pComent ,double pPunt) {
		Pelicula unaPelicula =GestorPeliculas.getGestorPeliculas().obtenerPelicula(pTitulo);
		Usuario unUsuario= GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
		GestorResenas.getGestorResenas().modificarResena(unaPelicula,unUsuario,pComent,pPunt);
	}
	
	public void pedirIncorporamiento(String pMail,String pTitulo,String pTrailer,String pDescr ,double pPrecio) {
		Usuario unUsuario = GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
		GestorIncorporamientos.getGestorIncorporamientos().crearIncorporamiento(unUsuario, pTitulo, pTrailer, pDescr ,pPrecio);
	}
	
	public String[] mostrarIncorporamientos(){
		String[] res=GestorIncorporamientos.getGestorIncorporamientos().obtenerIncorporamientos();
		return res;
	}
	
	public String[] aceptarIncorporamiento(String pMail,String pTitulo){
		Usuario unUsuario = GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
		GestorIncorporamientos.getGestorIncorporamientos().aceptarInc(unUsuario,pTitulo);
		String[] res=GestorIncorporamientos.getGestorIncorporamientos().obtenerIncorporamientos();
		return res;
		
	}
	public String mostrarDatosUsuario(String pMail) {
		String res=GestorUsuarios.getGestorUsuarios().mostrarUsuario(pMail);
		setChanged();
		notifyObservers(res);
		return res;
	}
	
	public String[] rechazarrIncorporamiento(String pMail,String pTitulo){
		Usuario unUsuario = GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
		GestorIncorporamientos.getGestorIncorporamientos().rechazarInc(unUsuario,pTitulo);
		String[] res=GestorIncorporamientos.getGestorIncorporamientos().obtenerIncorporamientos();
		return res;
	}
}