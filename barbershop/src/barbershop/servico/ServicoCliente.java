package barbershop.servico;

import barbershop.persistencia.ClienteDAO;
import java.util.List;
import barbershop.modelo.Cliente;
import barbershop.modelo.Servico;

public class ServicoCliente {
          
   private static ClienteDAO clienteDAO = new ClienteDAO();
    
    public static void criarCliente(Cliente c) throws Exception{
        //montar objeto
        clienteDAO.inserir(c);
        Servico.registarObervador(c);
        
    }
 
}
