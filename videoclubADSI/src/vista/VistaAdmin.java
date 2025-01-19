package vista;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import modelo.Videoclub;


import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VistaAdmin extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnBuscar;
	private JButton btnRegistros;
	private JButton btnPelis;
	private Controler controler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdmin frame = new VistaAdmin(Videoclub.getVideoclub());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaAdmin(Observable datos) {
		datos.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Bienvenido Admin!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		

		panel.add(getBtnBuscar());
		panel.add(getBtnRegistros());
		panel.add(getBtnPelis());
		
	}
	private JButton getBtnPelis() {
		if ( btnPelis == null) {
			btnPelis = new JButton("Ver solicitudes de Incorporamiento de Peliculas");
			btnPelis.addActionListener(getControler());
		}
		return btnPelis;
	}
	private JButton getBtnRegistros() {
		if ( btnRegistros == null) {
			btnRegistros = new JButton("ver Solicitudes de Registro");
			btnRegistros.addActionListener(getControler());
		}
		return btnRegistros;
	}
	private JButton getBtnBuscar() {
		if ( btnBuscar == null) {
			btnBuscar= new JButton("Buscar Usuarios");
			btnBuscar.addActionListener(getControler());
		}
		return btnBuscar;
	}
	@Override
	public void update(Observable o, Object arg) {
		this.dispose();
		SolicitudesReg frame = new SolicitudesReg(Videoclub.getVideoclub(), (String[])arg);
		frame.setVisible(true);
	}
	private Controler getControler() {
		if (controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	private class Controler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnBuscar)){
				VistaAdmin.this.dispose();
				//crear ventana de buscar usuarios
			}
			else if(e.getSource().equals(btnRegistros)) {
				Videoclub.getVideoclub().mostrarSolicitudes();
			}
			else if(e.getSource().equals(btnPelis)) {
				Videoclub.getVideoclub().mostrarIncorporamientos();
			}
		}
	}
		
		
	

}
