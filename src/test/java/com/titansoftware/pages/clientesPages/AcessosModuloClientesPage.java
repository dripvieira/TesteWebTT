package com.titansoftware.pages.clientesPages;

import org.openqa.selenium.By;

public class AcessosModuloClientesPage {

    By acessarModuloClientes = By.id("mod_customer");

    public By getAcessarModuloClientes() {
        return acessarModuloClientes;
    }

    By acessarSubmenuCliente = By.xpath("//a[@href=\"javascript:openProgList(0)\"]");

    public By getAcessarMenuCliente() {
        return acessarSubmenuCliente;
    }


    By acessarManutencaoClientes = By.xpath("//a[@href=\"javascript:chargeProgram('customer','customer_file.php?mode=view')\"]");

    public By getAcessarSubMenuManutencaoClientes() {
        return acessarManutencaoClientes;
    }


    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }
}
