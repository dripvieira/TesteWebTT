package com.titansoftware.pages.operacoes;

import org.openqa.selenium.By;

public class ModuloOperacoesAcessosPage {
    By acessarModuloOperacoes = By.xpath("//a[@href=\"javascript:openMenu('impexp')\"]");
    By acessarMenuTransacoes = By.xpath("//a[@href='javascript:openProgList(0)']");
    By acessarSubMenuCargaXML = By.xpath("//a[@href=\"javascript:chargeProgram('impexp','impexp_cargaPdv_xml.titan.php')\"]");
    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getAcessarModuloOperacoes() {
        return acessarModuloOperacoes;
    }

    public By getAcessarMenuTransacoes() {
        return acessarMenuTransacoes;
    }

    public By getAcessarSubMenuCargaXML() {
        return acessarSubMenuCargaXML;
    }

    public By getElementoTermino() {
        return elementoTermino;
    }
}
