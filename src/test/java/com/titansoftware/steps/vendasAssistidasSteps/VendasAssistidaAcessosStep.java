package com.titansoftware.steps.vendasAssistidasSteps;

import com.titansoftware.funcs.vendasAssistidasFuncs.VendasAssistidaAcessosFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

public class VendasAssistidaAcessosStep {

    VendasAssistidaAcessosFunc vendasAssistidaAcessosFunc = new VendasAssistidaAcessosFunc();

    @Quando("acessar a tela de Vendas Assistidas")
    public void acessarVendasAssistidas() throws InterruptedException {
        vendasAssistidaAcessosFunc.acessarModuloVendasAssistida();
        vendasAssistidaAcessosFunc.acessarMenuVendasAssistidas();
        vendasAssistidaAcessosFunc.acessarSubMenuVendas();
    }

    @E("entrar no módulo vendas assitidas")
    public void entrarVendasAssistidas() throws InterruptedException {
        vendasAssistidaAcessosFunc.acessarModuloVendasAssistida();
        vendasAssistidaAcessosFunc.acessarMenuVendasAssistidas();
        vendasAssistidaAcessosFunc.acessarSubMenuVendas();
    }

}
