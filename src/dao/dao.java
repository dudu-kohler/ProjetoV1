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

/**
 *
 * @author eduardo
 */
public class dao {

    conexao conexao = new conexao();
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    private static String CADASTRAR_CLIENTE = "INSERT INTO clientes (nome,cpfCnpj,email,telefone,endereco,rg,dataN,estadoC,profissao,cep,seguradora,apolice,item,placa,chassi,renavam,utilizacao,vigenciaF) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static String CONSULTAR_CLIENTE = "SELECT * FROM clientes WHERE nome=?";
    private static String ALTERAR_CLIENTE = "UPDATE clientes SET cpfCnpj=?,email=?,telefone=?,endereco=?,rg=?,dataN=?,estadoC=?,profissao=?,cep=?,seguradora=?,apolice=?,item=?,placa=?,chassi=?,renavam=?,utilizacao=?,vigenciaF=? WHERE nome=?";
    private static String EXCLUIR_CLIENTE = "DELETE * FROM clientes WHERE nome=?";
    private static String LISTAR_CLIENTES = "SELECT * FROM clientes WHERE 1=1";
    private static String CONSULTAR_USUARIO = "SELECT usuario, senha FROM usuario WHERE usuario=? and senha=?";

    public dao() {
    }

    public void cadastrarCliente(clientes cliente) {
        Connection connection = conexao.getConn().abrirConexao();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CADASTRAR_CLIENTE);
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

            preparedStatement.execute();
            connection.commit();

            JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso ");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    /**
     *
     * @param nome
     * @return
     * @throws Exception
     */
    /*public clientes consultarCliente(String nome) throws Exception {
    Connection connection = conexao.getConn().abrirConexao();
    clientes cliente = null;
    try {
    PreparedStatement preparedStatement = connection.prepareStatement(CONSULTAR_CLIENTE);
    preparedStatement.setString(1, nome);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
    cliente = new clientes(rs.getString("Nome"),
    rs.getString("CpfCnpj"),
    rs.getString("Email"),
    rs.getString("Telefone"),
    rs.getString("Endereco"),
    rs.getString("Rg"),
    rs.getString("DataN"),
    rs.getString("EstadoC"),
    rs.getString("Profissao"),
    rs.getString("Cep"),
    rs.getString("Seguradora"),
    rs.getString("Apolice"),
    rs.getString("Item"),
    rs.getString("Placa"),
    rs.getString("Chassi"),
    rs.getString("Renavam"),
    rs.getString("Utilizacao"),
    rs.getString("VigenciaF"));
    }
    } catch (SQLException e) {
    e.printStackTrace();
    } finally {
    conexao.fecharConexao();
    }
    if (cliente == null) {
    JOptionPane.showMessageDialog(null, "Não foi possível localizar o cliente selecionado ", "", JOptionPane.WARNING_MESSAGE);
    throw new Exception("Não foi possível localizar o cliente selecionado");
    }
    return cliente;
    }*/

    public void alterarCliente(String nome, clientes cliente) throws Exception {
        Connection connection = conexao.getConn().abrirConexao();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ALTERAR_CLIENTE);
            int i = 1;
            pst.setString(i++, cliente.getCpfCnpj());
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
            preparedStatement.execute();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso ");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void excluirCliente(String nome) throws Exception {
        Connection connection = conexao.getConn().abrirConexao();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EXCLUIR_CLIENTE);
            preparedStatement.setString(1, nome);
            preparedStatement.execute();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso ");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public ArrayList<clientes> listarClientes() throws Exception {
        Connection connection = conexao.getConn().abrirConexao();
        ArrayList<clientes> clientes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LISTAR_CLIENTES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                clientes.add(new clientes(rs.getString("Nome"), rs.getString("CpfCnpj"), rs.getString("Email"), rs.getString("Telefone"), rs.getString("Endereco"), rs.getString("Rg"), rs.getString("DataN"), rs.getString("EstadoC"), rs.getString("Profissao"), rs.getString("Cep"), rs.getString("Seguradora"), rs.getString("Apolice"), rs.getString("Item"), rs.getString("Placa"), rs.getString("Chassi"), rs.getString("Renavam"), rs.getString("Utilizacao"), rs.getString("VigenciaF")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há clientes cadastrados", "", JOptionPane.WARNING_MESSAGE);
            throw new Exception("Não há clientes cadastrados");
        }
        return clientes;
    }

    public usuario consultarUsuario(String nomeUsuario, String senhaCriptografada) throws Exception {
        Connection connection = conexao.getConn().abrirConexao();
        usuario usuario = null;  //Cliente cliente = null ?

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CONSULTAR_USUARIO);
            preparedStatement.setString(1, nomeUsuario);
            preparedStatement.setString(2, senhaCriptografada);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usuario = new usuario(resultSet.getString("USUARIO"), resultSet.getString("SENHA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o usuário", "", JOptionPane.WARNING_MESSAGE);
            throw new Exception("Não foi possível localizar o usuário");
        }
        return usuario;
    }

   

    /* public clientes consultarCliente(String ) throws Exception {
    Connection connection = conexao.getConn().abrirConexao();
    clientes cliente = null;
    
    
    try {
    PreparedStatement preparedStatement = connection.prepareStatement(CONSULTAR_CLIENTE);
    preparedStatement.setString(1, nome);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
    cliente = new clientes(rs.getString("Nome"),
    rs.getString("CpfCnpj"),
    rs.getString("Email"),
    rs.getString("Telefone"),
    rs.getString("Endereco"),
    rs.getString("Rg"),
    rs.getString("DataN"),
    rs.getString("EstadoC"),
    rs.getString("Profissao"),
    rs.getString("Cep"),
    rs.getString("Seguradora"),
    rs.getString("Apolice"),
    rs.getString("Item"),
    rs.getString("Placa"),
    rs.getString("Chassi"),
    rs.getString("Renavam"),
    rs.getString("Utilizacao"),
    rs.getString("VigenciaF"));
    }
    } catch (SQLException e) {
    e.printStackTrace();
    } finally {
    conexao.fecharConexao();
    }
    if (cliente == null) {
    JOptionPane.showMessageDialog(null, "Não foi possível localizar o cliente selecionado ", "", JOptionPane.WARNING_MESSAGE);
    throw new Exception("Não foi possível localizar o cliente selecionado");
    }
    return cliente;
    } */   
    
    
    private void fecharConexao() {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            conexao.getConn().fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }

    public void consultarCliente() throws Exception {
        Connection connection = conexao.getConn().abrirConexao();
        clientes cliente = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CONSULTAR_CLIENTE);
            String nome = null;
            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cliente = new clientes(rs.getString("Nome"),
                        rs.getString("CpfCnpj"),
                        rs.getString("Email"),
                        rs.getString("Telefone"),
                        rs.getString("Endereco"),
                        rs.getString("Rg"),
                        rs.getString("DataN"),
                        rs.getString("EstadoC"),
                        rs.getString("Profissao"),
                        rs.getString("Cep"),
                        rs.getString("Seguradora"),
                        rs.getString("Apolice"),
                        rs.getString("Item"),
                        rs.getString("Placa"),
                        rs.getString("Chassi"),
                        rs.getString("Renavam"),
                        rs.getString("Utilizacao"),
                        rs.getString("VigenciaF"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o cliente selecionado ", "", JOptionPane.WARNING_MESSAGE);
            throw new Exception("Não foi possível localizar o cliente selecionado");
        }
   
    }
}