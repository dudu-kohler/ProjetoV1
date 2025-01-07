package dao;
import java.sql.Connection;
import controller.conexao;

/**
 
@author Luis*/

public class BD {
    private static Connection connection = null;

    public static void main(String[] args) {
        try {
            connection = conexao.getConn().abrirConexao();
            System.out.println("Base criada com sucesso");
            conexao.getConn().fecharConexao();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}