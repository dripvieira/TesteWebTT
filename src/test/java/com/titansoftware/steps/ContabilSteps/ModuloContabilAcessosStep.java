package com.titansoftware.steps.ContabilSteps;

import com.titansoftware.funcs.ContabilFuncs.ModuloContabilAcessosFuncs;
import io.cucumber.java.pt.Então;

public class ModuloContabilAcessosStep {

    ModuloContabilAcessosFuncs moduloContabilAcessosFuncs = new ModuloContabilAcessosFuncs();

    @Então("deve acessar os lançamentos no módulo contábil")
    public void assercaoLancamentoContabil() throws InterruptedException {
        moduloContabilAcessosFuncs.acessarModuloContabil();
        moduloContabilAcessosFuncs.AcessarMenuContabilidade();
        moduloContabilAcessosFuncs.acessarSubMenuLancamentoContabil();
    }
}
