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
    private static AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
    
    public static void cadastrarAtendimento(Atendimento atendimento) throws Exception{
        atendimentoDAO.inserir(atendimento);
        
    }
    
    public static List<Servico> preencherComboBoxServico() throws Exception{
       return AtendimentoDAO.preencherComboBoxServico();
        
    }  
    
    public static List<Cliente> preencherComboBoxCliente() throws Exception{
       return AtendimentoDAO.preencherComboBoxCliente();
    }
    
    public static List<Atendimento> preecherListaAtendimento() throws Exception{
        return atendimentoDAO.listarTodos();
    }
    
    public static void finalizarAtendimento(Atendimento atendimento) throws Exception{
        atendimentoDAO.alterar(atendimento);
    }

    public static Atendimento recuperarPorNomeCliente(String nomeCliente) throws SQLException, Exception{
        return AtendimentoDAO.recuperarPorNomeCliente(nomeCliente);
    }

}
