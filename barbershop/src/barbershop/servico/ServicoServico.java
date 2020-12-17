package barbershop.servico;

import barbershop.modelo.Servico;
import barbershop.persistencia.ServicoDAO;

public class ServicoServico {
   
    private static ServicoDAO servicoDAO = new ServicoDAO();
    
    public static void salvarServico(Servico s) throws Exception{
        
        Servico.notificarObervadores(s);
        servicoDAO.inserir(s);
    }
    
}
