
package barbershop.persistencia;

import barbershop.modelo.Servico;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ServicoDAO {
    
    public static int inserirServico(Servico s){
//        
//        Connection c = Conexao.conectar();
//        try { 
//            Statement stmt=c.createStatement();
//           
//                    stmt.executeUpdate("INSERT INTO barbershop.servico (nome,preco) values('"+s.nomeServico+"','"+s.precoServico+"')");
//                    JOptionPane.showMessageDialog(null, "salvo com sucesso");
//                    
//                    return 1;
//                    
//        }catch (SQLException ex) {
//            Logger.getLogger(EstabelecimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return -1;
    }
    
}