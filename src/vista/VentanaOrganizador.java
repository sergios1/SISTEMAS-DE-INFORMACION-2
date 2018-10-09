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
public final class VentanaOrganizador extends VentanaUsuario implements ActionListener, Runnable{
	private JButton btnRegistrar, btnCerrarSesion, btnVerExpositores;
	private PanelListas listas;
	private LabelImagen img;
	private ConeccionBDPostgres con;
	private byte segundos;
	private Thread hilo1;
	public VentanaOrganizador(String nombreVentana, String titulo, String archivoIcono){
		
		super(nombreVentana, titulo, archivoIcono);
		
		con = new ConeccionBDPostgres();
		
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
		//panel12.add(new JLabel(" "));
		
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
		
		hilo1 = new Thread(this);
        hilo1.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				if(e.getSource()==itemSalir){
					System.exit(0);
					hilo1.stop();
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
		
		listas = new PanelListas(con.mostrarDatos("conferencista",
				new String[] {"idconfe","nomconfe", "apellidopatconfe", "apellidomatconfe", "especialidadconf", "dirconfe",
						"email", "telfconfe"}));
		try {
			panel22.add(listas.panelLista("LISTA DE EXPOSITORES"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void cerrarSesion(){
		ImageIcon icon = new ImageIcon("src/archivosmultimedia/exit.png");
        int input = JOptionPane.showConfirmDialog(this, 
                "Seguro de cerrar el programa?", "Confirmación", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
		if(input == 0){
			VentanaPrincipal inicio = new VentanaPrincipal();
			inicio.setVisible(true);
			this.dispose();
			hilo1.stop();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(segundos <= 5){
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(segundos==5){
				 if(con.cantidaFilas("conferencista") != listas.numeroDeFilas()){
					 listas.actualizaTabla(con.mostrarDatos("conferencista",
								new String[] {"idconfe","nomconfe", "apellidopatconfe", 
										"apellidomatconfe", "especialidadconf", "dirconfe",
										"email", "telfconfe"}));
				 }
				 
				 segundos = 0;
			 }
			segundos ++;
		}
	}
}
