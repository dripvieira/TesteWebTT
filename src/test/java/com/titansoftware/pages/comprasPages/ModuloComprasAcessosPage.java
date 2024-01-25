package com.titansoftware.pages.comprasPages;

import org.openqa.selenium.By;

public class ModuloComprasAcessosPage {

    By ModuloCompras = By.id("mod_fornecedores");

    public By getAcessarModuloCompras() {
        return ModuloCompras;
    }

    By subMenuCompras = By.xpath("//a[@href='javascript:openProgList(2)']");

    public By getAcessarMenuCompras() {
        return subMenuCompras;
    }

    By funcaoPedidoDeCompras = By.xpath("//a[@title='Pedido de Compras']");

    public By getAcessarSubMenuPedidoDeCompras() {
        return funcaoPedidoDeCompras;
    }

    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }
}
