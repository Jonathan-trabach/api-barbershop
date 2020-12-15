/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershopteste.persistencia;

import barbershopteste.modelo.Estabelecimento;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class EstabelecimentoDAO {
    
    
    public static int inserirEstabelecimento(Estabelecimento e){
        
        Connection c = Conexao.conectar();
        try { 
            Statement stmt=c.createStatement();
           
                    stmt.executeUpdate("INSERT INTO barbershop.estabelecimento (nome,cnpj,endereco,telefone) values('"+e.nomeEstabelecimento+"','"+e.cnjpEstabelecimento+"','"+e.enderecoEstabelecimento+"','"+e.telefoneEstabelecimento+"')");
                    JOptionPane.showMessageDialog(null, "salvo com sucesso");
                    
                    return 1;
                    
        }catch (SQLException ex) {
            Logger.getLogger(EstabelecimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
 }
    
}