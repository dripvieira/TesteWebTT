package com.titansoftware.steps.operacoes;

import com.titansoftware.funcs.operacoes.CargaDeOfertasFunc;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class CargaDeOfertaStep {


    CargaDeOfertasFunc cargaDeOfertasFunc = new CargaDeOfertasFunc();

    @E("gerar uma carga no PDV")
    public void gerarCargaNoPDV() {
        cargaDeOfertasFunc.cargaDeProdutos();
    }

    @Então("deve visualizar a mensagem {string}!!!")
    public void mensagemOferta(String msg) {
        Assert.assertEquals(msg, CargaDeOfertasFunc.msgCarga);
    }
}
