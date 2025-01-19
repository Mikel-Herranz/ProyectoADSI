package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Videoclub;
import vista.InicioSesion.Controler;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class InterfazPelis extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Controler controler = null;
	private JButton btnCerrarSesion;
	private JButton btnAmpliado;
	private JButton btnOrdenar;
	private JButton btnDatosPersonales;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[]nombres = {"nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez","nombre: Juan, apellido: Heranndez"};
					InterfazPelis frame = new InterfazPelis(Videoclub.getVideoclub(),nombres,"manuel" );
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
	public InterfazPelis(Observable datos, String[] JSON, String pUsu ) {
		datos.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1370, 954);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Peliculas");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("49px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("14px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBackground(new Color(0, 128, 192));
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		panel_2.add(btnCerrarSesion, "7, 1");
		
		JLabel lblNewLabel_1 = new JLabel("Buscar:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1, "1, 3, 3, 3, right, default");
		
		textField = new JTextField();
		panel_2.add(textField, "5, 3, 1, 4, fill, default");
		textField.setColumns(10);
		
		JButton btnDatosPersonales = new JButton("Cambiar Datos Personaleses");
		btnDatosPersonales.setBackground(new Color(0, 128, 192));
		btnDatosPersonales.setForeground(new Color(255, 255, 255));
		panel_2.add(btnDatosPersonales, "7, 3");
		
		JButton btnAmpliado = new JButton("Abrir Catalogo Ampliado");
		btnAmpliado.setBackground(new Color(0, 128, 192));
		btnAmpliado.setForeground(new Color(255, 255, 255));
		panel_2.add(btnAmpliado, "7, 5");
		
		JButton btnOrdenar = new JButton("Ordenar Pelis");
		btnOrdenar.setBackground(new Color(0, 128, 192));
		btnOrdenar.setForeground(new Color(255, 255, 255));
		panel_2.add(btnOrdenar, "7, 7");
		
		JList<String> list = new JList<>(JSON);
		JScrollPane scrollPane = new JScrollPane(list);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		
		
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
