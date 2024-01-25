package com.titansoftware.steps;

import com.titansoftware.funcs.LoginFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginStep {
    LoginFunc loginFunc = new LoginFunc();


    /**
     * Abre a URL especificada
     */
    @Dado("estiver na tela de login")
    public void entrarLogin() {
        loginFunc.acessarTelaLogin();
    }


    /**
     * Insere os dados do usuário e realiza login
     *
     * @param dataTable recebe os dados do dataTable
     */
    @Quando("inserir os dados do usuário")
    public void inserirOsDadosDoUsuario(DataTable dataTable) {

        List<Map<String, String>> usuario = dataTable.asMaps();
        String login = usuario.get(0).get("login");
        String senha = usuario.get(0).get("senha");
        loginFunc.realizarLogin(login, senha);
    }

    /**
     * Insere dados incorretos do usuário
     *
     * @param dataTable recebe dados incorretos do dataTable
     */
    @Quando("inserir os dados incorretos do usuário")
    public void inserirDadosIncorretos(DataTable dataTable) {

        List<Map<String, String>> usuario = dataTable.asMaps();
        String login = usuario.get(0).get("login");
        String senha = usuario.get(0).get("senha");
        loginFunc.loginDadosIncorretos(login, senha);
    }

    /**
     * Realiza a asserção da mensagem de erro
     *
     * @param msg recebe a mensagem da feature para asserção
     */
    @Então("deve visualizar a mensagem de erro {string}")
    public void deveVizualizarMsgDeErro(String msg) {
        Assert.assertEquals(msg, loginFunc.getMsgErroLogin());
    }
}
