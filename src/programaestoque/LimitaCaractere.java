/*
 * Classe que permite limitar a quantidade de caracteres que um campo de texto pode receber. Toda alteração em campo de texto
 * dispara a execução do insertString(), metodo da interface Document. 
 O que foi feito é sobrecarregar este metodo, desta forma quando ele for disparado sera utilizado o que foi definido nesta classe e não mais o original.
 Para utilizar basta seguir o exemplo: 
 jTextFieldNome.setDocument(new LimitaQtdaCaracteres(10));
 */

package programaestoque;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Lucas
 */
public class LimitaCaractere extends PlainDocument{
    private int tamanhoMaximo;

    public LimitaCaractere(int maxLen){
        super();
        tamanhoMaximo = maxLen;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if(str == null) return;
         //aceita qualquer numero de caracteres
        if(tamanhoMaximo <= 0){
            super.insertString(offset, str, attr);
            return;
        }
        int iLen = (getLength()+str.length());
        if(iLen <= tamanhoMaximo){
            super.insertString(offset, str, attr); //aceita a str
        }else{
            if(getLength() == tamanhoMaximo) return; // nada a fazer
            String novaStr = str.substring(0, (tamanhoMaximo - getLength()));
            super.insertString(offset, novaStr, attr);
        }
    }
}
