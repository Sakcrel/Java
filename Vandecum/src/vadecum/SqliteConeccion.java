package vadecum;

import java.sql.*;
import javax.swing.*;


public class SqliteConeccion {

	Connection coneccion = null;
	
	public static Connection dbConnector () {
		
		//Paso la direccion de la base de datos
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Windows\\Desktop\\Trabajos practicos\\Vandecum\\my_database.sqlite");
			JOptionPane.showMessageDialog(null, "Se pudo conectar");
			
			
			return conn;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	
	
}
