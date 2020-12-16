package barbershop.controlador;

import barbershop.modelo.Atendimento;
import barbershop.modelo.Cliente;
import barbershop.modelo.Servico;
import barbershop.servico.ServicoAtendimento;
import barbershop.visao.JanelaAtendimento;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
public class CIH_Atendimento {
    
    public static void exibirJanelaAtendimento() {
        JanelaAtendimento atendimento = new JanelaAtendimento();
        atendimento.setVisible(true);
    }
    
    public static void cadastrarAtendimento(int idCliente, Date dataInicio, int idServico) throws Exception{
      Atendimento atendimento = new Atendimento();
      atendimento.idCliente = idCliente;
      atendimento.dataInicio = dataInicio;
      atendimento.idServico = idServico;
        
      ServicoAtendimento.cadastrarAtendimento(atendimento);
      
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

    public static Atendimento recuperarPorIdCliente(int idCliente) throws SQLException{
        return ServicoAtendimento.recuperarPorIdCliente(idCliente);
    }

}
