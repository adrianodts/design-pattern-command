/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.globalcode;

/**
 *
 * @author globalcode
 */
public class CommandFactoryImpl implements CommandFactory  {
    public BaseCommand create(String nome) {
        BaseCommand baseCommand = null; 
        if("EnviaPedido".equals(nome)){
            baseCommand = new EnviaPedido();
        } else if("ExcluiPedido".equals(nome)){
            baseCommand = new ExcluiPedido();
        } if("NovoPedido".equals(nome)){
            baseCommand = new NovoPedido();
        } if("GeraPdf".equals(nome)){
            baseCommand = new GeraPdf();
        }
        return baseCommand;
    }
}
