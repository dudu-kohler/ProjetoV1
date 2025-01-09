package controller;

import java.sql.Connection;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 *
 * @author Luis
 */
public class conexao {

     private static final String URL = "jdbc:mysql://localhost:3306/banco_clientes";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    // Construtor privado para evitar instâncias diretas
    private conexao(){
    }

    /**
     * Método para obter uma conexão com o banco de dados.
     *
     * @return Uma instância de Connection
     * @throws SQLException Se ocorrer um erro ao conectar ao banco
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Registrar o driver (opcional para Java 8+)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado: " + e.getMessage());
        }

        // Retornar a conexão
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Método para fechar uma conexão com o banco de dados.
     *
     * @param connection A conexão a ser fechada
     */
    public static void closeConnection(Connection connection) {
      //  Connection connection = null; // daria erro?
        
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}