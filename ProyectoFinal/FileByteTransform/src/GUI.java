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
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.awt.event.ItemEvent;
import javax.swing.JFileChooser;

public class GUI {

	private JFrame frmEncripcion;
	private JTextField fieldPathIn;
	private JTextField fieldPathOut;
	private JTextField fieldPathPrivada;
	private boolean botonPresionado = false;
	private boolean botonLlaves = false;
	private boolean botonPrivada = false;
	private boolean botonPublica = false;
	private boolean botonSecreta = false;
	private boolean botonArchivo = false;
	private boolean botonSalida = false;
	private JComboBox fieldAlgoritmo;
	private JComboBox fieldModalidad;
	private JTextField fieldPathPublica;
	private JTextField fieldPathSecreta;
	private JButton btnPrivada;
	private JButton btnPublica;
	private JButton btnSecreta;
	private JButton btnArchivo;
	private JButton btnSalida;

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
		frmEncripcion.setMinimumSize(new Dimension(600, 420));
		frmEncripcion.setMaximumSize(new Dimension(600, 420));
		frmEncripcion.setTitle("Encripcion");
		frmEncripcion.setBounds(100, 100, 599, 421);
		frmEncripcion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fieldAlgoritmo = new JComboBox();
		fieldAlgoritmo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					fixEverything();
				} catch (NoSuchAlgorithmException | NoSuchProviderException | IOException | InvalidKeySpecException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fieldAlgoritmo.setModel(new DefaultComboBoxModel(new String[] {"AES", "IDEA", "DES"}));
		
		fieldPathIn = new JTextField();
		fieldPathIn.setEnabled(false);
		fieldPathIn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					fixEverything();
				} catch (NoSuchAlgorithmException | NoSuchProviderException | IOException | InvalidKeySpecException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				try {
					fixEverything();
				} catch (NoSuchAlgorithmException | NoSuchProviderException | IOException | InvalidKeySpecException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fieldPathIn.setColumns(10);
		
		fieldPathOut = new JTextField();
		fieldPathOut.setEnabled(false);
		fieldPathOut.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					fixEverything();
				} catch (NoSuchAlgorithmException | NoSuchProviderException | IOException | InvalidKeySpecException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				try {
					fixEverything();
				} catch (NoSuchAlgorithmException | NoSuchProviderException | IOException | InvalidKeySpecException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fieldPathOut.setColumns(10);
		
		fieldPathPrivada = new JTextField();
		fieldPathPrivada.setEnabled(false);
		
		JLabel lblSeleccioneAlgoritmo = new JLabel("Seleccione Algoritmo");
		
		fieldModalidad = new JComboBox();
		fieldModalidad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					fixEverything();
				} catch (NoSuchAlgorithmException | NoSuchProviderException | IOException | InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		fieldModalidad.setModel(new DefaultComboBoxModel(new String[] {"Encriptar", "Desencriptar"}));
		
		JLabel lblNewLabel = new JLabel("Modalidad");
		
		JLabel lblDireccionDelArchivo = new JLabel("Direccion del Archivo");
		
		JLabel lblDireccionDeSalida = new JLabel("Direccion de Salida");
		
		JLabel lblContrasea = new JLabel("Direccion de Llave Privada");
		
		JButton btnGo = new JButton("GO!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPresionado = true;
				try {
					fixEverything();
				} catch (NoSuchAlgorithmException | NoSuchProviderException | IOException | InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnGenerarLlaves = new JButton("Generar Par De Llaves");
		btnGenerarLlaves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonLlaves = true;
				try {
					fixEverything();
				} catch (NoSuchAlgorithmException | NoSuchProviderException | IOException | InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblDireccionDeLlave = new JLabel("Direccion de Llave Publica");
		
		fieldPathPublica = new JTextField();
		fieldPathPublica.setEnabled(false);
		
		fieldPathSecreta = new JTextField();
		fieldPathSecreta.setEnabled(false);
		
		JLabel lblDireccionDeLlave_1 = new JLabel("Direccion de Llave Secreta");
		
		btnPrivada = new JButton("...");
		btnPrivada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPrivada = true;
				fixChooser();
			}
		});
		
		btnPublica = new JButton("...");
		btnPublica.setEnabled(false);
		btnPublica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPublica = true;
				fixChooser();
			}
		});
		
		btnSecreta = new JButton("...");
		btnSecreta.setEnabled(false);
		btnSecreta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonSecreta = true;
				fixChooser();
			}
		});
		
		btnArchivo = new JButton("...");
		btnArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonArchivo = true;
				fixChooser();
			}
		});
		
		btnSalida = new JButton("...");
		btnSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonSalida = true;
				fixChooser();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmEncripcion.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
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
										.addComponent(fieldPathPrivada, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
										.addComponent(fieldPathOut, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalida, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnArchivo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPrivada, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDireccionDeLlave, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDireccionDeLlave_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnGenerarLlaves, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(fieldPathPublica, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnPublica, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(fieldPathSecreta, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSecreta, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
						.addComponent(lblDireccionDelArchivo)
						.addComponent(btnArchivo))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldPathOut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDireccionDeSalida)
						.addComponent(btnSalida))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldPathPrivada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea)
						.addComponent(btnPrivada))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccionDeLlave)
						.addComponent(fieldPathPublica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPublica))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldPathSecreta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDireccionDeLlave_1)
						.addComponent(btnSecreta))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnGo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGenerarLlaves, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		frmEncripcion.getContentPane().setLayout(groupLayout);
	}

	protected void fixChooser(){
		JFileChooser filechooser = new JFileChooser();
		if(botonSalida){
			filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
		int codigo = filechooser.showOpenDialog(null);
		
		if(botonArchivo){
			botonArchivo = false;
			if(codigo == JFileChooser.CANCEL_OPTION || codigo == JFileChooser.ERROR_OPTION){
				return;
			}
			fieldPathIn.setText(filechooser.getSelectedFile().getAbsolutePath());
			return;
		}
		
		if(botonSalida){
			botonSalida = false;
			if(codigo == JFileChooser.CANCEL_OPTION || codigo == JFileChooser.ERROR_OPTION){
				return;
			}
			fieldPathOut.setText(filechooser.getSelectedFile().getAbsolutePath());
			return;
		}
		
		if(botonPrivada){
			botonPrivada = false;
			if(codigo == JFileChooser.CANCEL_OPTION || codigo == JFileChooser.ERROR_OPTION){
				return;
			}
			fieldPathPrivada.setText(filechooser.getSelectedFile().getAbsolutePath());
			return;
		}
		if(botonPublica){
			botonPublica = false;
			if(codigo == JFileChooser.CANCEL_OPTION || codigo == JFileChooser.ERROR_OPTION){
				return;
			}
			fieldPathPublica.setText(filechooser.getSelectedFile().getAbsolutePath());
			return;
		}
		if(botonSecreta){
			botonSecreta = false;
			if(codigo == JFileChooser.CANCEL_OPTION || codigo == JFileChooser.ERROR_OPTION){
				return;
			}
			fieldPathSecreta.setText(filechooser.getSelectedFile().getAbsolutePath());
			return;
		}
		
	}
	
	protected void fixEverything() throws NoSuchAlgorithmException, NoSuchProviderException, IOException, InvalidKeySpecException {
		Bootstrapper boot = new Bootstrapper();
		if(botonLlaves){
			boot.genLlaves();
			botonLlaves = false;
			return;
		}
		
		String encripcion = fieldAlgoritmo.getSelectedItem().toString();
		String modalidad = fieldModalidad.getSelectedItem().toString();
		String path = fieldPathIn.getText();
		String out = fieldPathOut.getText();
		String llavePrivada = "";
		String llavePublica = "";
		String llaveSecreta = "";
		
		btnPrivada.setEnabled(fieldModalidad.getSelectedItem().toString().toUpperCase().equals("ENCRIPTAR"));
		btnPublica.setEnabled(fieldModalidad.getSelectedItem().toString().toUpperCase().equals("DESENCRIPTAR"));
		btnSecreta.setEnabled(fieldModalidad.getSelectedItem().toString().toUpperCase().equals("DESENCRIPTAR"));
		
		if (!fieldPathPrivada.getText().toString().isEmpty()){
			llavePrivada = fieldPathPrivada.getText().toString();
		}
		
		if (!fieldPathPublica.getText().toString().isEmpty()){
			llavePublica = fieldPathPublica.getText().toString();
		}
		
		if (!fieldPathSecreta.getText().toString().isEmpty()){
			llaveSecreta = fieldPathSecreta.getText().toString();
		}
		
		if(botonPresionado){
			String[] info;
			info = new String[7];
			info[0] = encripcion;
			info[1] = modalidad;
			info[2] = path;
			info[3] = out;
			info[4] = llavePrivada;
			info[5] = llavePublica;
			info[6] = llaveSecreta;
			
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
		/*if(info[1].toUpperCase().equals("DESENCRIPTAR")&&info[4].isEmpty()){
			JOptionPane.showMessageDialog(null, "La contraseña esta vacia");
			return false;
		}*/
		
		return true;
	}

	public JComboBox getFieldAlgoritmo() {
		return fieldAlgoritmo;
	}
	public JComboBox getFieldModalidad() {
		return fieldModalidad;
	}
	protected JButton getBtnPrivada() {
		return btnPrivada;
	}
	protected JButton getBtnPublica() {
		return btnPublica;
	}
	protected JButton getBtnSecreta() {
		return btnSecreta;
	}
}
