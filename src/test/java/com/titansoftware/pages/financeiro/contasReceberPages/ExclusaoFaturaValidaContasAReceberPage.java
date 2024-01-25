package com.titansoftware.pages.financeiro.contasReceberPages;

import org.openqa.selenium.By;

public class ExclusaoFaturaValidaContasAReceberPage {
    By statusContasReceber = By.xpath("/html/body/div[3]/table/tbody/tr[1]/td[19]");
    By chckExcluido = By.xpath("//input[@id='chkExcluido']");
    By btnFiltrar = By.xpath("//input[@value=' Filtrar ']");
    By waitDivTudo = By.id("tudo");

    public By getStatusContasReceber() {
        return statusContasReceber;
    }

    public By getChckExcluido() {
        return chckExcluido;
    }

    public By getBtnFiltrar() {
        return btnFiltrar;
    }

    public By getWaitDivTudo() {
        return waitDivTudo;
    }
}
