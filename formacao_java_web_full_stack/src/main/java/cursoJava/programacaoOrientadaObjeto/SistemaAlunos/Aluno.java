package cursoJava.programacaoOrientadaObjeto.SistemaAlunos;

import cursoJava.herancaPolimorfismoInterface.aluno.Constantes.StatusAluno;
import java.util.ArrayList;
import java.util.List;

public class Aluno {

    String nome;
    String sobrenome;
    String idade;

    public List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Aluno() {

        /* Esse m�todo serve para criar/iniciar os dados na mem�ria */
    }

    /* Sets and Getters ----------------------------------------------------------------------------- */
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

    /* HashCode e Equals --------------------------------------------------------------------------- */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idade == null) ? 0 : idade.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
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
        Aluno other = (Aluno) obj;
        if (idade == null) {
            if (other.idade != null) {
                return false;
            }
        } else if (!idade.equals(other.idade)) {
            return false;
        }
        if (nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!nome.equals(other.nome)) {
            return false;
        }
        if (sobrenome == null) {
            if (other.sobrenome != null) {
                return false;
            }
        } else if (!sobrenome.equals(other.sobrenome)) {
            return false;
        }
        return true;
    }

    /* to String --------------------------------------------------------------------------------- */
    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + "]";
    }

    /* ---------------------------------------------------------------------------------------------*/
    public double getMediaNota() {

        double somaNotas = 0.0;

        for (Disciplina disciplina : disciplinas) {
            somaNotas += disciplina.getValorNota();
        }

        return somaNotas / disciplinas.size();
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

}
