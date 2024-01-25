package com.titansoftware.pages.produtosPages;

import org.openqa.selenium.By;

public class AssercaoProdutosEstoquePage {

    By acessarModulProdutos = By.id("mod_plu");
    By acessarMenuProdutos = By.xpath("/html/body/div[5]/ul/li[1]/a");
    By acessarSubMenuProdutos = By.xpath("//a[@href=\"javascript:chargeProgram('plu','titan_plu.titan.php?mode=view')\"]");
    By consultarProdutoEscolhido = By.id("btnFilter");
    By selecionarCampoTabela = By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[6]");

    public By getAcessarModuloProdutos() {
        return acessarModulProdutos;
    }

    By campoDescricaoProduto = By.xpath("//input[contains(@name,'fText')]");

    public By getAcessarMenuProdutos() {
        return acessarMenuProdutos;
    }

    By botaoFiltrarProdutos = By.id("btnFilter");

    public By getAcessarSubMenuProdutos() {
        return acessarSubMenuProdutos;
    }

    public By getCampoDescricaoProduto() {
        return campoDescricaoProduto;
    }

    public By getConsultarProdutoEscolhido() {
        return consultarProdutoEscolhido;
    }

    public By getBotaoFiltrarProdutos() {
        return botaoFiltrarProdutos;
    }

    public By getSelecionarCampoTabela() {
        return selecionarCampoTabela;
    }

    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }

}
