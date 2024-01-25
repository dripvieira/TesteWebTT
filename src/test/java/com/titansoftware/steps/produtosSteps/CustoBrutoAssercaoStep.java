package com.titansoftware.steps.produtosSteps;

import com.titansoftware.funcs.ProdutosFuncs.AssercaoValorLiquidoMedioBrutoFunc;
import com.titansoftware.funcs.ProdutosFuncs.ModuloProdutosAcessosFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class CustoBrutoAssercaoStep {
    String brutoInicial;
    String brutoFinal;
    AssercaoValorLiquidoMedioBrutoFunc assercaoValorLiquidoMedioBrutoFunc = new AssercaoValorLiquidoMedioBrutoFunc();
    ModuloProdutosAcessosFunc moduloProdutosAcessosFunc = new ModuloProdutosAcessosFunc();

    @E("coletar o custo bruto do produto")
    public void coletarValorBruto() throws InterruptedException {
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuPrecoVenda();
        moduloProdutosAcessosFunc.acessarSubMenuLinkHistoricoDePreco();
        assercaoValorLiquidoMedioBrutoFunc.pesquisarProduto();
        brutoInicial = assercaoValorLiquidoMedioBrutoFunc.resgatarValorBruto();

    }


    @Então("deve visualizar o custo bruto do produto.")
    public void valoreBruto() throws InterruptedException {
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuPrecoVenda();
        moduloProdutosAcessosFunc.acessarSubMenuLinkHistoricoDePreco();
        assercaoValorLiquidoMedioBrutoFunc.pesquisarProduto();
        brutoFinal = assercaoValorLiquidoMedioBrutoFunc.resgatarValorBruto();
        Assert.assertEquals(brutoInicial, brutoFinal);


    }

}
