package com.titansoftware.funcs.EstoqueFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.EstoquePages.ValidarAjusteSobraManualPage;
import com.titansoftware.pages.EstoquePages.ValidarQuebraDeEstoquePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarAjusteSobraManualFunc extends BaseTeste {

    ValidarAjusteSobraManualPage validarAjusteSobraManualPage = new ValidarAjusteSobraManualPage();
    ValidarQuebraDeEstoquePage validarQuebraDeEstoquePage = new ValidarQuebraDeEstoquePage();
    String alert;
    String numDoc;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void validaAjusteSobra(String quantidade, String produto, String operacoes) throws InterruptedException {
        driver.switchTo().frame("Dir");
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getIncluirMovimentacao())).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.switchTo().frame("ifrmPopUpObj");
        wait.until(ExpectedConditions.elementToBeClickable(validarAjusteSobraManualPage.getBtnAjuste())).click();
        Select loja = new Select(driver.findElement(validarQuebraDeEstoquePage.getSelectLoja()));
        loja.selectByValue("1");
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getIncluiPLU())).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getInputPLU())).sendKeys(produto);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getInputPLU())).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getBtnEnviar()));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnEnviar())).click();
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getMotivoQuebra())).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getMotivoQuebra()));
        Select motivo = new Select(driver.findElement(validarQuebraDeEstoquePage.getMotivoQuebra()));
        motivo.selectByIndex(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getEmbalagem()));
        Select embalagem = new Select(driver.findElement(validarQuebraDeEstoquePage.getEmbalagem()));
        embalagem.selectByIndex(1);
        Select operacao = new Select(driver.findElement(validarAjusteSobraManualPage.getFiltroOperacao()));
        operacao.selectByValue(operacoes);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getQntdQuebra())).sendKeys(quantidade);
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getIncluiQuebra())).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert().getText();
        String nDocumento = alert;
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nDocumento);
        StringBuilder numero = new StringBuilder();
        while (matcher.find()) {
            numero.append(matcher.group());
            numDoc = String.valueOf(numero);
        }
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Dir");
        Thread.sleep(7000);
        Select filtrarPor = new Select(driver.findElement(validarQuebraDeEstoquePage.getSelectFiltro()));
        filtrarPor.selectByValue("doc");
        driver.findElement(validarQuebraDeEstoquePage.getSelectFiltro()).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getCampoDados())).sendKeys(numDoc);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getCampoFiltro())).sendKeys(produto);
        wait.until(ExpectedConditions.elementToBeClickable(validarAjusteSobraManualPage.getCheckAjuste())).click();
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnFiltrar())).click();
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnAlterar())).click();
        Thread.sleep(7000);
        driver.switchTo().frame("ifrmPopUpObj");
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnValidar())).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Dir");
    }
}
