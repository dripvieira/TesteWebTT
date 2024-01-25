package com.titansoftware.steps.estoqueSteps.recebimentoSteps;

import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;

import java.util.List;
import java.util.Map;

public class EntradaDeNotaFiscalComPedidoStep {

    EntradaDeNotaFiscalFunc entradaDeNotaFiscalFunc = new EntradaDeNotaFiscalFunc();


    @E("inserir o  pedido")
    public void inserirOPedido(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String quantidadePedido = usuario.get(0).get("Quantidade_pedido");
        entradaDeNotaFiscalFunc.inserirDadosPedido(quantidadePedido);

    }

}
