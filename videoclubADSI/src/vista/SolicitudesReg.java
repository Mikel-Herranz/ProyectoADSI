package vista;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Videoclub;


import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SolicitudesReg extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> list;
	private JPanel panel;
	private JButton btnAceptar;
	private JButton btnDenegar;
	private Controler controler;
	private JButton btnVolver;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			//		SolicitudesReg frame = new SolicitudesReg(Videoclub.getVideoclub());
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
	public SolicitudesReg(Observable datos, String[] solicitudes) {
		datos.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 825);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Solicitudes de Registro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		list = new JList<>(solicitudes);
		JScrollPane scrollPane = new JScrollPane(list);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		list.addListSelectionListener(getControler());

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		
		panel.add(getBtnAceptar());
		panel.add(getBtnDenegar());
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(getControler());
		panel.add(btnVolver);
	
		
	}
	private JButton getBtnAceptar() {
		if(btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(getControler());
		}
		return btnAceptar;
	}
	private JButton getBtnDenegar() {
		if(btnDenegar == null) {
			btnDenegar = new JButton("Denegar");
			btnDenegar.addActionListener(getControler());
		}
		return btnDenegar;
	}
		
	@Override
	public void update(Observable o, Object arg) {
		String[]nueva = (String[])arg;
		list = new JList<>(nueva);
		JScrollPane scrollPane = new JScrollPane(list);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		list.addListSelectionListener(getControler());
		
	}
	private Controler getControler() {
		if (controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	private class Controler implements ActionListener, ListSelectionListener {
		String elementoSeleccionado;
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnAceptar)){
				
				Videoclub.getVideoclub().aceptarSolicitudReg(elementoSeleccionado);
			}
			else if (e.getSource().equals(btnDenegar)) {
				Videoclub.getVideoclub().rechazarSolicitudReg(elementoSeleccionado);
			}
			else if(e.getSource().equals(btnVolver)){
				Comienzo frame = new Comienzo();
				SolicitudesReg.this.dispose();
				frame.setVisible(true);
				
			}
		}
		public void valueChanged(ListSelectionEvent e) {
	        if (!e.getValueIsAdjusting()) {
	            elementoSeleccionado = list.getSelectedValue();
	            System.out.println(elementoSeleccionado);
	            String datos = elementoSeleccionado;
				String[] partes = datos.split(",");
		         
		        String mail = partes[2].split(": ")[1];  // Extraer mail
		        elementoSeleccionado = mail;
	        }
	    }
	}
	
	
}
