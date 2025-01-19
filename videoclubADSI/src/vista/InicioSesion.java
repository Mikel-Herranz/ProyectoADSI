package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Videoclub;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
public class InicioSesion extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserteMail;
	private JTextField txtInserteContrasea;
	private Controler controler = null;
	private JButton btnIniciarSesion;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
		//			InicioSesion frame = new InicioSesion(Videoclub.getVideoclub());
		//			frame.setVisible(true);
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		//	}
	//	});
//	}

	/**
	 * Create the frame.
	 */
	public InicioSesion(Observable datos) {
		
		datos.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("INICIO DE SESION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtInserteMail = new JTextField();
		txtInserteMail.setBounds(299, 23, 233, 23);
		panel_1.add(txtInserteMail);
		txtInserteMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInserteMail.setColumns(10);
		
		txtInserteContrasea = new JTextField();
		txtInserteContrasea.setBounds(299, 78, 233, 23);
		panel_1.add(txtInserteContrasea);
		txtInserteContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInserteContrasea.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Correo electronico:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(155, 29, 134, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setBounds(155, 84, 134, 14);
		panel_1.add(lblNewLabel_1_1);
		panel.add(getBtnIniciarSesion());
	}
		private JButton getBtnIniciarSesion() {
			if (btnIniciarSesion == null) {
				btnIniciarSesion = new JButton("Iniciar Sesion");
				btnIniciarSesion.setForeground(new Color(255, 255, 255));
				btnIniciarSesion.setBackground(new Color(0, 128, 192));
				btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnIniciarSesion.addActionListener(getControler());
			
			}
			return btnIniciarSesion;
		}
	@Override
	public void update(Observable o, Object arg) {
		if (arg == null) {
			MalInicioSesion frame = new MalInicioSesion();
			this.dispose();
			frame.setVisible(true);
		}
		else {
			//aqui abrir pagina de inicio con la interfaz de pelis y posibilidad de ir a actualizar datos personales
			this.dispose();
			InterfazPelis frame2 = new InterfazPelis(Videoclub.getVideoclub(), (String[])arg, txtInserteMail.getText());
			
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
			if (e.getSource().equals(btnIniciarSesion)){
				Videoclub.getVideoclub().iniciarSesion(txtInserteMail.getText(), txtInserteContrasea.getText());
			}
		}
	}
}
