package com.titansoftware.steps.LoginsStep;

import com.titansoftware.funcs.LoginFunc;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class HomeStep {

    LoginFunc loginFunc = new LoginFunc();

    @Então("deve visualizar o nome {string}")
    public void deveVisualizarNome(String msg) {
        Assert.assertEquals(msg, loginFunc.getUsuarioLogado());
    }


}