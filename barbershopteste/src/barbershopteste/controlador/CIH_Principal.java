package barbershopteste.controlador;

import barbershopteste.visao.JanelaEstabecimento;
import barbershopteste.visao.JanelaPrincipal;
import barbershopteste.visao.JanelaServico;

public class CIH_Principal {
    
    public static void iniciarSistema(){
        JanelaPrincipal janela = new JanelaPrincipal();
        janela.setVisible(true);    
    }

    public static void exibirJanelaEstabelecimento() {
        JanelaEstabecimento estabelecimento = new JanelaEstabecimento();
        estabelecimento.setVisible(true); 
    }
    
    public static void exibirJanelaServico() {
        JanelaServico servico = new JanelaServico();
        servico.setVisible(true);
    }
    
}
