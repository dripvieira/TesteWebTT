package com.titansoftware.pages.produtosPages;

import org.openqa.selenium.By;

public class CadastrarProdutoPages {


    By selecionarModuloProdutos = By.xpath("//a[@id=\"mod_plu\"]");

    By selecionarSubmenuProdutos = By.xpath("//a[@href='javascript:openProgList(0)'][contains(.,'Produtos')]");

    By selecionarManutencaoDeProdutos = By.xpath("//a[@title='Manutenção de Produtos']");

    By incluirProduto = By.xpath("//a[@href='titan_plu.titan.php?mode=upd&key=0&thatpage=1&fField=&fOp=&fText=&inclusao=true']");

    By typePLU = By.id("plu_type");

    By tipoProduto = By.xpath("//select[@onchange='FlagAutomaticaNVenda()']");

    By ean = By.id("ean1");

    By descricaoCurta = By.id("descr_reduzida");

    By descricaoComercial = By.id("descr_comercial");

    By descricaoTecnica = By.xpath("//input[@name='descr_tecnica']");

    By referencia = By.id("referencia");

    By classificacaoMercadologica = By.id("txtDepto");

    By resgatarClassificacaoMercadologiga = By.xpath("//span[@id='depto_descr']");
    By filtrarProdutoPor = By.xpath("//select[@name='fField']");

    By selecionarNBM = By.xpath("//input[@value='0402.21.10 - LEITE INTEGRAL EM PO MATERIA GORDA>1.5% CONCENTR.N/ADOC / 0402.21.0101 - LEITE EM PO INTEGRAL,GORDURA>=26%,N/ADOCICADO - 110 - 110']");

    By confirmarNCM = By.id("btDialogBox_0");

    By fornecedorPrincipal = By.id("txtForn");

    By divisao = By.id("txt_divisao");

    By etiqueta = By.id("tipoEtq");

    By etiquetaFacing = By.id("qtd_etiqueta");

    By prazoDeEntrega = By.id("prazoEntrega");

    By selectUnidadeDeVolume = By.id("unidade_volume");

    By volume = By.xpath("//input[@id='volume']");

    By pesoBruto = By.id("pesoBruto");


    By pesoLiquido = By.id("pesoLiquido");


    By incluirPLU = By.xpath("//input[@id='validButton2']");

    public By getResgatarClassificacaoMercadologiga() {
        return resgatarClassificacaoMercadologiga;
    }

    By inserirDescrição = By.id("fText");

    By filtrarProduto = By.id("btnFilter");

    By vizualizarNumeroEAN = By.xpath("/html/body/div[4]/table/tbody/tr/td[9]");

    By botãoVoltar = By.xpath("//input[@value='Voltar' and parent::div[@id='legend2']]");

    By ean13 = By.id("ean13");

    public By getEan() {
        return ean;
    }

    public By getSelecionarModuloProdutos() {
        return selecionarModuloProdutos;
    }

    public By getSelecionarSubmenuProdutos() {
        return selecionarSubmenuProdutos;
    }

    public By getSelecionarManutencaoDeProdutos() {
        return selecionarManutencaoDeProdutos;
    }

    public By getIncluirProduto() {
        return incluirProduto;
    }

    public By getTypePLU() {
        return typePLU;
    }

    public By getTipoProduto() {
        return tipoProduto;
    }

    public By getDescricaoCurta() {
        return descricaoCurta;
    }

    public By getDescricaoComercial() {
        return descricaoComercial;
    }

    public By getDescricaoTecnica() {
        return descricaoTecnica;
    }

    public By getReferencia() {
        return referencia;
    }

    public By getClassificacaoMercadologica() {
        return classificacaoMercadologica;
    }

    public By getSelecionarNBM() {
        return selecionarNBM;
    }

    public By getConfirmarNCM() {
        return confirmarNCM;
    }

    public By getFornecedorPrincipal() {
        return fornecedorPrincipal;
    }

    public By getDivisao() {
        return divisao;
    }

    public By getEtiqueta() {
        return etiqueta;
    }

    public By getEtiquetaFacing() {
        return etiquetaFacing;
    }

    By mixDeProduto = By.id("mix");

    public By getMixDeProduto() {
        return mixDeProduto;
    }

    public By getPrazoDeEntrega() {
        return prazoDeEntrega;
    }

    public By getSelectUnidadeDeVolume() {
        return selectUnidadeDeVolume;
    }

    public By getVolume() {
        return volume;
    }

    public By getPesoBruto() {
        return pesoBruto;
    }

    public By getPesoLiquido() {
        return pesoLiquido;
    }


    public By getIncluirPLU() {
        return incluirPLU;
    }


    public By getFiltrarProdutoPor() {
        return filtrarProdutoPor;
    }

    public By getInserirEAN() {
        return inserirDescrição;
    }

    public By getFiltrarProduto() {
        return filtrarProduto;
    }

    public By getVizualizarNumeroEAN() {
        return vizualizarNumeroEAN;
    }

    public By getBotãoVoltar() {
        return botãoVoltar;
    }

    public By getEan13() {
        return ean13;
    }

    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }
}
