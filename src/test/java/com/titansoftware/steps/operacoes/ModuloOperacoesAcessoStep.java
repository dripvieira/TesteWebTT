package com.titansoftware.steps.operacoes;

import com.titansoftware.funcs.operacoes.ModuloOperacoesAcessosFunc;
import io.cucumber.java.pt.E;

public class ModuloOperacoesAcessoStep {
    ModuloOperacoesAcessosFunc moduloOperacoesAcessosFunc = new ModuloOperacoesAcessosFunc();

    @E("acessar o SubMenuCargaPDV")
    public void acessarOSubMenuCargaPDV() throws InterruptedException {
        moduloOperacoesAcessosFunc.acessarModuloOpercaoes();
        moduloOperacoesAcessosFunc.acessarMenuTransacoes();
        moduloOperacoesAcessosFunc.acessarSubMenuCargaXML();
    }
}
