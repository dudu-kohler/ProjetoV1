package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eduardo
 */
public class modeloTabela extends AbstractTableModel {

    private static final String[] colunas = {"ID", "NOME", "CPF/CNPJ", "TELEFONE", "EMAIL"};
    private ArrayList<clientes> clientes;

    public modeloTabela(ArrayList<clientes> clientes) {
        super();
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        clientes cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getCpfCnpj();
            case 2:
                return cliente.getEmail();
            case 3:
                return cliente.getTelefone();
            case 4:
                return cliente.getEndereco();
            case 5:
                return cliente.getRg();
            case 6:
                return cliente.getDataN();
            case 7:
                return cliente.getEstadoC();
            case 8:
                return cliente.getProfissao();
            case 9:
                return cliente.getCep();
            case 10:
                return cliente.getSeguradora();
            case 11:
                return cliente.getApolice();
            case 12:
                return cliente.getItem();
            case 13:
                return cliente.getPlaca();
            case 14:
                return cliente.getChassi();
            case 15:
                return cliente.getRenavam();
            case 16:
                return cliente.getUtilizacao();
            case 17:
                return cliente.getVigenciaF();

            default:
                return null;
        }
    }

    public String getColumnName(int column) {
        return colunas[column];
    }

}
