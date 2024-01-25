package com.titansoftware.pages.produtosPages;

import org.openqa.selenium.By;

public class AcessarModuloProdutosPage {
    By selecionarModuloProdutos = By.xpath("//a[@id=\"mod_plu\"]");
    By selecionarSubmenuProdutos = By.xpath("//a[@href='javascript:openProgList(0)'][contains(.,'Produtos')]");
    By selecionarManutencaoDeProdutos = By.xpath("//a[@title='Manutenção de Produtos']");

    public By getSelecionarManutencaoDeProdutos() {
        return selecionarManutencaoDeProdutos;
    }

    public By getSelecionarSubmenuProdutos() {
        return selecionarSubmenuProdutos;
    }

    public By getSelecionarModuloProdutos() {
        return selecionarModuloProdutos;
    }

}
