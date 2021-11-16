/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursoJava.herancaPolimorfismoInterface.secretario;

import cursoJava.herancaPolimorfismoInterface.interfaces.PermitirAcesso;
import cursoJava.herancaPolimorfismoInterface.Pessoa;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Willian
 */
public class Secretario extends Pessoa implements PermitirAcesso {

    private String registro;
    private String nivelCargo;
    private String experiencia;

    private String login;
    private String senha;

    public Secretario() {
    }

    public Secretario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(String nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String getIdade() {
        return idade;
    }

    @Override
    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public Integer getRg() {
        return rg;
    }

    @Override
    public void setRg(Integer rg) {
        this.rg = rg;
    }

    @Override
    public Integer getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getNomeMae() {
        return nomeMae;
    }

    @Override
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    @Override
    public String getNomePai() {
        return nomePai;
    }

    @Override
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.registro);
        hash = 47 * hash + Objects.hashCode(this.nivelCargo);
        hash = 47 * hash + Objects.hashCode(this.experiencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Secretario other = (Secretario) obj;
        if (!Objects.equals(this.registro, other.registro)) {
            return false;
        }
        if (!Objects.equals(this.nivelCargo, other.nivelCargo)) {
            return false;
        }
        if (!Objects.equals(this.experiencia, other.experiencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Secretario{" + "registro=" + registro + ", nivelCargo=" + nivelCargo + ", experiencia=" + experiencia + '}';
    }

    @Override
    public String metodoAbstrato() {
        return " Método abstract, teste teste, somente teste";
    }

    @Override
    public boolean autenticar(String login, String senha) {
        this.login = login;
        this.senha = senha;
        return autenticar();
    }

    @Override
    public boolean autenticar() {
        return "admin".equals(login) && "admin".equals(senha);
    }

}
