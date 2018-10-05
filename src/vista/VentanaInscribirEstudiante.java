package vista;

import java.awt.Button;

import javax.swing.*;

public class VentanaEstuduante {
	public static void main (String[]args ) {
		
		JFrame s = new JFrame("INSCRIPCION DE ESTUDIANTES")
		s.setSize(400,300);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
		
	}
}

public class VentanaInscribirEstudiante extends JPanel {
	
	JLabel labelTitulo, labelNombre, labelApellidoPaterno,labellabelApellidoMaterno,labelCelular,labelCorreoElectronico;
	JTextField fieldNombre,fieldApellidoPaterno,fieldApellidoMAterno,fieldCelular,fieldCorreoElectrinico;
	JButton botonInscribirse;
	JButton botonCancelar;
public VentanaInscribirEstudiante () {
  this.setLayout (null);
  

 }	
}
 
