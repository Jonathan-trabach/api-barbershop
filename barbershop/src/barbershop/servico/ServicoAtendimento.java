package barbershop.servico;

import barbershop.modelo.Atendimento;
import barbershop.modelo.Servico;
import barbershop.persistencia.AtendimentoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicoAtendimento {
    public static void cadastrarAtendimento(Atendimento atendimento) throws Exception{
        AtendimentoDAO.cadastrarAtendimento(atendimento);
        
    }
    
    public static List<Servico> preencherComboBoxServico() throws Exception{
       return AtendimentoDAO.preencherComboBoxServico();
        
    }
    
    public static List<Atendimento> preecherListaAtendimento() throws Exception{
        return AtendimentoDAO.buscarAtendimentos();
    }
    
}
