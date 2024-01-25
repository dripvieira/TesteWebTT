package com.titansoftware.pages.comprasPages;

import org.openqa.selenium.By;

public class PedidoDeComprasAcessarPage {

    By incluirNovoPedido = By.xpath("//img[@class='hideOnPrint hideOnPrint2']");

    public By getIncluirNovoPedido() {
        return incluirNovoPedido;
    }

    By tipoDePedido = By.xpath("//a[@href='pedido_compra_new.titan.php?mode=upd_item' and text()='Pedido Direto Item a Item- Por Embalagem de Compra']");

    public By getTipoDePedido() {
        return tipoDePedido;
    }
}
