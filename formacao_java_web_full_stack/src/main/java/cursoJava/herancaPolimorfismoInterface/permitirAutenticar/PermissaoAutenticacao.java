/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursoJava.herancaPolimorfismoInterface.permitirAutenticar;

import cursoJava.herancaPolimorfismoInterface.interfaces.PermitirAcesso;

/**
 * Aqui serão postos todos que forem permitidos o uso do contrato/interface de
 * autenticacao de usuário.
 *
 * @author Willian
 */
public class PermissaoAutenticacao {

    private PermitirAcesso permitirAcesso;

    public boolean autenticar() {
        return permitirAcesso.autenticar();
    }

    public PermissaoAutenticacao(PermitirAcesso acesso) {
        this.permitirAcesso = acesso;
    }

}
