package com.titansoftware.steps.produtosSteps;

import com.titansoftware.funcs.ProdutosFuncs.DescontoProdutoFunc;
import com.titansoftware.funcs.ProdutosFuncs.ModuloProdutosAcessosFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ht.E;
import io.cucumber.java.pt.Então;

import java.util.List;
import java.util.Map;

public class DescontoProdutoStep {

    public String porcentagemDesconto;
    ModuloProdutosAcessosFunc moduloProdutosAcessosFunc = new ModuloProdutosAcessosFunc();
    DescontoProdutoFunc descontoProdutoFunc = new DescontoProdutoFunc();

    @E("inserir desconto ao produto")
    public void inserirValorDesconto(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> usuario = dataTable.asMaps();
        String plu = usuario.get(0).get("Produto");
        String desconto = usuario.get(0).get("Desconto");
        porcentagemDesconto = desconto;
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuProdutos();
        moduloProdutosAcessosFunc.acessarSubMenuProdutos();
        descontoProdutoFunc.inserirDesconto(plu, desconto);

    }

    @Então("validar custo total da nota com desconto")
    public void asssercaoCustoDesconto() {
        descontoProdutoFunc.assercaoDesconto(porcentagemDesconto);
    }
}
