package barbershop.controlador;

import barbershop.modelo.Usuario;
import barbershop.servico.ServicoLogin;
import barbershop.visao.JanelaLogin;

public class CIH_Login {
    
    public static void iniciarSistema() throws Exception{
        new JanelaLogin().setVisible(true); 
    }

    public static boolean consultar(String nome_acesso, String senha_acesso){
       return ServicoLogin.consultar(nome_acesso, senha_acesso);
    }
    
    public static void criarUsuario(Usuario usuario) throws Exception{
        ServicoLogin.criarUsuario(usuario);
    }
}
