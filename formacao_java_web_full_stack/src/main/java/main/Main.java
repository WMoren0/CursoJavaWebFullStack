package main;

import cursoJava.herancaPolimorfismoInterface.aluno.MatriculaAluno;
import java.util.TimeZone;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class Main {

    public static void main(String[] args) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("GMT-03:00"));
            MatriculaAluno matriculaAluno = new MatriculaAluno();
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            /*
                Esse método sempre é executado indepedendo de erros
             */
            JOptionPane.showMessageDialog(null, "Programa Finalizado!");
        }
    }

}
