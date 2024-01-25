package com.titansoftware.pages.fiscal.RelatoriosPages;

import org.openqa.selenium.By;

public class AcessarModuloRelatorioLivroFiscalSaidaPage {


    By acessarFiscal = By.id("mod_fiscal");
    By acessarRelatorios = By.xpath("//a[@href='javascript:openProgList(2)']");
    By saidaLivroFiscal = By.xpath("//a[@title=\"Relatório Livro Fiscal de Saída\"]");

    public By getAcessarFiscal() {
        return acessarFiscal;
    }

    public By getAcessarRelatorios() {
        return acessarRelatorios;
    }

    public By getSaidaLivroFiscal() {
        return saidaLivroFiscal;
    }


}
