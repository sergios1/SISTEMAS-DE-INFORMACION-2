package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaInscribirEstudiante extends JDialog implements ActionListener {

	private JLabel labelTitulo, labelAnuncio;
	private JTextField fieldNombre, fieldApP, fieldApM, fieldCel, fieldEmail;
	private JButton botonInscribir;
	private JButton botonCancelar;
	private JComboBox<String> comboCurso;
	private DimensionesPantalla dimPan;
	private JPanel panelEncabezado;

	public VentanaInscribirEstudiante(Frame padre, boolean bloquear) {
		super(padre, bloquear);
		this.setLayout(null);
		this.setResizable(false);

		dimPan = new DimensionesPantalla();
		this.setSize(dimPan.PenX(40), dimPan.PenY(70));
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(155, 191, 42));
		
		panelEncabezado = new JPanel();
		panelEncabezado.setBounds(0, 0, dimPan.PenX(40), dimPan.PenY(13));
		panelEncabezado.setLayout(null);
		this.add(panelEncabezado);
		
		labelTitulo = new JLabel("REGISTRO DE INSCRIPCION");
		labelTitulo.setBounds(0, dimPan.PenY(3), dimPan.PenX(40), dimPan.PenY(4));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(30)));
		
		labelAnuncio = new JLabel("Ingrese los datos del interesado");
		labelAnuncio.setBounds(0, dimPan.PenY(8), dimPan.PenX(40), dimPan.PenY(4));
		labelAnuncio.setHorizontalAlignment(SwingConstants.CENTER);
		labelAnuncio.setFont(new Font("Andale Mono", 2, dimPan.tamanioLetra(15)));
		
		panelEncabezado.add(labelTitulo);
		panelEncabezado.add(labelAnuncio);
		
		escribir("Nombre:  ", dimPan.PenY(3.5F));
		escribir("Apellido Paterno:  ", dimPan.PenY(4.5F));
		escribir("Apellido Materno:  ", dimPan.PenY(5.5F));
		escribir("Telf. Ref.:  ", dimPan.PenY(6.5F));
		escribir("E-MAIL:  ", dimPan.PenY(7.5F));
		escribir("Curso:  ", dimPan.PenY(8.5F));
		
		dibujarFields();
		
		comboCurso = new JComboBox<String>();
		comboCurso.setBounds(dimPan.PenX(20), dimPan.PenY(46.5F), dimPan.PenX(12), dimPan.PenY(4));
		comboCurso.addItem(" ");
		comboCurso.addItem("Curso 1");
		comboCurso.addItem("Curso 2");
		this.add(comboCurso);
		
		dibujarBotones();

	}
	private void dibujarFields(){
		
		fieldNombre = new JTextField();
		fieldApP = new JTextField();
		fieldApM = new JTextField();
		fieldCel = new JTextField();
		fieldEmail = new JTextField();
		
		fieldNombre.setBounds(dimPan.PenX(20), dimPan.PenY(15), dimPan.PenX(12), dimPan.PenY(4));
		fieldApP.setBounds(dimPan.PenX(20), dimPan.PenY(21.4F), dimPan.PenX(12), dimPan.PenY(4));
		fieldApM.setBounds(dimPan.PenX(20), dimPan.PenY(27.7F), dimPan.PenX(12), dimPan.PenY(4));
		fieldCel.setBounds(dimPan.PenX(20), dimPan.PenY(33.2F), dimPan.PenX(12), dimPan.PenY(4));
		fieldEmail.setBounds(dimPan.PenX(20), dimPan.PenY(39.7F), dimPan.PenX(12), dimPan.PenY(4));
		
		Font font1 = new Font("Andale Mono", 0, dimPan.tamanioLetra(16));
		fieldNombre.setFont(font1);
		fieldApP.setFont(font1);
		fieldApM.setFont(font1);
		fieldCel.setFont(font1);
		fieldEmail.setFont(font1);
		
		this.add(fieldNombre);
		this.add(fieldApP);
		this.add(fieldApM);
		this.add(fieldCel);
		this.add(fieldEmail);
		
	}
	private void dibujarBotones(){
		
		botonCancelar = new JButton("Cancelar");
		botonInscribir = new JButton("Inscribir");
		
		botonCancelar.setBounds(dimPan.PenX(10), dimPan.PenY(55), dimPan.PenX(7), dimPan.PenY(4));
		botonInscribir.setBounds(dimPan.PenX(25), dimPan.PenY(55), dimPan.PenX(7), dimPan.PenY(4));
		
		botonCancelar.setBackground(Color.DARK_GRAY);
		botonInscribir.setBackground(Color.DARK_GRAY);
		botonCancelar.setForeground(Color.ORANGE);
		botonInscribir.setForeground(Color.ORANGE);
		
		this.add(botonCancelar);
		this.add(botonInscribir);
		
		botonCancelar.addActionListener(this);
		botonInscribir.addActionListener(this);
		
	}
	private JLabel escribir(String letra, int y){
		
		JLabel molde = new JLabel(letra);
		molde.setForeground(Color.DARK_GRAY);
		molde.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(20)));
		molde.setBounds(0, y, dimPan.PenX(20), dimPan.PenY(y-dimPan.PenY(1)));
		molde.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(molde);
		
		return molde;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==botonCancelar){
			this.dispose();
		}else {
			//Aquí van las acciones a desencadenar cuando se presiona inscribir
			if(fieldNombre.getText().trim().equals("") || fieldApP.getText().trim().equals("") ||
				fieldApM.getText().trim().equals("") || fieldCel.getText().trim().equals("") ||
				fieldEmail.getText().trim().equals("")){
				JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
			}else{//Accion del boton inscribir
//				System.out.println("Nombre: "+fieldNombre.getText()+"\n"+
//						"Ap Paterno: "+fieldApP.getText()+"\n"+
//						"Ap MAterno: "+fieldApM.getText()+"\n"+
//						"Celular: "+fieldCel.getText()+"\n"+
//						"E-mail: "+fieldEmail.getText()+"\n"+
//						"Curso: "+(String)comboCurso.getSelectedItem());
//				System.out.println("Esperando evento");
				//Limpiar
				fieldNombre.setText("");
				fieldApP.setText("");
				fieldApM.setText("");
				fieldCel.setText("");
				fieldEmail.setText("");
				comboCurso.setSelectedIndex(0);
			}
			
		}
	}
}
