package vadecum;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vandecum_Login {

	private JFrame frame;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vandecum_Login window = new Vandecum_Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection coneccion = null;
	
	/**
	 * Create the application.
	 */
	public Vandecum_Login() {
		initialize();
		//Uso el metodo en la clase SqliteConeccion para conectar la base al login
		coneccion = SqliteConeccion.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBienvenidoAVandecum = new JLabel("Bienvenido a Vandecum, por favor ingrese sus datos de usuario");
		lblBienvenidoAVandecum.setBounds(178, 29, 332, 14);
		frame.getContentPane().add(lblBienvenidoAVandecum);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setBounds(34, 99, 120, 42);
		frame.getContentPane().add(lblNombreDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(34, 172, 67, 42);
		frame.getContentPane().add(lblContrasea);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(134, 110, 507, 20);
		frame.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(134, 183, 507, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Querry para checar el login del usuario
				String Querry = "select * from Usuario where NombreDeUsuario =? and Contraseña= ?";
				
				PreparedStatement PS  = coneccion.prepareStatement(Querry);
				//Agarro la ? en posicion 0 y le agrego el valor de la variable del campo de texto
				
				PS.setString(0, textFieldUserName.getText());
				
			}
		});
		btnIngresar.setBounds(34, 362, 89, 23);
		frame.getContentPane().add(btnIngresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(552, 362, 89, 23);
		frame.getContentPane().add(btnSalir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 304, 664, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 65, 664, 2);
		frame.getContentPane().add(separator_1);
	}
}
