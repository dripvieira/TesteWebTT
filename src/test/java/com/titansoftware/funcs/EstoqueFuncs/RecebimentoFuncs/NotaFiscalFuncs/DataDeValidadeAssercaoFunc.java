package com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.EstoquePages.RecebimentoPages.NotaFiscalPages.DataDeValidadeAssercaoPages;
import com.titansoftware.pages.EstoquePages.RecebimentoPages.NotaFiscalPages.EntradaDeNotaFiscalPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class DataDeValidadeAssercaoFunc extends BaseTeste {

    EntradaDeNotaFiscalPage entradaDeNotaFiscalPage = new EntradaDeNotaFiscalPage();
    DataDeValidadeAssercaoPages dataDeValidadeAssercaoPages = new DataDeValidadeAssercaoPages();

    String NF = EntradaDeNotaFiscalFunc.nF.substring(0, 8);

    String data = EntradaDeNotaFiscalFunc.emissaoNF;


    public void pesquisarNF() {
        Select loja = new Select(driver.findElement(dataDeValidadeAssercaoPages.getSelectLoja()));
        loja.selectByIndex(1);
        Select filtrarPor = new Select(driver.findElement(dataDeValidadeAssercaoPages.getFiltrarPor()));
        filtrarPor.selectByIndex(0);
        Select condicao = new Select(driver.findElement(dataDeValidadeAssercaoPages.getCondicao()));
        condicao.selectByIndex(0);
        driver.findElement(dataDeValidadeAssercaoPages.getCondicao()).sendKeys(Keys.TAB);
        driver.findElement(dataDeValidadeAssercaoPages.getDataEmissaoInicial()).sendKeys(data);
        driver.findElement(dataDeValidadeAssercaoPages.getDataEmissaoFinal()).sendKeys(data);
        driver.findElement(dataDeValidadeAssercaoPages.getDataEmissaoFinal()).sendKeys(Keys.RETURN);
        driver.findElement(dataDeValidadeAssercaoPages.getDadosFiltro()).sendKeys(NF);
        driver.findElement(dataDeValidadeAssercaoPages.getDesativarParipassus()).click();
        driver.findElement(dataDeValidadeAssercaoPages.getBotaoFiltrar()).click();
    }

    public void consultarNF() {
        wait.until(ExpectedConditions.presenceOfElementLocated(dataDeValidadeAssercaoPages.getConsultarNf()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(dataDeValidadeAssercaoPages.getConsultarNf()))).click();
    }

    public void consultarextratoRomaneio() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(dataDeValidadeAssercaoPages.getConsultarRomaneio()))).click();
    }

    public String resgatarDataDeValidade() {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.switchTo().window(ChildWindow);
                return driver.findElement(dataDeValidadeAssercaoPages.getResgatarDataDeValidade()).getText();
            }
        }
        return mainWindowHandle;
    }
}
