package com.titansoftware.pages.financeiro;

import org.openqa.selenium.By;

public class ModuloFinanceiroAcessoPages {

    By moduloFinanceiro = By.id("mod_financial");
    By acessarModuloFinanceiro = By.xpath("//img[@src='../../img/financial.png']");
    By acessarContasAPagar = By.xpath("//a[contains(.,'Contas à Pagar')]");
    By acessarManutencaoDeTitulos = By.xpath("//a[@href=\"javascript:chargeProgram('financial','man_titulos_cp.titan.php')\"]");

    public By getModuloFinanceiro() {
        return moduloFinanceiro;
    }

    public By getAcessarModuloFinanceiro() {
        return acessarModuloFinanceiro;
    }

    public By getAcessarContasAPagar() {
        return acessarContasAPagar;
    }

    public By getAcessarManutencaoDeTitulos() {
        return acessarManutencaoDeTitulos;
    }

    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }
}
