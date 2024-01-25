package com.titansoftware.pages.EstoquePages;

import org.openqa.selenium.By;

public class ValidarAjusteSobraManualPage {
    By btnAjuste = By.xpath("//input[@value='Ajuste']");
    By filtroOperacao = By.xpath("//select[@id='OperacaoSelectSaida_0']");
    By checkAjuste = By.xpath("//input[@id='chkAjuste']");

    public By getBtnAjuste() {
        return btnAjuste;
    }

    public By getFiltroOperacao() {
        return filtroOperacao;
    }

    public By getCheckAjuste() {
        return checkAjuste;
    }
}
