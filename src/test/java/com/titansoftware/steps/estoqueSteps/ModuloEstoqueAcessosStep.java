package com.titansoftware.steps.estoqueSteps;

import com.titansoftware.funcs.EstoqueFuncs.ModuloEstoqueAcessosFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

public class ModuloEstoqueAcessosStep {

    ModuloEstoqueAcessosFunc moduloEstoqueAcessosFunc = new ModuloEstoqueAcessosFunc();


    public void acessarNotaFiscal20() throws InterruptedException {
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRecebimento();
        moduloEstoqueAcessosFunc.acessarSubMenuNotaFiscal2();
    }

    public void acessarEvolucaoEstoque() throws InterruptedException {
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRelatorios();
        moduloEstoqueAcessosFunc.acessarSubMenuEvolucaoEstoque();
    }

    @E("estiver na tela de movimentação de estoque")
    public void acessarMovimentacaoEstoque() throws InterruptedException {
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRecebimento();
        moduloEstoqueAcessosFunc.acessarSubMenuMovimentacaoEstoque();
    }

    @Quando("estiver na tela de inventário")
    public void acessarInventario() throws InterruptedException {
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuInventario();
        moduloEstoqueAcessosFunc.acessarSubMenuInventario();
    }
}
