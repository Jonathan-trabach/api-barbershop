package barbershop.servico;

import barbershop.persistencia.Conexao;
import barbershop.persistencia.UsuarioDAO;
import barbershop.visao.JanelaLogin;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoLogin {
          
    public static boolean consultar(String nome_acesso, String senha_acesso){
        boolean autenticado = false;
        try {
            return autenticado =  UsuarioDAO.consultarUsuario(nome_acesso, senha_acesso);
        } catch (Exception ex) {
            Logger.getLogger(JanelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return autenticado;
    }
    
    public static void criarUsuario(String nome,String senha,String cpf) throws Exception{
        UsuarioDAO.criarUsuario(nome, senha, cpf);
    }
 
}
