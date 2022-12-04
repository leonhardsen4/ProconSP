package br.gov.sp.procon.model;

import java.time.LocalDateTime;
import java.util.List;

public class RemessaMalote {

    private int id;
    private LocalDateTime dataRemessa;
    private String movimento;
    private List<Malote> listaMalotes;

    private float valorTotal;

    public RemessaMalote() {
    }

    public RemessaMalote(int id, LocalDateTime dataRemessa, String movimento, List<Malote> listaMalotes, float valorTotal) {
        this.id = id;
        this.dataRemessa = dataRemessa;
        this.movimento = movimento;
        this.listaMalotes = listaMalotes;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataRemessa() {
        return dataRemessa;
    }

    public void setDataRemessa(LocalDateTime dataRemessa) {
        this.dataRemessa = dataRemessa;
    }

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }

    public List<Malote> getListaMalotes() {
        return listaMalotes;
    }

    public void setListaMalotes(List<Malote> listaMalotes) {
        this.listaMalotes = listaMalotes;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "RemessaMalote{" +
                "id=" + id +
                ", dataRemessa=" + dataRemessa +
                ", movimento='" + movimento + '\'' +
                ", listaMalotes=" + listaMalotes +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
