package com.titansoftware.pages.EstoquePages;

import org.openqa.selenium.By;

public class ModulosEstoqueAcessosPages {

    By selecionarModuloEstoque = By.xpath("//a[@id='mod_stock']");
    By selecionarRecebimento = By.xpath("/html/body/div[5]/ul/li[1]/a");
    By selecionarRelatorios = By.xpath("//a[contains(.,'Relatórios')]");
    //By selecionarRelatorios = By.xpath("//a[@href='javascript:openProgList(3)']");

    By selecionarNF2 = By.xpath("//a[@title='Gerenciamento de Notas Fiscais 2.0']");

    By selecionarMovimentacao = By.xpath("//a[@title='Movimentação de Estoque']");
    By selecionarEvolucaoEstoque = By.xpath("//a[@title='Evolução de Estoque']");

    By selecionarMenuInventario = By.xpath("/html/body/div[5]/ul/li[2]/a");
    By selecionarSubMenuInventario = By.xpath("//a[@title='Inventário']");


    public By getAcessarModuloEstoque() {
        return selecionarModuloEstoque;
    }

    public By getAcessarMenuRecebimento() {
        return selecionarRecebimento;
    }

    public By getAcessarSubMenuNF2() {return selecionarNF2;}

    By acessarSubMenuImportacao = By.xpath("//a[@title='Importação de NF-e']");

    public By getAcessarSubMenuImportacao() {
        return acessarSubMenuImportacao;
    }

    public By getSelecionarMovimentacao() {
        return selecionarMovimentacao;
    }

    public By getSelecionarEvolucaoEstoque() {
        return selecionarEvolucaoEstoque;
    }

    public By getSelecionarRelatorios() {
        return selecionarRelatorios;
    }

    public By getSelecionarMenuInventario() {
        return selecionarMenuInventario;
    }

    public By getSelecionarSubMenuInventario() {
        return selecionarSubMenuInventario;
    }

    By elementoTermino = By.xpath("//div[@id='floatMenu']");

    public By getElementoTermino() {
        return elementoTermino;
    }
}
