package com.titansoftware.steps.faturamentoSteps;

import com.titansoftware.funcs.faturamentoFuncs.AssercaoContraNotaRuralFunc;
import com.titansoftware.funcs.faturamentoFuncs.ModuloFaturamentoAcessosFunc;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class AssercaoContraNotaRuralStep {
    ModuloFaturamentoAcessosFunc moduloFaturamentoAcessosFunc = new ModuloFaturamentoAcessosFunc();
    AssercaoContraNotaRuralFunc assercaoContraNotaRuralFunc = new AssercaoContraNotaRuralFunc();

    @Então("deve visualizar a contra nota no módulo Faturamento com a mensagem {string}")
    public void validacaoContraNotaRural(String msg) throws InterruptedException {
        moduloFaturamentoAcessosFunc.acessarModuloFaturamento();
        moduloFaturamentoAcessosFunc.acessarMenuFaturamento();
        moduloFaturamentoAcessosFunc.acessarSubMenuEmissaoDeFaturas();
        assercaoContraNotaRuralFunc.filtrarNotaRural();
        assercaoContraNotaRuralFunc.clicarAlterarNotaRural();
        assercaoContraNotaRuralFunc.filtrarNotaRuralEmitida();
        Assert.assertEquals(msg, assercaoContraNotaRuralFunc.verificarStatus());

    }
}
