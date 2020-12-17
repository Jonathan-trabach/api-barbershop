package barbershop.persistencia;

import barbershop.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO implements DAO<Cliente>{

    public static Conexao conexao;

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

    @Override
    public void inserir(Cliente objeto) throws Exception {
        conexao.conectar();
        
        try { 
           
            Statement stmt = conexao.con.createStatement();
           
            stmt.executeUpdate("INSERT INTO cliente (nome , email, cpf) values('"+ objeto.nome +"','"+ objeto.email +"','"+ objeto.cpf +"')");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                          
        }catch (SQLException ex) {
            System.err.println("Falha ao Cadastrar cliente !!!");
            throw new Exception(ex.getMessage());
        }
        
    }

    @Override
    public void alterar(Cliente objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Cliente objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente recuperar(int codigo) throws Exception {
        Cliente cliente = new Cliente();
        
        String sql = "SELECT * FROM cliente WHERE id = ?";
        PreparedStatement ps = conexao.con.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            cliente.id = rs.getInt("id");
            cliente.nome = rs.getString("nome");
        }
        return cliente;
    }
}
