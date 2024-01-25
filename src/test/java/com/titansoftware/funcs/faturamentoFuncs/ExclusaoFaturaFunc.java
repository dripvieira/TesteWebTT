package com.titansoftware.funcs.faturamentoFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.vendasAssistidasFuncs.PedidoVendasFunc;
import com.titansoftware.pages.faturamentoPages.ExclusaoFaturaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExclusaoFaturaFunc extends BaseTeste {

    ExclusaoFaturaPage exclusaoFaturaPage = new ExclusaoFaturaPage();
    String numPedidoVenda;

    public void filtrarPedido() {
        String numPedido = PedidoVendasFunc.numeroOrcamento;
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numPedido);
        StringBuilder pedido = new StringBuilder();
        while (matcher.find()) {
            pedido.append(matcher.group());
            numPedidoVenda = String.valueOf(pedido);
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(exclusaoFaturaPage.getWaitDivTudo()));
        Select filtro = new Select(driver.findElement(exclusaoFaturaPage.getSelectFiltro()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(exclusaoFaturaPage.getWaitDivTudo()));
        filtro.selectByValue("VENDAS_KEY");
        driver.findElement(exclusaoFaturaPage.getFiltroOperacao()).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(exclusaoFaturaPage.getCampoFiltro()))).sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(exclusaoFaturaPage.getCampoFiltro()))).sendKeys(numPedidoVenda);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(exclusaoFaturaPage.getBtnFiltrar()))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(exclusaoFaturaPage.getWaitDivTudo()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(exclusaoFaturaPage.getBtnConsulta()))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
    }

    public void cancelarFatura() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(exclusaoFaturaPage.getWaitDivTudo()));
        wait.until(ExpectedConditions.elementToBeClickable(exclusaoFaturaPage.getClicarCancelarNF())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(exclusaoFaturaPage.getClicarMsg())).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
        wait.until(ExpectedConditions.elementToBeClickable(exclusaoFaturaPage.getClicarMsg())).click();
    }
}
