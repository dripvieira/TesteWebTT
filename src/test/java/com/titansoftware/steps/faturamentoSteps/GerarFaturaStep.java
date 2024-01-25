package com.titansoftware.steps.faturamentoSteps;

import com.titansoftware.funcs.faturamentoFuncs.GerarFaturaFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;

import java.util.List;
import java.util.Map;

public class GerarFaturaStep {

    GerarFaturaFunc gerarFaturaFunc = new GerarFaturaFunc();

    @E("inserir os dados da Nota Fiscal e gerar uma fatura")
    public void gerarFatura(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        String codigo = data.get(0).get("Código");
        gerarFaturaFunc.incluirFatura();
        gerarFaturaFunc.tipoDeFatura(codigo);
        gerarFaturaFunc.tipoProduto(data);
        gerarFaturaFunc.validarFatura();
        gerarFaturaFunc.filtrarFatura();
        gerarFaturaFunc.baixarAnexo();
    }

    @E("inserir o código do cliente")
    public void inserirCodigoCliente(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        String codigo = data.get(0).get("Código");
        gerarFaturaFunc.incluirFatura();
        gerarFaturaFunc.tipoDeFatura(codigo);

    }

    @E("iserir os dados do produto")
    public void iserirDadosDoProduto(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        gerarFaturaFunc.tipoProduto(data);
        gerarFaturaFunc.validarFatura();
        gerarFaturaFunc.filtrarFatura();
        gerarFaturaFunc.baixarAnexo();
    }
}
