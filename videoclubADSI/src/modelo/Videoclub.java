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
			System.out.println("se ha enviado una solicitud de registro, pronto sera verificada");
		}
			
	}

	
	
	
}