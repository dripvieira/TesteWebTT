package com.titansoftware.pages.fiscal.livrosFiscais.manutencao;

import org.openqa.selenium.By;

public class ExclusaoLivroFiscalPage {

    By btnFiltrar = By.xpath("//input[@value=' Filtrar ']");
    By alterarLivroFiscal = By.id("testeLink1");
    By excluirLivroFiscal = By.xpath("//input[@value='Excluir']");


    public By getBtnFiltrar() {
        return btnFiltrar;
    }

    public By getAlterarLivroFiscal() {
        return alterarLivroFiscal;
    }

    public By getExcluirLivroFiscal() {
        return excluirLivroFiscal;
    }

}
