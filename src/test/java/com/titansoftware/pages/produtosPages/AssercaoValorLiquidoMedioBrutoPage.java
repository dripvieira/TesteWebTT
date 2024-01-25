package com.titansoftware.pages.produtosPages;

import org.openqa.selenium.By;

public class AssercaoValorLiquidoMedioBrutoPage {


    By inserirCodigoProduto = By.xpath("//input[@maxlength='13']");


    public By getInserirCodigoProduto() {
        return inserirCodigoProduto;
    }

    By filtrarCodigoProduto = By.xpath("//input[@class='nivela']");

    public By getFiltrarCodigoProduto() {
        return filtrarCodigoProduto;
    }


    By resgatarValorbruto = By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[2]");

    public By getResgatarValorbruto() {
        return resgatarValorbruto;
    }

    By resgatarValorLiquido = By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td[2]");

    public By getResgatarValorLiquido() {
        return resgatarValorLiquido;
    }

    By resgatarValorMedio = By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[3]/td[1]/table/tbody/tr[2]/td[2]");

    public By getResgatarValorMedio() {
        return resgatarValorMedio;
    }
}
