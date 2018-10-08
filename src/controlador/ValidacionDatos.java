package controlador;

import java.sql.*;

import javax.swing.JOptionPane;

import modelo.ConeccionBDPostgres;
import vista.VentanaOrganizador;
import vista.VentanaPrincipal;
import vista.VentanaSecretario;

public class ValidacionDatos {
	private ConeccionBDPostgres con;
	public ValidacionDatos() {
		con = new ConeccionBDPostgres();
	}

	public String eliminarEspacio(String texto) {// Este metodo eliminar los espacios
													// innecesarios
		String textoAuxiar = texto.trim();
		String textoFinal = "";
		int espacios = 0;

		for (int i = 0; i < textoAuxiar.length(); i++) {
			if (textoAuxiar.charAt(i) == ' ') {
				espacios++;
			} else
				espacios = 0;
			if (espacios <= 1) {
				textoFinal += textoAuxiar.charAt(i);
			}
		}

		return textoFinal;

	}
	
	public boolean validarAlfabeto(String textoAlfabetico){
		boolean caracterValido = true;
		for(int i = 0; i < textoAlfabetico.length();i++){
			if(textoAlfabetico.charAt(i)== '~'|| textoAlfabetico.charAt(i)=='´'||
					textoAlfabetico.charAt(i)== '0'|| textoAlfabetico.charAt(i)=='1'||
					textoAlfabetico.charAt(i)== '2'|| textoAlfabetico.charAt(i)=='3'||
					textoAlfabetico.charAt(i)== '4'|| textoAlfabetico.charAt(i)=='5'||
					textoAlfabetico.charAt(i)== '6'|| textoAlfabetico.charAt(i)=='7'||
					textoAlfabetico.charAt(i)== '8'|| textoAlfabetico.charAt(i)=='9'||
					textoAlfabetico.charAt(i)== '-'|| textoAlfabetico.charAt(i)=='_'||
					textoAlfabetico.charAt(i)== '='|| textoAlfabetico.charAt(i)=='*'||
					textoAlfabetico.charAt(i)== '&'|| textoAlfabetico.charAt(i)=='$'||
					textoAlfabetico.charAt(i)== '@'|| textoAlfabetico.charAt(i)=='!'||
					textoAlfabetico.charAt(i)== '¡'|| textoAlfabetico.charAt(i)=='+'||
					textoAlfabetico.charAt(i)== '/'|| textoAlfabetico.charAt(i)=='^'||
					textoAlfabetico.charAt(i)== '%'|| textoAlfabetico.charAt(i)=='('||
					textoAlfabetico.charAt(i)== ')'|| textoAlfabetico.charAt(i)=='{'||
					textoAlfabetico.charAt(i)== '}'|| textoAlfabetico.charAt(i)=='['||
					textoAlfabetico.charAt(i)== ']'|| textoAlfabetico.charAt(i)=='?'||
					textoAlfabetico.charAt(i)== '¿'|| textoAlfabetico.charAt(i)=='<'||
					textoAlfabetico.charAt(i)== '>'|| textoAlfabetico.charAt(i)=='#'||
					textoAlfabetico.charAt(i)== '-'|| textoAlfabetico.charAt(i)=='.'||
					textoAlfabetico.charAt(i)== ':'|| textoAlfabetico.charAt(i)==';'||
					textoAlfabetico.charAt(i)== '"'|| textoAlfabetico.charAt(i)=='|'||
					textoAlfabetico.charAt(i)== ','|| textoAlfabetico.charAt(i)==';'
					
					){
				caracterValido = false;
				break;
			}
			
		}
		return caracterValido;
	}

