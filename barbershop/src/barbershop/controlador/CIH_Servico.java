package barbershop.controlador;

import barbershop.modelo.Servico;
import barbershop.servico.ServicoServico;

public class CIH_Servico {
    
    public static int criarServico(String nome, String preco){
        Servico s = new Servico();
        s.nomeServico = nome;
        s.precoServico = preco;
        
        ServicoServico.salvarServico(s);
        
        return 0;
    }
}
