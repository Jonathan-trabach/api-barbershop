package barbershop.controlador;

import barbershop.modelo.Cliente;
import barbershop.servico.ServicoCliente;
import barbershop.visao.JanelaCliente;
import java.util.List;

public class CIH_Cliente {
    
    
    public static void criarCliente(String nome,String email, String cpf) throws Exception{
        Cliente c = new Cliente();
        c.nome = nome;
        c.email = email;
        c.cpf = cpf;
        
        ServicoCliente.criarCliente(c);
        
        
        
    }

}
