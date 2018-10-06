package vista;
import java.awt.*;
import java.sql.*;

import javax.swing.*;
public class PanelListaExpositores extends JPanel{
	private JTable tablaExpositores;
	private Statement st;
	protected JPanel panelEncabezado;
	private JLabel labelTituloItem;
	private JScrollPane scroll;
	private Herramientas dimPan;
	public PanelListaExpositores(){
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		dimPan = new Herramientas();
		
		Object[][] datos={{"1","Gustavo", "Abasto", "Argote", "SIPE SIPE", "soyyoyo88@gmail.com", "4386994"},
				};//Leer de la base de datos
		String[] nombrecolumnas={"ID","NOMBRE","APELLIDO PATERNO","APELLIDO MATERNO","DIRECCION","E-MAIL","TELEFONO"};
		tablaExpositores = new JTable(datos, nombrecolumnas);
		scroll = new JScrollPane();
		scroll.setViewportView(tablaExpositores);;
		this.add(scroll, BorderLayout.CENTER);
		this.add(new JLabel("      "), BorderLayout.SOUTH);
		this.add(new JLabel("      "), BorderLayout.WEST);
		this.add(new JLabel("      "), BorderLayout.EAST);
		this.add(new JLabel("      "), BorderLayout.NORTH);
		
		labelTituloItem = new JLabel("<html><P>LISTA DE EXPOSITORES<P></html>");
		labelTituloItem.setBounds(0,0,dimPan.PenX(50), dimPan.PenY(10));
		labelTituloItem.setForeground(Color.WHITE);
		labelTituloItem.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloItem.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(50)));
		
		panelEncabezado = new JPanel();
		panelEncabezado.setLayout(new BorderLayout());
		panelEncabezado.setOpaque(false);
		panelEncabezado.setBounds(0,0,dimPan.PenX(50), dimPan.PenY(10));
		panelEncabezado.add(labelTituloItem);
		this.add(panelEncabezado, BorderLayout.NORTH);
		
		
		//this.add(new JScrollPane(tablaExpositores), BorderLayout.CENTER);
	}
}
