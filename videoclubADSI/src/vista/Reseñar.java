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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Reseñar extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPunt;
	private JTextField textFieldComent;
	private Controler controler;
	private JButton btnRes;
	private String usuario;
	private String titulo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			//		Reseñar frame = new Reseñar();
			//		frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reseñar(Observable datos, String ptitulo, String pusuario) {
		datos.addObserver(this);
		usuario = pusuario;
		titulo = ptitulo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("RESEÑANDO");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Puntuacion");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(68, 174, 111, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Comentario:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(31, 302, 148, 14);
		panel.add(lblNewLabel_2);
		
		textFieldPunt = new JTextField();
		textFieldPunt.setBounds(223, 171, 96, 20);
		panel.add(textFieldPunt);
		textFieldPunt.setColumns(10);
		
		textFieldComent = new JTextField();
		textFieldComent.setBounds(223, 299, 494, 78);
		panel.add(textFieldComent);
		textFieldComent.setColumns(10);
		
		btnRes = new JButton("Enviar Reseña");
		btnRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRes.setBounds(299, 455, 284, 113);
		btnRes.addActionListener(getControler());
		panel.add(btnRes);
		
		JLabel lblNewLabel_3 = new JLabel(usuario);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(196, 60, 161, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(titulo);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(600, 60, 197, 14);
		panel.add(lblNewLabel_4);
		
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		InterfazPelis frame = new InterfazPelis(Videoclub.getVideoclub(),(String[])arg, usuario);
		this.dispose();
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
			if (e.getSource().equals(btnRes)){
				double punt = Double.parseDouble(textFieldPunt.getText());
				Videoclub.getVideoclub().resenarPelicula(usuario, titulo, textFieldComent.getText(),punt );
			}
		}
	}
	
}
