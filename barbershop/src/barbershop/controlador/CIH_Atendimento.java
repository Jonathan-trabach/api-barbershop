package barbershop.controlador;

import barbershop.modelo.Atendimento;
import barbershop.modelo.Servico;
import barbershop.servico.ServicoAtendimento;
import barbershop.visao.JanelaAtendimento;
import java.util.Date;
import java.util.List;
public class CIH_Atendimento {
    
    public static void exibirJanelaAtendimento() {
        JanelaAtendimento atendimento = new JanelaAtendimento();
        atendimento.setVisible(true);
    }
    
    public static void cadastrarAtendimento(String nomeCliente, Date dataInicio, int idServico) throws Exception{
      Atendimento atendimento = new Atendimento();
      atendimento.nome = nomeCliente;
      atendimento.dataInicio = dataInicio;
      atendimento.idServico = idServico;
        
      ServicoAtendimento.cadastrarAtendimento(atendimento);
      
    }

    public static List<Servico> preencherComboBoxServico() throws Exception{
       return ServicoAtendimento.preencherComboBoxServico();
    }
}
