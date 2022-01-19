package SystemTray;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import programaestoque.TelaPrincipal;

public class TrayClass{
    static TrayIcon trayIcon;

/**
 *
 * @author Lucas
 */
     public TrayClass() {
        
        show();
    }
       public static void show(){
       if (!SystemTray.isSupported()){
       System.exit(0);
       }
       trayIcon =new TrayIcon(createIcon("/Icones/iconestoque.png","Icon"));
       trayIcon.setToolTip("Stock V1.0");
       final SystemTray tray =SystemTray.getSystemTray();
       
       final PopupMenu menu = new PopupMenu();
       
       MenuItem encerrar = new MenuItem("Encerrar");
       MenuItem abrir = new MenuItem("Abrir");
       MenuItem sobre = new MenuItem ("Sobre");
       
     
       menu.add(abrir);
       menu.add(sobre);
       menu.addSeparator();
       menu.add(encerrar);
       
       encerrar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             System.exit(0);
               
           }
       });
       
       
       abrir.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             TelaPrincipal tel = new TelaPrincipal();
             tel.setVisible(true);
             tray.remove(trayIcon);
               
           }
       });
       
       
       sobre.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(null,"Smart Stock V1.0\n Autor: Lucas Jesus");
               
           }
       });
       
       trayIcon.setPopupMenu(menu);
       
       try{
           tray.add(trayIcon);
       }
       
       catch(Exception e){
       
       }
       }
       
       
       
       
       public static Image createIcon(String path, String desc){
       
       URL imageURL=TrayClass.class.getResource(path);
       return (new ImageIcon(imageURL,desc)).getImage();
       }
}    

        
        


