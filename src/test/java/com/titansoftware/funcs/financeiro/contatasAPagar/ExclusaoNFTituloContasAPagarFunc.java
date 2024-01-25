package com.titansoftware.funcs.financeiro.contatasAPagar;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.pages.financeiro.contatasAPagar.manutencaoDeTitulos.ExclusaoNFTituloContasAPagarPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ExclusaoNFTituloContasAPagarFunc extends BaseTeste {

    public static String statusTitulo;
    public static String statusMeio;
    ExclusaoNFTituloContasAPagarPage exclusaoNFTituloContasAPagarPage = new ExclusaoNFTituloContasAPagarPage();
    String titulo = EntradaDeNotaFiscalFunc.nF.substring(0, 8);
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void buscaStatusTituloContasAPagar() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        //Elemento abaixo não foi encontrado 21/11/2023
        //js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.switchTo().defaultContent();
        actions.moveToElement(driver.findElement(exclusaoNFTituloContasAPagarPage.getAcessarModuloFinanceiro())).click().perform();
        driver.findElement(exclusaoNFTituloContasAPagarPage.getAcessarContasAPagar()).click();
        driver.findElement(exclusaoNFTituloContasAPagarPage.getAcessarManutencaoDeTitulos()).click();
        driver.switchTo().frame("Dir");
        Thread.sleep(1000);
        driver.findElement(exclusaoNFTituloContasAPagarPage.getCondicao()).sendKeys(Keys.TAB);
        Thread.sleep(1000);
        driver.findElement(exclusaoNFTituloContasAPagarPage.getNumTitulo()).sendKeys(Keys.DELETE);
        driver.findElement(exclusaoNFTituloContasAPagarPage.getNumTitulo()).sendKeys(titulo);
        Thread.sleep(5000);
        Select tipoData = new Select(driver.findElement(exclusaoNFTituloContasAPagarPage.getTipoDeData()));
        tipoData.selectByVisibleText("Movimento");
    }

    public void filtrarPendente() {
        driver.findElement(exclusaoNFTituloContasAPagarPage.getBtnFiltrar()).click();
    }

    public void filtrarExcluida() {
        driver.findElement(exclusaoNFTituloContasAPagarPage.getExcluidaCheckbox()).click();
        driver.findElement(exclusaoNFTituloContasAPagarPage.getBtnFiltrar()).click();
    }

    public void validaStatusMeio() {
        statusMeio = driver.findElement(exclusaoNFTituloContasAPagarPage.getStatusTitulo()).getText();
        Assert.assertEquals("Pendente", statusMeio);
    }

    public void assercaoStatusTitulo() {
        statusTitulo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(exclusaoNFTituloContasAPagarPage.getStatusTitulo()))).getText();
        //statusTitulo = driver.findElement(exclusaoNFTituloContasAPagarPage.getStatusTitulo()).getText();
        Assert.assertEquals("Excluido", statusTitulo);
    }

}
