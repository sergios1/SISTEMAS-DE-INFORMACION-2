package vista;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
*
* @author Gustavo
* 
*/
public final class VentanaOrganizador extends VentanaUsuario implements ActionListener {
	private JButton btnRegistrar, btnCerrarSesion;
	private PanelListaExpositores listaExpo;
	private LabelImagen img;
	public VentanaOrganizador(String nombreVentana, String titulo, String archivoIcono){
		super(nombreVentana, titulo, archivoIcono);
		btnRegistrar = new JButton("Nuevo Expositor");
		btnRegistrar.addActionListener(this);
		panel12.add(btnRegistrar);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setBackground(Color.ORANGE);
		panel12.add(btnCerrarSesion);
		
		img = new LabelImagen(50, 50);
		panel21.add(img.labelImagen("fotoConferencia.png"));
		img.setX(15);
		img.setY(9.5F);
		panel11.add(img.labelImagen("cursos.png"));
		
		listaExpo = new PanelListaExpositores();
		panel22.add(listaExpo);
		itemSalir.addActionListener(this);
		itemCerrarSesion.addActionListener(this);
		itemAcerca.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				if(e.getSource()==itemSalir){
					System.exit(0);
				}else if(e.getSource()==itemCerrarSesion){
					//Esto cierra la ventana actual y nos lleva al login
					
				}else if(e.getSource()==btnRegistrar){
					new VentanaRegistroExpositores(this, true).setVisible(true);
				}else if(e.getSource()==itemAcerca){
					mostrarAutores();
				} else if(e.getSource()==btnCerrarSesion){
					this.dispose();
				}
	}
}
