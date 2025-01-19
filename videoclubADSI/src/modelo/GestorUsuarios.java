package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class GestorUsuarios {

    private static GestorUsuarios miGestorUsuarios = new GestorUsuarios();
    private ArrayList<Usuario> lista;

    private GestorUsuarios() {
        this.lista = new ArrayList<Usuario>();
    }

    public static GestorUsuarios getGestorUsuarios() {
        return miGestorUsuarios;
    }

    private Iterator<Usuario> getItr() {
        return lista.iterator();
    }

    public Usuario iniciarSesion(String pMail, String pContraseña) {
        Iterator<Usuario> itr = getItr();
        boolean encontrado = false;
        Usuario unUsuario = null;
        while (itr.hasNext() && !encontrado) {
            unUsuario = itr.next();
            encontrado = unUsuario.coincide(pMail, pContraseña);
        }
        if (!encontrado) {
            unUsuario = null;
        }
        return unUsuario;
    }

    public Usuario buscarUsuarioPorMail(String pMail) {
        Iterator<Usuario> itr = getItr();
        boolean encontrado = false;
        Usuario unUsuario = null;
        while (itr.hasNext() && !encontrado) {
            unUsuario = itr.next();
            encontrado = unUsuario.getMail().equals(pMail);
        }
        if (!encontrado) {
            unUsuario = null;
        }
        return unUsuario;
    }

    public void anadirUsuario(String pContraseña, String pNombre, String pApellido, String pMail, Integer pTelefono,
                              Date pFechaNacimiento) {
        lista.add(new Usuario(pContraseña, pNombre, pApellido, pMail, pTelefono, pFechaNacimiento));
    }

    public void eliminarUsuario(String pMail) {
        Iterator<Usuario> itr = getItr();
        boolean encontrado = false;
        Usuario unUsuario = null;
        int pos = 0;
        while (itr.hasNext() && !encontrado) {
            unUsuario = itr.next();
            encontrado = unUsuario.getMail().equals(pMail);
            if (!encontrado) {
                pos++;
            }
        }
        if (unUsuario != null) {
            lista.remove(pos);
        }
    }
    
    
    
    public void actualizarDatos(String pNombre, String pApellido, String pMail, Integer pTelefono,
                                Date pFechaNacimiento) {
        Usuario unUsuario = buscarUsuarioPorMail(pMail);
        if (unUsuario != null) {
            unUsuario.actualizarDatos(pNombre, pApellido, pTelefono, pFechaNacimiento);
        }
    }

	public void alquilarPeliPara(String pMail,Pelicula pPeli) {
		Usuario unUsuario = buscarUsuarioPorMail(pMail);
		if (unUsuario != null) {
			unUsuario.anadirAAlquiladas(pPeli);
		}
		
	}

	public boolean comprobarSiLaTieneAlquilada(String pMail, Pelicula unaPelicula) {
		boolean laTiene=false;
		Usuario unUsuario=buscarUsuarioPorMail(pMail);
		laTiene=unUsuario.estaEnSusAlquiladas(unaPelicula);
		return laTiene;
	}

	public void resenarPeliPara(String pMail, Pelicula unaPelicula) {
		Usuario unUsuario = buscarUsuarioPorMail(pMail);
		if (unUsuario != null) {
			unUsuario.anadirAResenadas(unaPelicula);
		}
		
	}

	public String mostrarUsuario(String pMail) {
		Usuario unUsu = buscarUsuarioPorMail(pMail);
		return unUsu.obtenerDatos();
		
	}
}