package com.titansoftware.pages.EstoquePages;

import org.openqa.selenium.By;

public class ValidarQuebraDeEstoquePage {
    By loadPage = By.id("carregando_loadObject");
    By incluirMovimentacao = By.xpath("//a[@onclick=\"pop();\"]");
    By selecionaQuebra = By.xpath("//input[@value='Quebra']");
    By selectLoja = By.xpath("//select[@id='store']");
    By incluiPLU = By.id("btnInsere");
    By inputPLU = By.xpath("//input[@id='txt_saida']");
    By btnEnviar = By.xpath("/html/body/div[5]/div[11]/button[1]");
    By motivoQuebra = By.xpath("//select[@id='motivoSelectSaida_0']");
    By embalagem = By.xpath("//select[@id='embaSelectSaida_0']");
    By qntdQuebra = By.xpath("//input[@id='quantidade_saida_0']");
    By incluiQuebra = By.xpath("//input[@value='Incluir']");
    By campoFiltro = By.xpath("//input[@id='pluID']");
    By selectFiltro = By.xpath("//select[@id='campo']");
    By campoDados = By.xpath("//input[@id='valorTexto']");
    By btnFiltrar = By.xpath("//input[@id='btnEnv']");
    By btnAlterar = By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[1]/a[1]/img");
    By btnValidar = By.xpath("//input[@value='Validar']");
    By filtroLoja = By.xpath("//select[@id='store']");
    By campoProduto = By.xpath("//input[@id='product']");
    By btnFiltragem = By.xpath("//input[@value='Filtrar']");
    By pageLoader = By.xpath("//span[@class='loader']");
    By qntddEstoque = By.xpath("/html/body/main/table/tbody/tr/td[7]");

    //pegar valor do alerta
    //aceitar alerta

    public By getLoadPage() {
        return loadPage;
    }

    public By getIncluirMovimentacao() {
        return incluirMovimentacao;
    }

    public By getSelecionaQuebra() {
        return selecionaQuebra;
    }

    public By getSelectLoja() {
        return selectLoja;
    }

    public By getIncluiPLU() {
        return incluiPLU;
    }

    public By getInputPLU() {
        return inputPLU;
    }

    public By getBtnEnviar() {
        return btnEnviar;
    }

    public By getMotivoQuebra() {
        return motivoQuebra;
    }

    public By getEmbalagem() {
        return embalagem;
    }

    public By getQntdQuebra() {
        return qntdQuebra;
    }

    public By getIncluiQuebra() {
        return incluiQuebra;
    }

    public By getCampoFiltro() {
        return campoFiltro;
    }

    //aceitar alerta

    public By getSelectFiltro() {
        return selectFiltro;
    }

    public By getCampoDados() {
        return campoDados;
    }

    public By getBtnFiltrar() {
        return btnFiltrar;
    }

    public By getBtnAlterar() {
        return btnAlterar;
    }

    public By getBtnValidar() {
        return btnValidar;
    }

    public By getFiltroLoja() {
        return filtroLoja;
    }

    public By getCampoProduto() {
        return campoProduto;
    }

    public By getBtnFiltragem() {
        return btnFiltragem;
    }

    public By getPageLoader() {
        return pageLoader;
    }

    public By getQntddEstoque() {
        return qntddEstoque;
    }
}
