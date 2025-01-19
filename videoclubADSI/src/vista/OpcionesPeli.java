package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Videoclub;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class OpcionesPeli extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String titulo;
	private JButton btnAlq;
	private JButton btnReseñar;
	private JButton btnVolver;
	private Controler controler;
	private String usuario;
	private String desc;
	private String poster;
	private String precio;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
		//		try {
			//		OpcionesPeli frame = new OpcionesPeli();
				//	frame.setVisible(true);
	//			} catch (Exception e) {
		//			e.printStackTrace();
			//	}
	//		}
		//});
	//}
	

	/**
	 * Create the frame.
	 */
	public OpcionesPeli(Observable datos, String pUsu, String pPeli) {
		datos.addObserver(this);
		String[] partes = pPeli.split(",");
        
        // Crear un array para guardar las partes procesadas
        desc = partes[0].split(": ")[1];  // Extraer  Desc
        poster = partes[1].split(": ")[1];  // Extraer Poster
        precio = partes[2].split(": ")[1];  // Extraer Precio
        titulo = partes[3].split(": ")[1];  // Extraer  titulo 
		this.usuario = pUsu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		
		
		JLabel lblNewLabel = new JLabel("Pelicula: "+ titulo);
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Precio: " + precio + " €");
		lblNewLabel_1.setBounds(57, 94, 114, 46);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Poster:" + poster);
		lblNewLabel_2.setBounds(57, 192, 174, 79);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Desc: " + desc);
		lblNewLabel_3.setBounds(57, 318, 264, 138);
		panel_1.add(lblNewLabel_3);
		String puntPro =String.valueOf(Videoclub.getVideoclub().verPuntPromedio(titulo));
		JLabel lblNewLabel_4 = new JLabel("punt Promedio: " + puntPro);
		lblNewLabel_4.setBounds(57, 453, 181, 14);
		panel_1.add(lblNewLabel_4);
		
		
		panel.add(getBtnAlq());
		
		panel.add(getBtnReseñar());
		
		panel.add(getBtnVolver());
	}
	private JButton getBtnAlq() {
		if(btnAlq == null) {
			btnAlq = new JButton("Alquilar");
			btnAlq.addActionListener(getControler());
		}
		return btnAlq;
	}
	private JButton getBtnReseñar() {
		if(btnReseñar == null) {
			btnReseñar = new JButton("Reseñar (solo si ha sido alquilada)");
			btnReseñar.addActionListener(getControler());
		}
		return btnReseñar;
	}
	private JButton getBtnVolver() {
		if(btnVolver == null) {
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(getControler());
		}
		return btnVolver;
	}
		

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Character){
			this.dispose();
			AlqBien frame = new AlqBien(Videoclub.getVideoclub(), usuario);
			frame.setVisible(true);
		}
		else{
			this.dispose();
			InterfazPelis frame2 = new InterfazPelis(Videoclub.getVideoclub(), (String[])arg, usuario);
			frame2.setVisible(true);
		}
		
		
	}
	private Controler getControler() {
		if (controler == null) {
			controler = new Controler();
		}
		return controler;
	}

	private class Controler implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnVolver)){
				Videoclub.getVideoclub().mostrarPeliculas();
			}
			else if(e.getSource().equals(btnAlq)){
				Videoclub.getVideoclub().alquilarPelicula(usuario, titulo);
			}
			else if(e.getSource().equals(btnReseñar)){
				Reseñar frame = new Reseñar(Videoclub.getVideoclub(),titulo, usuario);
				OpcionesPeli.this.dispose();
				frame.setVisible(true);
			}
		}
	}
	
}