	public boolean correoCorrecto(String correo) {// Este metodo verifica y valida el
													// Correo electrÃ³nico 
		String email = correo.trim();
		int puntos = 0, espacios = 0, arrobas = 0, caracteresEspeciales = 0;
		boolean inavilidarPorPosicion = true;
		for (int i = 0; i < email.length(); i++) {
			if (i == 0 || i == email.length() - 1) {//Controla de que no inicie ni termine en . o @
				if (email.charAt(i) == '.' || email.charAt(i) == '@') {
					inavilidarPorPosicion = false;
					break;
				}
			}
			
			if (i < email.length() - 2 && (email.charAt(i) == '@' || email.charAt(i) == '.')) {//Controla que no exista @@ o ..
				if (email.charAt(i) == email.charAt(i + 1)) {
					inavilidarPorPosicion = false;
					break;
				}
			}

			if (email.charAt(i) == '.') {
				puntos++;
			} else if (email.charAt(i) == ' ') {
				espacios++;
			} else if (email.charAt(i) == '@') {
				arrobas++;
			} else if (email.charAt(i) == '´' || email.charAt(i) == '*' || email.charAt(i) == '~'
					|| email.charAt(i) == '<' || email.charAt(i) == '=' || email.charAt(i) == '>'
					|| email.charAt(i) == '&' || email.charAt(i) == '$' || email.charAt(i) == '^'
					|| email.charAt(i) == '}' || email.charAt(i) == '{' || email.charAt(i) == '+'
					|| email.charAt(i) == '‘' || email.charAt(i) == '#' || email.charAt(i) == '¿'
					|| email.charAt(i) == '?' || email.charAt(i) == '+' || email.charAt(i) == '['
					|| email.charAt(i) == ']' || email.charAt(i) == '(' || email.charAt(i) == ')'
					|| email.charAt(i) == '/' || email.charAt(i) == '"' || email.charAt(i) == '!'
					|| email.charAt(i) == '~' || email.charAt(i) == '¡' || email.charAt(i) == ';'
					|| email.charAt(i) == ',' || email.charAt(i) == ':' || email.charAt(i) == '%')  {
				//Controla que no tenga caracteres especiales
				caracteresEspeciales++;
			}
		}

		if (puntos > 0 && espacios == 0 && arrobas == 1 && caracteresEspeciales == 0 && inavilidarPorPosicion) {

			return true;

		} else return false;
			
	}
	public boolean acceder(String user, String pass ){ // Controla acceso de usuario
		boolean ocultar = false;
		String idBD = "";
		String userBD = "";
		String passBD = "";
		String tipoUsuario = "";
		ResultSet rs = con.inicioSesion(user, pass);
		try {
			while(rs.next()){
				idBD = rs.getString("id_usuario");
				userBD = rs.getString("USUARIO");
				passBD = rs.getString("CLAVE");
				tipoUsuario = rs.getString("TIPO");
				System.out.println("Leido desde la base de datos: "+idBD+" "+userBD+" "+passBD+" "+tipoUsuario);
			}
			if(userBD.equals(user) && passBD.equals(pass) && !tipoUsuario.equals("null")){
				if(tipoUsuario.equals("ORGANIZA")){//Si es organizador
					VentanaOrganizador organizador = new VentanaOrganizador("Organizador", "ORGANIZADOR DE EVENTOS", "icono.png");
					organizador.setVisible(true);
					ocultar = true;
				}else if(tipoUsuario.equals("SECRE")){//Si es Secretario
					VentanaSecretario VentanaSecretario = new VentanaSecretario("Secreatrio", "CUENTA SECRETARIO", "icono.png");
					VentanaSecretario.setVisible(true);
					ocultar = true;
				}else {
					JOptionPane.showMessageDialog(null,
							"El rol del usuario ingresado no existe!\nConsulte con el administrador",
							"Sin rol", JOptionPane.ERROR_MESSAGE);
				}
				
			}else if(tipoUsuario.equals("null")){
				JOptionPane.showMessageDialog(null,
						"No existe rol para el usuario ingresado!\nConsulte con el administrador",
						"Inconsistencia", JOptionPane.NO_OPTION);
			} else{
				JOptionPane.showMessageDialog(null,
						"Revise los campos!\nSi olvidó su contraseña\nconsulte con el administrador",
						"Inconsistencia", JOptionPane.QUESTION_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error..................!");
			e.printStackTrace();
		}
		
		return ocultar;
	}
	public static void main(String args[]) {
		String texto = "   ABAD RAMOS MALDONADO  ";
		System.out.println(texto);
		System.out.println(new ValidacionDatos().eliminarEspacio(texto)+ " "+new ValidacionDatos().validarAlfabeto(texto));
		System.out.println(" el correo electronico es: " + new ValidacionDatos().correoCorrecto("    aarrmmgmail.com"));

	}
}

	
