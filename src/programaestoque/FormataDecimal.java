/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaestoque;

import javax.swing.text.*;

/**
 *
 * @author Lucas
 */
public final class FormataDecimal extends PlainDocument{
     private static final SimpleAttributeSet nullAttribute = new SimpleAttributeSet();
    private int qtdaDigitos;
    private int casasDecimais;

    public FormataDecimal(int qtdaDigitos, int casasDecimais) {
        this.qtdaDigitos = qtdaDigitos;
        this.casasDecimais = casasDecimais;
    }

    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        String original = getText(0, getLength());
        //verifica se esta dentro do tamanho maximo definido
        if (original.length() <= qtdaDigitos) {
            StringBuffer mascarado = new StringBuffer();
            if (a != nullAttribute) {
                //limpa o campo
                remove(-1, getLength());
                mascarado.append((original + str).replaceAll("[^0-9]", ""));
                for (int i = 0; i < mascarado.length(); i++) {
                    if (!Character.isDigit(mascarado.charAt(i))) {
                        mascarado.deleteCharAt(i);
                    }
                }
                Long number = new Long(mascarado.toString());
                mascarado.replace(0, mascarado.length(), number.toString());

                if (mascarado.length() < (casasDecimais + 1)) {

                    if (casasDecimais == 0) {
                        //
                    } else if (casasDecimais == 1) {
                        if (mascarado.length() == 1) {
                            mascarado.insert(0, ".");
                            mascarado.insert(0, "0");
                        }
                    } else if (casasDecimais == 2) {
                        if (mascarado.length() == 1) {
                            mascarado.insert(0, "0");
                            mascarado.insert(0, ".");
                            mascarado.insert(0, "0");
                        } else if (mascarado.length() == 2) {
                            mascarado.insert(0, ".");
                            mascarado.insert(0, "0");
                        }
                    } else if (casasDecimais == 3) {
                        if (mascarado.length() == 1) {
                            mascarado.insert(0, "0");
                            mascarado.insert(0, "0");
                            mascarado.insert(0, ".");
                            mascarado.insert(0, "0");
                        } else if (mascarado.length() == 2) {
                            mascarado.insert(0, "0");
                            mascarado.insert(0, ".");
                            mascarado.insert(0, "0");
                        } else if (mascarado.length() == 3) {
                            mascarado.insert(0, ".");
                            mascarado.insert(0, "0");
                        }
                    }

                } else {  //add o ponto separador de decimal conforme as casas decimais definidas
                    if (casasDecimais > 0) {
                        mascarado.insert(mascarado.length() - casasDecimais, ".");
                    }
                }

                super.insertString(0, mascarado.toString(), a);

            } else {
                if (original.length() == 0) {
                    String vlPadrao = "";
                    /*if (casasDecimais == 0) {
                        vlPadrao = "0";
                    } else if (casasDecimais == 1) {
                        vlPadrao = "0.0";
                    } else if (casasDecimais == 2) {
                        vlPadrao = "0.00";
                    } else if (casasDecimais == 3) {
                        vlPadrao = "0.000";
                    }*/
                    super.insertString(0, vlPadrao, a);
                }
            }
        }
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        if (len == getLength()) {
            super.remove(0, len);
            if (offs != -1) {
                insertString(0, "", nullAttribute);
            }
        } else {
            String original = getText(0, getLength()).substring(0, offs) + getText(0, getLength()).substring(offs + len);
            super.remove(0, getLength());
            insertString(0, original, null);
        }
    }
}
    

