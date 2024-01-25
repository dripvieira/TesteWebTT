package com.titansoftware.funcs.fiscal.livrosFiscais.manutencao;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.pages.fiscal.livrosFiscais.manutencao.AssercaoGravaNFLivroFiscalPage;
import com.titansoftware.pages.fiscal.livrosFiscais.manutencao.ExclusaoLivroFiscalPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExclusaoLivroFiscalFunc extends BaseTeste {

    ExclusaoLivroFiscalPage exclusaoLivroFiscalPage = new ExclusaoLivroFiscalPage();


    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formatteDate = currentDate.format(formatter);

    AssercaoGravaNFLivroFiscalPage assercaoGravaNFLivroFiscalPage = new AssercaoGravaNFLivroFiscalPage();

    String nNF = EntradaDeNotaFiscalFunc.nF;
    String nNFE = nNF.substring(0, 6);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void excluirLivroFiscal() {
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(Keys.END);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(Keys.BACK_SPACE);
        Select loja = new Select(driver.findElement(assercaoGravaNFLivroFiscalPage.getSelectLoja()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        loja.selectByValue("1");
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(nNFE);
        Select tipoData = new Select(driver.findElement(assercaoGravaNFLivroFiscalPage.getTipoData()));
        tipoData.selectByVisibleText("Entrada");
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDataInicial()).sendKeys(formatteDate);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDataFinal()).sendKeys(formatteDate);
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(assercaoGravaNFLivroFiscalPage.getFiltrarNF()).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.presenceOfElementLocated(exclusaoLivroFiscalPage.getAlterarLivroFiscal()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(exclusaoLivroFiscalPage.getAlterarLivroFiscal()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(exclusaoLivroFiscalPage.getAlterarLivroFiscal()))).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.presenceOfElementLocated(exclusaoLivroFiscalPage.getExcluirLivroFiscal()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(exclusaoLivroFiscalPage.getExcluirLivroFiscal()))).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

}
