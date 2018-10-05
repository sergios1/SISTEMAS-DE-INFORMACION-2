package modelo;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
public class coneccionBDPostgres {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String bd,nombreUsuario,password; 
	
	public coneccionBDPostgres(){
		con = null;
		st = null;
		rs = null;
		bd = "conferencia";
		nombreUsuario = "postgres";
		password = "admin";
		conectar();
	}
	private void conectar(){//Conecta con la base de datos
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+bd,nombreUsuario,password);
			System.out.println("Se conecto con exito");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se conecto con exito" + e);
		}


	}
public ResultSet mostrarDatos(String nombreTabla) {
	
	st = con.createStatement();
	rs = st.executeQuery("select * from " + nombreTabla);
	
	return rs;
	
}
	

}
