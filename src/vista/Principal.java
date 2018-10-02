
package vista;

/**creacion de la vista principal cuando inicia el sistema ,
 *clase que inicializa la interfaz presentacin del sistema calcul de tiempos y tamaño 
 *de las ventanas
 * @author Sergio
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

import vista.VistaFrame;
import vista.ImagePrincipal;

import javax.swing.*;

public class Principal extends JFrame{
 
    
  
    public Principal()
    {
     
      setBounds(150, 200,800 ,600);
      setResizable(false); 
      setLocationRelativeTo(null);
      
       ImagePrincipal imagen = new ImagePrincipal();
      
      add(imagen);
    }
    
    Timer tiempo =new Timer(2000,new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
           VistaFrame conferencia  = new VistaFrame();
           conferencia.repaint();
        }
    } );
    
    
     
    
}
