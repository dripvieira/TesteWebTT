package com.titansoftware.steps.financeiroSteps.contasReceberSteps;

import com.titansoftware.funcs.financeiro.contasReceberFuncs.ModuloContasReceberFunc;
import com.titansoftware.funcs.financeiro.contasReceberFuncs.TituloVendasAssistidasFunc;
import com.titansoftware.funcs.vendasAssistidasFuncs.PedidoVendasFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class TituloVendasAssistidasStep {
    TituloVendasAssistidasFunc tituloVendasAssistidasFunc = new TituloVendasAssistidasFunc();

    ModuloContasReceberFunc moduloContasReceberFunc = new ModuloContasReceberFunc();


    @E("entrar no módulo contas à receber")
    public void validarTitulos() {
        moduloContasReceberFunc.acessarModuloFinanceiro();
        moduloContasReceberFunc.acessarMenuContasAReceber();
        moduloContasReceberFunc.acessarSubMenuManutencaoTitulos();
    }

    @E("consultar o titulo no contas a receber")
    public void ConsultarTituloNoContasAReceber() {
        tituloVendasAssistidasFunc.consultarTituloNoContasAreceber();
    }

    @E("baixar titulo financeiro")
    public void baixarTitulos() {
        tituloVendasAssistidasFunc.consultarTituloNoContasAreceber();
        tituloVendasAssistidasFunc.baixaTituloVendasAssistidas();
    }

    @Então("deve visualizar os dados do título")
    public void assercaoDadosTitulo() {
        tituloVendasAssistidasFunc.assercaoContasAReceber();
        Assert.assertEquals(TituloVendasAssistidasFunc.titulo, TituloVendasAssistidasFunc.resgatarNumTitulo);
        Assert.assertEquals(PedidoVendasFunc.valorVendasAssistidas, TituloVendasAssistidasFunc.resgatarValorTitulo);
        Assert.assertEquals("P", TituloVendasAssistidasFunc.resgatarStatusTitutlo);
    }
}
