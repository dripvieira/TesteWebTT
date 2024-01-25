package com.titansoftware.steps.estoqueSteps.recebimentoSteps;

import com.titansoftware.funcs.faturamentoFuncs.GerarFaturaFunc;
import io.cucumber.java.pt.E;

public class NotaDeDevolucaoAutomaticaStep {

    GerarFaturaFunc gerarFaturaFunc = new GerarFaturaFunc();

    @E("validar no recebimento")
    public void notaDeDevolucaoAutomatica() throws InterruptedException {
        gerarFaturaFunc.validarNotaDevolucaoAutomatica();
    }
}
