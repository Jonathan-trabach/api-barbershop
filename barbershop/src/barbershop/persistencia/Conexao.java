package barbershop.persistencia;

import barbershop.visao.JanelaPrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    public static Connection con;
    
    public static void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void conectar() throws Exception{

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/barbershop","root","root");
       
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Problema para achar o driver do banco de dados");
           throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema para conectar com o banco de dados!");
            throw new Exception(ex.getMessage());
        }
        
    }
   
}


