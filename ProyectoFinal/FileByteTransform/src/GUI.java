import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.awt.event.ItemEvent;

public class GUI {

	private JFrame frmEncripcion;
	private JTextField fieldPathIn;
	private JTextField fieldPathOut;
	private JTextField fieldContrasena;
	private boolean botonPresionado = false;
	private JComboBox fieldAlgoritmo;
	private JComboBox fieldModalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmEncripcion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEncripcion = new JFrame();
		frmEncripcion.setResizable(false);
		frmEncripcion.setMinimumSize(new Dimension(555, 300));
		frmEncripcion.setMaximumSize(new Dimension(555, 300));
		frmEncripcion.setTitle("Encripcion");
		frmEncripcion.setBounds(100, 100, 555, 301);
		frmEncripcion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fieldAlgoritmo = new JComboBox();
		fieldAlgoritmo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				fixEverything();
			}
		});
		fieldAlgoritmo.setModel(new DefaultComboBoxModel(new String[] {"AES", "IDEA", "DES"}));
		
		fieldPathIn = new JTextField();
		fieldPathIn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				fixEverything();
			}
			@Override
			public void focusLost(FocusEvent e) {
				fixEverything();
			}
		});
		fieldPathIn.setColumns(10);
		
		fieldPathOut = new JTextField();
		fieldPathOut.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				fixEverything();
			}
			@Override
			public void focusLost(FocusEvent e) {
				fixEverything();
			}
		});
		fieldPathOut.setColumns(10);
		
		fieldContrasena = new JTextField();
		fieldContrasena.setEnabled(false);
		
		JLabel lblSeleccioneAlgoritmo = new JLabel("Seleccione Algoritmo");
		
		fieldModalidad = new JComboBox();
		fieldModalidad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				fixEverything();
			}
		});
		fieldModalidad.setModel(new DefaultComboBoxModel(new String[] {"Encriptar", "Desencriptar"}));
		
		JLabel lblNewLabel = new JLabel("Modalidad");
		
		JLabel lblDireccionDelArchivo = new JLabel("Direccion del Archivo");
		
		JLabel lblDireccionDeSalida = new JLabel("Direccion de Salida");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		JButton btnGo = new JButton("GO!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPresionado = true;
				fixEverything();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmEncripcion.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSeleccioneAlgoritmo)
							.addGap(18)
							.addComponent(fieldAlgoritmo, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDireccionDeSalida)
								.addComponent(lblDireccionDelArchivo)
								.addComponent(lblNewLabel)
								.addComponent(lblContrasea))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldPathIn, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
								.addComponent(fieldModalidad, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(fieldContrasena, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
								.addComponent(fieldPathOut, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
								.addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(fieldAlgoritmo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSeleccioneAlgoritmo))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldModalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldPathIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDireccionDelArchivo))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldPathOut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDireccionDeSalida))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnGo, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		frmEncripcion.getContentPane().setLayout(groupLayout);
	}

	protected void fixEverything() {
		String encripcion = fieldAlgoritmo.getSelectedItem().toString();
		String modalidad = fieldModalidad.getSelectedItem().toString();
		String path = fieldPathIn.getText();
		String out = fieldPathOut.getText();
		String contrasena = "";
		
		fieldContrasena.setEnabled(fieldModalidad.getSelectedItem().toString().toUpperCase().equals("DESENCRIPTAR"));
		
		if (!fieldContrasena.getText().toString().isEmpty()){
			contrasena = fieldContrasena.getText().toString();
		}
		
		if(botonPresionado){
			Bootstrapper boot = new Bootstrapper();
			String[] info;
			info = new String[5];
			info[0] = encripcion;
			info[1] = modalidad;
			info[2] = path;
			info[3] = out;
			info[4] = contrasena;
			if(camposOk(info)){
				try {
					boot.start(info);
				} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException
						| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
			botonPresionado = false;
		}
		
		
		
	}
	private boolean camposOk(String[] info) {
		
		if(info[2].isEmpty()||info[3].isEmpty()){
			JOptionPane.showMessageDialog(null, "Alguno de tus paths esta vacio");
			return false;
		}
		if(info[1].toUpperCase().equals("DESENCRIPTAR")&&info[4].isEmpty()){
			JOptionPane.showMessageDialog(null, "La contraseña esta vacia");
			return false;
		}
		
		return true;
	}

	public JComboBox getFieldAlgoritmo() {
		return fieldAlgoritmo;
	}
	public JComboBox getFieldModalidad() {
		return fieldModalidad;
	}
}
