package barbershop.servico;

import barbershop.modelo.Servico;
import barbershop.persistencia.ServicoDAO;

public class ServicoServico {
    
    public static int salvarServico(Servico s){
        return ServicoDAO.inserirServico(s);
    }
    
}
