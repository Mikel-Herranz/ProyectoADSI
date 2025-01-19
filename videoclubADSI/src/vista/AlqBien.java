package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import modelo.Videoclub;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;
import java.awt.Color;

public class AlqBien extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVolver;
	private Controler controler;
	private String usuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			//		AlqBien frame = new AlqBien();
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
	public AlqBien(Observable datos, String pUsuario) {
		datos.addObserver(this);
		usuario = pUsuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alquilado Correctamente");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(150, 126, 625, 149);
		contentPane.add(lblNewLabel);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolver.setBounds(338, 407, 262, 81);
		btnVolver.addActionListener(getControler());
		contentPane.add(btnVolver);
	}

	@Override
	public void update(Observable o, Object arg) {
		InterfazPelis frame = new InterfazPelis(Videoclub.getVideoclub(), (String[])arg, usuario );
		
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
		}
	}

}
