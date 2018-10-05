package vista;
import java.awt.*;

import javax.swing.*;
public class PanelListaExpositores extends JPanel{
	private JTable tablaExpositores;
	public PanelListaExpositores(){
		this.setLayout(new BorderLayout());
		Object[][] datos={};//Leer de la base de datos
		String[] nombrecolumnas={"Nombre","Primer apellido","Segundo apellido","Edad","Profesion","Socio"};
		tablaExpositores = new JTable(datos, nombrecolumnas);
		this.add(tablaExpositores, BorderLayout.CENTER);
		this.add(new JLabel(" "), BorderLayout.WEST);
		this.add(new JLabel("<html> \n\n</html>"), BorderLayout.NORTH);
	}
}
