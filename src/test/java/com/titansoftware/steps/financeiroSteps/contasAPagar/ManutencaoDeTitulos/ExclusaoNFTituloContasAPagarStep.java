package com.titansoftware.steps.financeiroSteps.contasAPagar.ManutencaoDeTitulos;

import com.titansoftware.funcs.financeiro.contatasAPagar.ExclusaoNFTituloContasAPagarFunc;
import io.cucumber.java.pt.Então;

public class ExclusaoNFTituloContasAPagarStep {

    ExclusaoNFTituloContasAPagarFunc exclusaoNFTituloContasAPagarFunc = new ExclusaoNFTituloContasAPagarFunc();


    @Então("validar status na tela contas à pagar")
    public void validaStatusTitulo() throws InterruptedException {
        exclusaoNFTituloContasAPagarFunc.buscaStatusTituloContasAPagar();
        exclusaoNFTituloContasAPagarFunc.filtrarExcluida();
        exclusaoNFTituloContasAPagarFunc.assercaoStatusTitulo();
    }

}
