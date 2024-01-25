package com.titansoftware.pages.faturamentoPages;

import org.openqa.selenium.By;

public class EmitirVendaAssistidaPage {

    By filtrarPor = By.id("filterField");
    By valorFiltro = By.id("filterValor");
    By btnFiltrar = By.xpath("//input[@id='btFilter']");
    By AlterarVenda = By.xpath("//img[@title='Alterar']");
    By MensagemOk = By.xpath("//input[@class='btOkMsgBox']");
    By serieNF = By.xpath("//select[@id='nfserie']");
    By emitirVenda = By.id("emitirNF");
    By resgatartotalNF = By.id("spn_total");
    By selecionarImpressora = By.xpath("//input[@value='PDFCreator']");
    By confirmar = By.id("btDialogBox_0");
    By resgatarPedido = By.xpath("//*[@id=\"LstNF\"]/tbody/tr/td[5]");
    By titulo = By.xpath("//table[@id=\"LstNF\"]/tbody/tr/td[6]");
    By resgatarStatus = By.xpath("//table[@id=\"LstNF\"]/tbody/tr/td[14]");
    By resgatarValor = By.xpath("//table[@id=\"LstNF\"]/tbody/tr/td[15]");
    By inputPedido = By.xpath("//input[@id='fText']");
    By desabilitarFiltro = By.xpath("/html/body/div[8]/form/div[1]/div[2]/fieldset/legend/a");
    By botaoFiltrar = By.xpath("//input[@onclick='Filtrar();']");
    By resgatarStatusVA = By.id("status_0");
    By acessarFramePadrao = By.id("Dir");
    By waitDivTudo = By.id("tudo");
    By esperarCarregamento = By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']");

    public By getFiltrarPor() {
        return filtrarPor;
    }

    public By getValorFiltro() {
        return valorFiltro;
    }

    public By getBtnFiltrar() {
        return btnFiltrar;
    }

    public By getAlterarVenda() {
        return AlterarVenda;
    }

    public By getMensagemOk() {
        return MensagemOk;
    }

    public By getSerieNF() {
        return serieNF;
    }

    public By getEmitirVenda() {
        return emitirVenda;
    }

    public By getResgatartotalNF() {
        return resgatartotalNF;
    }

    public By getSelecionarImpressora() {
        return selecionarImpressora;
    }

    public By getConfirmar() {
        return confirmar;
    }

    public By getResgatarPedido() {
        return resgatarPedido;
    }

    public By getTitulo() {
        return titulo;
    }

    public By getResgatarStatus() {
        return resgatarStatus;
    }

    public By getResgatarValor() {
        return resgatarValor;
    }

    public By getInputPedido() {
        return inputPedido;
    }

    public By getDesabilitarFiltro() {
        return desabilitarFiltro;
    }

    public By getBotaoFiltrar() {
        return botaoFiltrar;
    }

    public By getResgatarStatusVA() {
        return resgatarStatusVA;
    }

    public By getAcessarFramePadrao() {
        return acessarFramePadrao;
    }

    public By getWaitDivTudo() {
        return waitDivTudo;
    }

    public By getEsperarCarregamento() {
        return esperarCarregamento;
    }
}
