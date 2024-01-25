package com.titansoftware.funcs.faturamentoFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.faturamentoPages.ModuloFaturamentoPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModuloFaturamentoAcessosFunc extends BaseTeste {
    ModuloFaturamentoPages moduloFaturamentoPages = new ModuloFaturamentoPages();
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

    public void acessarModuloFaturamento() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        Thread.sleep(5000);
        driver.switchTo().defaultContent();

        while (!isElementVisible(driver, moduloFaturamentoPages.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(moduloFaturamentoPages.getModuloFaturamentoAcessar()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(moduloFaturamentoPages.getModuloFaturamentoAcessar()));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloFaturamentoPages.getModuloFaturamentoAcessar()))).click();
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void acessarMenuFaturamento() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloFaturamentoPages.getSubmenuFaturamentoAcessar()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(moduloFaturamentoPages.getSubmenuFaturamentoAcessar())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloFaturamentoPages.getSubmenuFaturamentoAcessar()))).click();
    }

    public void acessarSubMenuEmissaoDeFaturas() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloFaturamentoPages.getFuncaoEmissaoDeFaturas()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(moduloFaturamentoPages.getFuncaoEmissaoDeFaturas())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloFaturamentoPages.getFuncaoEmissaoDeFaturas()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }
}
