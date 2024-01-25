package com.titansoftware.funcs.faturamentoFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.vendasAssistidasFuncs.PedidoVendasFunc;
import com.titansoftware.pages.faturamentoPages.EmitirVendaAssistidaPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmitirVendaAssistidaFunc extends BaseTeste {

    public static String numNFEmitida;
    public static String resgatarPedido;
    public static String regatarStatus;
    public static String resgatarValor;
    public static String TotalNotaEmitida;
    public static String statusVenda;
    EmitirVendaAssistidaPage emitirVendaAssistidaPage = new EmitirVendaAssistidaPage();
    String numPedidoVenda;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    private static boolean isElementVisible(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException |
                 org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    /**
     * Emite uma fatura com os dados resgatados do pedido de vendas assistidas
     */
    public void emitirVenda() {
        String numPedido = PedidoVendasFunc.numeroOrcamento;
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numPedido);
        StringBuilder pedido = new StringBuilder();
        while (matcher.find()) {
            pedido.append(matcher.group());
            numPedidoVenda = String.valueOf(pedido);
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(emitirVendaAssistidaPage.getFiltrarPor()));
        wait.until(ExpectedConditions.elementToBeClickable(emitirVendaAssistidaPage.getFiltrarPor()));
        Select filtro = new Select(driver.findElement(emitirVendaAssistidaPage.getFiltrarPor()));
        filtro.selectByValue("VENDAS_KEY");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emitirVendaAssistidaPage.getValorFiltro()))).sendKeys(numPedidoVenda);
        driver.findElement(emitirVendaAssistidaPage.getBtnFiltrar()).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(emitirVendaAssistidaPage.getAlterarVenda()).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emitirVendaAssistidaPage.getEmitirVenda())));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(emitirVendaAssistidaPage.getMensagemOk()))).click();
        } catch (Exception e) {
        }
        Select serieNota = new Select(driver.findElement(emitirVendaAssistidaPage.getSerieNF()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        serieNota.selectByValue("2");
        TotalNotaEmitida = driver.findElement(emitirVendaAssistidaPage.getResgatartotalNF()).getText();
        driver.findElement(emitirVendaAssistidaPage.getEmitirVenda()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(emitirVendaAssistidaPage.getConfirmar()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emitirVendaAssistidaPage.getConfirmar())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(emitirVendaAssistidaPage.getConfirmar()))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(emitirVendaAssistidaPage.getSelecionarImpressora()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(emitirVendaAssistidaPage.getSelecionarImpressora()))).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(emitirVendaAssistidaPage.getConfirmar()))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(emitirVendaAssistidaPage.getEsperarCarregamento()));
        wait.until(ExpectedConditions.presenceOfElementLocated(emitirVendaAssistidaPage.getConfirmar()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emitirVendaAssistidaPage.getConfirmar()));
        while (isElementVisible(driver, emitirVendaAssistidaPage.getConfirmar())) {
            try {
                driver.findElement(emitirVendaAssistidaPage.getConfirmar()).click();
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(emitirVendaAssistidaPage.getTitulo()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emitirVendaAssistidaPage.getTitulo())));
        numNFEmitida = driver.findElement(emitirVendaAssistidaPage.getTitulo()).getText();
    }

    /**
     * Resgata dados da fatura emitida
     */
    public void NFFaturamento() {
        js.executeScript("document.getElementById('tudo').style.display='none';");
        resgatarPedido = driver.findElement(emitirVendaAssistidaPage.getResgatarPedido()).getText();
        regatarStatus = driver.findElement(emitirVendaAssistidaPage.getResgatarStatus()).getText();
        resgatarValor = driver.findElement(emitirVendaAssistidaPage.getResgatarValor()).getText();
    }

    /**
     * Realiza o filtro e confirma se a fatura foi excluida
     *
     * @param expected recebe atributo do Data Table para realizar asserção
     */
    public void validarExclusao(String expected) {
        String numPedido = PedidoVendasFunc.numeroOrcamento;
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numPedido);
        StringBuilder pedido = new StringBuilder();
        while (matcher.find()) {
            pedido.append(matcher.group());
            numPedidoVenda = String.valueOf(pedido);
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(emitirVendaAssistidaPage.getInputPedido()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emitirVendaAssistidaPage.getInputPedido())).sendKeys(numPedidoVenda);
        driver.findElement(emitirVendaAssistidaPage.getInputPedido()).sendKeys(Keys.TAB);
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(emitirVendaAssistidaPage.getDesabilitarFiltro())).click();
        wait.until(ExpectedConditions.elementToBeClickable(emitirVendaAssistidaPage.getBotaoFiltrar())).click();
        statusVenda = wait.until(ExpectedConditions.visibilityOfElementLocated(emitirVendaAssistidaPage.getResgatarStatusVA())).getText();
        Assert.assertEquals(expected, statusVenda);
    }
}
