package barbershop.servico;

import barbershop.modelo.Servico;
import barbershop.persistencia.ServicoDAO;

public class ServicoServico {
    
    public static void salvarServico(Servico s) throws Exception{
        ServicoDAO.inserirServico(s);
    }
    
}
