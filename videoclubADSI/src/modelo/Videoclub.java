package modelo;

import java.util.Date;

public class Videoclub {

    private static Videoclub miVideoclub = new Videoclub();
    
    private Videoclub(){
        
        //this.gestorPelis=gestorPelis.getgestorPeliculas();
        //this.gestorProp=gestorProp.getGestorPropuestas();
        //this.gestorRes=gestorRes.getGestorResenas();
        //this.gestorUs=gestorUs.getGestorUsuarios();
        //this.gestorAlq=gestorAlq.getGestorAlquileres();
    }
	public static Videoclub getVideoclub(){
        return miVideoclub;
    }
	
	
	public void iniciarSesion(String pMail, String pContraseña ) {
		Usuario elUsuario= GestorUsuarios.getGestorUsuarios().iniciarSesion(pMail,pContraseña);
		if (elUsuario == null) {
			System.out.println("usuario no encontrado, introduce otra vez los datos, si no ha iniciado sesion, registrase");
		}
		else {
			System.out.println("se ha iniciado sesion");
		}
	}
	
	public void solicitarRegistro(String pContraseña, String pNombre, String pApellido, String pMail, int pTelefono, Date pFechaNacimiento) {
		Usuario elUsuario= GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
		if (elUsuario != null) {
			System.out.println("usuario ya existente");
		}
		else {
			GSolicitudesReg.getGSolicitudReg().insertarSolicitud(pContraseña, pNombre, pApellido, pMail, pTelefono, pFechaNacimiento);
			System.out.println("se ha enviado una solicitud de registro, pronto sera verificada");
		}
	}
	public void mostrarSolicitudes() {
		GSolicitudesReg.getGSolicitudReg().mostrarSolicitudes();
	}
	
	public void aceptarSolicitudReg(String pMail) {
		GSolicitudesReg.getGSolicitudReg().aceptarSolicitud(pMail);
	}
	public void eliminarCuenta(String pMail) {
		GestorUsuarios.getGestorUsuarios().eliminarUsuario(pMail);
	}
	
	public void actualizarDatosUsurio(String pContraseña, String pNombre, String pApellido, String pMail, int pTelefono, Date pFechaNacimiento) {
		GestorUsuarios.getGestorUsuarios().actualizarDatos(pContraseña,pNombre,pApellido,pMail,pTelefono,pFechaNacimiento);
	}
	public void mostrarPeliculas() {
		GestorPeliculas.getGestorPeliculas().mostrarPeliculas();
	}
	
	public void alquilarPelicula(String pMail, String pTitulo) {
		Pelicula unaPelicula =GestorPeliculas.getGestorPeliculas().obtenerPelicula(pTitulo);
		GestorUsuarios.getGestorUsuarios().alquilarPeliPara(pMail,unaPelicula);
		Usuario unUsuario= GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
		GestorAlquileres.getGestorAlquileres().crearAlquiler(unUsuario,unaPelicula);
	}
	public void buscarPelicula(String pTitulo) {
		GestorPeliculas.getGestorPeliculas().mostrarUnaPelicula(pTitulo);
		
	}
	
	public void resenarPelicula(String pMail,String pTitulo , String pComent , Double pPunt) {
		boolean laTiene= false;
		Pelicula unaPelicula =GestorPeliculas.getGestorPeliculas().obtenerPelicula(pTitulo);
		laTiene=GestorUsuarios.getGestorUsuarios().comprobarSiLaTieneAlquilada(pMail,unaPelicula);
		if(laTiene == true) {
			Usuario unUsuario= GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
			GestorUsuarios.getGestorUsuarios().resenarPeliPara(pMail,unaPelicula);
			GestorResenas.getGestorResenas().crearResena(unUsuario,unaPelicula,pComent,pPunt);
			
		}
		
	}
	public double verPuntPromedio(String pTitulo) {
		Pelicula unaPelicula =GestorPeliculas.getGestorPeliculas().obtenerPelicula(pTitulo);
		double punt =GestorResenas.getGestorResenas().obtenerPuntPromedio(unaPelicula);
		return punt;
	}
	
	public void obtenerPelisOrdenadasPorPunt() {
		//todo
	}
	public void cambiarResena(String pMail,String pTitulo,String pComent ,double pPunt) {
		Pelicula unaPelicula =GestorPeliculas.getGestorPeliculas().obtenerPelicula(pTitulo);
		Usuario unUsuario= GestorUsuarios.getGestorUsuarios().buscarUsuarioPorMail(pMail);
		GestorResenas.getGestorResenas().modificarResena(unaPelicula,unUsuario,pComent,pPunt);
	}
}