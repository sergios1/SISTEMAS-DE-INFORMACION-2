package vista;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class VentanaOrganizador extends VentanaUsuario implements ActionListener {
	private JButton btn;
	private PanelListaExpositores listaExpo;
	public VentanaOrganizador(String nombreVentana, String titulo, String archivoIcono){
		super(nombreVentana, titulo, archivoIcono);
		btn = new JButton("Actividades");
		btn.addActionListener(this);
		panel12.add(btn);
		
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
					
				}else if(e.getSource()==btn){
					new VentanaSecretario("Secretario", "Secretario administrador", "ICONO-conferencia.png").setVisible(true);;
				}else if(e.getSource()==itemAcerca){
					mostrarAutores();
				}
	}
}
