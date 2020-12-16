package barbershop.servico;

import barbershop.persistencia.ClienteDAO;
import java.util.List;
import barbershop.modelo.Cliente;

public class ServicoCliente {
          
    public static void criarCliente(String nome,String email, String cpf) throws Exception{
        ClienteDAO.criarCliente(nome, email, cpf);
    }
 
}
