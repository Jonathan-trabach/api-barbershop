/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershopteste.controlador;

import barbershopteste.visao.JanelaEstabecimento;
import barbershopteste.visao.JanelaPrincipal;
import barbershopteste.visao.JanelaServico;

/**
 *
 * @author danie
 */
public class CIH_Principal {
    
    public static void iniciarSistema(){
        JanelaPrincipal janela = new JanelaPrincipal();
        janela.setVisible(true);
        
}

    public static void exibirJanelaEstabelecimento() {
        JanelaEstabecimento estabelecimento = new JanelaEstabecimento();
        estabelecimento.setVisible(true);
        
    }
    
    public static void exibirJanelaServico() {
        JanelaServico servico = new JanelaServico();
        servico.setVisible(true);
        
    }
    
}
