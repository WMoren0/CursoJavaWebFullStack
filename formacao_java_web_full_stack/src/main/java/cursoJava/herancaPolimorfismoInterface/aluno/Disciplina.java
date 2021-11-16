/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursoJava.herancaPolimorfismoInterface.aluno;

/**
 *
 * @author Willian
 */
public class Disciplina {
    
    String nome;
    double nota;

    public Disciplina() {

        /* Esse método serve para criar/iniciar os dados na memória */
    }

    /* Sets and Getters */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    /* HashCode and Equals */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        long temp;
        temp = Double.doubleToLongBits(nota);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
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
        Disciplina other = (Disciplina) obj;
        if (nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!nome.equals(other.nome)) {
            return false;
        }
        if (Double.doubleToLongBits(nota) != Double.doubleToLongBits(other.nota)) {
            return false;
        }
        return true;
    }

    /* toString */
    @Override
    public String toString() {
        return "Disciplina [nomeDisciplina=" + nome + ", valorNota=" + nota + "]";
    }
    
}
