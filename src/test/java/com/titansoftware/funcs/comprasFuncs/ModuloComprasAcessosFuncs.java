package com.titansoftware.funcs.comprasFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.pages.comprasPages.ModuloComprasAcessosPage;
import com.titansoftware.pages.comprasPages.PedidoDeComprasItemAItemPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ModuloComprasAcessosFuncs extends BaseTeste {

    ModuloComprasAcessosPage moduloComprasAcessosPage = new ModuloComprasAcessosPage();
    PedidoDeComprasItemAItemPage pedidoDeComprasItemAItemPage = new PedidoDeComprasItemAItemPage();
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
     * Acessa módulo compras
     */
    public void acessarModuloCompras() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        while (!isElementVisible(driver, moduloComprasAcessosPage.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(moduloComprasAcessosPage.getAcessarModuloCompras()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(moduloComprasAcessosPage.getAcessarModuloCompras()));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloComprasAcessosPage.getAcessarModuloCompras()))).click();
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Acessa menu compras dentro do módulo compras
     *
     * @throws InterruptedException aplicação não possui elementos com parâmetros passiveis de serem utilizados para esperas aninhadas
     */

    public void acessarMenuCompras() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloComprasAcessosPage.getAcessarMenuCompras()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloComprasAcessosPage.getAcessarMenuCompras()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloComprasAcessosPage.getAcessarMenuCompras()))).click();
    }

    /**
     * Acessa submenu pedido de compras dentro do módulo compras
     *
     * @throws InterruptedException aplicação não possui elementos com parâmetros passiveis de serem utilizados para esperas aninhadas
     */
    public void AcessarSubMenuPedidoDeCompras() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloComprasAcessosPage.getAcessarSubMenuPedidoDeCompras()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloComprasAcessosPage.getAcessarSubMenuPedidoDeCompras()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloComprasAcessosPage.getAcessarSubMenuPedidoDeCompras()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    /**
     * Insere dados do pedido e o localiza atrávés de filtragem
     *
     * @throws InterruptedException não possui elementos com parâmetros passiveis de serem utilizados para esperas aninhadas
     */

    public void filtrarPedido() {
        Select selecionarLoja = new Select(driver.findElement(pedidoDeComprasItemAItemPage.getSelecionarLojaPedido()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        selecionarLoja.selectByValue("1");
        driver.findElement(pedidoDeComprasItemAItemPage.getNumeroPedido()).sendKeys(EntradaDeNotaFiscalFunc.numPedido);
        driver.findElement(pedidoDeComprasItemAItemPage.getSelecionarPedidoBaixado()).click();
        driver.findElement(pedidoDeComprasItemAItemPage.getFiltrarPedido()).click();
    }

    /**
     * Resgata a mensagem de pedido baixado para realizar a asserção
     *
     * @return o status do pedido filtrado
     */
    public String assercaoPedidoDeCompras() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(pedidoDeComprasItemAItemPage.getConfirmarPedidoBaixado()))).getText();
    }

}
