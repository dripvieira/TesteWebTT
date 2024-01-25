package com.titansoftware.pages.fiscal.livrosFiscais.manutencao;

import org.openqa.selenium.By;

public class EntrarManutencaoLivroFiscalPage {

    By acessarModuloFiscal = By.id("mod_fiscal");
    //By acessarLivroFiscal = By.xpath("//a[@href=\"javascript:openProgList('0')\"]");
    By acessarLivroFiscal = By.xpath("//a[contains(.,'Livros Fiscais')]");
    By manutencaoLivroFiscal = By.xpath("//a[@href=\"javascript:chargeProgram('fiscal','../stock/livro_fiscal.titan.php?mode=view')\"]");
    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getAcessarModuloFiscal() {
        return acessarModuloFiscal;
    }

    public By getAcessarLivroFiscal() {
        return acessarLivroFiscal;
    }

    public By getManutencaoLivroFiscal() {
        return manutencaoLivroFiscal;
    }

    public By getElementoTermino() {
        return elementoTermino;
    }
}
