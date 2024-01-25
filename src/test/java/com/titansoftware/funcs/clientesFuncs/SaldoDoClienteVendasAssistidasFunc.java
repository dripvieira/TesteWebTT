package com.titansoftware.funcs.clientesFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.faturamentoFuncs.EmitirVendaAssistidaFunc;
import com.titansoftware.pages.clientesPages.SaldoDoClienteVendasAssistidasPage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SaldoDoClienteVendasAssistidasFunc extends BaseTeste {

    SaldoDoClienteVendasAssistidasPage saldoDoClienteVendasAssistidasPage = new SaldoDoClienteVendasAssistidasPage();

    public static String saldoInicial;
    public static String saldoPosVenda;
    public static String saldoPosBaixa;
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;


    /**
     * Insere dados do cliente selecionado, filtra e resgata o saldo inicial para conferência ao final do processo
     */

    public void ResgatarSaldoInicial() {
        driver.findElement(saldoDoClienteVendasAssistidasPage.getDadoFiltro()).sendKeys("16");
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(saldoDoClienteVendasAssistidasPage.getBtnFiltrar()).click();
        saldoInicial = driver.findElement(saldoDoClienteVendasAssistidasPage.getSaldoInicial()).getText();
    }

    /**
     * Insere dados do cliente selecionado, filtra e resgata o saldo após realizar uma venda para conferência ao final do processo
     */
    public void ResgatarSaldoPosVenda() {
        actions.moveToElement(driver.findElement(saldoDoClienteVendasAssistidasPage.getDadoFiltro())).click().perform();
        driver.findElement(saldoDoClienteVendasAssistidasPage.getDadoFiltro()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(saldoDoClienteVendasAssistidasPage.getDadoFiltro()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(saldoDoClienteVendasAssistidasPage.getDadoFiltro()).sendKeys("16");
        saldoPosVenda = driver.findElement(saldoDoClienteVendasAssistidasPage.getSaldoInicial()).getText();
    }

    /**
     * Insere dados do cliente selecionado, filtra e resgata o saldo após realizar baixa na fatura para conferência ao final do processo
     */
    public void ResgatarSaldoPosBaixa() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(saldoDoClienteVendasAssistidasPage.getDadoFiltro())))).click().perform();
        driver.findElement(saldoDoClienteVendasAssistidasPage.getDadoFiltro()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(saldoDoClienteVendasAssistidasPage.getDadoFiltro()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(saldoDoClienteVendasAssistidasPage.getDadoFiltro()).sendKeys("16");
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(saldoDoClienteVendasAssistidasPage.getBtnFiltrar()).click();
        actions.moveToElement(driver.findElement(saldoDoClienteVendasAssistidasPage.getBtnFiltrar())).click().perform();
        saldoPosBaixa = driver.findElement(saldoDoClienteVendasAssistidasPage.getSaldoInicial()).getText();
    }

    /**
     * Realiza a asserção de saldo inicial, pos venda e pos baixa nos processoas anteriores
     */
    public void AssercaoSaldos() {
        float saldoIni = Float.parseFloat(saldoInicial.replace(",", "."));
        float saldoPosV = Float.parseFloat(saldoPosVenda.replace(",", "."));
        float saldoPosB = Float.parseFloat(saldoPosBaixa.replace(",", "."));
        float totalNF = Float.parseFloat(EmitirVendaAssistidaFunc.TotalNotaEmitida.replace(",", "."));
        float somaSaldo = saldoPosV + totalNF;
        float delta = 0.02f;
        Assert.assertEquals(saldoIni, somaSaldo, delta);
        Assert.assertEquals(saldoIni, saldoPosB, delta);
    }
}
