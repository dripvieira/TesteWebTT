package com.titansoftware.pages.EstoquePages.RecebimentoPages.NotaFiscalPages;

import org.openqa.selenium.By;

public class ValidarNotaDevolucaoAutoPage {

    By entrarEstoque = By.id("mod_stock");
    By entrarRecebimento = By.xpath("//a[@href='javascript:openProgList(0)']");
    By notasFiscais = By.xpath("//a[@title='Gerenciamento de Notas Fiscais 2.0']");
    By dadosDoFiltro = By.xpath("//input[@name='dados']");
    By btnFiltroNF = By.xpath("//input[@value='Filtrar']");
    By alterarNF = By.xpath("//a[@href='titan_rec_nf.titan.php?mode=upd&nf_key=45801']");
    By criticarNF = By.id("criticar");
    By validarNF = By.xpath("//input[@id='validateButton']");

    public By getEntrarEstoque() {
        return entrarEstoque;
    }

    public By getEntrarRecebimento() {
        return entrarRecebimento;
    }

    public By getNotasFiscais() {
        return notasFiscais;
    }

    public By getDadosDoFiltro() {
        return dadosDoFiltro;
    }

    public By getBtnFiltroNF() {
        return btnFiltroNF;
    }

    public By getAlterarNF() {
        return alterarNF;
    }

    public By getCriticarNF() {
        return criticarNF;
    }

    public By getValidarNF() {
        return validarNF;
    }


    //--------------------------------!Aceitar 4 alerts!------------------------------------//


}
