package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Videoclub;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Registrarse extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldMail;
	private JTextField textFieldTelefono;
	private JTextField textFieldFecha;
	private JTextField textFieldContraseña;
	private JButton btnNewButton;
	private Controler controler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrarse frame = new Registrarse(Videoclub.getVideoclub());
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
	public Registrarse(Observable datos) {
		datos.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 898);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(331, 114, 192, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(331, 193, 192, 20);
		panel.add(textFieldApellido);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(331, 291, 192, 20);
		panel.add(textFieldMail);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(331, 370, 192, 20);
		panel.add(textFieldTelefono);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(331, 462, 192, 20);
		panel.add(textFieldFecha);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(331, 564, 192, 20);
		panel.add(textFieldContraseña);
		
		
		panel.add(getBtnNewButton());
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(256, 117, 65, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(234, 193, 89, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mail:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_1.setBounds(248, 294, 75, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Telefono:");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_2.setBounds(222, 373, 101, 14);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_3.setBounds(160, 465, 163, 14);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Nueva Contraseña:");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_4.setBounds(194, 567, 127, 14);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
		
	}
		
	private JButton getBtnNewButton() {
		if (btnNewButton==null) {
			btnNewButton = new JButton("Solicitar Registro");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(0, 128, 192));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnNewButton.setBounds(277, 655, 368, 98);
			btnNewButton.addActionListener(getControler());
		}return btnNewButton;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg == null) {
			ErrorReg frame = new ErrorReg();
			this.dispose();
			frame.setVisible(true);
		}
		else {
			SolicitudCorrecta frame1 = new SolicitudCorrecta();
			this.dispose();
			frame1.setVisible(true);
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
			if (e.getSource().equals(btnNewButton)){
				Integer numero = Integer.parseInt(textFieldTelefono.getText());
				String fechaStr = textFieldFecha.getText();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			    // Convertir la cadena a LocalDate (sin hora)
			    LocalDate localDate = LocalDate.parse(fechaStr, formatter);

			    // Convertir LocalDate a Date (si es necesario)
			    Date fecha = java.sql.Date.valueOf(localDate);
				Videoclub.getVideoclub().solicitarRegistro(textFieldContraseña.getText(), textFieldNombre.getText(), textFieldApellido.getText(), textFieldMail.getText(), numero, fecha);
				
			}
		}
	}
		
}