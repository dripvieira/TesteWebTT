package com.titansoftware.funcs.fiscal.livrosFiscais.manutencao;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.pages.fiscal.livrosFiscais.manutencao.AssercaoGravaNFLivroFiscalPage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AssercaoGravaNFLivroFiscalFunc extends BaseTeste {

    LocalDate currentDate = LocalDate.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formatteDate = currentDate.format(formatter);

    String nNF = EntradaDeNotaFiscalFunc.nF;
    String nNFE = nNF.substring(0, 8);

    public static String totalBrutoNota;
    String statusMeio;
    AssercaoGravaNFLivroFiscalPage assercaoGravaNFLivroFiscalPage = new AssercaoGravaNFLivroFiscalPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void acessarManutencaoLivroFiscal() {
        Select loja = new Select(driver.findElement(assercaoGravaNFLivroFiscalPage.getSelectLoja()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        loja.selectByValue("1");
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDadosNF()).sendKeys(nNFE);
        Select tipoData = new Select(driver.findElement(assercaoGravaNFLivroFiscalPage.getTipoData()));
        tipoData.selectByVisibleText("Entrada");
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDataInicial()).sendKeys(formatteDate);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getDataFinal()).sendKeys(formatteDate);
        driver.findElement(assercaoGravaNFLivroFiscalPage.getFiltrarNF()).click();
        //Thread.sleep(9000);
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(assercaoGravaNFLivroFiscalPage.getConsultarNota()).click();
        totalBrutoNota = driver.findElement(assercaoGravaNFLivroFiscalPage.getTotalBrutoNota()).getText();
    }

    public void assercaoStatusMeio() {
        statusMeio = driver.findElement(assercaoGravaNFLivroFiscalPage.getConsultarStatus()).getText();
        Assert.assertEquals("P", statusMeio);
    }
}

