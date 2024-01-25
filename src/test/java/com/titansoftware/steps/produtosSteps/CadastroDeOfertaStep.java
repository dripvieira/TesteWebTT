package com.titansoftware.steps.produtosSteps;

import com.titansoftware.funcs.ProdutosFuncs.CadastroDeOfertasFunc;
import com.titansoftware.funcs.ProdutosFuncs.ModuloProdutosAcessosFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

public class CadastroDeOfertaStep {
    ModuloProdutosAcessosFunc moduloProdutosAcessosFunc = new ModuloProdutosAcessosFunc();
    CadastroDeOfertasFunc cadastroDeOfertasFunc = new CadastroDeOfertasFunc();

    @Quando("estiver na tela de preço de ofertas")
    public void acessarPrecoDeOfertas() throws InterruptedException {
        moduloProdutosAcessosFunc.acessarModuloProdutos();
        moduloProdutosAcessosFunc.acessarMenuPrecoVenda();
        moduloProdutosAcessosFunc.acessarSubMenuOfertas();
    }

    @E("inserir os dados da oferta")
    public void inserirDadosDaOferta() {
        cadastroDeOfertasFunc.inserirDadosOferta();
    }

}
