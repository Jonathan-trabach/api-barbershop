package barbershop.persistencia;

import barbershop.modelo.Atendimento;
import barbershop.modelo.Cliente;
import barbershop.modelo.Servico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class AtendimentoDAO {
    
    public static Conexao conexao;
    
    public static void cadastrarAtendimento(Atendimento atendimento) throws Exception{
     
        conexao.conectar();
        try { 
       
            Statement stmt = conexao.con.createStatement();
           
            Timestamp dataTimestamp =new Timestamp(atendimento.dataInicio.getTime());  
            stmt.executeUpdate("INSERT INTO atendimento (id_cliente , inicio, idServico) values('"+atendimento.cliente.id+"','"+dataTimestamp+"','"+atendimento.servico.id+"')");
            JOptionPane.showMessageDialog(null, "salvo com sucesso");
                          
        }catch (SQLException ex) {
            System.err.println("Falha ao Cadastrar atendimento !!!");
            throw new Exception(ex.getMessage());
        }
        
    }
        
    public static void conectarAoBanco() throws Exception{
        conexao.conectar();
    }
    
    
    public static List<Servico> preencherComboBoxServico() throws Exception{
        return ServicoDAO.buscarServicos();
        
    }
    
    public static List<Cliente> preencherComboBoxCliente() throws Exception{
        return ClienteDAO.buscarClientes();
    }
    
     public static List<Atendimento> buscarAtendimentos() throws Exception{
        String sql;
        List<Atendimento> listaAtendimentos = new ArrayList<>();
        try {
            sql = "select id_cliente , inicio , idServico , fim "
                + " from atendimento "
                + " order by inicio";
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
           
            ResultSet rs;
            rs = ps.executeQuery();
            
           while (rs.next()) {
               Atendimento atendimento = new Atendimento();
        
               atendimento.setCliente(ClienteDAO.buscarClientePorId(rs.getInt("id_cliente")));
               atendimento.dataInicio = rs.getTimestamp("inicio");
               atendimento.setServico(ServicoDAO.buscarServicoPorId(rs.getInt("idServico")));
               atendimento.dataFim = rs.getTimestamp("fim");
               
               listaAtendimentos.add(atendimento);
           }
            
            return listaAtendimentos;
        } catch (SQLException ex) {
            System.err.println("Falha ao pesquisar Atendimentos !!!");
            throw new Exception(ex.getMessage());
        }
    }
  
         
    public static void finalizarAtendimento(Atendimento atendimento) throws Exception{
        Date dataFim = new Date();
        Timestamp dataTimestamp = new Timestamp(dataFim.getTime());  
        
        String sql = "UPDATE atendimento SET fim = '" + dataTimestamp + "' WHERE ID = ? ";
        PreparedStatement ps = conexao.con.prepareStatement(sql);
        ps.setInt(1, atendimento.id);
        ps.execute();
        
    }
    
    public static Atendimento recuperarPorNomeCliente(String nomeCliente) throws SQLException, Exception{
        Atendimento atendimento = new Atendimento();
        
        String sql = "SELECT * FROM atendimento a "
                + " join cliente c on c.id = a.id_cliente "
                + "WHERE c.nome = ?";
        PreparedStatement ps = conexao.con.prepareStatement(sql);
        ps.setString(1, nomeCliente);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            atendimento.id = rs.getInt("id");
            atendimento.setCliente(ClienteDAO.buscarClientePorId(rs.getInt("id_cliente")));
            atendimento.dataInicio = rs.getDate("inicio");
        }
        return atendimento;
    }
    
}
