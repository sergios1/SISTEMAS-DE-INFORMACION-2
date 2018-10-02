
//clase que hereda la imagen principal(metodo)
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author sergio
 */

public class ImagePrincipal extends JPanel{
    
        public void paint(Graphics grafico) {
           Dimension height = getSize();
           ImageIcon Img = new ImageIcon("src/logos proyecto/pincipal1.jpg "); 
           grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
           setOpaque(false);
           super.paintComponent(grafico);
         
          
    }
    
}
