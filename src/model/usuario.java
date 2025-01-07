package model;

/**
 *
 * @author eduardo
 */
public class usuario {
    private String nome, senha;

    public usuario(String nome, String senha) {
       super();
        this.nome = nome;
        this.senha = senha;
    }

    public usuario(String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
