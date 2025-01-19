package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Videoclub;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class CambiarDatosUsu extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelf;
	private JTextField textFieldFecha;
	private JButton btnModificarDatos;
	private Controler controler;
	private String usuario;
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				CambiarDatosUsu frame = new CambiarDatosUsu();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 * @param usuario 
	 * @param fechaNacimiento 
	 * @param telefono 
	 * @param apellido 
	 * @param nombre 
	 * @param  
	 */
	public CambiarDatosUsu(Observable datos, String nombre, String apellido, String telefono, String fechaNacimiento, String usuario) {
		datos.addObserver(this);
		this.usuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Editando Datos De: "+ usuario);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(263, 62, 65, 14);
		panel.add(lblNewLabel_1);
		
		textFieldNombre = new JTextField(nombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(338, 59, 183, 20);
		panel.add(textFieldNombre);
		
		textFieldApellido = new JTextField(apellido);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(338, 135, 183, 20);
		panel.add(textFieldApellido);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(241, 138, 89, 14);
		panel.add(lblNewLabel_2);
		
		textFieldTelf = new JTextField(telefono);
		textFieldTelf.setColumns(10);
		textFieldTelf.setBounds(346, 224, 177, 20);
		panel.add(textFieldTelf);
		
		JLabel lblNewLabel_2_2 = new JLabel("Telefono:");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_2.setBounds(237, 227, 101, 14);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Fecha de Nacimiento(yyyy-MM-dd):");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_3.setBounds(99, 319, 239, 14);
		panel.add(lblNewLabel_2_3);
		
		textFieldFecha = new JTextField(fechaNacimiento);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(346, 316, 183, 20);
		panel.add(textFieldFecha);
		panel.add(getBtnModificarDatos());
		
	}
	private JButton getBtnModificarDatos() {
		if(btnModificarDatos == null) {
			btnModificarDatos = new JButton("Modificar Datos");
			btnModificarDatos.setForeground(Color.WHITE);
			btnModificarDatos.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnModificarDatos.setBackground(new Color(0, 128, 192));
			btnModificarDatos.setBounds(237, 425, 368, 98);
			btnModificarDatos.addActionListener(getControler());	
		}
		return btnModificarDatos;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.dispose();
		InterfazPelis frame = new InterfazPelis(Videoclub.getVideoclub(), (String[])arg , usuario);
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
			if (e.getSource().equals(btnModificarDatos)){
				Integer numero = Integer.parseInt(textFieldTelf.getText());
				String fechaStr = textFieldFecha.getText();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			    // Convertir la cadena a LocalDate (sin hora)
			    LocalDate localDate = LocalDate.parse(fechaStr, formatter);

			    // Convertir LocalDate a Date (si es necesario)
			    Date fecha = java.sql.Date.valueOf(localDate);
				Videoclub.getVideoclub().actualizarDatosUsurio(textFieldNombre.getText(),textFieldApellido.getText(), usuario, numero, fecha);
			}
		}
	}
}
