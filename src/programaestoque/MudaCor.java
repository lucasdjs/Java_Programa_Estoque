/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaestoque;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Lucas
 */
public class MudaCor implements FocusListener {
   
    public void focusGained( FocusEvent e ) {
        Object o = e.getSource();
        if ( o instanceof JTextField ) {
            JTextField f = ( JTextField ) o;
            f.setBackground( new Color( 234,229,229 ) );
        }
    }
    public void focusLost( FocusEvent e ) {
        Object o = e.getSource();
        if ( o instanceof JTextField ) {
            JTextField f = ( JTextField ) o;
            f.setBackground( new Color( 255, 255, 255 ) );
        }
    }
}


    

