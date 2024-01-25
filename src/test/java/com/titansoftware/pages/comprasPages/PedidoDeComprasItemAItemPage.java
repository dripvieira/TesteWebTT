package com.titansoftware.pages.comprasPages;

import org.openqa.selenium.By;

public class PedidoDeComprasItemAItemPage {

    By selecionarLoja = By.id("cbLoja");

    public By getSelecionarLoja() {
        return selecionarLoja;
    }

    By selecionarLojaPedido = By.xpath("//select[@id=\"lojas\"]");

    public By getSelecionarLojaPedido() {
        return selecionarLojaPedido;
    }

    By botaoCodigoLoja = By.xpath("//input[@value='»']");

    public By getBotaoCodigoLoja() {
        return botaoCodigoLoja;
    }

    By selecionarFornecedor = By.xpath("//input[@value='2059']");

    public By getSelecionarFornecedor() {
        return selecionarFornecedor;
    }

    By botaoConfirmarFornecedor = By.xpath("//input[@value='Enviar']");

    public By getBotaoConfirmarFornecedor() {
        return botaoConfirmarFornecedor;
    }

    By dataDeEntrega = By.id("dtEntrega1");

    public By getDataDeEntrega() {
        return dataDeEntrega;
    }

    By confirmaQuantidade = By.xpath("//button[@type='button'][contains(@id,'1')][contains(.,'Confirmar')]");

    By pesquisarProduto = By.id("idSearchPLU");

    public By getPesquisarProduto() {
        return pesquisarProduto;
    }

    By quantidadeProduto = By.id("qtde_20000");

    public By getQuantidadeProduto() {
        return quantidadeProduto;
    }

    By filtratPedido = By.xpath("//input[@id='buttonFilter']");

    public By getConfirmaQuantidade() {
        return confirmaQuantidade;
    }

    By botaoSalvar = By.xpath("//input[@value='Salvar']");

    By botaoOk = By.xpath("//input[@class='btOkMsgBox']");


    public By getBotaoSalvar() {
        return botaoSalvar;
    }

    By registrarPedidoDeCompras = By.xpath("//input[@id=\"btDialogBox_0\"]");

    public By getRegistrarPedidoDeCompras() {
        return registrarPedidoDeCompras;
    }

    By msgConfirmacao = By.xpath("//td[@id=\"dQdPopUpObj\"]/div/div/span");

    public By getMsgConfirmacao() {
        return msgConfirmacao;
    }

    By numeroPedido = By.xpath("//input[@name='filter[dado]']");

    public By getNumeroPedido() {
        return numeroPedido;
    }

    public By getFiltrarPedido() {
        return filtratPedido;
    }

    By selecionarPedidoBaixado = By.id("chbBaixado");

    public By getSelecionarPedidoBaixado() {
        return selecionarPedidoBaixado;
    }

    By confirmarPedidoBaixado = By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[8]");
    public By getConfirmarPedidoBaixado() {
        return confirmarPedidoBaixado;
    }

    By resgatarNumeroPedido = By.xpath("/html/body/form/div[4]/div/table/tbody/tr[2]/td/div/div/a");

    public By getResgatarNumeroPedido() {
        return resgatarNumeroPedido;
    }
}
