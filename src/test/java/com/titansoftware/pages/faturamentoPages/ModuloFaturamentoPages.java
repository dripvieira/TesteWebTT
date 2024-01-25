package com.titansoftware.pages.faturamentoPages;

import org.openqa.selenium.By;

public class ModuloFaturamentoPages {
    By moduloFaturamentoAcessar = By.xpath("//a[@href=\"javascript:openMenu('faturam')\"]");

    //By funbcaoEmissaoDeFaturas = By.xpath("//a[@class='a_faturam' and text()=' Emissão de Faturas ']");
    By funbcaoEmissaoDeFaturas = By.xpath("//a[@title='Faturas']");

    By submenuFaturamentoAcessar = By.xpath("//a[@href='javascript:openProgList(0)']");

    public By getModuloFaturamentoAcessar() {
        return moduloFaturamentoAcessar;
    }

    public By getSubmenuFaturamentoAcessar() {
        return submenuFaturamentoAcessar;
    }

    public By getFuncaoEmissaoDeFaturas() {
        return funbcaoEmissaoDeFaturas;
    }

    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }
}
