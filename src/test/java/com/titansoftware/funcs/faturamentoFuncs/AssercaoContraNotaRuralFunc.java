package com.titansoftware.funcs.faturamentoFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.pages.faturamentoPages.AssercaoContraNotaRuralPages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssercaoContraNotaRuralFunc extends BaseTeste {
    AssercaoContraNotaRuralPages assercaoContraNotaRuralPages = new AssercaoContraNotaRuralPages();
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formatteDate = currentDate.format(formatter);
    String codNFRural = EntradaDeNotaFiscalFunc.codigoNFRural;
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void filtrarNotaRural() {
        Select loja = new Select(driver.findElement(assercaoContraNotaRuralPages.getSelectLoja()));
        loja.selectByValue("1");
        Select filtarPor = new Select(driver.findElement(assercaoContraNotaRuralPages.getSelectFiltrarPor()));
        filtarPor.selectByValue("CODIGO_NOTA");
        Select operacao = new Select(driver.findElement(assercaoContraNotaRuralPages.getOperacao()));
        operacao.selectByValue("LIKE");
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(codNFRural);
        StringBuilder codigoNFRural = new StringBuilder();
        while (matcher.find()) {
            codigoNFRural.append(matcher.group());
        }
        driver.findElement(assercaoContraNotaRuralPages.getValor()).sendKeys(codigoNFRural);
        Select tipoData = new Select(driver.findElement(assercaoContraNotaRuralPages.getTipoData()));
        tipoData.selectByValue("tfn.fnf_movimento");
        driver.findElement(assercaoContraNotaRuralPages.getDataInicial()).sendKeys(formatteDate);
        driver.findElement(assercaoContraNotaRuralPages.getDataFinal()).sendKeys(formatteDate);
        driver.findElement(assercaoContraNotaRuralPages.getBotaoFiltrar()).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }

    public void clicarAlterarNotaRural() {
        driver.findElement(assercaoContraNotaRuralPages.getBotaoAlterar()).click();
        try {
            driver.findElement(assercaoContraNotaRuralPages.getClicarMsg()).click();
        } catch (Exception e) {

        }
        Select serieNota = new Select(driver.findElement(assercaoContraNotaRuralPages.getSerieNF()));
        serieNota.selectByValue("2");
        driver.findElement(assercaoContraNotaRuralPages.getDataSaida()).sendKeys(formatteDate);
        try {
            driver.findElement(assercaoContraNotaRuralPages.getClicarMsg()).click();
        } catch (Exception e) {

        }
        driver.findElement(assercaoContraNotaRuralPages.getClicarEmitirNF()).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(assercaoContraNotaRuralPages.getConfirmar()))).click();
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
        }
        actions.moveToElement(driver.findElement(assercaoContraNotaRuralPages.getImpressaoPdf())).build().perform();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(assercaoContraNotaRuralPages.getImpressaoPdf()).click();
        driver.findElement(assercaoContraNotaRuralPages.getConfirmar()).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(assercaoContraNotaRuralPages.getConfirmar()).click();
        try {
            driver.findElement(assercaoContraNotaRuralPages.getClicarMsg()).click();
        } catch (Exception e) {
        }
    }

    public void filtrarNotaRuralEmitida() {
        Select loja = new Select(driver.findElement(assercaoContraNotaRuralPages.getSelectLoja()));
        loja.selectByValue("1");
        Select filtarPor = new Select(driver.findElement(assercaoContraNotaRuralPages.getSelectFiltrarPor()));
        filtarPor.selectByValue("CODIGO_NOTA");
        Select operacao = new Select(driver.findElement(assercaoContraNotaRuralPages.getOperacao()));
        operacao.selectByValue("LIKE");
        Select tipoData = new Select(driver.findElement(assercaoContraNotaRuralPages.getTipoData()));
        tipoData.selectByValue("tfn.fnf_movimento");
        driver.findElement(assercaoContraNotaRuralPages.getDataInicial()).sendKeys(formatteDate);
        driver.findElement(assercaoContraNotaRuralPages.getDataFinal()).sendKeys(formatteDate);
        driver.findElement(assercaoContraNotaRuralPages.getBotaoFiltrar()).click();
    }

    public String verificarStatus() {
        return driver.findElement(assercaoContraNotaRuralPages.getVerificarStatus()).getText();
    }
}
