package com.titansoftware.pages.ContabilPages;

import org.openqa.selenium.By;

public class AssercaoLancamentoContabilVendasAssistidasPages {

    By filtroLoja = By.xpath("//select[@id='emitente']");
    By filtroOperacao = By.xpath("//select[@id='fField']");
    By filtroCondicao = By.xpath("//select[@id='fOp']");
    By inserirDados = By.xpath("//input[@id='fText']");
    By dataInicial = By.xpath("//input[@id='dti']");
    By dataFinal = By.xpath("//input[@id='dtf']");
    By botaoFiltrar = By.id("filtrar");

    public By getFiltroLoja() {
        return filtroLoja;
    }

    public By getFiltroOperacao() {
        return filtroOperacao;
    }

    public By getFiltroCondicao() {
        return filtroCondicao;
    }

    public By getInserirDados() {
        return inserirDados;
    }

    public By getDataInicial() {
        return dataInicial;
    }

    public By getDataFinal() {
        return dataFinal;
    }

    public By getBotaoFiltrar() {
        return botaoFiltrar;
    }

    By numFatura = By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[3]");
    By status = By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[9]");
    By ValorFatura = By.xpath("//th[@id='thTotalPagina']");

    public By getNumFatura() {
        return numFatura;
    }

    public By getStatus() {
        return status;
    }

    public By getValorFatura() {
        return ValorFatura;
    }
}
