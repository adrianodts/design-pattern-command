/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.globalcode;

import javax.swing.JTextArea;

/**
 *
 * @author globalcode
 */
public class GeraPdf extends BaseCommand{

    @Override
    public void executa(JTextArea text) {
        ConfigManager config = ConfigManager.getInstance();
        String server = config.getServerName();
        text.setText("Conex�o com servidor " + server+"\n");
        //C�digo de gera��o do arquivo PDF
        text.append("Gerando PDF do pedido...");
    }
    
}
