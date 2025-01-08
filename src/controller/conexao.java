package controller;

import java.sql.Connection;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.DriverManager;


/**
 *
 
@author Luis*/
public class conexao {
    private static final String url = "jdbc:mysql://localhost:3306/banco_clientes";
    private static final String user = "root";
    private static final String password = "";

    private static Connection conexao;  
    private static conexao conn;

    public static Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public conexao() {}

    public static conexao getConn() {
        if(conn == null) {
            conn = new conexao();
        }
        return conn;
    }
    
    public Connection abrirConexao() {
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //DRIVER
            conexao = DriverManager.getConnection(url, user, password); //BD
            conexao.setAutoCommit(false); 
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage()); 
        }
        return conexao;
    }
    
    public void fecharConexao() {
        try {
            if(conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexao: "+e.getMessage());
        } finally {
            conexao = null;
        }
    }
}