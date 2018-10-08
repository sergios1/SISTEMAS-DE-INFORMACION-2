package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modelo.ConeccionBDPostgres;
/**
*
* @author Gustavo
* 
*/
public final class VentanaOrganizador extends VentanaUsuario implements ActionListener {
	private JButton btnRegistrar, btnCerrarSesion, btnVerExpositores;
	private PanelListas listas;
	private LabelImagen img;
	private ConeccionBDPostgres conexion;
	public VentanaOrganizador(String nombreVentana, String titulo, String archivoIcono){
		
		super(nombreVentana, titulo, archivoIcono);
		
		conexion = new ConeccionBDPostgres();
		
		panel12.setLayout(new GridLayout(3, 6, 10,10));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		btnRegistrar = new JButton("Nuevo Expositor");
		btnRegistrar.addActionListener(this);
		
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		
		panel12.add(btnRegistrar);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setBackground(Color.ORANGE);
		panel12.add(btnCerrarSesion);
		
		btnVerExpositores = new JButton("VER EXPOSITORES");
		btnVerExpositores.addActionListener(this);
		panel12.add(btnVerExpositores);
		
		
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		panel12.add(new JLabel(" "));
		
		img = new LabelImagen(50, 50);
		panel21.add(img.labelImagen("fotoConferencia.png"));
		img.setX(15);
		img.setY(9.5F);
		panel11.add(img.labelImagen("cursos.png"));
		
		itemSalir.addActionListener(this);
		itemCerrarSesion.addActionListener(this);
		itemAcerca.addActionListener(this);
		
		panel22.setVisible(false);
		
		mostrarListaExpositores();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				if(e.getSource()==itemSalir){
					System.exit(0);
				}else if(e.getSource()==itemCerrarSesion){
					cerrarSesion();
				}else if(e.getSource()==btnRegistrar){
					new VentanaRegistroExpositores(this, true).setVisible(true);
				}else if(e.getSource()==itemAcerca){
					mostrarAutores();
				}else if(e.getSource()==btnCerrarSesion){
					cerrarSesion();
				}else if(e.getSource() == btnVerExpositores){
					panel22.setVisible(true);
				}
	}
	
	protected void mostrarListaExpositores(){
		
		listas = new PanelListas();
		try {
			panel22.add(listas.panelLista("LISTA DE EXPOSITORES", conexion.mostrarDatos("conferencista",
					new String[] {"idconfe","nomconfe", "apellidopatconfe", "apellidomatconfe", "especialidadconf", "dirconfe",
							"email", "telfconfe"})));
			System.out.println("Se pulso el boton");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void cerrarSesion(){
		ImageIcon icon = new ImageIcon("src/archivosmultimedia/exit.png");
        int input = JOptionPane.showConfirmDialog(this, 
                "Seguro de cerrar el programa?", "Confirmación", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
		if(input == 0){
			VentanaPrincipal inicio = new VentanaPrincipal();
			inicio.setVisible(true);
			this.dispose();
		}
	}
}
