/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershopteste.controlador;

import barbershopteste.modelo.Estabelecimento;
import barbershopteste.servico.ServicoEstabelecimento;

/**
 *
 * @author danie
 */
public class CIH_Estabelecimento {
    
    public static int criarEstabelecimento(String nome, String cnpj, String endereco, String telefone){
        Estabelecimento e = new Estabelecimento();
        e.nomeEstabelecimento = nome;
        e.cnjpEstabelecimento = cnpj;
        e.enderecoEstabelecimento = endereco;
        e.telefoneEstabelecimento = telefone;
        
        ServicoEstabelecimento.salvarEstabelecimento(e);
        
        return 0;
        
    }
}
