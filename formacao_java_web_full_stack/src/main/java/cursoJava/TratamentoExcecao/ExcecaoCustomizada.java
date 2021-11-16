/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursoJava.TratamentoExcecao;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian Moreno
 */
public class ExcecaoCustomizada extends Exception {

    /**
     * - Construtor da classe, que recebe uma string, no qual é passada para o construtor da classe extendida,
     * ou seja, Exception. Assim, ao chamar o construtor dessa classe, passando uma mensagem, é possivel criar
     * uma mensagem customizada para cada tipo de erro. - O objetivo dessa classe, é a customização do erro,
     * pois seria possivel chamar o construtor da classe Exception de forma direta, sem depender dessa.
     *
     * @param msg
     */
    public ExcecaoCustomizada(String msg) {
        super(msg);
        JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + msg);
    }

}
