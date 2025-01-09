package dao;
import java.sql.Connection;
import controller.conexao;

/**
 
@author Luis*/

public class BD {
    private static Connection connection = null;

    public static void main(String[] args) {
        try {
            Connection connection = conexao.getConnection();
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            conexao.closeConnection(connection);
            System.out.println("Conexão encerrada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}