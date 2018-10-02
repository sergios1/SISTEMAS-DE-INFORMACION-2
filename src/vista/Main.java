
package vista;

import javax.swing.JFrame;

import vista.Principal;


public class Main {
    public static void main(String [] arg)
    {
      
      Principal pri = new Principal(); 
      pri.setVisible(true);
       pri.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       pri.tiempo.start();
       pri.tiempo.setRepeats(false);
    }
    
}

