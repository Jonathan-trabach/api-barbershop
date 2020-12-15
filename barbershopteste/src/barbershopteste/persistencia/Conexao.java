package barbershopteste.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    public static void main(String[] args) {
        Conexao.conectar();
    }
    
    public static void fecharConexao(Connection c){
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection conectar(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/barbershop","root","root");
            System.out.println("conectou");
            return con;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "deu problema para achar o driver");
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deu problema para conectar com o banco");
            ex.printStackTrace();
        }
            
     return null;   
        
    }
    
    
}


