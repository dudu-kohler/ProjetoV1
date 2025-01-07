package model;

/**
 *
 * @author eduardo
 */
public class clientes {
    protected String nome;
    protected String cpfCnpj;
    protected String email;
    protected String telefone;
    protected String endereco;
    protected String rg;
    protected String dataN;
    protected String estadoC;
    protected String profissao;
    protected String cep;
    protected String seguradora;
    protected String apolice;
    protected String item;
    protected String placa;
    protected String chassi;
    protected String renavam;
    protected String utilizacao;
    protected String vigenciaF;
    

    public clientes(String nome, String cpfCnpj, String email, String telefone, String endereco, String rg, String dataN, String estadoC, String profissao, String cep, String seguradora, String apolice, String item, String placa, String chassi, String renavam, String utilizacao, String vigenciaF) {
        super();
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.rg = rg;
        this.dataN = dataN;
        this.estadoC = estadoC;
        this.profissao = profissao;
        this.cep = cep;
        this.seguradora = seguradora;
        this.apolice = apolice;
        this.item = item;
        this.placa = placa;
        this.chassi = chassi;
        this.renavam = renavam;
        this.utilizacao = utilizacao;
        this.vigenciaF = vigenciaF;
    }

    public clientes(clientes clientes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereço(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataN() {
        return dataN;
    }

    public void setDataN(String dataN) {
        this.dataN = dataN;
    }

    public String getEstadoC() {
        return estadoC;
    }

    public void setEstadoC(String estadoC) {
        this.estadoC = estadoC;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(String seguradora) {
        this.seguradora = seguradora;
    }

    public String getApolice() {
        return apolice;
    }

    public void setApolice(String apolice) {
        this.apolice = apolice;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizaçao(String utilizacao) {
        this.utilizacao = utilizacao;
    }

    public String getVigenciaF() {
        return vigenciaF;
    }

    public void setVigenciaF(String vigenciaF) {
        this.vigenciaF = vigenciaF;
    }
        public static void main(String[] args) {
        
    }
       
    
    
    
    
    
}
