
package barbershop.persistencia;

import barbershop.modelo.Servico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ServicoDAO implements DAO<Servico>{
    
    public static Conexao conexao;
     
    public static Servico buscarServicoPorId(int id) throws Exception{
        String sql;
        Servico servico = new Servico();
        try {
            sql = "SELECT id, nome , preco FROM servico WHERE id = ?";
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs;
            rs = ps.executeQuery();
            
           if(rs.next()) {
               servico.id = rs.getInt("id");
               servico.nomeServico = rs.getString("nome");
               servico.precoServico = rs.getString("preco");
              
           }
            
            return servico;
        } catch (SQLException ex) {
            System.err.println("Falha ao pesquisar o serviço !!!");
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void inserir(Servico objeto) throws Exception {
         conexao.conectar();
        
        try { 
          
            Statement stmt = conexao.con.createStatement();
           
            stmt.executeUpdate("INSERT INTO servico (nome,preco) values('"+objeto.nomeServico+"','"+objeto.precoServico+"')");
            JOptionPane.showMessageDialog(null, "salvo com sucesso");
                          
        }catch (SQLException ex) {
            System.err.println("Falha ao Cadastrar serviço !!!");
            throw new Exception(ex.getMessage());
        }
        
    }

    @Override
    public void alterar(Servico objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Servico objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Servico> listarTodos() throws Exception {
       
        String sql;
        ArrayList<Servico> listaServicos = new ArrayList<>();
        try {
            sql = "select nome , preco from servico ";
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
           
            ResultSet rs;
            rs = ps.executeQuery();
            
           while (rs.next()) {
               Servico servico = new Servico();
               servico.nomeServico = rs.getString("nome");
               servico.precoServico = rs.getString("preco");
               
               listaServicos.add(servico);
           }
            
            return listaServicos;
        } catch (SQLException ex) {
            System.err.println("Falha ao pesquisar serviços !!!");
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Servico recuperar(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

