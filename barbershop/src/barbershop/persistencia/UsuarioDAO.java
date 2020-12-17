package barbershop.persistencia;

import barbershop.modelo.Usuario;
import barbershop.visao.JanelaPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UsuarioDAO {

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
    
    public static void criarUsuario(String nome,String senha) throws Exception{
        conexao.conectar();
        
        try { 
            
            validarCampos(nome, senha);
            Statement stmt = conexao.con.createStatement();
           
            stmt.executeUpdate("INSERT INTO usuario (nome_acesso , senha_acesso) values('"+ nome +"','"+ senha +"')");
            JOptionPane.showMessageDialog(null, "salvo com sucesso");
                          
        }catch (SQLException ex) {
            System.err.println("Falha ao Cadastrar user !!!");
            throw new Exception(ex.getMessage());
        }
        
    }
    
    private static void validarCampos(String nome,String senha) throws Exception{
        if(nome.equals("") || nome.length() < 3 || senha.equals("") || senha.length() < 3 ){
            JOptionPane.showMessageDialog(null, "Os campos devem estar preenchidos corretamentes !");
            throw new Exception("Campos Nulos");
        }
    }
    
    public static void conectarAoBanco() throws Exception{
        conexao.conectar();
    }

    public void inserir(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
