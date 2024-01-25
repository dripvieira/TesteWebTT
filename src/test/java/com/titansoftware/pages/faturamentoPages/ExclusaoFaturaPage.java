package com.titansoftware.pages.faturamentoPages;

import org.openqa.selenium.By;

public class ExclusaoFaturaPage {

    By acessarFramePadrao = By.id("Dir");
    By waitDivTudo = By.id("tudo");
    By esperarCarregamento = By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']");
    By filtroOperacao = By.xpath("//select[@name='filterFatNf[op]']");
    By clicarMsg = By.id("btDialogBox_0");
    By ClicarCancelarNF = By.xpath("//input[@value='Cancelar Nota Fiscal Eletrônica']");
    By campoFiltro = By.xpath("//input[@id='filterValor']");
    By selectFiltro = By.xpath("//select[@id='filterField']");
    By btnFiltrar = By.xpath("//input[@id='btFilter']");
    By btnConsulta = By.xpath("/html/body/form[1]/table/tbody/tr/td[2]/img[1]");

    public By getAcessarFramePadrao() {
        return acessarFramePadrao;
    }

    public By getWaitDivTudo() {
        return waitDivTudo;
    }

    public By getEsperarCarregamento() {
        return esperarCarregamento;
    }

    public By getFiltroOperacao() {
        return filtroOperacao;
    }

    public By getClicarMsg() {
        return clicarMsg;
    }

    public By getClicarCancelarNF() {
        return ClicarCancelarNF;
    }

    public By getCampoFiltro() {
        return campoFiltro;
    }

    public By getSelectFiltro() {
        return selectFiltro;
    }

    public By getBtnFiltrar() {
        return btnFiltrar;
    }

    public By getBtnConsulta() {
        return btnConsulta;
    }
}
