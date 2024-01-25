package com.titansoftware.steps.estoqueSteps;

import com.titansoftware.funcs.EstoqueFuncs.ModuloEstoqueAcessosFunc;
import com.titansoftware.funcs.EstoqueFuncs.ValidarAjusteSobraManualFunc;
import com.titansoftware.funcs.EstoqueFuncs.ValidarQuebraDeEstoqueFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;

import java.util.List;
import java.util.Map;

public class ValidarQuebraDeEstoqueStep {

    ValidarQuebraDeEstoqueFunc validarQuebraDeEstoqueFunc = new ValidarQuebraDeEstoqueFunc();
    ValidarAjusteSobraManualFunc validarAjusteSobraManualFunc = new ValidarAjusteSobraManualFunc();
    ModuloEstoqueAcessosFunc moduloEstoqueAcessosFunc = new ModuloEstoqueAcessosFunc();
    String qntddEstoqueInicial = validarQuebraDeEstoqueFunc.qntdEstoqueInicial;
    String qntddEstoqueFinal = validarQuebraDeEstoqueFunc.qntdEstoque;
    Float init;
    Float fin;
    Float delta;
    Float qProduto;
    public String opr;


    @E("resgatar quantidade inicial de estoque")
    public void quantidadeInicial(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String produtos = usuario.get(0).get("Produto");
        String loja = usuario.get(0).get("Loja");
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRelatorios();
        moduloEstoqueAcessosFunc.acessarSubMenuEvolucaoEstoque();
        validarQuebraDeEstoqueFunc.resgataEstoqueInicial(produtos, loja);
    }

    @E("gerar movimentação de estoque")
    public void geraQuebra(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String processo = usuario.get(0).get("Processo");
        String produto = usuario.get(0).get("Produto");
        String quantidade = usuario.get(0).get("Quantidade");
        String operacoes = usuario.get(0).get("Operações");
        validarQuebraDeEstoqueFunc.realizarQuebra(processo, quantidade, produto, operacoes);
    }

    @E("resgatar quantidade em estoque pós movimentação")
    public void quantidadeFinal(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String produto = usuario.get(0).get("Produto");
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRelatorios();
        moduloEstoqueAcessosFunc.acessarSubMenuEvolucaoEstoque();
        validarQuebraDeEstoqueFunc.filtrarQuebra(produto);
    }

    @Então("realizar a asserção da quantidade em estoque")
    public void assercaoQuebra(DataTable dataTable) {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String qtd = usuario.get(0).get("Quantidade");
        String processo = usuario.get(0).get("Processo");
        String operacao = usuario.get(0).get("Operações");
        validarQuebraDeEstoqueFunc.assercaoMovimentacaoDeEstoque(qtd, processo, operacao);
    }

    @E("gerar ajuste de sobra manual")
    public void sobraEstoque(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String produto = usuario.get(0).get("Produto");
        String quantidade = usuario.get(0).get("Quantidade");
        String operacoes = usuario.get(0).get("Operações");
        validarAjusteSobraManualFunc.validaAjusteSobra(quantidade, produto, operacoes);
    }
}
