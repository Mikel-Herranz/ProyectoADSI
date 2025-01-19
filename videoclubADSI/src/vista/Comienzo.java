package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Videoclub;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Comienzo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Comienzo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 815);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("VIDEOCLUB");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBackground(new Color(0, 128, 192));
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(btnIniciarSesion);
		
		JButton btnRegistro = new JButton("Solicitar Registro");
		
		btnRegistro.setForeground(new Color(255, 255, 255));
		btnRegistro.setBackground(new Color(0, 128, 192));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(btnRegistro);
		
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comienzo.this.dispose();
				Registrarse frame = new Registrarse();
				frame.setVisible(true);
			}
		});
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comienzo.this.dispose();
				InicioSesion frame = new InicioSesion(Videoclub.getVideoclub());
				frame.setVisible(true);
			}
		});
	
		
	}
	
}
