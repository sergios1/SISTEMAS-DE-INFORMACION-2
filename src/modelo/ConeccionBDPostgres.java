package modelo;

import java.sql.*;

public class ConeccionBDPostgres {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String bd, nombreUsuario, password;

	public ConeccionBDPostgres() {
		con = null;
		st = null;
		rs = null;
		bd = "bdConferencia";
		nombreUsuario = "postgres";
		password = "admin";
		conectar();
	}

	private void conectar() {// Conecta con la base de datos
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + bd, nombreUsuario, password);
			System.out.println("Se conecto con exito");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se conecto con exito\n" + e);
		}
	}

	public ResultSet mostrarDatos(String nombreTabla, String [] elementos) {
		String datos = "";
		for(int i = 0; i < elementos.length; i++){
			if(i< elementos.length -1){
				datos += elementos [i]+", ";
			}else{
				datos += elementos [i];
			}
			
		}
		System.out.println(datos);
		try {
			st = con.createStatement();
			rs = st.executeQuery("select "+datos+" from " + nombreTabla);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet inicioSesion(String nombre, String pass){
		try{
			st = con.createStatement();
			rs = st.executeQuery("SELECT id_usuario, USUARIO, CLAVE, TIPO  FROM USUARIO WHERE USUARIO = '"+nombre+"' AND CLAVE = '"+pass+"';");
			System.out.println("Se hizo la consulta");
			return rs;
		}catch(Exception e){
			System.out.println("No se optenieron los datos de login de la BD");
			return rs;
			
		}
		
	}
}
