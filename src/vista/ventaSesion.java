package vista;
import javax.swing.*;
public class ventaSesion extends JFrame {
	private DimensionesPantalla dimPan;
	private JPanel panelFondo;
	public ventaSesion(){
		this.setTitle("SESION");
		this.setLayout(null);
		this.setSize(dimPan.PenX(50), dimPan.PenY(70));
		
	}
}
