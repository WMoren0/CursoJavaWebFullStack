/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursoJava.herancaPolimorfismoInterface.interfaces;

/**
 * Dentro da interface podemos definir um ou varios métodos, sem implementa-los,
 * ou seja, sem declarar a regra de negócio, além disso, a interface expõe o que
 * o objeto deve fazer, sem dizer como faz, nem o que tem, mas como ele faz será
 * definido quando a interface for implementada no objeto que precisar.
 *
 * Dentro da inferface não existe a regra de negócio, ou seja, tudo o que o
 * método deve fazer, logo aqui é somente declarado o método.
 *
 * @author Willian
 */
public interface PermitirAcesso {

    // O método foi somente declarado, como deve ser.
    public boolean autenticar(String login, String senha);
    public boolean autenticar();

}
