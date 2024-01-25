package com.titansoftware.funcs.comprasFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.comprasPages.PedidoDeComprasItemAItemPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PedidoDeComprasItemAItemFunc extends BaseTeste {
    public static String numeroPedido;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate currentDate = LocalDate.now();
    String formatteDate = currentDate.format(formatter);

    PedidoDeComprasItemAItemPage pedidoDeComprasItemAItemPage = new PedidoDeComprasItemAItemPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void InserirDadosPedido(String codigoProdutoPedido, String quantidadeProdutoPedido) {
        Select selecionarLoja = new Select(driver.findElement(pedidoDeComprasItemAItemPage.getSelecionarLoja()));
        selecionarLoja.selectByValue("1");
        driver.findElement(pedidoDeComprasItemAItemPage.getBotaoCodigoLoja()).click();
        driver.switchTo().frame("richiFrameContent");
        driver.findElement(pedidoDeComprasItemAItemPage.getSelecionarFornecedor()).click();
        driver.switchTo().parentFrame();
        driver.findElement(pedidoDeComprasItemAItemPage.getBotaoConfirmarFornecedor()).click();
        driver.findElement(pedidoDeComprasItemAItemPage.getDataDeEntrega()).sendKeys(Keys.CLEAR);
        driver.findElement(pedidoDeComprasItemAItemPage.getDataDeEntrega()).sendKeys(Keys.CLEAR);
        driver.findElement(pedidoDeComprasItemAItemPage.getDataDeEntrega()).sendKeys(formatteDate);
        driver.findElement(pedidoDeComprasItemAItemPage.getPesquisarProduto()).sendKeys(codigoProdutoPedido);
        driver.findElement(pedidoDeComprasItemAItemPage.getBotaoSalvar()).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("progressbar")));
        driver.findElement(pedidoDeComprasItemAItemPage.getQuantidadeProduto()).sendKeys(quantidadeProdutoPedido);
        driver.findElement(pedidoDeComprasItemAItemPage.getQuantidadeProduto()).sendKeys(Keys.RETURN);
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(pedidoDeComprasItemAItemPage.getBotaoSalvar()).click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(pedidoDeComprasItemAItemPage.getConfirmaQuantidade()));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(pedidoDeComprasItemAItemPage.getConfirmaQuantidade())));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(pedidoDeComprasItemAItemPage.getConfirmaQuantidade()))).click();
        } catch (Exception e) {
        }
    }

    public void registraPedidoDeCompras() {
        wait.until(ExpectedConditions.presenceOfElementLocated(pedidoDeComprasItemAItemPage.getResgatarNumeroPedido()));
        numeroPedido = driver.findElement(pedidoDeComprasItemAItemPage.getResgatarNumeroPedido()).getText();
        driver.findElement(pedidoDeComprasItemAItemPage.getRegistrarPedidoDeCompras()).click();
    }

    public String vizualizarPedidoDeCompras() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(pedidoDeComprasItemAItemPage.getMsgConfirmacao()))).getText();
    }
}
