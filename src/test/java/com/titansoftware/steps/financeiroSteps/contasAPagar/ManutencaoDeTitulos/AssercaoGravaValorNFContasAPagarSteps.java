package com.titansoftware.steps.financeiroSteps.contasAPagar.ManutencaoDeTitulos;

import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.funcs.financeiro.ModuloFinanceiroAcessosFuncs;
import com.titansoftware.funcs.financeiro.contatasAPagar.manutencaoDeTitulos.AssercaoGravaValorNFContasAPagarFunc;
import io.cucumber.java.an.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class AssercaoGravaValorNFContasAPagarSteps {


    AssercaoGravaValorNFContasAPagarFunc assercaoGravaValorNFContasAPagarFunc = new AssercaoGravaValorNFContasAPagarFunc();
    ModuloFinanceiroAcessosFuncs moduloFinanceiroAcessosFuncs = new ModuloFinanceiroAcessosFuncs();

    public AssercaoGravaValorNFContasAPagarSteps() {
    }

    @Então("deve visualizar o valor da nota na tela de contas a pagar!")
    public void valorNF() throws InterruptedException {
        moduloFinanceiroAcessosFuncs.acessarModuloFinanceiro();
        moduloFinanceiroAcessosFuncs.acessarMenuContasAPagar();
        moduloFinanceiroAcessosFuncs.acessarSubMenuManutencaoDeTitulo();
        Assert.assertEquals(EntradaDeNotaFiscalFunc.valorNF, assercaoGravaValorNFContasAPagarFunc.ConsultarValorNF());
    }

    @E("validar status no meio do processo")
    public void validaStatusMeio() throws InterruptedException {
        moduloFinanceiroAcessosFuncs.acessarModuloFinanceiro();
        moduloFinanceiroAcessosFuncs.acessarMenuContasAPagar();
        moduloFinanceiroAcessosFuncs.acessarSubMenuManutencaoDeTitulo();
        Assert.assertEquals(EntradaDeNotaFiscalFunc.valorNF, assercaoGravaValorNFContasAPagarFunc.ConsultarValorNF());
    }


}