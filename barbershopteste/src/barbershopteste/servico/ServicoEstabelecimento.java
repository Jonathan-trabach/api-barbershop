package barbershopteste.servico;

import barbershopteste.modelo.Estabelecimento;
import barbershopteste.persistencia.EstabelecimentoDAO;

public class ServicoEstabelecimento {
    
    public static int salvarEstabelecimento(Estabelecimento e){
        if(e.validarCnpj()==true){
            return EstabelecimentoDAO.inserirEstabelecimento(e);
        }else{
            return -1;
        }
        
    }
}
