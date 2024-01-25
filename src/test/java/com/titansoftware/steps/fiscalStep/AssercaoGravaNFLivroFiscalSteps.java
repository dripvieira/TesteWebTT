package com.titansoftware.steps.fiscalStep;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.funcs.fiscal.livrosFiscais.AcessarModuloRelatorioLivroFiscalSaidaFunc;
import com.titansoftware.funcs.fiscal.livrosFiscais.manutencao.AssercaoGravaNFLivroFiscalFunc;
import com.titansoftware.funcs.fiscal.livrosFiscais.manutencao.EntrarModuloFiscalFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class AssercaoGravaNFLivroFiscalSteps {

    EntrarModuloFiscalFunc entrarModuloFiscalFunc = new EntrarModuloFiscalFunc();
    AcessarModuloRelatorioLivroFiscalSaidaFunc acessarModuloRelatorioLivroFiscalSaidaFunc = new AcessarModuloRelatorioLivroFiscalSaidaFunc();
    AssercaoGravaNFLivroFiscalFunc assercaoGravaNFLivroFiscalFunc = new AssercaoGravaNFLivroFiscalFunc();

    @Então("deve visualizar o número e valor da nota na manutenção dos livros fiscais!")
    public void numeroNF(){
        entrarModuloFiscalFunc.acessarModuloFiscal();
        entrarModuloFiscalFunc.acessarMenuLivroFiscal();
        entrarModuloFiscalFunc.acessarSubMenuManutencaoLivroFiscal();
        assercaoGravaNFLivroFiscalFunc.acessarManutencaoLivroFiscal();
        Assert.assertEquals(EntradaDeNotaFiscalFunc.valorNF, AssercaoGravaNFLivroFiscalFunc.totalBrutoNota);
    }

    @E("entrar no módulo Relatório Livro Fiscal de Saída")

    public void ecessarRalatorioSaidaLivro() throws InterruptedException {

        entrarModuloFiscalFunc.acessarModuloFiscal();

        acessarModuloRelatorioLivroFiscalSaidaFunc.acessarRelatorioSaidaFiscal();

    }


}
