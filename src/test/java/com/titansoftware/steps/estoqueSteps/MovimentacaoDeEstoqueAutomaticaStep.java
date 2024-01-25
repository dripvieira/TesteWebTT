package com.titansoftware.steps.estoqueSteps;

import com.titansoftware.funcs.EstoqueFuncs.ModuloEstoqueAcessosFunc;
import com.titansoftware.funcs.EstoqueFuncs.MovimentacaoDeEstoqueAutomaticaFunc;
import com.titansoftware.funcs.EstoqueFuncs.ValidarQuebraDeEstoqueFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class MovimentacaoDeEstoqueAutomaticaStep {
    MovimentacaoDeEstoqueAutomaticaFunc movimentacaoDeEstoqueAutomaticaFunc = new MovimentacaoDeEstoqueAutomaticaFunc();
    ValidarQuebraDeEstoqueFunc validarQuebraDeEstoqueFunc = new ValidarQuebraDeEstoqueFunc();
    ModuloEstoqueAcessosFunc moduloEstoqueAcessosFunc = new ModuloEstoqueAcessosFunc();

    @E("criar um novo inventário")
    public void criaInventario(DataTable dataTable) {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String prod = usuario.get(0).get("Produto");
        String max = usuario.get(0).get("Max. Lote");
        String desc = usuario.get(0).get("Descrição");
        String loja = usuario.get(0).get("Loja");
        movimentacaoDeEstoqueAutomaticaFunc.gerarInventario(prod, max, desc, loja);
    }

    @E("inserir quantidade contada em estoque")
    public void contaEstoque(DataTable dataTable) {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String prod = usuario.get(0).get("Produto");
        String contador = usuario.get(0).get("Contador");
        String qntdd = usuario.get(0).get("Quantidade_Contada");
        movimentacaoDeEstoqueAutomaticaFunc.contaEstoque(prod, contador, qntdd);
    }

    @E("gerar nota de movimentação automática")
    public void movimentaEstoque(DataTable dataTable) {
        List<Map<String, String>> usuario = dataTable.asMaps();
        Float qntd_contada = Float.valueOf(usuario.get(0).get("Quantidade_Contada"));
        String operacoes = validarQuebraDeEstoqueFunc.analisaOperacao(qntd_contada);
        movimentacaoDeEstoqueAutomaticaFunc.movimentaEstoque(operacoes);
    }

    @Então("realizar a asserção da movimentação de estoque autómatica")
    public void assercaoMovimentacaoAutomatica(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        Float qntd_contada = Float.valueOf(usuario.get(0).get("Quantidade_Contada"));
        String produto = usuario.get(0).get("Produto");
        String loja = usuario.get(0).get("Loja");
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRelatorios();
        moduloEstoqueAcessosFunc.acessarSubMenuEvolucaoEstoque();
        movimentacaoDeEstoqueAutomaticaFunc.resgataEstoqueFinal(produto, loja);
        Assert.assertEquals(MovimentacaoDeEstoqueAutomaticaFunc.qtdContada, movimentacaoDeEstoqueAutomaticaFunc.qntdEstoqueFinal);
    }
}
