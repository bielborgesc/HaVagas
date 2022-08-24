package br.edu.scl.ifsp.ads.pdm.havagas;

import androidx.annotation.NonNull;

import java.util.Date;

public class Candidato {
    private String nome;
    private String email;
    private Boolean recebeEmail;
    private String telefone;
    private TipoTelefone tipoTelefone;
    private String celular;
    private Sexo  sexo;
    private Date dataNascimento;
    private Escolaridade escolaridade;
    private Integer anoEscolaridade;
    private String vagaPretendida;

    public Candidato(String nome, String email, Boolean recebeEmail, String telefone, TipoTelefone tipoTelefone, String celular, Sexo sexo, Date dataNascimento, Escolaridade escolaridade, Integer anoEscolaridade, String vagaPretendida) {
        this.nome = nome;
        this.email = email;
        this.recebeEmail = recebeEmail;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
        this.celular = celular;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.escolaridade = escolaridade;
        this.anoEscolaridade = anoEscolaridade;
        this.vagaPretendida = vagaPretendida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRecebeEmail() {
        return recebeEmail;
    }

    public void setRecebeEmail(Boolean recebeEmail) {
        this.recebeEmail = recebeEmail;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Integer getAnoEscolaridade() {
        return anoEscolaridade;
    }

    public void setAnoEscolaridade(Integer anoEscolaridade) {
        this.anoEscolaridade = anoEscolaridade;
    }

    public String getVagaPretendida() {
        return vagaPretendida;
    }

    public void setVagaPretendida(String vagaPretendida) {
        this.vagaPretendida = vagaPretendida;
    }

    @NonNull
    @Override
    public String toString() {
        String sb = "Candidato{" + "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", recebeEmail=" + recebeEmail +
                ", telefone='" + telefone + '\'' +
                ", tipoTelefone=" + tipoTelefone +
                ", celular='" + celular + '\'' +
                ", sexo=" + sexo +
                ", dataNascimento=" + dataNascimento +
                ", escolaridade=" + escolaridade +
                ", anoEscolaridade=" + anoEscolaridade +
                ", vagaPretendida='" + vagaPretendida + '\'' +
                '}';
        return sb;
    }
}
