package com.titansoftware.pages.produtosPages;

import org.openqa.selenium.By;

public class CadastroDeOfertaPage {

    By incluirOferta = By.xpath("//img[@class='actionButton']");
    By selecionarLoja = By.xpath("//select[@id='store']");
    By clicarLoja = By.xpath("//option[contains(.,'1 - LOJA TESTE 1  UF SP nao mude')]");
    By nomeOferta = By.id("nome");
    By tipoPreco = By.xpath("//select[@id='price']");
    By inputCodPLU = By.xpath("//input[@id='srchPro']");
    By precoNovo = By.xpath("//input[@id='pricePro']");
    By incluirProduto = By.xpath("//img[@src='../../img/DoInsert.gif' and parent:: a]");
    By selecionarTodos = By.xpath("//input[@onclick='selectall(this)']");
    By msg = By.id("btDialogBox_0");
    By botaoIncluir = By.xpath("//input[@onclick=\"javascript:habilitaDataHora('alt')\"]");
    By clicarValidar = By.xpath("//input[@onclick=\"passaValorParaHidden( this , 'vld' )\"]");

    public By getIncluirOferta() {
        return incluirOferta;
    }

    public By getSelecionarLoja() {
        return selecionarLoja;
    }

    public By getClicarLoja() {
        return clicarLoja;
    }

    public By getNomeOferta() {
        return nomeOferta;
    }

    public By getTipoPreco() {
        return tipoPreco;
    }

    public By getInputCodPLU() {
        return inputCodPLU;
    }

    public By getPrecoNovo() {
        return precoNovo;
    }

    public By getIncluirProduto() {
        return incluirProduto;
    }

    public By getSelecionarTodos() {
        return selecionarTodos;
    }

    public By getMsg() {
        return msg;
    }

    public By getBotaoIncluir() {
        return botaoIncluir;
    }

    public By getClicarValidar() {
        return clicarValidar;
    }
}
