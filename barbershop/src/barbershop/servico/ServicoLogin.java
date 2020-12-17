package barbershop.servico;

import barbershop.modelo.Usuario;
import barbershop.persistencia.UsuarioDAO;
import barbershop.visao.JanelaLogin;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoLogin {
          
    static UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public static boolean consultar(String nome_acesso, String senha_acesso){
        boolean autenticado = false;
        try {
            return autenticado =  UsuarioDAO.consultarUsuario(nome_acesso, senha_acesso);
        } catch (Exception ex) {
            Logger.getLogger(JanelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return autenticado;
    }
    
    public static void criarUsuario(Usuario usuario) throws Exception{
       usuarioDAO.inserir(usuario);
    }
 
}
