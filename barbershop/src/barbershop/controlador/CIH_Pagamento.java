package barbershop.controlador;

import barbershop.modelo.Cliente;
import barbershop.modelo.Pagamento;
import barbershop.modelo.factory.ComboAtendimento;
import barbershop.servico.ServicoPagamento;
import barbershop.visao.JanelaPagamento;

public class CIH_Pagamento {
    
    public static void exibirJanelaCliente() {
        JanelaPagamento pagamento = new JanelaPagamento();
        pagamento.setVisible(true);
    }
    
    public static Cliente buscarCliente(int id) throws Exception{
       return  ServicoPagamento.buscarClientePorId(id);
    }
    
    public static Pagamento processarPagamento(Cliente c) throws Exception{
       return ComboAtendimento.criarComboParaDesconto(c);    
    }
}
