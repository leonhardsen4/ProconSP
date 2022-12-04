package br.gov.sp.procon.model;

import java.time.LocalDateTime;
import java.util.List;

public class Motofrete {

    private int requisicao;
    private Usuario idServidor;
    private LocalDateTime dataCadastro;
    private LocalDateTime horaCadastro;
    private LocalDateTime dataServico;
    private LocalDateTime horaServico;
    private LocalDateTime dataConclusao;
    private LocalDateTime horaConclusao;
    private Setor setor;
    private Servidor servidor;
    private Entidade destinatario;
    private List<Documento> listaDocumento;
    private Portador portador;
    private String observacoes;

    public Motofrete() {
    }

    public Motofrete(int requisicao, Usuario idServidor, LocalDateTime dataCadastro, LocalDateTime horaCadastro, LocalDateTime dataServico, LocalDateTime horaServico, LocalDateTime dataConclusao, LocalDateTime horaConclusao, Setor setor, Servidor servidor, Entidade destinatario, List<Documento> listaDocumento, Portador portador, String observacoes) {
        this.requisicao = requisicao;
        this.idServidor = idServidor;
        this.dataCadastro = dataCadastro;
        this.horaCadastro = horaCadastro;
        this.dataServico = dataServico;
        this.horaServico = horaServico;
        this.dataConclusao = dataConclusao;
        this.horaConclusao = horaConclusao;
        this.setor = setor;
        this.servidor = servidor;
        this.destinatario = destinatario;
        this.listaDocumento = listaDocumento;
        this.portador = portador;
        this.observacoes = observacoes;
    }

    public int getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(int requisicao) {
        this.requisicao = requisicao;
    }

    public Usuario getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(Usuario idServidor) {
        this.idServidor = idServidor;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getHoraCadastro() {
        return horaCadastro;
    }

    public void setHoraCadastro(LocalDateTime horaCadastro) {
        this.horaCadastro = horaCadastro;
    }

    public LocalDateTime getDataServico() {
        return dataServico;
    }

    public void setDataServico(LocalDateTime dataServico) {
        this.dataServico = dataServico;
    }

    public LocalDateTime getHoraServico() {
        return horaServico;
    }

    public void setHoraServico(LocalDateTime horaServico) {
        this.horaServico = horaServico;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public LocalDateTime getHoraConclusao() {
        return horaConclusao;
    }

    public void setHoraConclusao(LocalDateTime horaConclusao) {
        this.horaConclusao = horaConclusao;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Entidade getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Entidade destinatario) {
        this.destinatario = destinatario;
    }

    public List<Documento> getListaDocumento() {
        return listaDocumento;
    }

    public void setListaDocumento(List<Documento> listaDocumento) {
        this.listaDocumento = listaDocumento;
    }

    public Portador getPortador() {
        return portador;
    }

    public void setPortador(Portador portador) {
        this.portador = portador;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "motofrete{" +
                "requisicao=" + requisicao +
                ", idServidor=" + idServidor +
                ", dataCadastro=" + dataCadastro +
                ", horaCadastro=" + horaCadastro +
                ", dataServico=" + dataServico +
                ", horaServico=" + horaServico +
                ", dataConclusao=" + dataConclusao +
                ", horaConclusao=" + horaConclusao +
                ", setor=" + setor +
                ", servidor=" + servidor +
                ", destinatario=" + destinatario +
                ", listaDocumento=" + listaDocumento +
                ", portador=" + portador +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
