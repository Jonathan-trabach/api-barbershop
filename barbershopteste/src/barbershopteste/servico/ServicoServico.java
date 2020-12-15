package barbershopteste.servico;

import barbershopteste.modelo.Servico;
import barbershopteste.persistencia.ServicoDAO;

public class ServicoServico {
    
    public static int salvarServico(Servico s){
        return ServicoDAO.inserirServico(s);
    }
    
}
