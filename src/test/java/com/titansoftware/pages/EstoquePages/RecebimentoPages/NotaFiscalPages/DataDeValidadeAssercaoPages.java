package com.titansoftware.pages.EstoquePages.RecebimentoPages.NotaFiscalPages;

import org.openqa.selenium.By;

public class DataDeValidadeAssercaoPages {

    By acessarRelatorioEstoque = By.xpath("//a[@href='javascript:openProgList(3)']");

    public By getAcessarRelatorioEstoque() {
        return acessarRelatorioEstoque;
    }

    By acessarValidadeDeProdutos = By.xpath("//a[@class='a_stock'][contains(.,'Validade de Produtos')]");

    By dataEmissaoInicial = By.id("periodo_de");

    By selecionarLoja = By.xpath("//select[@name='store[]']");

    public By getSelecionarLoja() {
        return selecionarLoja;
    }

    By codigoProduto = By.id("plus");

    public By getCodigoProduto() {
        return codigoProduto;
    }

    By dataEmissaoFinal = By.id("periodo_para");
    By botaoEnviar = By.id("richiFrameSendButton");
    By selectLoja = By.id("loja");
    By filtrarPor = By.xpath("//select[@name='campo']");
    By condicao = By.xpath("//select[@name='condicao']");
    By dadosFiltro = By.xpath("//input[@name='dados']");
    By logParipassusSucesso = By.xpath("//fieldset[@id=\"block-paripassus\"]/ul/li[1]/label/input");
    By logParipassusErro = By.xpath("//fieldset[@id=\"block-paripassus\"]/ul/li[2]/label/input");
    By botaoFiltrar = By.xpath("//input[@value='Filtrar']");
    By consultarNf = By.xpath("//table[@id=\"listNfs\"]/tbody/tr[1]/td[1]/a");
    By consultarRomaneio = By.id("btnExtratoRoma");
    By resgatarDataDeValidade = By.xpath("//tr[@id=\"tr_red_1\"]/td[11]");
    By desativarParipassus = By.xpath("//input[@value='paripassus']");

    public By getAcessarValidadeDeProdutos() {
        return acessarValidadeDeProdutos;
    }

    public By getBotaoEnviar() {
        return botaoEnviar;
    }

    public By getDataEmissaoInicial() {
        return dataEmissaoInicial;
    }

    public By getDataEmissaoFinal() {
        return dataEmissaoFinal;
    }

    public By getSelectLoja() {
        return selectLoja;
    }

    public By getFiltrarPor() {
        return filtrarPor;
    }

    public By getCondicao() {
        return condicao;
    }

    public By getDadosFiltro() {
        return dadosFiltro;
    }

    public By getLogParipassusSucesso() {
        return logParipassusSucesso;
    }

    public By getDesativarParipassus() {
        return desativarParipassus;
    }

    public By getLogParipassusErro() {
        return logParipassusErro;
    }

    public By getBotaoFiltrar() {
        return botaoFiltrar;
    }

    public By getConsultarNf() {
        return consultarNf;
    }

    public By getConsultarRomaneio() {
        return consultarRomaneio;
    }

    public By getResgatarDataDeValidade() {
        return resgatarDataDeValidade;
    }
}










