package modelo;

public class conexionBD {

private Conexion crearconexion() throws SQLException ,ClassNotFoundException{
class.forName ("org.postgres.Driver");
String url= "jdbc:postgresql://localhost5432/CONFERENCIA";
Connection conexion= DriverManager.getConnection(url,"postgres","Jonathan");
return conexion; 
}
