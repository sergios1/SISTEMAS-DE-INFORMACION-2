package vista;
import javax.swing.*;

import sun.java2d.pipe.hw.AccelDeviceEventListener;

import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaInscribirEstudiante extends JFrame implements ActionListener {
	
	private JLabel labelTitulo, labelNombre, labelApellidoPaterno,labellabelApellidoMaterno,labelCelular,labelCorreoElectronico;
	JTextField fieldNombre,fieldApellidoPaterno,fieldApellidoMAterno,fieldCelular,fieldCorreoElectrinico;
	JButton botonInscribirse;
	JButton botonCancelar;
	private DimensionesPantalla dimPan;
public VentanaInscribirEstudiante () {
  this.setLayout (null);
  dimPan = new DimensionesPantalla();
  this.setBounds(0, 0, dimPan.PenX(50), dimPan.PenY(50));
  labelTitulo = new JLabel("INSCRIPCION");
  labelTitulo.setBounds(0, dimPan.PenY(1), dimPan.PenX(50), dimPan.PenY(4));
  labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
  labelTitulo.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(25)));
  add(labelTitulo);
  
  
  

 }	

public static void main (String[]args ) {
	
	new VentanaInscribirEstudiante().setVisible(true);
	
}
}
 
