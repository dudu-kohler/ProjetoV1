package dao;

import java.sql.Connection;
import controller.conexao;
import model.clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.usuario;
import view.InterfacePrincipal;
/**
 *
 * @author eduardo
 */
public class dao {
clientes cliente = null;
    private static final String CADASTRAR_CLIENTE = "INSERT INTO clientes (nome, cpfCnpj, email, telefone, endereco, rg, dataN, estadoC, profissao, cep, seguradora, apolice, item, placa, chassi, renavam, utilizacao, vigenciaF) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String CONSULTAR_CLIENTE = "SELECT * FROM clientes WHERE nome = ?";
    private static final String ALTERAR_CLIENTE = "UPDATE clientes SET cpfCnpj = ?, email = ?, telefone = ?, endereco = ?, rg = ?, dataN = ?, estadoC = ?, profissao = ?, cep = ?, seguradora = ?, apolice = ?, item = ?, placa = ?, chassi = ?, renavam = ?, utilizacao = ?, vigenciaF = ? WHERE nome = ?";
    private static final String EXCLUIR_CLIENTE = "DELETE FROM clientes WHERE nome = ?";
    private static final String LISTAR_CLIENTES = "SELECT * FROM clientes";
    private static final String CONSULTAR_USUARIO = "SELECT usuario, senha FROM usuario WHERE usuario = ? AND senha = ?";
    public Iterable<dao> listarClientes;

    public dao() {
    }

    public void cadastrarCliente(clientes cliente) {
        try (Connection connection = conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CADASTRAR_CLIENTE)) {

            int i = 1;
            preparedStatement.setString(i++, cliente.getNome());
            preparedStatement.setString(i++, cliente.getCpfCnpj());
            preparedStatement.setString(i++, cliente.getEmail());
            preparedStatement.setString(i++, cliente.getTelefone());
            preparedStatement.setString(i++, cliente.getEndereco());
            preparedStatement.setString(i++, cliente.getRg());
            preparedStatement.setString(i++, cliente.getDataN());
            preparedStatement.setString(i++, cliente.getEstadoC());
            preparedStatement.setString(i++, cliente.getProfissao());
            preparedStatement.setString(i++, cliente.getCep());
            preparedStatement.setString(i++, cliente.getSeguradora());
            preparedStatement.setString(i++, cliente.getApolice());
            preparedStatement.setString(i++, cliente.getItem());
            preparedStatement.setString(i++, cliente.getPlaca());
            preparedStatement.setString(i++, cliente.getChassi());
            preparedStatement.setString(i++, cliente.getRenavam());
            preparedStatement.setString(i++, cliente.getUtilizacao());
            preparedStatement.setString(i++, cliente.getVigenciaF());

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    /**
     * Método para alterar os dados de um cliente.
     */
    public void alterarCliente(String nome, clientes cliente) {
        try (Connection connection = conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ALTERAR_CLIENTE)) {

            int i = 1;
            preparedStatement.setString(i++, cliente.getCpfCnpj());
            preparedStatement.setString(i++, cliente.getEmail());
            preparedStatement.setString(i++, cliente.getTelefone());
            preparedStatement.setString(i++, cliente.getEndereco());
            preparedStatement.setString(i++, cliente.getRg());
            preparedStatement.setString(i++, cliente.getDataN());
            preparedStatement.setString(i++, cliente.getEstadoC());
            preparedStatement.setString(i++, cliente.getProfissao());
            preparedStatement.setString(i++, cliente.getCep());
            preparedStatement.setString(i++, cliente.getSeguradora());
            preparedStatement.setString(i++, cliente.getApolice());
            preparedStatement.setString(i++, cliente.getItem());
            preparedStatement.setString(i++, cliente.getPlaca());
            preparedStatement.setString(i++, cliente.getChassi());
            preparedStatement.setString(i++, cliente.getRenavam());
            preparedStatement.setString(i++, cliente.getUtilizacao());
            preparedStatement.setString(i++, cliente.getVigenciaF());
            preparedStatement.setString(i++, nome);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar cliente: " + e.getMessage());
        }
    }

    /**
     * Método para excluir um cliente pelo nome.
     */
    public void excluirCliente(String nome) {
        try (Connection connection = conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EXCLUIR_CLIENTE)) {

            preparedStatement.setString(1, nome);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + e.getMessage());
        }
    }

    /**
     * Método para listar todos os clientes.
     */
    public ArrayList<clientes> listarClientes() {
        ArrayList<clientes> listaClientes = new ArrayList<>();

        try (Connection connection = conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LISTAR_CLIENTES);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                clientes cliente = new clientes(
                        resultSet.getString("nome"),
                        resultSet.getString("cpfCnpj"),
                        resultSet.getString("email"),
                        resultSet.getString("telefone"),
                        resultSet.getString("endereco"),
                        resultSet.getString("rg"),
                        resultSet.getString("dataN"),
                        resultSet.getString("estadoC"),
                        resultSet.getString("profissao"),
                        resultSet.getString("cep"),
                        resultSet.getString("seguradora"),
                        resultSet.getString("apolice"),
                        resultSet.getString("item"),
                        resultSet.getString("placa"),
                        resultSet.getString("chassi"),
                        resultSet.getString("renavam"),
                        resultSet.getString("utilizacao"));
                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
        }

        return listaClientes;
    }

    /**
     * Método para consultar um cliente pelo nome.
     */
    public clientes consultarCliente() {
       
        String nome = null;
        try (Connection connection = conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CONSULTAR_CLIENTE)) {

            preparedStatement.setString(1, nome);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                            resultSet.getString("nome");
                            resultSet.getString("cpfCnpj");
                            resultSet.getString("email");
                            resultSet.getString("telefone");
                            resultSet.getString("endereco");
                            resultSet.getString("rg");
                            resultSet.getString("dataN");
                            resultSet.getString("estadoC");
                            resultSet.getString("profissao");
                            resultSet.getString("cep");
                            resultSet.getString("seguradora");
                            resultSet.getString("apolice");
                            resultSet.getString("item");
                            resultSet.getString("placa");
                            resultSet.getString("chassi");
                            resultSet.getString("renavam");
                            resultSet.getString("utilizacao");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao consultar cliente: " + e.getMessage());
        }

        return cliente;
    }

    /**
     * Método para autenticar um usuário.
     */
    public usuario consultarUsuario(String nomeUsuario, String senha) {
        usuario user = null;

        try (Connection connection = conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CONSULTAR_USUARIO)) {

            preparedStatement.setString(1, nomeUsuario);
            preparedStatement.setString(2, senha);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new usuario(
                            resultSet.getString("usuario"),
                            resultSet.getString("senha")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuário: " + e.getMessage());
        }

        return user;
    }
}