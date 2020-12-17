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

    public static void criarCliente(Cliente c) throws Exception{
        conexao.conectar();
        
        try { 
           
            Statement stmt = conexao.con.createStatement();
           
            stmt.executeUpdate("INSERT INTO cliente (nome , email, cpf) values('"+ c.nome +"','"+ c.email +"','"+ c.cpf +"')");
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
            System.err.println("Falha ao pesquisar clientes !!!");
            throw new Exception(ex.getMessage());
        }
    }
    
    public static Cliente buscarClientePorId(int id) throws Exception{
        String sql;
        Cliente cliente = new Cliente();
        try {
            sql = "SELECT id, nome , email FROM cliente  where id = ?";
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs;
            rs = ps.executeQuery();
            
           if(rs.next()) {
               cliente.id = rs.getInt("id");
               cliente.nome = rs.getString("nome");
               cliente.email = rs.getString("email");
           }
            
            return cliente;
        } catch (SQLException ex) {
            System.err.println("Falha ao pesquisar o cliente !!!");
            throw new Exception(ex.getMessage());
        }
    }
}
