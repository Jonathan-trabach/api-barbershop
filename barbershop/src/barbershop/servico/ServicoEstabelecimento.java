package barbershop.servico;

import barbershop.modelo.Estabelecimento;
import barbershop.persistencia.EstabelecimentoDAO;

public class ServicoEstabelecimento {
    
    public static int salvarEstabelecimento(Estabelecimento e){
        if(e.validarCnpj()==true){
            return EstabelecimentoDAO.inserirEstabelecimento(e);
        }else{
            return -1;
        }
        
    }
}
