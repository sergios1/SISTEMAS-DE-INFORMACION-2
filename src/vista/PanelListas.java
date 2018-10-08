package vista;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class PanelListas {
	private JTable tablaExpositores, tabla;
	protected JPanel panelEncabezado;
	private JLabel labelTituloItem;
	private JScrollPane scroll;
	private Herramientas dimPan;
	private String [] filas;
	
	public PanelListas(){
		
		dimPan = new Herramientas();
		/*
		Object[][] datos=new Object();//Leer de la base de datos
		String[] nombrecolumnas={"ID","NOMBRE","APELLIDO PATERNO","APELLIDO MATERNO","DIRECCION","E-MAIL","TELEFONO"};
		tablaExpositores = new JTable(datos, nombrecolumnas);
		*/
		
		scroll = new JScrollPane();
		
		
		labelTituloItem = new JLabel();
		labelTituloItem.setBounds(0,0,dimPan.PenX(50), dimPan.PenY(10));
		labelTituloItem.setForeground(Color.WHITE);
		labelTituloItem.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloItem.setFont(new Font("Andale Mono", 1, dimPan.tamanioLetra(50)));
		
		panelEncabezado = new JPanel();
		panelEncabezado.setLayout(new GridLayout(3,1));
		panelEncabezado.setOpaque(false);
		panelEncabezado.setBounds(0,0,dimPan.PenX(50), dimPan.PenY(10));
		panelEncabezado.add(new JLabel(" "));
		panelEncabezado.add(labelTituloItem);
		
	}
	
	protected JPanel panelLista(String titulo, ResultSet rs) throws SQLException{//Solo para la lista de los expositores
		
		DefaultTableModel tablaModel = new DefaultTableModel();
		tablaModel.addColumn("ID");
		tablaModel.addColumn("NOMBRE");
		tablaModel.addColumn("AP. PATERNO");
		tablaModel.addColumn("AP. MATERNO");
		tablaModel.addColumn("ESPECIALIDAD");
		tablaModel.addColumn("DIRECCION");
		tablaModel.addColumn("E-MAIL");
		tablaModel.addColumn("TELEFONO");
		
		tabla = new JTable();
		tabla.setModel(tablaModel);
		
		filas = new String[8];
		int indice = 1;
		while(rs.next()){ // Mejorar ojo
			filas [0] = (rs.getString(1));
			filas [1] = (rs.getString(2));
			filas [2] = (rs.getString(3));
			filas [3] = (rs.getString(4));
			filas [4] = (rs.getString(5));
			filas [5] = (rs.getString(6));
			filas [6] = (rs.getString(7));
			filas [7] = (rs.getString(8));
			tablaModel.addRow(filas);
		}
		tabla.setEnabled(false);
		scroll.setViewportView(tabla);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);
		
		panel.add(scroll, BorderLayout.CENTER);
		panel.add(new JLabel("      "), BorderLayout.SOUTH);
		panel.add(new JLabel("      "), BorderLayout.WEST);
		panel.add(new JLabel("      "), BorderLayout.EAST);
		panel.add(new JLabel("      "), BorderLayout.NORTH);
		
		panel.add(panelEncabezado, BorderLayout.NORTH);
		labelTituloItem.setText(titulo);
		
		return panel;
	}
}
