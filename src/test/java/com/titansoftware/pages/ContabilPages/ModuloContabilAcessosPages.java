package com.titansoftware.pages.ContabilPages;

import org.openqa.selenium.By;

public class ModuloContabilAcessosPages {

    By ModuloContabilAcesso = By.id("mod_contabil");
    By SubmenuContabilidade = By.xpath("//a[@href='javascript:openProgList(1)']");
    By lancamentoContabil = By.xpath("//a[@title='Lançamento Contábil']");

    public By getAcessarModuloContabil() {
        return ModuloContabilAcesso;
    }

    public By getAcessarMenuContabilidade() {
        return SubmenuContabilidade;
    }

    public By getAcessarSubMenuLancamentoContabil() {
        return lancamentoContabil;
    }

    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }
}
