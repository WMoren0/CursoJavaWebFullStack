/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursoJava.herancaPolimorfismoInterface.aluno;

import cursoJava.herancaPolimorfismoInterface.Pessoa;
import cursoJava.herancaPolimorfismoInterface.aluno.Constantes.StatusAluno;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Essa classe tem por objetivo construir um objeto Aluno extendendo
 * valores/atributos de uma outra classe, no caso Pessoa, que passa a ser a
 * classe Pai.
 *
 * @author Willian
 */
public class Aluno extends Pessoa {

    private Date dataMatricula;
    private String nomeEscola;
    private Integer serieMatriculado;
    private List<Disciplina> listaDisciplina = new ArrayList<>();

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public Integer getSerieMatriculado() {
        return serieMatriculado;
    }

    public void setSerieMatriculado(Integer serieMatriculado) {
        this.serieMatriculado = serieMatriculado;
    }

    public List<Disciplina> getListaDisciplina() {
        return listaDisciplina;
    }

    public void setListaDisciplina(List<Disciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
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

    public double getMediaNota() {
        double media = 0.0;
        for (Disciplina disciplina : this.listaDisciplina) {
            media += disciplina.getNota();
        }
        return media / this.listaDisciplina.size();
    }

    public String getStatusAluno() {
        double media = this.getMediaNota();
        if (media >= 5) {
            if (media >= 7) {
                return StatusAluno.APROVADO;
            } else {
                return StatusAluno.RECUPERACAO;
            }
        } else {
            return StatusAluno.REPROVADO;
        }
    }

    @Override
    public String metodoAbstrato() {
        return " Método abstrato";
    }

}
