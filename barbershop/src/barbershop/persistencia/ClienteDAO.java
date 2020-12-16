package barbershop.persistencia;

import barbershop.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {

    public static Conexao conexao;

    public static void criarCliente(String nome,String email, String cpf) throws Exception{
        conexao.conectar();
        
        try { 
           
            Statement stmt = conexao.con.createStatement();
           
            stmt.executeUpdate("INSERT INTO cliente (nome , email, cpf) values('"+ nome +"','"+ email +"','"+ cpf +"')");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                          
        }catch (SQLException ex) {
            System.err.println("Falha ao Cadastrar cliente !!!");
            throw new Exception(ex.getMessage());
        }
        
    }
    public static void conectarAoBanco() throws Exception{
        conexao.conectar();
    }
    
    
    public static List<Cliente> buscarClientes() throws Exception{
        String sql;
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            sql = "select nome , email from cliente ";
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
           
            ResultSet rs;
            rs = ps.executeQuery();
            
           while (rs.next()) {
               Cliente cliente = new Cliente();
               cliente.nome = rs.getString("nome");
               cliente.email = rs.getString("email");
               
               listaClientes.add(cliente);
           }
            
            return listaClientes;
        } catch (SQLException ex) {
            System.err.println("Falha ao pesquisar serviços !!!");
            throw new Exception(ex.getMessage());
        }
    }
}
