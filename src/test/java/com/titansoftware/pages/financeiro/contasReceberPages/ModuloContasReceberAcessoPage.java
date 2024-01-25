package com.titansoftware.pages.financeiro.contasReceberPages;

import org.openqa.selenium.By;

public class ModuloContasReceberAcessoPage {


    By entrarFinanceiro = By.id("mod_financial");
    By entrarContasReceber = By.xpath("//a[@href='javascript:openProgList(1)']");
    By manutencaoTitulos = By.xpath("//a[@href=\"javascript:chargeProgram('financial','man_titulos_cr.titan.php')\"]");

    public By getEntrarFinanceiro() {
        return entrarFinanceiro;
    }

    public By getEntrarContasReceber() {
        return entrarContasReceber;
    }

    public By getManutencaoTitulos() {
        return manutencaoTitulos;
    }

    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }


}
