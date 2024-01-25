package com.titansoftware.steps.produtosSteps;

import com.titansoftware.funcs.ProdutosFuncs.AssercaoValorLiquidoMedioBrutoFunc;
import com.titansoftware.funcs.ProdutosFuncs.ModuloProdutosAcessosFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class CustoLiquidoAssercaoStep {
    String liquidoInicial;
    String liquidoFinal;
    AssercaoValorLiquidoMedioBrutoFunc assercaoValorLiquidoMedioBrutoFunc = new AssercaoValorLiquidoMedioBrutoFunc();
    ModuloProdutosAcessosFunc moduloProdutosAcessosFunc = new ModuloProdutosAcessosFunc();

    @E("coletar o custo líquido do produto")
    public void coletarValorLiquido() throws InterruptedException {
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuPrecoVenda();
        moduloProdutosAcessosFunc.acessarSubMenuLinkHistoricoDePreco();
        assercaoValorLiquidoMedioBrutoFunc.pesquisarProduto();
        liquidoInicial = assercaoValorLiquidoMedioBrutoFunc.resgatarValorLiquido();

    }


    @Então("deve visualizar o custo líquido do produto.")
    public void valorLiquido() throws InterruptedException {
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuPrecoVenda();
        moduloProdutosAcessosFunc.acessarSubMenuLinkHistoricoDePreco();
        assercaoValorLiquidoMedioBrutoFunc.pesquisarProduto();
        liquidoFinal = assercaoValorLiquidoMedioBrutoFunc.resgatarValorLiquido();
        Assert.assertEquals(liquidoFinal, liquidoInicial);
    }

}
