package com.titansoftware.steps.vendasAssistidasSteps;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.faturamentoFuncs.EmitirVendaAssistidaFunc;
import com.titansoftware.funcs.faturamentoFuncs.ExclusaoFaturaFunc;
import com.titansoftware.funcs.faturamentoFuncs.ModuloFaturamentoAcessosFunc;
import com.titansoftware.funcs.vendasAssistidasFuncs.VendasAssistidaAcessosFunc;
import io.cucumber.java.gl.E;
import io.cucumber.java.pt.Então;

public class ValidarExclusaoVendasAssistidasStep extends BaseTeste {
    VendasAssistidaAcessosFunc vendasAssistidaAcessosFunc = new VendasAssistidaAcessosFunc();
    ModuloFaturamentoAcessosFunc moduloFaturamentoAcessosFunc = new ModuloFaturamentoAcessosFunc();

    EmitirVendaAssistidaFunc emitirVendaAssistidaFunc = new EmitirVendaAssistidaFunc();

    ExclusaoFaturaFunc exclusaoFaturaFunc = new ExclusaoFaturaFunc();

    @E("excluir a nota no faturamento")
    public void excluirFatura() throws InterruptedException {
        moduloFaturamentoAcessosFunc.acessarModuloFaturamento();
        moduloFaturamentoAcessosFunc.acessarMenuFaturamento();
        moduloFaturamentoAcessosFunc.acessarSubMenuEmissaoDeFaturas();
        exclusaoFaturaFunc.filtrarPedido();
        exclusaoFaturaFunc.cancelarFatura();
    }

    @Então("deve visualizar o status {string}")
    public void assercaoVendasAssistidasExclusaoFutura(String expected) {
        emitirVendaAssistidaFunc.validarExclusao(expected);
    }
}
