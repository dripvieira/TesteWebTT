package com.titansoftware.pages.EstoquePages.RecebimentoPages.NotaFiscalPages;

import org.openqa.selenium.By;

public class ExclusaoNFPage {

    By campoFiltrar = By.xpath("//input[@name='dados']");
    By filtrarNF = By.xpath("//input[@value='Filtrar']");
    By alterarNF = By.xpath("//img[@title='Editar/Excluir']");
    By excluirNF = By.id("deletar");
    By resgatarStatusNF = By.xpath("/html/body/div[3]/div[3]/table/tbody/tr[1]/td[13]");
    By desativarParipassus = By.xpath("//input[@value='paripassus']");
    //By DesativarAtivarFiltroRecebimento = By.xpath("//legend[@onclick=\"selectAll('block-recebimento','chkRecebimento')\"]");
    By DesativarAtivarFiltroRecebimento = By.xpath("//legend[contains(.,'Recebimento')]");
    By selecionarFlagExcluida = By.xpath("//input[@value='R']");
    By selecionarFlagPendente = By.xpath("(//input[@value='P'])[1]");

    public By getCampoFiltrar() {
        return campoFiltrar;
    }

    public By getFiltrarNF() {
        return filtrarNF;
    }

    public By getAlterarNF() {
        return alterarNF;
    }

    public By getExcluirNF() {
        return excluirNF;
    }

    public By getResgatarStatusNF() {
        return resgatarStatusNF;
    }

    public By getDesativarParipassus() {
        return desativarParipassus;
    }

    public By getDesativarAtivarFiltroRecebimento() {
        return DesativarAtivarFiltroRecebimento;
    }

    public By getSelecionarFlagExcluida() {
        return selecionarFlagExcluida;
    }

    public By getSelecionarFlagPendente() {
        return selecionarFlagPendente;
    }
}
