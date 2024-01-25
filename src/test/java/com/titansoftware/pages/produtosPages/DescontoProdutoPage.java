package com.titansoftware.pages.produtosPages;

import org.openqa.selenium.By;

public class DescontoProdutoPage {

    By condicaoSelect = By.id("fOp");
    By campoDados = By.id("fText");
    By filtraPlu = By.id("btnFilter");
    By btnAlterar = By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[1]/a[1]");
    By campoDesconto = By.id("desconto");
    By btnSalva = By.id("validButton2");
    By btnVoltar = By.xpath("//input[@value='Voltar' and parent::div[@id='legend2']]");
    By valorTotalPLU = By.xpath("/html/body/form/div[1]/div[2]/div[2]/div[13]/div[3]/div[2]/div/div/div[3]/input[5]");

    public By getCondicaoSelect() {
        return condicaoSelect;
    }

    public By getCampoDados() {
        return campoDados;
    }

    public By getFiltraPlu() {
        return filtraPlu;
    }

    public By getBtnAlterar() {
        return btnAlterar;
    }

    public By getCampoDesconto() {
        return campoDesconto;
    }

    public By getBtnSalva() {
        return btnSalva;
    }

    public By getBtnVoltar() {
        return btnVoltar;
    }


}
