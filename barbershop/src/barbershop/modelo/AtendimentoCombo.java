package barbershop.modelo;

import barbershop.persistencia.AtendimentoDAO;
import java.util.List;
import javax.swing.JOptionPane;


public class AtendimentoCombo extends Atendimento{
    private static AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
    
    public boolean criarComboParaDesconto () throws Exception {
        List<Atendimento> buscarAtendimentos = atendimentoDAO.listarTodos();
        int idClientePromocao = 1;
        for (Atendimento atendimento: buscarAtendimentos) {
            if (atendimento.cliente.id == idClientePromocao){
                JOptionPane.showMessageDialog(null, "Você ganhou 10% de desconto!");
                return true;
            }
        }
        return false;
    }
    
}
