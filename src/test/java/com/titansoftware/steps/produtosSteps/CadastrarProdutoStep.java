package com.titansoftware.steps.produtosSteps;


import com.titansoftware.funcs.ProdutosFuncs.CadastrarProdutoFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CadastrarProdutoStep {
    CadastrarProdutoFunc cadastrarProdutoFunc = new CadastrarProdutoFunc();

    public static String eanCadastrado;

    @Quando("estiver na tela de manutenção de produtos")
    public void selecionarSubmenuManutençãoDeProdutos() throws InterruptedException {
        cadastrarProdutoFunc.acessarModuloProdutos();
        cadastrarProdutoFunc.acessarMenuProdutos();
        cadastrarProdutoFunc.acessarSubMenuProdutos();
        cadastrarProdutoFunc.acessarManutencaoDeProdutos();

    }


    @E("inserir os dados do produto")
    public void inserirDadosDoProduto(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String tipoPLU = usuario.get(0).get("Tipo_PLU");
        String tipoProduto = usuario.get(0).get("Tipo_Produto");
        String descricaoCurta = usuario.get(0).get("Descrição_curta");
        String descricaoComercial = usuario.get(0).get("Descrição_comercial");
        String descricaoTecnica = usuario.get(0).get("Descrição_tecnica");
        String referencia = usuario.get(0).get("Referencia");
        String classificaçãoMercadologica = usuario.get(0).get("Classificação_Mercadologica");
        String fornecedorPrincipal = usuario.get(0).get("Fornecedor_principal");
        String divisao = usuario.get(0).get("Divisão");
        String etiqueta = usuario.get(0).get("Etiqueta");
        String etiquetaFacing = usuario.get(0).get("Etiqueta_facing");
        String mixDeProdutos = usuario.get(0).get("Mix_de_produtos");
        String prazoDeEntrega = usuario.get(0).get("Prazo_de_entrega");
        String volume = usuario.get(0).get("Volume");
        String pesoBruto = usuario.get(0).get("Peso_bruto");
        String pesoLiquido = usuario.get(0).get("Peso_liquido");
        cadastrarProdutoFunc.inserirDadosDoProduto(tipoPLU, tipoProduto, descricaoCurta, descricaoComercial, descricaoTecnica, referencia, classificaçãoMercadologica, fornecedorPrincipal, divisao, etiqueta, etiquetaFacing, mixDeProdutos, prazoDeEntrega, volume, pesoBruto, pesoLiquido);
        eanCadastrado = cadastrarProdutoFunc.eanCadastrado();
        cadastrarProdutoFunc.inserirProduto();
    }


    @Então("deve visualizar  o EAN na tela de consulta!!!")
    public void deveVisualizarNumeroEAN() {
        cadastrarProdutoFunc.filtrarProduto();
        Assert.assertEquals(cadastrarProdutoFunc.vizualizaEANProduto(), eanCadastrado);
    }
}

