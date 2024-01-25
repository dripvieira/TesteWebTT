package com.titansoftware.steps.produtosSteps;

import com.titansoftware.funcs.ProdutosFuncs.AssercaoProdutoEstoqueFunc;
import com.titansoftware.funcs.ProdutosFuncs.AssercaoValorLiquidoMedioBrutoFunc;
import com.titansoftware.funcs.ProdutosFuncs.ModuloProdutosAcessosFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class CustoMedioAssercaoStep {
    String medio;
    String quantidadeInicial;
    String medioFinal;
    String quantidadeFinal;
    AssercaoValorLiquidoMedioBrutoFunc assercaoValorLiquidoMedioBrutoFunc = new AssercaoValorLiquidoMedioBrutoFunc();
    AssercaoProdutoEstoqueFunc assercaoProdutoEstoqueFunc = new AssercaoProdutoEstoqueFunc();
    ModuloProdutosAcessosFunc moduloProdutosAcessosFunc = new ModuloProdutosAcessosFunc();

    @E("coletar o custo médio do produto")
    public void coletarValorMedio() throws InterruptedException {
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuPrecoVenda();
        moduloProdutosAcessosFunc.acessarSubMenuLinkHistoricoDePreco();
        assercaoValorLiquidoMedioBrutoFunc.pesquisarProduto();
        medio = assercaoValorLiquidoMedioBrutoFunc.resgatarValorMedio();
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuProdutos();
        moduloProdutosAcessosFunc.acessarSubMenuProdutos();
        assercaoProdutoEstoqueFunc.consultarProdutoEstoqueInicial();
        quantidadeInicial = assercaoProdutoEstoqueFunc.estoqueInicial();
    }


    @Então("deve visualizar o custo médio do produto.")
    public void valorMedio() throws InterruptedException {

        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuPrecoVenda();
        moduloProdutosAcessosFunc.acessarSubMenuLinkHistoricoDePreco();
        assercaoValorLiquidoMedioBrutoFunc.pesquisarProduto();
        medioFinal = assercaoValorLiquidoMedioBrutoFunc.resgatarValorMedio();
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuProdutos();
        moduloProdutosAcessosFunc.acessarSubMenuProdutos();
        assercaoProdutoEstoqueFunc.consultarProdutoEstoqueInicial();
        quantidadeFinal = assercaoProdutoEstoqueFunc.estoqueInicial();

        float quantidadeInicialF = Float.parseFloat(quantidadeInicial.replaceAll("\\.", "").replaceAll(",", "."));
        float medioFinalF = Float.parseFloat(medioFinal.replaceAll("\\.", "").replaceAll(",", "."));
        float quantidadeFinalF = Float.parseFloat(quantidadeFinal.replaceAll("\\.", "").replaceAll(",", "."));
        float medioF = Float.parseFloat(medio.replaceAll("\\.", "").replaceAll(",", "."));

        float valorTotalIncial = quantidadeInicialF * medioF;
        float mediaCalculada = (valorTotalIncial + 10) / quantidadeFinalF;
        float delta = 0.099f;
        Assert.assertEquals(mediaCalculada, medioFinalF, delta);

    }

}