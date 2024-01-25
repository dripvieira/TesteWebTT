package com.titansoftware.pages.clientesPages;

import org.openqa.selenium.By;

public class SaldoDoClienteVendasAssistidasPage {

    By dadoFiltro = By.xpath("//input[@id='dadoCod']");

    public By getDadoFiltro() {return dadoFiltro;}

    By btnFiltrar = By.xpath("//input[@id='filtrar']");

    public By getBtnFiltrar() {return btnFiltrar;}

    By saldoInicial = By.xpath("/html/body/table/tbody/tr[1]/td[8]");

    public By getSaldoInicial() {return saldoInicial;}


}
