package com.titansoftware.funcs.financeiro.contasReceberFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.faturamentoFuncs.EmitirVendaAssistidaFunc;
import com.titansoftware.pages.financeiro.contasReceberPages.TituloVendasAssistidasPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class TituloVendasAssistidasFunc extends BaseTeste {

    public static String resgatarNumTitulo;
    public static String resgatarValorTitulo;
    public static String resgatarStatusTitutlo;
    static String numTitulo;
    public static String titulo;
    TituloVendasAssistidasPage tituloVendasAssistidasPage = new TituloVendasAssistidasPage();
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void consultarTituloNoContasAreceber() {
        numTitulo = EmitirVendaAssistidaFunc.numNFEmitida;
        titulo = numTitulo.substring(0, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(tituloVendasAssistidasPage.getCampoFiltro()))).sendKeys(EmitirVendaAssistidaFunc.numNFEmitida.substring(0, 5));
        actions.moveToElement(driver.findElement(tituloVendasAssistidasPage.getCampoFiltro())).build().perform();
        Select tipoPeriodo = new Select(driver.findElement(tituloVendasAssistidasPage.getPeriodo()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        tipoPeriodo.selectByValue("t.tit_movimento");
        driver.findElement(tituloVendasAssistidasPage.getBtnFiltrar()).click();
    }


    public <List> void baixaTituloVendasAssistidas() {
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(tituloVendasAssistidasPage.getBaixarTitulo()).click();
        Select tipoPagamento = new Select(driver.findElement(tituloVendasAssistidasPage.getTipoCobranca()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        tipoPagamento.selectByValue("B");
        driver.findElement(tituloVendasAssistidasPage.getDataRecebimento()).sendKeys("22/07/2024");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(tituloVendasAssistidasPage.getCalendario()))).isEnabled();
        driver.findElement(tituloVendasAssistidasPage.getDataRecebimento()).click();
        driver.findElement(tituloVendasAssistidasPage.getDataRecebimento()).sendKeys(Keys.TAB);
        driver.findElement(tituloVendasAssistidasPage.getPortador()).sendKeys("1");
        driver.findElement(tituloVendasAssistidasPage.getPortador()).sendKeys(Keys.TAB);
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(tituloVendasAssistidasPage.getCalendario()))).isEnabled();
            driver.findElement(tituloVendasAssistidasPage.getDataRecebimento()).click();
            driver.findElement(tituloVendasAssistidasPage.getDataRecebimento()).sendKeys(Keys.TAB);
        } catch (Exception e) {

        }
        Select recebimento = new Select(driver.findElement(tituloVendasAssistidasPage.getFormaRecebimento()));
        recebimento.selectByValue("2");
        String janelaPai = driver.getWindowHandle();
        Set<String> janelasFilhas = driver.getWindowHandles();
        Iterator<String> interacao = janelasFilhas.iterator();
        while (interacao.hasNext()) {
            String ChildWindow = interacao.next();
            if (!janelaPai.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.findElement(tituloVendasAssistidasPage.getNumFinalizadora()).click();
                driver.switchTo().window(janelaPai);
            }
        }
        driver.switchTo().frame("Dir");
        driver.findElement(tituloVendasAssistidasPage.getCondicaoPgto()).sendKeys(Keys.TAB);
        driver.findElement(tituloVendasAssistidasPage.getIncluirParcela()).click();
        driver.findElement(tituloVendasAssistidasPage.getIncluirParcela()).click();
        driver.findElement(tituloVendasAssistidasPage.getBaixaDoTitulo()).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        while (interacao.hasNext()) {
            String ChildWindow = interacao.next();
            if (!janelaPai.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.switchTo().alert().accept();
                driver.switchTo().window(janelaPai);
            }
        }
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void assercaoContasAReceber() {
        resgatarNumTitulo = driver.findElement(tituloVendasAssistidasPage.getResgatarNumTitulo()).getText();
        resgatarValorTitulo = driver.findElement(tituloVendasAssistidasPage.getResgatarValorTitulo()).getText();
        resgatarStatusTitutlo = driver.findElement(tituloVendasAssistidasPage.getResgatarStatusTitulo()).getText();
    }

}
