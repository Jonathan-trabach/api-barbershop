
package barbershop.persistencia;

import barbershop.modelo.Servico;
import static barbershop.persistencia.UsuarioDAO.conexao;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ServicoDAO {
    
    public static Conexao conexao;
    
    public static void inserirServico(Servico s) throws Exception{
        conexao.conectar();
        
        try { 
            
            validarCampos(s.nomeServico, s.precoServico);
            Statement stmt = conexao.con.createStatement();
           
            stmt.executeUpdate("INSERT INTO servico (nome,preco) values('"+s.nomeServico+"','"+s.precoServico+"')");
            JOptionPane.showMessageDialog(null, "salvo com sucesso");
                          
        }catch (SQLException ex) {
            System.err.println("Falha ao Cadastrar serviço !!!");
            throw new Exception(ex.getMessage());
        }
        
    }
    
    private static void validarCampos(String nome,String preco) throws Exception{
        if(nome.equals("") || nome.length() < 3 || preco.equals(0.00)){
            JOptionPane.showMessageDialog(null, "Os campos devem estar preenchidos corretamentes !");
            throw new Exception("Valores dos Campos sao Invalidos");
        }
    }
        
    public static void conectarAoBanco() throws Exception{
        conexao.conectar();
    }
    
}
