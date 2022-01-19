/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaestoque;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


/**
 *
 * @author Lucas
 */
public class Eventos {
    public static void    setAcessibilidade(final JFrame frame) {
       JRootPane meurootpane = frame.getRootPane();
       
       //Quando a tecla Esc for pressionada fecha a tela
     meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            public void actionPerformed(ActionEvent e) {
                int Answer = JOptionPane.showConfirmDialog(null, "Quer mesmo Sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (Answer == JOptionPane.YES_OPTION) {
                    frame.setVisible(false);
                } else {
                    frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }

        });
        
            
        
        

        
meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0), "ENTER");
       meurootpane.getRootPane().getActionMap().put("ENTER", new AbstractAction("ENTER") {
           
           public void actionPerformed(ActionEvent e) {
               if (frame.getFocusOwner() instanceof JButton) {
                   JButton aux = (JButton) frame.getFocusOwner();
                   aux.doClick();
               }else if(frame.getFocusOwner() instanceof JPanel){
                   
               }else{
                   frame.getFocusOwner().transferFocus();
               }
               
           }
           
          
       });
       
       
}
    


}
        
          

   
       
    
     


