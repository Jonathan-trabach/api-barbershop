/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershopteste.servico;

import barbershopteste.modelo.Estabelecimento;
import barbershopteste.persistencia.EstabelecimentoDAO;



/**
 *
 * @author danie
 */
public class ServicoEstabelecimento {
    
    public static int salvarEstabelecimento(Estabelecimento e){
        if(e.validarCnpj()==true){
            return EstabelecimentoDAO.inserirEstabelecimento(e);
        }else{
            return -1;
        }
        
    }
}
