/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursoJava.herancaPolimorfismoInterface;

import java.util.Date;

/**
 * Essa classe/objeto é, dentro dos conceitos de herança, a classe Pai, pois ela
 * tem atributos comuns para as classes Filho que a extende.
 *
 * A abstração de uma classe é feita quando a mesma é usada de forma
 * generalizada, ou seja, no caso dessa classe Pessoa, levando em conta que
 * temos os objetos Aluno, Diretor, Secretário, o fato é que todos são "Pessoa",
 * logo essa classe é de uso generalizado. Além disso, a palavra chave
 * "abstract" serve para impedir que a classe seja instanciada, para que o
 * programador não consiga trabalhar diretamente nela, pois o objetivo da classe
 * abstrata é servir como um modelo geral para as classes que a extendem.
 *
 * @author Willian
 */
public abstract class Pessoa {

    protected String nome;
    protected String sobrenome;
    protected String idade;
    protected Date dataNascimento;
    protected int rg;
    protected int cpf;
    protected String nomeMae;
    protected String nomePai;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public boolean pessoaMaiorIdade() {
        if (Integer.valueOf(this.idade) >= 18) {
            return true;
        }
        return false;
    }

    /**
     * Vale ressaltar que objetos com o parametro "abstract" servem para obrigar
     * que a anotação "@override" seja colocada junto ao mesmo método chamado em
     * uma class filha, assim impedindo que o código compile na falta dessa
     * anotação.
     * Um método abstract só pode ficar dentro de uma classe abstract.
     * Uma atenção que se deve ter, é que todos os métodos abstract são OBRIGATÓRIOS
     * de serem implementados nas classes filhas, caso contrário o código não
     * compilará.
     */
    public abstract String metodoAbstrato();
}
