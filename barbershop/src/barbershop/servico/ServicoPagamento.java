package barbershop.servico;

import barbershop.modelo.Cliente;
import barbershop.persistencia.ClienteDAO;

public class ServicoPagamento {

    private static ClienteDAO clienteDAO = new  ClienteDAO();
    
    public static Cliente buscarClientePorId(int id) throws Exception{
            return clienteDAO.recuperar(id);
    }
    
    
}
