package com.titansoftware.pages.vendasAssistidasPages;

import org.openqa.selenium.By;

public class PedidoVendasPage {


    By incluirVenda = By.xpath("//a[@href='vendasAssist_nota_fiscal.titan.php?mode=upd']");
    By destinatario = By.xpath("//select[@id='destType']");
    By numeroFornecedor = By.xpath("//input[@id='destId']");
    By serieNF = By.xpath("//select[@id='nfser']");
    By adicionarPLU = By.xpath("//input[@id='searchField' and parent::td]");
    By adicionarQuantidade = By.id("qtde_2");
    By referencia = By.id("searchFieldStrREF");
    By frete = By.xpath("//input[@id='frete']");
    By recuperarValorVenda = By.xpath("//span[@id='place4total']");
    By btnSalvar = By.id("but_Salvar");
    By recuperaNumeroNF = By.xpath("/html/body/h2");
    By enviarFaturamento = By.xpath("//input[@name='doEmitir']");
    By descricaoDestinatario = By.id("destDescr");

    public By getIncluirVenda() {
        return incluirVenda;
    }

    public By getDestinatario() {
        return destinatario;
    }

    public By getDescricaoDestinatario() {
        return descricaoDestinatario;
    }

    public By getNumeroFornecedor() {
        return numeroFornecedor;
    }

    public By getSerieNF() {
        return serieNF;
    }

    public By getAdicionarPLU() {
        return adicionarPLU;
    }

    public By getAdicionarQuantidade() {
        return adicionarQuantidade;
    }


    public By getFrete() {
        return frete;
    }

    //aceitar alert...

    public By getRecuperarValorVenda() {
        return recuperarValorVenda;
    }

    public By getBtnSalvar() {
        return btnSalvar;
    }

    public By getRecuperaNumeroNF() {
        return recuperaNumeroNF;
    }

    public By getEnviarFaturamento() {
        return enviarFaturamento;
    }
}
