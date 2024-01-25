package com.titansoftware.pages.produtosPages;

import org.openqa.selenium.By;

public class GravacaoCustoReceitaPages {

    By acessarModuloProdutos = By.xpath("//a[@id='mod_plu']");

    public By getAcessarModuloProdutos() {
        return acessarModuloProdutos;
    }

    By acessarSubMenuProdutos = By.xpath("//a[@href='javascript:openProgList(0)']");

    public By getAcessarSubMenuProdutos() {
        return acessarSubMenuProdutos;
    }

    By acessarEntidadeReceita = By.xpath("//a[text()=' Receita ']");

    public By getAcessarEntidadeReceita() {
        return acessarEntidadeReceita;
    }

    By incluirReceita = By.xpath("//img[@src='../../img/DoInsert.gif' and parent::a[@href='receita.titan.php?mode=upd']]");

    public By getIncluirReceita() {
        return incluirReceita;
    }

    By adicionarPlu = By.id("pluID");

    public By getAdicionarPlu() {
        return adicionarPlu;
    }

    By nutriQuantidade = By.id("nutriQuant");

    public By getNutriQuantidade() {
        return nutriQuantidade;
    }


    By nutriCalorias = By.id("nutriCal");

    public By getNutriCalorias() {
        return nutriCalorias;
    }

    By nutriProteina = By.id("nutriProt");

    public By getNutriProteina() {
        return nutriProteina;
    }

    By nutriGordurasTotais = By.id("nutriGor");

    public By getNutriGordurasTotais() {
        return nutriGordurasTotais;
    }

    By nutriGorsdurasSaturadas = By.id("nutriGorSat");

    public By getNutriGorsdurasSaturadas() {
        return nutriGorsdurasSaturadas;
    }

    By nutriColesterol = By.id("nutriCol");

    public By getNutriColesterol() {
        return nutriColesterol;
    }

    By nutriFibra = By.id("nutriFibra");

    public By getNutriFibra() {
        return nutriFibra;
    }

    By nutriCalcio = By.id("nutriCalcio");

    public By getNutriCalcio() {
        return nutriCalcio;
    }

    By nutriFerro = By.id("nutriFerro");

    public By getNutriFerro() {
        return nutriFerro;
    }

    By nutriSodio = By.id("nutriSodio");

    public By getNutriSodio() {
        return nutriSodio;
    }

    By nutriGordurasTrans = By.id("nutritrans");

    public By getNutriGordurasTrans() {
        return nutriGordurasTrans;
    }

    By adicionarPluReceita = By.xpath("//img[@src='../../img/DoInsert.gif' and parent::a]");

    public By getAdicionarPluReceita() {
        return adicionarPluReceita;
    }

    By CodPluCafe = By.xpath("//input[@onblur='pegaItemDados(1);calcTotais();']");

    public By getCodPluCafe() {
        return CodPluCafe;
    }

    By qntddCafe = By.xpath("//input[@onblur='calcTotalItem(1);calcTotais();']");

    public By getQntddCafe() {
        return qntddCafe;
    }

    By CodPluAcucar = By.xpath("//input[@onblur='pegaItemDados(2);calcTotais();']");

    public By getCodPluAcucar() {
        return CodPluAcucar;
    }

    By qntddAcucar = By.xpath("//input[@onblur='calcTotalItem(2);calcTotais();']");

    public By getQntddAcucar() {
        return qntddAcucar;
    }

    By CodPluAgua = By.xpath("//input[@onblur='pegaItemDados(3);calcTotais();']");

    public By getCodPluAgua() {
        return CodPluAgua;
    }

    By qntddAgua = By.xpath("//input[@onblur='calcTotalItem(3);calcTotais();']");

    public By getQntddAgua() {
        return qntddAgua;
    }


    By salvarReceita = By.id("btIncluir");

    public By getSalvarReceita() {
        return salvarReceita;
    }

    By filtrarPor = By.xpath("//input[@id='filtroText']");

    public By getFiltrarPor() {
        return filtrarPor;
    }

    By botaoFiltrar = By.id("filtroBtFiltrar");

    public By getBotaoFiltrar() {
        return botaoFiltrar;
    }

    By resgatarPLU = By.xpath("//table[@id=\"lista\"]/tbody/tr/td[2]");

    public By getResgatarPLU() {
        return resgatarPLU;
    }
}
