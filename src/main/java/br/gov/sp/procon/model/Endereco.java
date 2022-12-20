package br.gov.sp.procon.model;

public class Endereco {

    private int id;
    private int idEntidade;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;

    public Endereco() {
    }

    public Endereco(int id, int idEntidade, String cep, String logradouro, String numero, String complemento, String bairro, String municipio, String uf) {
        this.id = id;
        this.idEntidade = idEntidade;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(int idEntidade) {
        this.idEntidade = idEntidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro.toUpperCase();
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro.toUpperCase();
    }

    public String getNumero() {
        return numero.toUpperCase();
    }

    public void setNumero(String numero) {
        this.numero = numero.toUpperCase();
    }

    public String getComplemento() {
        return complemento.toUpperCase();
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento.toUpperCase();
    }

    public String getBairro() {
        return bairro.toUpperCase();
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.toUpperCase();
    }

    public String getMunicipio() {
        return municipio.toUpperCase();
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio.toUpperCase();
    }

    public String getUf() {
        return uf.toUpperCase();
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return logradouro + ", " + numero + ", " + complemento + ", " + bairro + ", " + municipio  + ", " + uf + ", " + cep;
    }
}
