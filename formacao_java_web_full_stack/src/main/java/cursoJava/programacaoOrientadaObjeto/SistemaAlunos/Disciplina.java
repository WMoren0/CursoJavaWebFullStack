package cursoJava.programacaoOrientadaObjeto.SistemaAlunos;

public class Disciplina {

    String nomeDisciplina;
    double valorNota;

    public Disciplina() {

        /* Esse método serve para criar/iniciar os dados na memória */
    }

    /* Sets and Getters */
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }

    /* HashCode and Equals */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeDisciplina == null) ? 0 : nomeDisciplina.hashCode());
        long temp;
        temp = Double.doubleToLongBits(valorNota);
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
        if (nomeDisciplina == null) {
            if (other.nomeDisciplina != null) {
                return false;
            }
        } else if (!nomeDisciplina.equals(other.nomeDisciplina)) {
            return false;
        }
        if (Double.doubleToLongBits(valorNota) != Double.doubleToLongBits(other.valorNota)) {
            return false;
        }
        return true;
    }

    /* toString */
    @Override
    public String toString() {
        return "Disciplina [nomeDisciplina=" + nomeDisciplina + ", valorNota=" + valorNota + "]";
    }

}
