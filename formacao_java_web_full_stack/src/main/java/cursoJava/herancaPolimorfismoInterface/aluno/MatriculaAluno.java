package cursoJava.herancaPolimorfismoInterface.aluno;

import cursoJava.herancaPolimorfismoInterface.aluno.Constantes.StatusAluno;
import cursoJava.herancaPolimorfismoInterface.diretor.Diretor;
import cursoJava.herancaPolimorfismoInterface.permitirAutenticar.PermissaoAutenticacao;
import cursoJava.TratamentoExcecao.ExcecaoCustomizada;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;

public class MatriculaAluno {

    String login;
    String senha;

    boolean loginUsuario = true;
    boolean continuarMatricula = true;
    boolean continuarRemover = true;
    boolean continuarPergunta = true;

    public MatriculaAluno() {
        try {
            while (loginUsuario) {

                login = JOptionPane.showInputDialog("Informe seu login");
                senha = JOptionPane.showInputDialog("Informe sua senha");

                if (new PermissaoAutenticacao(new Diretor(login, senha)).autenticar()) {

                    try {
                        List<String> teste = null;
                        teste.add("aaa");
                    } catch (Exception ex) {
                        throw new ExcecaoCustomizada("Erro ao criar lista teste");
                    }

                    List<Aluno> alunoLista = new ArrayList<>();

                    /**
                     * O HashMap funciona como uma lista, porém usa um parâmetro, ou seja, uma chave, para
                     * separar ou organizar as listas.
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

                        continuarPergunta = true;
                        while (continuarPergunta) {
                            String quantDisciplinas = JOptionPane.showInputDialog("Quantidade de Disciplinas");
                            if (!StringUtils.isNumeric(quantDisciplinas)) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Por favor, digite somente números!");
                            } else {
                                for (int i = 1; i <= Integer.valueOf(quantDisciplinas); i++) {
                                    String nomeDisciplina = JOptionPane.showInputDialog(
                                            "Digite o nome da " + i + "ª Disciplina");
                                    continuarPergunta = true;
                                    while (continuarPergunta) {
                                        String valorNota = JOptionPane.showInputDialog("Digite a " + i + "ª Nota");
                                        try {
                                            if (Double.valueOf(valorNota) >= 0 && Double.valueOf(valorNota) <= 10) {
                                                Disciplina disciplina = new Disciplina();
                                                disciplina.setNome(nomeDisciplina);
                                                disciplina.setNota(Double.valueOf(valorNota));
                                                alunos.getListaDisciplina().add(disciplina);
                                                continuarPergunta = false;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Por favor, digite uma nota entre 0 e 10!");
                                            }
                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Por favor, digite somente números!");
                                        }
                                    }
                                }
                                continuarPergunta = false;
                            }
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
                                alunos.getListaDisciplina().remove(Integer.parseInt(nomeDisciplina) - 1);
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

                        Date date = new Date();
                        alunos.setDataMatricula(date);

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
                        System.out.println(" -------------------------------------------------------------------------");
                        System.out.println(" Lista Vazia!!!");
                    }
                    mapStatusAluno.get(StatusAluno.APROVADO).forEach(aluno -> {
                        System.out.println(" -------------------------------------------------------------------------");
                        System.out.println(" Nome: " + aluno.getNome() + " " + aluno.getSobrenome());
                        System.out.println(" Média: " + aluno.getMediaNota());
                        System.out.println(" Status: " + aluno.getStatusAluno());
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        System.out.println(" Data da Matrícula: " + formatter.format(aluno.getDataMatricula()));
                    });

                    System.out.println("");
                    System.out.println(" Lista de Alunos em Recuperacao ");
                    if (mapStatusAluno.get(StatusAluno.RECUPERACAO).isEmpty()) {
                        System.out.println(" -------------------------------------------------------------------------");
                        System.out.println(" Lista Vazia!!!");
                    }
                    mapStatusAluno.get(StatusAluno.RECUPERACAO).forEach(aluno -> {
                        System.out.println(" -------------------------------------------------------------------------");
                        System.out.println(" Nome: " + aluno.getNome() + " " + aluno.getSobrenome());
                        System.out.println(" Média: " + aluno.getMediaNota());
                        System.out.println(" Status: " + aluno.getStatusAluno());
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        System.out.println(" Data da Matrícula: " + formatter.format(aluno.getDataMatricula()));
                    });

                    System.out.println("");
                    System.out.println(" Lista de Alunos Reprovados ");
                    if (mapStatusAluno.get(StatusAluno.REPROVADO).isEmpty()) {
                        System.out.println(" -------------------------------------------------------------------------");
                        System.out.println(" Lista Vazia!!!");
                    }
                    mapStatusAluno.get(StatusAluno.REPROVADO).forEach(aluno -> {
                        System.out.println(" -------------------------------------------------------------------------");
                        System.out.println(" Nome: " + aluno.getNome() + " " + aluno.getSobrenome());
                        System.out.println(" Média: " + aluno.getMediaNota());
                        System.out.println(" Status: " + aluno.getStatusAluno());
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        System.out.println(" Data da Matrícula: " + formatter.format(aluno.getDataMatricula()));
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

        } catch (Throwable ex) {
            StringBuilder saida = new StringBuilder();
            saida = null;
            ex.printStackTrace();
            for (int pos = 0; pos < ex.getStackTrace().length; pos++) {
                saida.append(
                        "Classe: " + ex.getStackTrace()[pos].getClassName()
                        + "\nMétodo: " + ex.getStackTrace()[pos].getMethodName()
                        + "\nLinha: " + ex.getStackTrace()[pos].getLineNumber()
                );
            }
            JOptionPane.showMessageDialog(null, "Erro! \n" + saida.toString());
        } 
    }
}
