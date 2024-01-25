package com.titansoftware.pages.fiscal.RelatoriosPages;

import org.openqa.selenium.By;

public class AssercaoSaidaLivroFiscalPage {

    By periodoDe = By.xpath("//input[@id='dataDe']");
    By periodoAte = By.xpath("//input[@id='dataAte']");
    By filtrar = By.xpath("//input[@id='filtrar']");
    By serieNF = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div[1]/table/tbody/tr[2]/td[5]");

    public By getPeriodoDe() {
        return periodoDe;
    }

    public By getPeriodoAte() {
        return periodoAte;
    }

    public By getFiltrar() {
        return filtrar;
    }

    public By getSerieNF() {
        return serieNF;
    }

}
