package controlador;
import vista.*;
/**
*
* @author Gustavo
* 
*/
public class Arranque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ventaSesion sesion = new ventaSesion();
		new VentanaOrganizador("Organizador", "ORGANIZADOR DE EVENTOS", "icono.png").setVisible(true);
		VentanaPrincipal ventana= new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
