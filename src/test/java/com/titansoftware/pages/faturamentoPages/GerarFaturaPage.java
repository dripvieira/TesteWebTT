package com.titansoftware.pages.faturamentoPages;

import org.openqa.selenium.By;

public class GerarFaturaPage {

    By tudo = By.id("tudo");

    public By getTudo() {
        return tudo;
    }

    By loadObjeto = By.id("carregando_loadObject");

    public By getLoadObjeto() {
        return loadObjeto;
    }

    By load = By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left']");

    public By getLoad() {
        return load;
    }

    By incluirFatura = By.xpath("//img[@title='Inserir NF não conjugada']");

    public By getIncluirFatura() {
        return incluirFatura;
    }

    By tipoCliente = By.xpath("//select[@name='dest_tipo']");

    public By getTipoCliente() {
        return tipoCliente;
    }

    By tipoEndereco = By.xpath("//select[@name='dest_ende_tipo']");

    public By getTipoEndereco() {
        return tipoEndereco;
    }

    By inputCodigo = By.xpath("//input[@name='dest_key']");

    public By getInputCodigo() {
        return inputCodigo;
    }

    By tipoNF = By.xpath("//select[@name='tipo_nota']");

    public By getTipoNF() {
        return tipoNF;
    }

    By serie = By.xpath("//select[@name='nfserie']");

    public By getSerie() {
        return serie;
    }

    By totalItens = By.xpath("//span[@id='spn_total_itens']");

    public By getTotalItens() {
        return totalItens;
    }

    By inputPLU = By.xpath("//input[@name='searchPLU']");

    public By getInputPLU() {
        return inputPLU;
    }

    By quantidade = By.xpath("//input[@name='plu_qtde[]']");

    public By getQuantidade() {
        return quantidade;
    }

    By botaoSalvar = By.xpath("//input[@value='Salvar']");

    public By getBotaoSalvar() {
        return botaoSalvar;
    }

    By botaoMSG = By.id("btDialogBox_0");

    public By getBotaoMSG() {
        return botaoMSG;
    }

    By emitirNF = By.id("emitirNF");

    public By getEmitirNF() {
        return emitirNF;
    }

    By selecionarImpressora = By.xpath("//input[@value='PDFCreator']");

    By FiltrarPor = By.id("filterField");
    By filtrarNumeroDaNota = By.id("filterValor");
    By botaoFiltrar = By.xpath("//input[@id='btFilter']");
    By botaoAlterar = By.xpath("//img[@title='Alterar']");
    By okAlerta = By.className("btOkMsgBox");

    By resgatarTexto = By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td/div/div");

    By selesctSerie = By.xpath("//select[@id='nfserie']");
    By emitirNota = By.id("emitirNF");
    By ok2 = By.id("btDialogBox_0");
    By resgatarCodDevAut = By.xpath("/html/body/form[1]/table/tbody/tr/td[3]");
    By resgatarSerieNf = By.xpath("/html/body/form[1]/table/tbody/tr/td[6]");
    By resgatarStatusNF = By.xpath("/html/body/form[1]/table/tbody/tr/td[14]");
    By resgatarValorNf = By.xpath("/html/body/form[1]/table/tbody/tr/td[15]");


    public By getFiltrarPor() {
        return FiltrarPor;
    }


    //-------------------!Aceitar 2 alertas!------------------------//

    public By getFiltrarNumeroDaNota() {
        return filtrarNumeroDaNota;
    }

    public By getBotaoFiltrar() {
        return botaoFiltrar;
    }

    public By getBotaoAlterar() {
        return botaoAlterar;
    }

    public By getMsgOk() {
        return okAlerta;
    }

    public By getSelesctSerie() {
        return selesctSerie;
    }

    public By getEmitirNota() {
        return emitirNota;
    }

    public By getSelecionarImpressora() {
        return selecionarImpressora;
    }

    public By getOkAlerta() {
        return okAlerta;
    }

    public By getResgatarTexto() {
        return resgatarTexto;
    }

    public By getOk2() {
        return ok2;
    }

    public By getResgatarCodDevAut() {
        return resgatarCodDevAut;
    }

    public By getResgatarSerieNf() {
        return resgatarSerieNf;
    }

    public By getResgatarStatusNF() {
        return resgatarStatusNF;
    }

    public By getResgatarValorNf() {
        return resgatarValorNf;
    }


    By inputnumeroFatura = By.xpath("//input[@name='filterFatNf[valor]']");

    public By getInputnumeroFatura() {
        return inputnumeroFatura;
    }

    By consultarAnexo = By.xpath("(//img[@title='Ver Anexos da Nota'])[1]");

    public By getConsultarAnexo() {
        return consultarAnexo;
    }
    By codXMLNFE = By.xpath("/html/body/div[4]/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[2]");
    public By getCodXMLNFE() {
        return codXMLNFE;
    }

    By downloadXML = By.xpath("(//img[@src='../../img/abre.png'])[2]");

    public By getDownloadXML() {
        return downloadXML;
    }
}