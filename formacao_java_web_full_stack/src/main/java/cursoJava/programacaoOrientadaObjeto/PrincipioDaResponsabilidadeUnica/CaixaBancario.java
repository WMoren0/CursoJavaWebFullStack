/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursoJava.programacaoOrientadaObjeto.PrincipioDaResponsabilidadeUnica;

/**
 * Essa classe tem por objetivo explicar o princípio da responsabilidade única,
 * que diz respeito a implementação de métodos de um objeto de forma interna ou
 * externa ao objeto, ou seja, se esse método deve ou não estar dentro da
 * classe/objeto.
 *
 * @author Willian
 */
public class CaixaBancario {

    double valorConta = 1000;

    /**
     * Esse método por serem simples podem ser feitos dentro do próprio objeto,
     * e como podemos perceber ele tem a propriedade de sacar um valor passado
     * no método do "valorConta".
     *
     * @param saque
     */
    public void sacar(double saque) {
        this.valorConta -= saque;
    }

    /**
     * Esse método por serem simples podem ser feitos dentro do próprio objeto,
     * e como podemos perceber ele tem a propriedade de depositar um valor
     * passado no método no "valorConta".
     *
     * @param deposito
     */
    public void depositar(double deposito) {
        this.valorConta += deposito;
    }

    @Override
    public String toString() {
        return "CaixaBancario{" + "valorConta=" + valorConta + '}';
    }

    /**
     * O ideal é que métodos complexos ou que possam ser usados de forma geral,
     * sejam construídos de forma externa ao objeto.
     */
}
