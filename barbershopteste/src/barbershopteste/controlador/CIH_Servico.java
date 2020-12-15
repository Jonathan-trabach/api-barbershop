/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershopteste.controlador;

import barbershopteste.modelo.Servico;
import barbershopteste.servico.ServicoServico;

/**
 *
 * @author danie
 */
public class CIH_Servico {
    
    public static int criarServico(String nome, String preco){
        Servico s = new Servico();
        s.nomeServico = nome;
        s.precoServico = preco;
        
        ServicoServico.salvarServico(s);
        
        return 0;
        
    }
}
