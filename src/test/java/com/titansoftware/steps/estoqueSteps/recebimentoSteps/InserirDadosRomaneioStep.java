package com.titansoftware.steps.estoqueSteps.recebimentoSteps;

import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;

import java.util.List;
import java.util.Map;

public class InserirDadosRomaneioStep {
    EntradaDeNotaFiscalFunc entradaDeNotaFiscalFunc = new EntradaDeNotaFiscalFunc();

    @E("inserir dados incorretos de Romaneio")
    public void dadosIncorretosDeRomaneio(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> romaneio = dataTable.asMaps();
        String quantidadeRomaneio = romaneio.get(0).get("Quantidade_Romaneio");
        String validadeRomaneio = romaneio.get(0).get("Validade_Romaneio");
        entradaDeNotaFiscalFunc.inserirDadosRomaneio(romaneio);
    }

}
