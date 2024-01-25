package com.titansoftware.pages.operacoes;

import org.openqa.selenium.By;

public class CargaDeOfertaPages {

    By selecionarCargaDeProduto = By.xpath("//input[@id='ckProdGeral']");
    By selecionarOferta = By.id("oferta");
    By selecionarData = By.xpath("//input[@id='data']");
    By gerarCarga = By.xpath("//input[@id='geraCarga']");

    public By getSelecionarCargaDeProduto() {
        return selecionarCargaDeProduto;
    }

    public By getSelecionarOferta() {
        return selecionarOferta;
    }

    public By getSelecionarData() {
        return selecionarData;
    }

    public By getGerarCarga() {
        return gerarCarga;
    }
}
