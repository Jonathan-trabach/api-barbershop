/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.services;

import barbershop.layout.TelaPrincipal;
import java.sql.*; // pacote jdbc
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.trabach
 */
public class ConexaoDB {


    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/saude";
    private String usuario = "postgres";
    private String senha = "Master123";
    public Connection con;

    public void Conexao() {

        try {

            Class.forName(driver);
            System.out.println("Driver OK!!!");

            con = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("Conexão OK!!!");

        } catch (ClassNotFoundException exc) {

            JOptionPane.showMessageDialog(null, "Erro no driver, ClassNotFoundException " + exc.getMessage());

        } catch (SQLException exc) {
            System.out.println("Erro de conexao ,SQLException " + exc.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de Dados! \n" + exc.getMessage(), "Erro ao Conectar no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void desconectar() {

        try {
            con.close();
            System.out.println("Desconectado do Banco!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar do banco \n" + ex.getMessage());
        }

    }

    public boolean consultarUser(String login, String senha) {
        boolean autenticado = false;
        String sql;
        try {

            sql = "select nome_usuario, senha_acesso from usuarios where nome_usuario = ? and senha_acesso = ?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {

                autenticado = true;
                if (rs.getString("senha_acesso").equals(senha)) {
                    
                    TelaPrincipal tp = new TelaPrincipal();
                    tp.setVisible(true);
                  
                }

            } else {

                JOptionPane.showMessageDialog(null, "USUARIO INVALIDO !");

                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            System.err.println("Falha ao pesquisar user !!!");
        }
        return autenticado;
    }

}
