package barbershop.controlador;

import barbershop.modelo.Cliente;
import barbershop.servico.ServicoCliente;
import barbershop.visao.JanelaCliente;
import java.util.List;

public class CIH_Cliente {
    
    public static void exibirJanelaCliente() {
        JanelaCliente cliente = new JanelaCliente();
        cliente.setVisible(true);
    }
    
    public static void criarCliente(Cliente c) throws Exception{
        ServicoCliente.criarCliente(c);
    }

}
