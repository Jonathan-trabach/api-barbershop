package barbershop.controlador;

import barbershop.modelo.Servico;
import barbershop.servico.ServicoServico;

public class CIH_Servico {
    
    public static void criarServico(String nome, String preco) throws Exception{
        Servico s = new Servico();
        s.nomeServico = nome;
        s.precoServico = preco;
        
        ServicoServico.salvarServico(s);
        
    }
}
