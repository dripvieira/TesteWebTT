package com.titansoftware.funcs.EstoqueFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.EstoquePages.ModulosEstoqueAcessosPages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModuloEstoqueAcessosFunc extends BaseTeste {
    ModulosEstoqueAcessosPages modulosEstoqueAcessosPages = new ModulosEstoqueAcessosPages();
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
     * Acessa o módulo estoque
     */

    public void acessarModuloEstoque() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        while (!isElementVisible(driver, modulosEstoqueAcessosPages.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(modulosEstoqueAcessosPages.getAcessarModuloEstoque()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(modulosEstoqueAcessosPages.getAcessarModuloEstoque()));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(modulosEstoqueAcessosPages.getAcessarModuloEstoque()))).click();

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Acessa o menu recebimento dentro do módulo estoque
     */
    public void acessarMenuRecebimento() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modulosEstoqueAcessosPages.getAcessarMenuRecebimento()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modulosEstoqueAcessosPages.getAcessarMenuRecebimento()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(modulosEstoqueAcessosPages.getAcessarMenuRecebimento()))).click();
    }

    /**
     * Acessa o submenu nota fiscal 2.0 dentro do módulo estoque
     */
    public void acessarSubMenuNotaFiscal2() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modulosEstoqueAcessosPages.getAcessarSubMenuNF2()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modulosEstoqueAcessosPages.getAcessarSubMenuNF2()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(modulosEstoqueAcessosPages.getAcessarSubMenuNF2()))).click();
        try {
            System.out.println("Texto do alerta: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }

    public void acessarSubMenuImportacaoNFE() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modulosEstoqueAcessosPages.getAcessarSubMenuImportacao()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modulosEstoqueAcessosPages.getAcessarSubMenuImportacao()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(modulosEstoqueAcessosPages.getAcessarSubMenuImportacao()))).click();
        try {
            System.out.println("Texto do alerta: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    public void acessarMenuRelatorios() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modulosEstoqueAcessosPages.getSelecionarRelatorios()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modulosEstoqueAcessosPages.getSelecionarRelatorios()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(modulosEstoqueAcessosPages.getSelecionarRelatorios()))).click();
    }

    public void acessarMenuInventario() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modulosEstoqueAcessosPages.getSelecionarMenuInventario()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modulosEstoqueAcessosPages.getSelecionarMenuInventario()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(modulosEstoqueAcessosPages.getSelecionarMenuInventario()))).click();
    }

    public void acessarSubMenuMovimentacaoEstoque() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modulosEstoqueAcessosPages.getSelecionarMovimentacao()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modulosEstoqueAcessosPages.getSelecionarMovimentacao()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(modulosEstoqueAcessosPages.getSelecionarMovimentacao()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    public void acessarSubMenuEvolucaoEstoque() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modulosEstoqueAcessosPages.getSelecionarEvolucaoEstoque()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modulosEstoqueAcessosPages.getSelecionarEvolucaoEstoque()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(modulosEstoqueAcessosPages.getSelecionarEvolucaoEstoque()))).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        //wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    public void acessarSubMenuInventario() {
        wait.until(ExpectedConditions.presenceOfElementLocated(modulosEstoqueAcessosPages.getSelecionarSubMenuInventario()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modulosEstoqueAcessosPages.getSelecionarSubMenuInventario()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(modulosEstoqueAcessosPages.getSelecionarSubMenuInventario()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }
}
