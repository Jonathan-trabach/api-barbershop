package barbershop.persistencia;

import barbershop.modelo.Atendimento;
import barbershop.modelo.Servico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AtendimentoDAO {
    
    public static Conexao conexao;
    
    public static void cadastrarAtendimento(Atendimento atendimento) throws Exception{
     
        conexao.conectar();
        try { 
            
            validarCampos(atendimento.nome);
            Statement stmt = conexao.con.createStatement();
           
            Timestamp dataTimestamp =new Timestamp(atendimento.dataInicio.getTime());  
            stmt.executeUpdate("INSERT INTO atendimento (nome_cliente , inicio, idServico) values('"+atendimento.nome+"','"+dataTimestamp+"','"+atendimento.idServico+"')");
            JOptionPane.showMessageDialog(null, "salvo com sucesso");
                          
        }catch (SQLException ex) {
            System.err.println("Falha ao Cadastrar atendimento !!!");
            throw new Exception(ex.getMessage());
        }
        
    }
    
    private static void validarCampos(String nome) throws Exception{
        if(nome.equals("") || nome.length() < 3){
            JOptionPane.showMessageDialog(null, "Os campos devem estar preenchidos corretamentes !");
            throw new Exception("Valores dos Campos sao Invalidos");
        }
    }
        
    public static void conectarAoBanco() throws Exception{
        conexao.conectar();
    }
    
    
    public static List<Servico> preencherComboBoxServico() throws Exception{
        return ServicoDAO.buscarServicos();
        
    }
    
     public static List<Atendimento> buscarAtendimentos() throws Exception{
        String sql;
        List<Atendimento> listaAtendimentos = new ArrayList<>();
        try {
            sql = "select nome_cliente , inicio , idServico "
                + " from atendimento "
                + " order by inicio";
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
           
            ResultSet rs;
            rs = ps.executeQuery();
            
           while (rs.next()) {
               Atendimento atendimento = new Atendimento();
               atendimento.nome = rs.getString("nome_cliente");
               atendimento.dataInicio = rs.getDate("inicio");
               atendimento.idServico = rs.getInt("idServico");
               
               listaAtendimentos.add(atendimento);
           }
            
            return listaAtendimentos;
        } catch (SQLException ex) {
            System.err.println("Falha ao pesquisar Atendimentos !!!");
            throw new Exception(ex.getMessage());
        }
    }
  
    
}
