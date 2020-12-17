package barbershop.servico;

import barbershop.modelo.Atendimento;
import barbershop.modelo.Cliente;
import barbershop.modelo.Servico;
import barbershop.persistencia.AtendimentoDAO;
import java.sql.SQLException;
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
    
    public static List<Cliente> preencherComboBoxCliente() throws Exception{
       return AtendimentoDAO.preencherComboBoxCliente();
    }
    
    public static List<Atendimento> preecherListaAtendimento() throws Exception{
        return AtendimentoDAO.buscarAtendimentos();
    }
    
    public static void finalizarAtendimento(Atendimento atendimento) throws Exception{
        AtendimentoDAO.finalizarAtendimento(atendimento);
    }

    public static Atendimento recuperarPorNomeCliente(String nomeCliente) throws SQLException, Exception{
        return AtendimentoDAO.recuperarPorNomeCliente(nomeCliente);
    }

}
