package barbershop.controlador;

import barbershop.servico.ServicoLogin;
import barbershop.visao.JanelaLogin;

public class CIH_Login {
    
    public static void iniciarSistema() throws Exception{
        new JanelaLogin().setVisible(true); 
    }

    public static boolean consultar(String nome_acesso, String senha_acesso){
       return ServicoLogin.consultar(nome_acesso, senha_acesso);
    }
    
    public static void criarUsuario(String nome,String senha,String cpf) throws Exception{
        ServicoLogin.criarUsuario(nome,senha,cpf);
    }
}
