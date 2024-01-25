package com.titansoftware.steps.ContabilSteps;

import com.titansoftware.funcs.ContabilFuncs.AssercaoLancamentoContabilVendasAssistidasFuncs;
import com.titansoftware.funcs.faturamentoFuncs.EmitirVendaAssistidaFunc;
import io.cucumber.java.pt.E;
import org.junit.Assert;

public class AssercaoLancamentoContabilVendasAssistidasStep {

    AssercaoLancamentoContabilVendasAssistidasFuncs assercaoLancamentoContabilVendasAssistidasFuncs = new AssercaoLancamentoContabilVendasAssistidasFuncs();

    @E("visualizar o lançamento realizado")
    public void visualizarLancamentos() throws InterruptedException {
        assercaoLancamentoContabilVendasAssistidasFuncs.filtrarLancamentos();
        Assert.assertEquals(EmitirVendaAssistidaFunc.numNFEmitida, assercaoLancamentoContabilVendasAssistidasFuncs.assercaoContabilNumFatura());
        Assert.assertEquals("P", assercaoLancamentoContabilVendasAssistidasFuncs.assercaoContabilStatus());
        Assert.assertEquals(EmitirVendaAssistidaFunc.TotalNotaEmitida, assercaoLancamentoContabilVendasAssistidasFuncs.assercaoContabilValorFatura());
    }

}
