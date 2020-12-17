package barbershop.controlador;

import barbershop.modelo.Atendimento;
import barbershop.modelo.Cliente;
import barbershop.modelo.Servico;
import barbershop.persistencia.ClienteDAO;
import barbershop.persistencia.ServicoDAO;
import barbershop.servico.ServicoAtendimento;
import barbershop.servico.ServicoPreencherGridInicial;
import barbershop.visao.JanelaAtendimento;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
public class CIH_Atendimento {
    
    private static JTable jTableFila;
    
    
    public static void exibirJanelaAtendimento() {
        JanelaAtendimento atendimento = new JanelaAtendimento();
        atendimento.setVisible(true);
    }
    
    public static void cadastrarAtendimento(int idCliente, Date dataInicio, int idServico) throws Exception{
      Atendimento atendimento = new Atendimento();
      atendimento.setCliente(ClienteDAO.buscarClientePorId(idCliente));
      atendimento.dataInicio = dataInicio;
      atendimento.setServico(ServicoDAO.buscarServicoPorId(idServico));
        
      ServicoAtendimento.cadastrarAtendimento(atendimento);
      if(jTableFila != null){
        ServicoPreencherGridInicial.preecherGridAtendimento(objetoTabelaAtendimento(jTableFila));
      }
    }

    public static void finalizarAtendimento(Atendimento atendimento) throws Exception{
        ServicoAtendimento.finalizarAtendimento(atendimento);
    }
    
    public static List<Servico> preencherComboBoxServico() throws Exception{
       return ServicoAtendimento.preencherComboBoxServico();
    }
 
    public static List<Cliente> preencherComboBoxCliente() throws Exception{
       return ServicoAtendimento.preencherComboBoxCliente();
    }

    public static Atendimento recuperarPorNomeCliente(String nomeCliente) throws SQLException, Exception{
        return ServicoAtendimento.recuperarPorNomeCliente(nomeCliente);
    }

    public static JTable objetoTabelaAtendimento(JTable jTableFila){
        return CIH_Atendimento.jTableFila = jTableFila;
    }

}
