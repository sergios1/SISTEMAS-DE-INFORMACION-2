package vista;



import javax.swing.*;



import java.awt.*;
public class ventanaPrincipal extends JFrame{

	 
	private JPanel panelFondo;
	private DimensionesPantalla dimPan= new DimensionesPantalla();
	private JButton botonVer;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel labelUno;

	
	
	 /* constructor
	  * 
	  */
	 
	public ventanaPrincipal()
	{
	this.setLayout(new BorderLayout());
	this.setBounds(0, 0, dimPan.horizontal(), dimPan.vertical());
    //this.setForeground(Color.blue);
	
	botonVer =new JButton("enviar");
	botonVer.setBounds(dimPan.PenX(50), dimPan.PenY(50), dimPan.PenX(10), dimPan.PenY(10));
	this.add(botonVer);
	

	
	panel1 =new JPanel();
	panel1.setBounds(dimPan.PenX(20), dimPan.PenY(45), dimPan.PenX(25), dimPan.PenY(30));
	panel1.setBackground(Color.GRAY);
	this.add(panel1,BorderLayout.NORTH);
	labelUno = new JLabel("CONFERENCIA");
	panel1.add(labelUno);
	
	panelFondo = new JPanel();
	//panelFondo.setBounds(dimPan.PenX(50), dimPan.PenY(50), dimPan.PenX(50), dimPan.PenY(50));
	panelFondo.setBackground(Color.blue);
	this.add(panelFondo,BorderLayout.CENTER);
	panelFondo.setLayout(new GridLayout(1, 2));
	//para el derecho panel
	panel2 =new JPanel();
	panel2.setBounds(0, 80, dimPan.horizontal(), dimPan.vertical());
	panel2.setBackground(Color.red);
	panel2.setLayout(new GridLayout(1,1,10,10));
	panelFondo.add(panel2,BorderLayout.SOUTH);
	panel2.add(new JLabel("hola"));
	//para el izquierdo
	panel3 =new JPanel();
	panel3.setBounds(0, 80, dimPan.horizontal(), dimPan.vertical());
	panel3.setBackground(Color.black);
	panel3.setLayout(new GridLayout(1,1,10,10));
	panelFondo.add(panel3,BorderLayout.WEST);
	panel3.add(new JLabel("SESION"));

	
	
	
	}
}
	
	
	
	
	
	

