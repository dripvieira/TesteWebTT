package com.titansoftware.pages.EstoquePages;

import org.openqa.selenium.By;

public class ValidarExclusaoFaturaAssercaoEstoquePage {

    By campoFiltro = By.id("fText");
    By btnFiltrar = By.xpath(" Filtrar ");
    By qntddProdutos = By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[6]");
    By waitDivTudo = By.id("tudo");
    By divPadrao = By.id("Dir");

    public By getCampoFiltro() {
        return campoFiltro;
    }

    public By getBtnFiltrar() {
        return btnFiltrar;
    }

    public By getQntddProdutos() {
        return qntddProdutos;
    }

    public By getWaitDivTudo() {
        return waitDivTudo;
    }

    public By getDivPadrao() {
        return divPadrao;
    }
}
