package com.titansoftware.pages.fiscal.livrosFiscais.manutencao;

import org.openqa.selenium.By;

public class AssercaoGravaNFLivroFiscalPage {

    By consultarStatus = By.xpath("//span[@id=\"d_stat_1\"]");

    By selectLoja = By.id("Store");


    By dadosNF = By.id("fText");

    public By getSelectLoja() {
        return selectLoja;
    }

    By tipoData = By.id("fDateField");

    public By getDadosNF() {
        return dadosNF;
    }

    By filtrarNF = By.id("filtrarBtn");

    public By getTipoData() {
        return tipoData;
    }

    By dataInicial = By.id("dataDe");

    public By getFiltrarNF() {
        return filtrarNF;
    }

    By dataFinal = By.id("dataAte");

    public By getDataInicial() {
        return dataInicial;
    }

    By consultarNota = By.xpath("//img[@class='doShowButton']");

    public By getDataFinal() {
        return dataFinal;
    }

    By totalBrutoNota = By.id("tot_d_bruto");

    public By getConsultarNota() {
        return consultarNota;
    }

    public By getTotalBrutoNota() {
        return totalBrutoNota;
    }

    public By getConsultarStatus() {
        return consultarStatus;
    }
}
