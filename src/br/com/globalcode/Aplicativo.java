package br.com.globalcode;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Aplicativo extends JFrame {

    private final CommandFactory factory = new CommandFactoryImpl1();
            
    JTextArea taMensagens = new JTextArea();
    
    public static void main(String[] args) {
        new Aplicativo();
    }
    
    public Aplicativo() {
        super("Curso de Design Patterns - lab01");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = montaPainelBotoes();
        add(panel,BorderLayout.SOUTH);
        add(taMensagens,BorderLayout.CENTER);
        setSize(500,200);
        setVisible(true);
    }
    
    private JPanel montaPainelBotoes() {
        JPanel panel = new JPanel();
        JButton btEnviarPedido = new JButton("Enviar Pedido");
        btEnviarPedido.setActionCommand("EnviaPedido");
        JButton btGerarPDF = new JButton("Gerar PDF");
        btGerarPDF.setActionCommand("GeraPdf");
        JButton btNovoPedido = new JButton("Novo Pedido");
        btNovoPedido.setActionCommand("NovoPedido");
        JButton btExcluirPedido = new JButton("Excluir Pedido");
        btExcluirPedido.setActionCommand("ExcluiPedido");
        panel.add(btExcluirPedido);
        panel.add(btNovoPedido);
        panel.add(btGerarPDF);
        panel.add(btEnviarPedido);
        ActionListener listener = new BotaoHandler();
        
        btEnviarPedido.addActionListener(listener);
        btGerarPDF.addActionListener(listener);
        btNovoPedido.addActionListener(listener);
        btExcluirPedido.addActionListener(listener);
        
        return panel;
    }
    
    public class BotaoHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            BaseCommand command = factory.create(action);
            command.executa(taMensagens);
        }    
    }
}
