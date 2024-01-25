package com.titansoftware.steps.estoqueSteps.recebimentoSteps;

import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.funcs.ProdutosFuncs.AssercaoProdutoEstoqueFunc;
import com.titansoftware.funcs.ProdutosFuncs.ModuloProdutosAcessosFunc;
import com.titansoftware.steps.vendasAssistidasSteps.PedidoVendasStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AsserçãoProdutosEstoqueStep {

    String inicial;
    String fin;

    ModuloProdutosAcessosFunc moduloProdutosAcessosFunc = new ModuloProdutosAcessosFunc();

    AssercaoProdutoEstoqueFunc assercaoProdutoEstoqueFunc = new AssercaoProdutoEstoqueFunc();

    @E("coletar a quantidade em estoque")
    public void coletarQuantidadeEstoque() throws InterruptedException {
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuProdutos();
        moduloProdutosAcessosFunc.acessarSubMenuProdutos();
        assercaoProdutoEstoqueFunc.consultarProdutoEstoqueInicial();
        inicial = assercaoProdutoEstoqueFunc.estoqueInicial();
    }


    @Então("deve visualizar a quantidade em estoque na tela de estoque!")
    public void quantidadeEmEstoque() throws InterruptedException {
        assercaoProdutoEstoqueFunc.consultarProdutoEstoqueFinal();
        fin = assercaoProdutoEstoqueFunc.estoqueFinal();
        float init = Float.parseFloat(inicial.replaceAll("\\.", "").replaceAll(",", "."));
        float qProduto = Float.parseFloat(EntradaDeNotaFiscalFunc.quantidadeProduto);
        float end = Float.parseFloat(fin.replaceAll("\\.", "").replaceAll(",", "."));
        float delta = 0.001f;
        Assert.assertEquals(init + qProduto, end, delta);
    }

    @E("visualizar a quantidade em estoque após exclusão no recebimento")
    public void qntddEstoqueMeioRecebimento() {
        assercaoProdutoEstoqueFunc.consultarProdutoEstoqueFinal();
        fin = assercaoProdutoEstoqueFunc.estoqueFinal();
        float init = Float.parseFloat(inicial.replaceAll("\\.", "").replaceAll(",", "."));
        float qProduto = Float.parseFloat(EntradaDeNotaFiscalFunc.quantidadeProduto);
        float end = Float.parseFloat(fin.replaceAll("\\.", "").replaceAll(",", "."));
        float delta = 0.001f;
        Assert.assertEquals(init + qProduto, end, delta);
    }

    @Então("deve visualizar a quantidade em estoque!")
    public void quantidadeEmEstoqueAssercao() throws InterruptedException {
        assercaoProdutoEstoqueFunc.consultarProdutoEstoqueFinal();
        fin = assercaoProdutoEstoqueFunc.estoqueFinal();
        float quantidade = Float.parseFloat(PedidoVendasStep.quantidadePedido);
        float init = Float.parseFloat(inicial.replaceAll("\\.", "").replaceAll(",", "."));
        //float qProduto = Float.parseFloat(EntradaDeNotaFiscalFunc.quantidadeProduto);
        float end = Float.parseFloat(fin.replaceAll("\\.", "").replaceAll(",", "."));
        float delta = 0.001f;
        Assert.assertEquals(init - quantidade, end, delta);
    }

    @Então("deve visualizar quantidade baixada em estoque!")
    public void baixaQuantidadeEstoque() throws InterruptedException {
        assercaoProdutoEstoqueFunc.consultarProdutoEstoqueFinal();
        fin = assercaoProdutoEstoqueFunc.estoqueFinal();
        float init = Float.parseFloat(inicial.replaceAll("\\.", "").replaceAll(",", "."));
        float end = Float.parseFloat(fin.replaceAll("\\.", "").replaceAll(",", "."));
        float delta = 0.001f;
        Assert.assertEquals(init, end, delta);
    }

    @E("visualizar a quantidade em estoque após exclusão da fatura")
    public void qntddEstoqueMeioFaturamento(DataTable dataTable) {
        List<Map<String, String>> usuario = dataTable.asMaps();
        assercaoProdutoEstoqueFunc.consultarProdutoEstoqueFinal();
        fin = assercaoProdutoEstoqueFunc.estoqueFinal();
        float init = Float.parseFloat(inicial.replaceAll("\\.", "").replaceAll(",", "."));
        String quantidade = usuario.get(0).get("Quantidade");
        float qProduto = Float.parseFloat(quantidade.replaceAll("\\.", "").replaceAll(",", "."));
        float end = Float.parseFloat(fin.replaceAll("\\.", "").replaceAll(",", "."));
        float posNota = init - qProduto;
        float delta = 0.001f;
        Assert.assertEquals(posNota, end, delta);
    }

}

