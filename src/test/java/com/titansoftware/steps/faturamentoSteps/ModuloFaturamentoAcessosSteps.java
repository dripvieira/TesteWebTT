package com.titansoftware.steps.faturamentoSteps;

import com.titansoftware.funcs.faturamentoFuncs.ModuloFaturamentoAcessosFunc;
import io.cucumber.java.pt.Quando;

public class ModuloFaturamentoAcessosSteps {
    ModuloFaturamentoAcessosFunc moduloFaturamentoAcessosFunc = new ModuloFaturamentoAcessosFunc();


    @Quando("estiver na tela de emissão de fatura")
    public void acessarEmissaoFatura() throws InterruptedException {
        moduloFaturamentoAcessosFunc.acessarModuloFaturamento();
        moduloFaturamentoAcessosFunc.acessarMenuFaturamento();
        moduloFaturamentoAcessosFunc.acessarSubMenuEmissaoDeFaturas();
    }


}
