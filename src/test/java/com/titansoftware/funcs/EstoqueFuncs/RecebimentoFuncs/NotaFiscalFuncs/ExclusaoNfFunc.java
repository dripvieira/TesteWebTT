package com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.EstoquePages.RecebimentoPages.NotaFiscalPages.ExclusaoNFPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExclusaoNfFunc extends BaseTeste {

    ExclusaoNFPage consultarNFPage = new ExclusaoNFPage();
    String status;
    String nNF = EntradaDeNotaFiscalFunc.nF;
    String nNFE = nNF.substring(0, 8);

    public void consultarNfRecebimento() {
        driver.findElement(consultarNFPage.getCampoFiltrar()).sendKeys(nNFE);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(consultarNFPage.getDesativarParipassus()))).click();
        driver.findElement(consultarNFPage.getSelecionarFlagPendente()).click();
        driver.findElement(consultarNFPage.getFiltrarNF()).click();
    }

    public void assercaoStatus() {
        wait.until(ExpectedConditions.presenceOfElementLocated(consultarNFPage.getResgatarStatusNF()));
        status = driver.findElement(consultarNFPage.getResgatarStatusNF()).getText();
        Assert.assertEquals("Excluído", status);
    }
}
