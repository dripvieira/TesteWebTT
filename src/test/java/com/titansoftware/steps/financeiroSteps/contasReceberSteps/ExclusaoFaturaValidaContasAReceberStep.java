package com.titansoftware.steps.financeiroSteps.contasReceberSteps;

import com.titansoftware.funcs.financeiro.contasReceberFuncs.ExclusaoFaturaValidaContasAReceberFunc;
import io.cucumber.java.pt.Então;

public class ExclusaoFaturaValidaContasAReceberStep {

    ExclusaoFaturaValidaContasAReceberFunc exclusaoFaturaValidaContasAReceberFunc = new ExclusaoFaturaValidaContasAReceberFunc();


    @Então("validar status {string} no titulo contas a receber")
    public void validarContasAReceberExclusaoFatura(String expected) {
        exclusaoFaturaValidaContasAReceberFunc.validarStatusContasAReceber(expected);
    }
}
