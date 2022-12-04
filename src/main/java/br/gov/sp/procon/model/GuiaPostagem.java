package br.gov.sp.procon.model;

import java.time.LocalDateTime;
import java.util.List;

public class GuiaPostagem {

    private int id;
    private LocalDateTime dataPostagem;
    private int qtd;
    private float valorTotal;
    private List<Correspondencias> listaCorrespondencias;
    private Usuario usuario;

    public GuiaPostagem() {
    }

    public GuiaPostagem(int id, LocalDateTime dataPostagem, int qtd, float valorTotal, List<Correspondencias> listaCorrespondencias, Usuario usuario) {
        this.id = id;
        this.dataPostagem = dataPostagem;
        this.qtd = qtd;
        this.valorTotal = valorTotal;
        this.listaCorrespondencias = listaCorrespondencias;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDateTime dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Correspondencias> getListaCorrespondencias() {
        return listaCorrespondencias;
    }

    public void setListaCorrespondencias(List<Correspondencias> listaCorrespondencias) {
        this.listaCorrespondencias = listaCorrespondencias;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "GuiaPostagem{" +
                "id=" + id +
                ", dataPostagem=" + dataPostagem +
                ", qtd=" + qtd +
                ", valorTotal=" + valorTotal +
                ", listaCorrespondencias=" + listaCorrespondencias +
                ", usuario=" + usuario +
                '}';
    }
}
