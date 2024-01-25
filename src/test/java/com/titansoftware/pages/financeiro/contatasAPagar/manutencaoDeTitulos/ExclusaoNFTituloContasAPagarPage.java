package com.titansoftware.pages.financeiro.contatasAPagar.manutencaoDeTitulos;

import org.openqa.selenium.By;

public class ExclusaoNFTituloContasAPagarPage {

    By acessarModuloFinanceiro = By.xpath("//img[@src='../../img/financial.png']");
    By acessarContasAPagar = By.xpath("//a[contains(.,'Contas à Pagar')]");
    By acessarManutencaoDeTitulos = By.xpath("//a[@href=\"javascript:chargeProgram('financial','man_titulos_cp.titan.php')\"]");
    By condicao = By.xpath("//select[@id='fOp']");
    By numTitulo = By.xpath("//input[@placeholder='Título']");
    By tipoDeData = By.xpath("//select[@id='fDateField']");
    By periodoDe = By.xpath("//input[@id='dataDe']");
    By periodoAte = By.xpath("//input[@id='dataAte']");
    By excluidaCheckbox = By.xpath("//input[@id='chkExcluido']");
    By btnFiltrar = By.xpath("//input[@value=' Filtrar ']");
    By statusTitulo = By.xpath("/html/body/div[6]/table/tbody/tr/td[19]");

    public By getAcessarModuloFinanceiro() {
        return acessarModuloFinanceiro;
    }

    public By getAcessarContasAPagar() {
        return acessarContasAPagar;
    }

    public By getAcessarManutencaoDeTitulos() {
        return acessarManutencaoDeTitulos;
    }

    public By getCondicao() {
        return condicao;
    }

    public By getNumTitulo() {
        return numTitulo;
    }

    public By getTipoDeData() {
        return tipoDeData;
    }

    public By getPeriodoDe() {
        return periodoDe;
    }

    public By getPeriodoAte() {
        return periodoAte;
    }

    public By getExcluidaCheckbox() {
        return excluidaCheckbox;
    }

    public By getBtnFiltrar() {
        return btnFiltrar;
    }

    public By getStatusTitulo() {
        return statusTitulo;
    }
}
