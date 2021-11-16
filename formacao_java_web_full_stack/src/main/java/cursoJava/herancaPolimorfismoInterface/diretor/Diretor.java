/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursoJava.herancaPolimorfismoInterface.diretor;

import cursoJava.herancaPolimorfismoInterface.Pessoa;
import cursoJava.herancaPolimorfismoInterface.interfaces.PermitirAcesso;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Willian
 */
public class Diretor extends Pessoa implements PermitirAcesso {

    private String registroEducacao;
    private int tempoDirecao;
    private String titulacao;

    private String login;
    private String senha;

    public Diretor() {
    }

    public Diretor(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getRegistroEducacao() {
        return registroEducacao;
    }

    public void setRegistroEducacao(String registroEducacao) {
        this.registroEducacao = registroEducacao;
    }

    public int getTempoDirecao() {
        return tempoDirecao;
    }

    public void setTempoDirecao(int tempoDirecao) {
        this.tempoDirecao = tempoDirecao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
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
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.registroEducacao);
        hash = 47 * hash + this.tempoDirecao;
        hash = 47 * hash + Objects.hashCode(this.titulacao);
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
        final Diretor other = (Diretor) obj;
        if (this.tempoDirecao != other.tempoDirecao) {
            return false;
        }
        if (!Objects.equals(this.registroEducacao, other.registroEducacao)) {
            return false;
        }
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Diretor{" + "registroEducacao=" + registroEducacao + ", tempoDirecao=" + tempoDirecao + ", titulacao=" + titulacao + '}';
    }

    /**
     * A anotação Override é colocada quando o método implementado já existe em
     * outro lugar, sendo sobreescrito no lugar ao qual foi chamado, nesse caso
     * o método pessoaMaiorIdade() esta sendo chamado da classe Pessoa, que foi
     * extendida, e sobreescrito nessa classe Diretor.
     *
     * @return
     */
    @Override
    public boolean pessoaMaiorIdade() {
        return super.pessoaMaiorIdade(); //To change body of generated methods, choose Tools | Templates.
    }

    public String msgMaiorIdade() {
        return this.pessoaMaiorIdade() ? " Você é maior de idade!" : " Você é menor de idade!";
    }

    @Override
    public String metodoAbstrato() {
        return " Hello World";
    }

    @Override
    public boolean autenticar(String login, String senha) {
        this.login = login;
        this.senha = senha;
        return autenticar();
    }

    @Override
    public boolean autenticar() {
        return "will".equals(login) && "123".equals(senha);
    }

}
