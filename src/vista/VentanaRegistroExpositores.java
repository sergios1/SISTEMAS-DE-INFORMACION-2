package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class VentanaRegistroExpositores extends JFrame implements ActionListener{
	
	private JPanel panelFondo;
	private JLabel labelTitulo, labelNombreExpositor, labelAP, labelAM, 
	labelDireccion, labelEmail, labelTelefono; 
	private JTextField fieldNombreExpositor, fieldAP, fieldAM, 
	fieldDireccion, fieldEmail, fieldTelefono;
	private JButton botonCancelar,botonRegistrar;
	private DimensionesPantalla dimPan;
	public VentanaRegistroExpositores(){
		
		dimPan = new DimensionesPantalla();
		this.setSize(dimPan.PenX(50), dimPan.PenY(70));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panelFondo = new JPanel();
		panelFondo.setBounds(0,0,dimPan.PenX(50), dimPan.PenY(70));
		panelFondo.setLayout(null);
		this.add(panelFondo);
		//INICIALIZACION DE LOS OBJETOS
		labelTitulo = new JLabel("REGISTRO DE EXPOSITORES");
		labelNombreExpositor = new JLabel("NOMBRE:   ");
		labelAP = new JLabel ("APELLIDO PATERNO:   ");
		labelAM = new JLabel ("APELLIDO MATERNO:   ");
		labelEmail = new JLabel ("E-MAIL:   ");
		labelTelefono = new JLabel ("TELEFONO:   ");
		labelDireccion = new JLabel("DIRECCION:   ");
		
		fieldNombreExpositor = new JTextField();
		fieldAP = new JTextField();
		fieldAM = new JTextField ();
		fieldEmail = new JTextField ();
		fieldTelefono = new JTextField ();
		fieldDireccion = new JTextField();
		
		botonCancelar = new JButton("CANCELAR");
		botonRegistrar = new JButton("REGISTRAR");
		
		labelTitulo.setBounds(0, dimPan.PenY(1), dimPan.PenX(50), dimPan.PenY(6));
		labelTitulo.setFont(new Font("Andale mono", 1, dimPan.tamanioLetra(25)));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelFondo.add(labelTitulo);
		
		labelNombreExpositor.setBounds(0, dimPan.PenY(10), dimPan.PenX(25), dimPan.PenY(5));
		labelNombreExpositor.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFondo.add(labelNombreExpositor);
		
		labelAP.setBounds(0, dimPan.PenY(15), dimPan.PenX(25), dimPan.PenY(5));
		labelAP.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFondo.add(labelAP);
		
		labelAM.setBounds(0, dimPan.PenY(20), dimPan.PenX(25), dimPan.PenY(5));
		labelAM.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFondo.add(labelAM);
		
		labelDireccion.setBounds(0, dimPan.PenY(25), dimPan.PenX(25), dimPan.PenY(5));
		labelDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFondo.add(labelDireccion);
		
		labelEmail.setBounds(0, dimPan.PenY(30), dimPan.PenX(25), dimPan.PenY(5));
		labelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFondo.add(labelEmail);
		
		labelTelefono.setBounds(0, dimPan.PenY(35), dimPan.PenX(25), dimPan.PenY(5));
		labelTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFondo.add(labelTelefono);
		
		
		
		fieldNombreExpositor.setBounds(dimPan.PenX(25), dimPan.PenY(10), dimPan.PenX(10), dimPan.PenY(5));
		panelFondo.add(fieldNombreExpositor);
		
		fieldAP.setBounds(dimPan.PenX(25), dimPan.PenY(15), dimPan.PenX(10), dimPan.PenY(5));
		panelFondo.add(fieldAP);
		
		fieldAM.setBounds(dimPan.PenX(25), dimPan.PenY(20), dimPan.PenX(10), dimPan.PenY(5));
		panelFondo.add(fieldAM);
		
		fieldDireccion.setBounds(dimPan.PenX(25), dimPan.PenY(25), dimPan.PenX(10), dimPan.PenY(5));
		panelFondo.add(fieldDireccion);
		
		fieldEmail.setBounds(dimPan.PenX(25), dimPan.PenY(30), dimPan.PenX(10), dimPan.PenY(5));
		panelFondo.add(fieldEmail);
		
		fieldTelefono.setBounds(dimPan.PenX(25), dimPan.PenY(35), dimPan.PenX(10), dimPan.PenY(5));
		panelFondo.add(fieldTelefono);
		
		
		botonCancelar = new JButton("CANCELAR");
		botonCancelar.setBounds(dimPan.PenX(10), dimPan.PenY(50), dimPan.PenX(10), dimPan.PenY(5));
		botonCancelar.addActionListener(this);
		panelFondo.add(botonCancelar);
		
		botonRegistrar = new JButton("REGISTRAR");
		botonRegistrar.setBounds(dimPan.PenX(30), dimPan.PenY(50), dimPan.PenX(10), dimPan.PenY(5));
		botonRegistrar.addActionListener(this);
		panelFondo.add(botonRegistrar);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==botonCancelar){
			this.dispose();
		}else {
			
			
			
		}
	}
	
	public static void main(String args []){
		
		new VentanaRegistroExpositores().setVisible(true);
		
	}

}
