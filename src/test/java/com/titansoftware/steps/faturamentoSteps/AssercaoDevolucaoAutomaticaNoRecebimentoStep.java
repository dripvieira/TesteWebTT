package com.titansoftware.steps.faturamentoSteps;

import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.funcs.faturamentoFuncs.GerarFaturaFunc;
import com.titansoftware.funcs.faturamentoFuncs.ModuloFaturamentoAcessosFunc;
import io.cucumber.java.pt.E;
import org.junit.Assert;

public class AssercaoDevolucaoAutomaticaNoRecebimentoStep {
    GerarFaturaFunc gerarFaturaFunc = new GerarFaturaFunc();
    ModuloFaturamentoAcessosFunc moduloFaturamentoAcessosFunc = new ModuloFaturamentoAcessosFunc();

    @E("gerar a nota de devolução automática no faturamento")
    public void gerarNFDevolucãoAutomatica() throws InterruptedException {
        moduloFaturamentoAcessosFunc.acessarModuloFaturamento();
        moduloFaturamentoAcessosFunc.acessarMenuFaturamento();
        moduloFaturamentoAcessosFunc.acessarSubMenuEmissaoDeFaturas();
        gerarFaturaFunc.validarNotaDevolucaoAutomatica();
    }

    @E("coletar dados da NF")
    public void assercaoDevolucaoAutomatica() {
        gerarFaturaFunc.assercaoDevolucaoAutomatica();
        Assert.assertEquals(EntradaDeNotaFiscalFunc.nfDevAutomatica, gerarFaturaFunc.codDevAut);
        Assert.assertEquals("Emitida", gerarFaturaFunc.resgatarStatusNF);
        //Assert.assertEquals(EntradaDeNotaFiscalFunc.valorNF, EmitirDevolucaoAutomaticaFunc.resgatarValorNf);

    }


}
