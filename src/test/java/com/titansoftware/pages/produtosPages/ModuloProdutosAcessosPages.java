package com.titansoftware.pages.produtosPages;

import org.openqa.selenium.By;

public class ModuloProdutosAcessosPages {
    By moduloProduto = By.xpath("//div[@id=\"moduleMenu\"]/div[5]/img");
    By acessarMenuPrecoVenda = By.xpath("//a[contains(.,'Preços de Venda')]");
    By acessarSubMenulinkHistoricoDePreco = By.xpath("//a[contains(.,'Link para Historico de Preço')]");

    public By getModuloProduto() {
        return moduloProduto;
    }

    public By getAcessarMenuPrecoVenda() {
        return acessarMenuPrecoVenda;
    }

    public By getAcessarSubMenuLinkHistoricoDePreco() {
        return acessarSubMenulinkHistoricoDePreco;
    }

    By acessarSubMenuOfertas = By.xpath("//a[@title='Preços de Venda - Ofertas']");

    public By getAcessarSubMenuOfertas() {
        return acessarSubMenuOfertas;
    }
}
