package br.com.fiap.postech.machinecheck.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_checklist")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maquina;
    private String observacao;
    private String componente;
    private String statusChecagem;
    private String dataChecagem;
    private String tempoDaChecagem;
    private String urlFoto;
    private String urlVideo;
    private String executante;

    public Check() {
        super();
    }

    public Check(String maquina, String observacao, String componente, String statusChecagem, String dataChecagem, String tempoDaChecagem, String urlFoto, String urlVideo, String executante) {
        this.maquina = maquina;
        this.observacao = observacao;
        this.componente = componente;
        this.statusChecagem = statusChecagem;
        this.dataChecagem = dataChecagem;
        this.tempoDaChecagem = tempoDaChecagem;
        this.urlFoto = urlFoto;
        this.urlVideo = urlVideo;
        this.executante = executante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Check check = (Check) o;

        return id.equals(check.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getStatusChecagem() {
        return statusChecagem;
    }

    public void setStatusChecagem(String statusChecagem) {
        this.statusChecagem = statusChecagem;
    }

    public String getDataChecagem() {
        return dataChecagem;
    }

    public void setDataChecagem(String dataChecagem) {
        this.dataChecagem = dataChecagem;
    }

    public String getTempoDaChecagem() {
        return tempoDaChecagem;
    }

    public void setTempoDaChecagem(String tempoDaChecagem) {
        this.tempoDaChecagem = tempoDaChecagem;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getExecutante() {
        return executante;
    }

    public void setExecutante(String executante) {
        this.executante = executante;
    }
}
