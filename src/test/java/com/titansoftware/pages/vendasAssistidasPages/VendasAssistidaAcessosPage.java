package com.titansoftware.pages.vendasAssistidasPages;

import org.openqa.selenium.By;

public class VendasAssistidaAcessosPage {

    By entrarVendasAssistidas = By.id("mod_vendasAssistidas");
    //By subMenuVendasAssistidas = By.xpath("//a[@href='javascript:openProgList(1)']");
    By subMenuVendasAssistidas = By.xpath("/html/body/div[5]/ul/li[2]/a[@href='javascript:openProgList(1)']");
    By entrarVendas = By.xpath("//a[@href=\"javascript:chargeProgram('vendasAssistidas','vendasAssist_nota_fiscal.titan.php')\"]");

    public By getEntrarVendasAssistidas() {
        return entrarVendasAssistidas;
    }

    public By getSubMenuVendasAssistidas() {
        return subMenuVendasAssistidas;
    }

    public By getEntrarVendas() {
        return entrarVendas;
    }

    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }
}
