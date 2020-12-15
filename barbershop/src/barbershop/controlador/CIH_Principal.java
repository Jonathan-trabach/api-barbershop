package barbershop.controlador;

import barbershop.visao.JanelaEstabecimento;
import barbershop.visao.JanelaServico;

public class CIH_Principal {

    public static void exibirJanelaEstabelecimento() {
        JanelaEstabecimento estabelecimento = new JanelaEstabecimento();
        estabelecimento.setVisible(true); 
    }
    
    public static void exibirJanelaServico() {
        JanelaServico servico = new JanelaServico();
        servico.setVisible(true);
    }
    
}
