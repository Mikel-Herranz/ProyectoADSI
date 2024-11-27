package modelo;
import java.util.Date;


public class Usuario {

    private String codUsuario ;
    private String contraseña ;
    private String nombre ;
    private String apellido ;
    private String mail ;
    private int telefono;
    private Date fechaNacimiento;
    private double saldo;
    private boolean admin ;
    private Pelicula[] alquiladas;
    private Pelicula[] reseñadas;

    
    public Usuario(){

    }



}