package br.gov.sp.procon.model;

public class Usuario {

    private int id;
    private String usuario;
    private String senha;
    private int idServidor;
    private int Acesso;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String senha, int idServidor, int acesso) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.idServidor = idServidor;
        Acesso = acesso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(int idServidor) {
        this.idServidor = idServidor;
    }

    public int getAcesso() {
        return Acesso;
    }

    public void setAcesso(int acesso) {
        Acesso = acesso;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", idServidor=" + idServidor +
                ", Acesso=" + Acesso +
                '}';
    }
}
