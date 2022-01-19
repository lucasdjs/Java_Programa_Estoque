/* Para utilizar:
 * jFormattedTextField1.setFormatterFactory(Mascara.setMaskData());
 * jFormattedTextField2.setFormatterFactory(Mascara.setMaskDataHora());   


 */
package programaestoque;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Lucas
 */
public class Mascara {
    //exemplo de uso.....
    public static DefaultFormatterFactory setMaskCNPJ(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("###.###/####-##");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }
    public static DefaultFormatterFactory setMaskTelefoneFixo(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("(##)####-####");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }
    public static DefaultFormatterFactory setMaskCPF(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("###.###.###-##");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }
    public static DefaultFormatterFactory setMaskCelular(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("(##)#####-####");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }

    public static DefaultFormatterFactory setMaskDataHora(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("##/##/#### ##:##");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }
	
    public static void setLog(String log){
        try{
            //abre/cria o arquivo de log
            String nomeArq = new SimpleDateFormat("MMMyyyy").format(new Date())+".uniplac";
            BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArq, true));
            //grava no arquivo
            bw.write("\n\n"+new SimpleDateFormat("[dd/MM/yyy HH:mm] ").format(new Date())+log);
            bw.close();
        }catch(Exception e){}
    }
	

}

