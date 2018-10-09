package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controlador.ValidacionDatos;
import modelo.ConeccionBDPostgres;
/**
*
* @author Gustavo
* 
*/
public class VentanaRegistroExpositores extends JDialog implements ActionListener{
	
	private JPanel panelFondo;
	private JLabel labelTitulo, labelNombreExpositor, labelAP, labelAM, 
	labelDireccion, labelEmail, labelTelefono, labelEspecialidad; 
	private JTextField fieldNombreExpositor, fieldAP, fieldAM, 
	fieldDireccion, fieldEmail, fieldTelefono;
	private JComboBox comboEspecialidad;
	private JButton botonCancelar,botonRegistrar;
	private Herramientas dimPan;
	public VentanaRegistroExpositores(Frame padre, boolean bloquear){
		super(padre, bloquear);
		dimPan = new Herramientas();
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
		labelEspecialidad = new JLabel("ESPECIALIDAD:   ");
		comboEspecialidad = new JComboBox();
		
		fieldNombreExpositor = new JTextField();
		fieldAP = new JTextField();
		fieldAM = new JTextField ();
		fieldEmail = new JTextField ();
		fieldTelefono = new JTextField ();
		fieldDireccion = new JTextField();
		
		botonCancelar = new JButton("CANCELAR");
		botonRegistrar = new JButton("REGISTRAR");
		
		labelTitulo.setBounds(0, dimPan.PenY(1), dimPan.PenX(50), dimPan.PenY(6));
		labelTitulo.setFont(new Font("Andale mono", 1, dimPan.tamanioLetra(45)));
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
		
		labelEspecialidad.setBounds(0, dimPan.PenY(40), dimPan.PenX(25), dimPan.PenY(5));
		labelEspecialidad.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFondo.add(labelEspecialidad);
		
		fieldNombreExpositor.setBounds(dimPan.PenX(25), dimPan.PenY(10), dimPan.PenX(10), dimPan.PenY(4.5F));
		panelFondo.add(fieldNombreExpositor);
		
		fieldAP.setBounds(dimPan.PenX(25), dimPan.PenY(15), dimPan.PenX(10), dimPan.PenY(4.5F));
		panelFondo.add(fieldAP);
		
		fieldAM.setBounds(dimPan.PenX(25), dimPan.PenY(20), dimPan.PenX(10), dimPan.PenY(4.5F));
		panelFondo.add(fieldAM);
		
		fieldDireccion.setBounds(dimPan.PenX(25), dimPan.PenY(25), dimPan.PenX(10), dimPan.PenY(4.5F));
		panelFondo.add(fieldDireccion);
		
		fieldEmail.setBounds(dimPan.PenX(25), dimPan.PenY(30), dimPan.PenX(10), dimPan.PenY(4.5F));
		panelFondo.add(fieldEmail);
		
		fieldTelefono.setBounds(dimPan.PenX(25), dimPan.PenY(35), dimPan.PenX(10), dimPan.PenY(4.5F));
		panelFondo.add(fieldTelefono);
		
		comboEspecialidad.setBounds(dimPan.PenX(25), dimPan.PenY(40), dimPan.PenX(10), dimPan.PenY(4.5F));
		panelFondo.add(comboEspecialidad);
		
		
		botonCancelar = new JButton("CANCELAR");
		botonCancelar.setBounds(dimPan.PenX(10), dimPan.PenY(50), dimPan.PenX(10), dimPan.PenY(4.5F));
		botonCancelar.addActionListener(this);
		panelFondo.add(botonCancelar);
		
		botonRegistrar = new JButton("REGISTRAR");
		botonRegistrar.setBounds(dimPan.PenX(30), dimPan.PenY(50), dimPan.PenX(10), dimPan.PenY(5));
		botonRegistrar.addActionListener(this);
		panelFondo.add(botonRegistrar);
		
		comboEspecialidad.addItem(" ");
		comboEspecialidad.addItem("REDES");
		comboEspecialidad.addItem("DESARROLLO");
		comboEspecialidad.addItem("INTELIGENCIA ARTIFICIAL");
		comboEspecialidad.addItem("SERVIDORES LINUX");
		comboEspecialidad.addItem("BASE DE DATOS");
		comboEspecialidad.addItem("WEB");
		comboEspecialidad.addItem("HACKING");
		
		panelFondo.setBackground(new Color(155, 191, 42));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==botonCancelar){
			this.dispose();
		}else {
			ValidacionDatos validar = new ValidacionDatos();
			
			String nombre = validar.eliminarEspacio(fieldNombreExpositor.getText()).toUpperCase();
			String aP = validar.eliminarEspacio(fieldAP.getText()).toUpperCase();
			String aM = validar.eliminarEspacio(fieldAM.getText()).toUpperCase();
			String dir = validar.eliminarEspacio(fieldDireccion.getText()).toUpperCase();
			String telf = validar.eliminarEspacio(fieldTelefono.getText());
			String email = validar.eliminarEspacio(fieldEmail.getText());
			String especialidad = comboEspecialidad.getSelectedItem().toString();
			String idAdmin = "1";
			
			if(validar.autorizarGuardado(nombre, aP, aM, dir, telf, email, especialidad)){
				ConeccionBDPostgres con = new ConeccionBDPostgres();
				con.guargarDatosExpositor(new String []{nombre, aP, aM, dir, telf, especialidad, idAdmin, email});
				JOptionPane.showMessageDialog(this, "Se guardó con éxito!");
				this.dispose();
				
			}else{
				JOptionPane.showMessageDialog(this, "Revisa los campos");
			}
			
		}
	}
}
