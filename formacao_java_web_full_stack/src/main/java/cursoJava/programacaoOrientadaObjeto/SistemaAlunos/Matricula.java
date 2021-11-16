package cursoJava.programacaoOrientadaObjeto.SistemaAlunos;

import cursoJava.herancaPolimorfismoInterface.aluno.Constantes.StatusAluno;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;

public class Matricula {

    String login = "Admin";
    String senha = "123";

    boolean loginUsuario = true;
    boolean continuarMatricula = true;
    boolean continuarRemover = true;
    boolean continuarPergunta = true;

    public Matricula() {

    }

    public void notasAlunos() {

        while (loginUsuario) {

            String getLogin = JOptionPane.showInputDialog("Informe seu login");
            String getSenha = JOptionPane.showInputDialog("Informe sua senha");

            System.out.println("Login " + login + " Senha " + senha);

            if (login.equalsIgnoreCase(getLogin) & senha.equalsIgnoreCase(getSenha)) {

                List<Aluno> alunoLista = new ArrayList<>();

                /**
                 * O HashMap funciona como uma lista, porém usa um parâmetro, ou
                 * seja, uma chave, para separar ou organizar as listas.
                 */
                HashMap<String, List<Aluno>> mapStatusAluno = new HashMap<>();

                while (continuarMatricula) {

                    Aluno alunos = new Aluno();

                    continuarPergunta = true;
                    while (continuarPergunta) {
                        alunos.setNome(JOptionPane.showInputDialog("Digite seu nome"));
                        if (alunos.getNome().isEmpty()) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Por favor, digite o seu NOME!");
                        } else if (StringUtils.isNumeric(alunos.getNome())) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Por favor, digite somente letras!");
                        } else if (alunos.getNome() == null) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Você não digitou o nome do aluno. Finalizando programa!");
                            return;
                        } else {
                            continuarPergunta = false;
                        }
                    }

                    continuarPergunta = true;
                    while (continuarPergunta) {
                        alunos.setSobrenome(JOptionPane.showInputDialog("Digite seu sobrenome"));
                        if (alunos.getSobrenome().isEmpty()) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Por favor, digite o seu SOBRENOME!");
                        } else if (StringUtils.isNumeric(alunos.getSobrenome())) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Por favor, digite somente letras!");
                        } else if (alunos.getSobrenome() == null) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Você não digitou o sobrenome do aluno. Finalizando programa!");
                            return;
                        } else {
                            continuarPergunta = false;
                        }
                    }

                    continuarPergunta = true;
                    while (continuarPergunta) {
                        alunos.setIdade(JOptionPane.showInputDialog("Digite sua idade"));
                        if (alunos.getIdade().isEmpty()) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Por favor, digite a sua IDADE!");
                        } else if (!StringUtils.isNumeric(alunos.getIdade())) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Por favor, digite somente números!");
                        } else if (alunos.getIdade() == null) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Você não digitou a idade do aluno. Finalizando programa!");
                            return;
                        } else {
                            continuarPergunta = false;
                        }
                    }

                    String quantDisciplinas = JOptionPane.showInputDialog("Quantidade de Disciplinas");

                    for (int i = 1; i <= Integer.valueOf(quantDisciplinas); i++) {
                        String nomeDisciplina = JOptionPane.showInputDialog(
                                "Digite o nome da " + i + "ª Disciplina");
                        String valorNota = JOptionPane.showInputDialog("Digite a " + i + "ª Nota");
                        Disciplina disciplina = new Disciplina();
                        disciplina.setNomeDisciplina(nomeDisciplina);
                        disciplina.setValorNota(Double.valueOf(valorNota));
                        alunos.getDisciplinas().add(disciplina);
                    }

                    int removerDisciplina = JOptionPane.showConfirmDialog(
                            null,
                            "Deseja remover alguma disciplina?");

                    continuarRemover = true;
                    while (continuarRemover) {

                        if (removerDisciplina == 0) {
                            String nomeDisciplina = JOptionPane.showInputDialog(
                                    "Por favor, insira o número da disciplina a ser removida,"
                                    + " levando em conta a ordem de cadastro: ");
                            alunos.getDisciplinas().remove(Integer.parseInt(nomeDisciplina) - 1);
                            int continuarRemovendo = JOptionPane.showConfirmDialog(
                                    null,
                                    "Deseja continuar removendo?");
                            if (continuarRemovendo == 1 || continuarRemovendo == 2) {
                                continuarRemover = false;
                            }
                        } else {
                            continuarRemover = false;
                        }

                    }

                    alunoLista.add(alunos);

                    int status = JOptionPane.showConfirmDialog(
                            null,
                            "Deseja fazer outra matrícula?");

                    continuarMatricula = true;
                    if (status == 1 | status == 2) {
                        continuarMatricula = false;
                    }
                }

                mapStatusAluno.put(StatusAluno.APROVADO, new ArrayList<>());
                mapStatusAluno.put(StatusAluno.RECUPERACAO, new ArrayList<>());
                mapStatusAluno.put(StatusAluno.REPROVADO, new ArrayList<>());

                alunoLista.forEach(aluno -> {
                    if (aluno.getStatusAluno().equalsIgnoreCase(StatusAluno.APROVADO)) {
                        mapStatusAluno.get(StatusAluno.APROVADO).add(aluno);
                    } else if (aluno.getStatusAluno().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                        mapStatusAluno.get(StatusAluno.RECUPERACAO).add(aluno);
                    } else {
                        mapStatusAluno.get(StatusAluno.REPROVADO).add(aluno);
                    }
                });

                System.out.println("");
                System.out.println(" Lista de Alunos Aprovados ");
                if (mapStatusAluno.get(StatusAluno.APROVADO).isEmpty()) {
                    System.out.println(" Lista Vazia!!!");
                }
                mapStatusAluno.get(StatusAluno.APROVADO).forEach(aluno -> {
                    System.out.println(" -------------------------------------------------------------------------");
                    System.out.println(" Código: " + aluno.hashCode());
                    System.out.println(" Nome: " + aluno.getNome() + " " + aluno.getSobrenome());
                    System.out.println(" Média: " + aluno.getMediaNota());
                    System.out.println(" Status: " + aluno.getStatusAluno());
                });

                System.out.println("");
                System.out.println(" Lista de Alunos em Recuperacao ");
                if (mapStatusAluno.get(StatusAluno.RECUPERACAO).isEmpty()) {
                    System.out.println(" Lista Vazia!!!");
                }
                mapStatusAluno.get(StatusAluno.RECUPERACAO).forEach(aluno -> {
                    System.out.println(" -------------------------------------------------------------------------");
                    System.out.println(" Código: " + aluno.hashCode());
                    System.out.println(" Nome: " + aluno.getNome() + " " + aluno.getSobrenome());
                    System.out.println(" Média: " + aluno.getMediaNota());
                    System.out.println(" Status: " + aluno.getStatusAluno());
                });

                System.out.println("");
                System.out.println(" Lista de Alunos Reprovados ");
                if (mapStatusAluno.get(StatusAluno.REPROVADO).isEmpty()) {
                    System.out.println(" Lista Vazia!!!");
                }
                mapStatusAluno.get(StatusAluno.REPROVADO).forEach(aluno -> {
                    System.out.println(" -------------------------------------------------------------------------");
                    System.out.println(" Código: " + aluno.hashCode());
                    System.out.println(" Nome: " + aluno.getNome() + " " + aluno.getSobrenome());
                    System.out.println(" Média: " + aluno.getMediaNota());
                    System.out.println(" Status: " + aluno.getStatusAluno());
                });
                return;

            } else {
                int status = JOptionPane.showConfirmDialog(
                        null,
                        "Login ou senha incorreta. Deseja continuar tentando?"
                );

                if (status != 0) {
                    System.out.println(" Programa Finalizado!!!");
                    loginUsuario = false;
                }
            }
        }
    }
}
