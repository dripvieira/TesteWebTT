package com.titansoftware.funcs.financeiro.contatasAPagar.manutencaoDeTitulos;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.pages.financeiro.contatasAPagar.manutencaoDeTitulos.AssercaoGravaValorNFContasAPagarPages;
import com.titansoftware.pages.financeiro.contatasAPagar.manutencaoDeTitulos.ExclusaoNFTituloContasAPagarPage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AssercaoGravaValorNFContasAPagarFunc extends BaseTeste {

    AssercaoGravaValorNFContasAPagarPages assercaoGravaValorNFContasAPagarPages = new AssercaoGravaValorNFContasAPagarPages();
    String nNF = EntradaDeNotaFiscalFunc.nF;
    String nNFE = nNF.substring(0, 8);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public static String statusTitulo;
    public static String statusMeio;
    ExclusaoNFTituloContasAPagarPage exclusaoNFTituloContasAPagarPage = new ExclusaoNFTituloContasAPagarPage();
    String titulo = EntradaDeNotaFiscalFunc.nF.substring(0, 8);
    Actions actions = new Actions(driver);

    public String ConsultarValorNF() throws InterruptedException {
        driver.findElement(assercaoGravaValorNFContasAPagarPages.getFiltrarDadosNF()).sendKeys(nNFE);
        Select tipoData = new Select(driver.findElement(assercaoGravaValorNFContasAPagarPages.getSelecionatTipoData()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        tipoData.selectByVisibleText("Movimento");
        driver.findElement(assercaoGravaValorNFContasAPagarPages.getFiltrarNF()).click();
        statusMeio = wait.until(ExpectedConditions.visibilityOf(driver.findElement(assercaoGravaValorNFContasAPagarPages.getStatusTitulo()))).getText();
        Assert.assertEquals("Pendente", statusMeio);
        return driver.findElement(assercaoGravaValorNFContasAPagarPages.getValorNF()).getText();
    }
}
