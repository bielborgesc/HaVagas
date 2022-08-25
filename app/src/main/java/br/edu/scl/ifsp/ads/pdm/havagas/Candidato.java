package br.edu.scl.ifsp.ads.pdm.havagas;

import androidx.annotation.NonNull;

import java.util.Date;

public class Candidato {
    private String nome;
    private String email;
    private Boolean recebeEmail;
    private String telefone;
    private String tipoTelefone;
    private String celular;
    private String  sexo;
    private String dataNascimento;
    private String escolaridade;
    private String anoEscolaridade;
    private String instituicao;
    private String tituloMonografio;
    private String orientador;
    private String vagaPretendida;

    public Candidato(String nome, String email, Boolean recebeEmail, String telefone, String tipoTelefone, String celular, String sexo, String escolaridade, String vagaPretendida) {
        this.nome = nome;
        this.email = email;
        this.recebeEmail = recebeEmail;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
        this.celular = celular;
        this.sexo = sexo;
        this.escolaridade = escolaridade;
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

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getAnoEscolaridade() {
        return anoEscolaridade;
    }

    public void setAnoEscolaridade(String anoEscolaridade) {
        this.anoEscolaridade = anoEscolaridade;
    }

    public String getVagaPretendida() {
        return vagaPretendida;
    }

    public void setVagaPretendida(String vagaPretendida) {
        this.vagaPretendida = vagaPretendida;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTituloMonografio() {
        return tituloMonografio;
    }

    public void setTituloMonografio(String tituloMonografio) {
        this.tituloMonografio = tituloMonografio;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    @NonNull
    @Override
    public String toString() {
        return "Candidato{" + "nome='" + nome + '\'' +
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
                ", instituicao='" + instituicao + '\'' +
                ", tituloMonografio='" + tituloMonografio + '\'' +
                ", orientador='" + orientador + '\'' +
                '}';
    }
}
