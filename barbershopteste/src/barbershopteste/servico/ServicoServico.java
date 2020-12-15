/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershopteste.servico;

import barbershopteste.modelo.Servico;
import barbershopteste.persistencia.ServicoDAO;

/**
 *
 * @author danie
 */
public class ServicoServico {
    
    public static int salvarServico(Servico s){
        return ServicoDAO.inserirServico(s);
    }
    
}
