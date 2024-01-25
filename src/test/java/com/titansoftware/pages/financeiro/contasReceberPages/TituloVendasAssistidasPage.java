package com.titansoftware.pages.financeiro.contasReceberPages;

import org.openqa.selenium.By;

public class TituloVendasAssistidasPage {

    By campoFiltro = By.id("t_tit_numero");
    By periodo = By.xpath("//select[@id='fDateField']");
    By btnFiltrar = By.xpath("//input[@value=' Filtrar ']");
    By baixarTitulo = By.xpath("//img[@src=\"../../img/DoUpdate.gif\" and parent::a]");
    By tipoCobranca = By.id("a_tipo_cob");
    By dataRecebimento = By.xpath("//input[@id='a_pgto']");
    By portador = By.xpath("//input[@id='a_portador']");
    By formaRecebimento = By.xpath("//select[@id='a_forma_pgto']");
    By numFinalizadora = By.xpath("//input[@onclick=\"javascript: selItem('27','32')\"]");
    By condicaoPgto = By.xpath("//input[@id='a_cond_pgto']");
    By incluirParcela = By.xpath("/html/body/form/table/tbody[3]/tr[4]/td/table/tbody/tr/td[1]/a/img");
    By baixaDoTitulo = By.xpath("//input[@value='Baixa Direta']");
    By resgatarNumTitulo = By.xpath("//table[@id=\"listagem\"]/tbody/tr/td[2]");
    By resgatarValorTitulo = By.xpath("//table[@id=\"listagem\"]/tbody/tr/td[16]");
    By resgatarStatusTitulo = By.xpath("//table[@id=\"listagem\"]/tbody/tr/td[19]");

    By Calendario = By.xpath("//span[@class='ui-datepicker-month']");

    public By getCalendario() {
        return Calendario;
    }

    public By getCampoFiltro() {
        return campoFiltro;
    }

    public By getPeriodo() {
        return periodo;
    }

    public By getBtnFiltrar() {
        return btnFiltrar;
    }

    public By getBaixarTitulo() {
        return baixarTitulo;
    }

    public By getTipoCobranca() {
        return tipoCobranca;
    }

    public By getDataRecebimento() {
        return dataRecebimento;
    }

    public By getPortador() {
        return portador;
    }

    public By getFormaRecebimento() {
        return formaRecebimento;
    }

    public By getNumFinalizadora() {
        return numFinalizadora;
    }

    public By getCondicaoPgto() {
        return condicaoPgto;
    }

    public By getIncluirParcela() {
        return incluirParcela;
    }

    public By getBaixaDoTitulo() {
        return baixaDoTitulo;
    }


    public By getResgatarNumTitulo() {
        return resgatarNumTitulo;
    }

    public By getResgatarValorTitulo() {
        return resgatarValorTitulo;
    }

    public By getResgatarStatusTitulo() {
        return resgatarStatusTitulo;
    }
}
