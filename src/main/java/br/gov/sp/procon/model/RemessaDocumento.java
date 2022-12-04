package br.gov.sp.procon.model;

import java.util.List;

public class RemessaDocumento {

    private int id;
    private int dataRemessa;
    private Usuario usuario;
    private Setor setor;
    private List<Documento> listaDocumentos;

    public RemessaDocumento() {
    }

    public RemessaDocumento(int id, int dataRemessa, Usuario usuario, Setor setor, List<Documento> listaDocumentos) {
        this.id = id;
        this.dataRemessa = dataRemessa;
        this.usuario = usuario;
        this.setor = setor;
        this.listaDocumentos = listaDocumentos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataRemessa() {
        return dataRemessa;
    }

    public void setDataRemessa(int dataRemessa) {
        this.dataRemessa = dataRemessa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    @Override
    public String toString() {
        return "RemessaDocumento{" +
                "id=" + id +
                ", dataRemessa=" + dataRemessa +
                ", usuario=" + usuario +
                ", setor=" + setor +
                ", listaDocumentos=" + listaDocumentos +
                '}';
    }
}
