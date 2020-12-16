package barbershop.servico;

import barbershop.persistencia.ClienteDAO;
import java.util.List;
import barbershop.modelo.Cliente;
import barbershop.modelo.Servico;

public class ServicoCliente {
          
    public static void criarCliente(Cliente c) throws Exception{
        //montar objeto
        ClienteDAO.criarCliente(c);
        Servico.registarObervador(c);
        
    }
 
}
