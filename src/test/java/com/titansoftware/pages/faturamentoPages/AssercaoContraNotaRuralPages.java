package com.titansoftware.pages.faturamentoPages;

import org.openqa.selenium.By;

public class AssercaoContraNotaRuralPages {
    By selectLoja = By.id("filterStore");

    By serieNF = By.xpath("//select[@id='nfserie']");

    By selectFiltrarPor = By.id("filterField");

    public By getSelectLoja() {
        return selectLoja;
    }

    By operacao = By.id("filterOp");

    public By getSelectFiltrarPor() {
        return selectFiltrarPor;
    }

    By valor = By.id("filterValor");

    public By getOperacao() {
        return operacao;
    }

    By tipoData = By.id("filterData");

    public By getValor() {
        return valor;
    }

    By dataInicial = By.id("filterDtIni");

    public By getTipoData() {
        return tipoData;
    }

    By dataFinal = By.id("filterDtFim");

    public By getDataInicial() {
        return dataInicial;
    }

    By botaoFiltrar = By.id("btFilter");

    public By getDataFinal() {
        return dataFinal;
    }

    By botaoAlterar = By.xpath("/html/body/form[1]/table/tbody/tr[1]/td[2]/img[1]");

    public By getBotaoFiltrar() {
        return botaoFiltrar;
    }

    By clicarMsg = By.xpath("//input[@class='btOkMsgBox']");

    public By getBotaoAlterar() {
        return botaoAlterar;
    }

    public By getClicarMsg() {
        return clicarMsg;
    }

    public By getSerieNF() {
        return serieNF;
    }

    By dataSaida = By.id("data_saida");

    public By getDataSaida() {
        return dataSaida;
    }

    By clicarEmitirNF = By.id("emitirNF");

    public By getClicarEmitirNF() {
        return clicarEmitirNF;
    }

    By confirmar = By.id("btDialogBox_0");

    public By getConfirmar() {
        return confirmar;
    }

    By impressaoPdf = By.xpath("//input[@value='PDFCreator']");

    public By getImpressaoPdf() {
        return impressaoPdf;
    }

    By verificarStatus = By.xpath("/html/body/form[1]/table/tbody/tr[1]/td[14]");

    public By getVerificarStatus() {
        return verificarStatus;
    }
}
