package com.titansoftware.steps.produtosSteps;

import com.titansoftware.funcs.ProdutosFuncs.GravacaoCustoReceitaFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class GravacaoCustoReceitaStep {
    GravacaoCustoReceitaFunc gravacaoCustoReceitaFunc = new GravacaoCustoReceitaFunc();

    @Quando("estiver na tela de receita de produtos")
    public void acessarReceitaProdutos() throws InterruptedException {
        gravacaoCustoReceitaFunc.acessarTelaReceita();
        gravacaoCustoReceitaFunc.incluirReceita();

    }

    @E("inserir os dados da receita")
    public void inserirDadosReceita(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String quantidade = usuario.get(0).get("Quantidade");
        String caloria = usuario.get(0).get("Caloria");
        String proteina = usuario.get(0).get("Proteína");
        String gordura = usuario.get(0).get("Gordura");
        String gordurasSaturadas = usuario.get(0).get("Gorduras Saturadas");
        String colesterol = usuario.get(0).get("Colesterol");
        String fibraAlimentar = usuario.get(0).get("Fibra Alimentar");
        String calcio = usuario.get(0).get("Cálcio");
        String ferro = usuario.get(0).get("Ferro");
        String sodio = usuario.get(0).get("Sódio");
        String gorduraTrans = usuario.get(0).get("Gordura Trans");
        String pLUCaFe = usuario.get(0).get("PLU Café");
        String quantCafe = usuario.get(0).get("Quant Café");
        String pLUAgua = usuario.get(0).get("PLU Água");
        String quantAgua = usuario.get(0).get("Quant Água");
        String pLUAcucar = usuario.get(0).get("PLU Açucar");
        String quantAcucar = usuario.get(0).get("Quant Açucar");
        gravacaoCustoReceitaFunc.inserirDadosReceita(quantidade, caloria, proteina, gordura, gordurasSaturadas, colesterol, fibraAlimentar, calcio, ferro, sodio, gorduraTrans, pLUCaFe, quantCafe, pLUAgua, quantAgua, pLUAcucar, quantAcucar);
    }

    @Então("deve visualizar  a receita criada com sucesso!!!")
    public void visualizarreceitacriada() throws InterruptedException {
        gravacaoCustoReceitaFunc.acessarTelaReceita();
        Assert.assertEquals(GravacaoCustoReceitaFunc.receita, gravacaoCustoReceitaFunc.filtrarReceita());
    }
}
