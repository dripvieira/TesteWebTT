package com.titansoftware.steps.fiscalStep.RelatoriosSteps;

import com.titansoftware.funcs.fiscal.RelatoriosFuncs.AssercaoSaidaLivroFiscalFunc;
import com.titansoftware.funcs.fiscal.livrosFiscais.AcessarModuloRelatorioLivroFiscalSaidaFunc;
import io.cucumber.java.it.E;
import io.cucumber.java.pt.Então;

public class AssercaoSaidaLivroFiscalStep {

    AssercaoSaidaLivroFiscalFunc assercaoSaidaLivroFiscalFunc = new AssercaoSaidaLivroFiscalFunc();
    AcessarModuloRelatorioLivroFiscalSaidaFunc acessarModuloRelatorioLivroFiscalSaidaFunc = new AcessarModuloRelatorioLivroFiscalSaidaFunc();


    @E("entrar no módulo  Relatório Livro Fiscal de Saída")
    public void ecessarRalatorioSaidaLivro() throws InterruptedException {
        acessarModuloRelatorioLivroFiscalSaidaFunc.acessarRelatorioSaidaFiscal();
    }

    @Então("deve visualizar a numero de série e total bruto no relatório de saída livro fiscal")
    public void realizarAsercao() {
        assercaoSaidaLivroFiscalFunc.assercaoRelatorioFiscalSaida();
    }
}
