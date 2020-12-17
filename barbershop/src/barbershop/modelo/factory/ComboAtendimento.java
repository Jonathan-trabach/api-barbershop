package barbershop.modelo.factory;

import barbershop.modelo.Atendimento;
import barbershop.modelo.Cliente;
import barbershop.modelo.Pagamento;
import barbershop.modelo.PagamentoComDesconto;
import barbershop.modelo.PagamentoSemDesconto;
import barbershop.persistencia.AtendimentoDAO;

import java.util.List;

public class ComboAtendimento {
    
    private static AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
    
    public static Pagamento criarComboParaDesconto (Cliente cliente) throws Exception {
        Pagamento p;
        
        List<Atendimento> buscarAtendimentos = atendimentoDAO.listarTodos();
        int qntAtendimento = 0;
                
        for (Atendimento atendimento: buscarAtendimentos) {
            if (atendimento.cliente.id == cliente.id){
                qntAtendimento ++;
            }
        }
        
        if (qntAtendimento >= 2 ) {
            p = new PagamentoComDesconto();
        }else{
            p = new PagamentoSemDesconto();
        }
        
        return p;
    }
    
}
