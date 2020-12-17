package barbershop.persistencia;

import barbershop.modelo.Usuario;
import barbershop.visao.JanelaPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO implements DAO<Usuario>{

    public static Conexao conexao;
    
    public static boolean consultarUsuario(String nome, String senha) throws Exception {
        conexao.conectar();
         
        boolean autenticado = false;
        String sql;
        try {

            sql = "select nome_acesso, senha_acesso from usuario where nome_acesso = ? and senha_acesso = ?";
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {

                autenticado = true;
                if (rs.getString("senha_acesso").equals(senha)) {
                    
                    JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
                    janelaPrincipal.setVisible(true);
                  
                }

            } else {

                JOptionPane.showMessageDialog(null, "USUARIO INVALIDO !");

                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            System.err.println("Falha ao pesquisar user !!!");
            throw new Exception(ex.getMessage());
        }
        return autenticado;
    }
  
    @Override
    public void inserir(Usuario objeto) throws Exception {
        conexao.conectar();
        
        try { 
            Statement stmt = conexao.con.createStatement();
           
            stmt.executeUpdate("INSERT INTO usuario (nome_acesso , senha_acesso) values('"+ objeto.nomeAcesso +"','"+ objeto.senhaAcesso +"')");
            JOptionPane.showMessageDialog(null, "salvo com sucesso");
                          
        }catch (SQLException ex) {
            System.err.println("Falha ao Cadastrar user !!!");
            throw new Exception(ex.getMessage());
        }
        
    }

    @Override
    public void alterar(Usuario objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Usuario objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario recuperar(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
