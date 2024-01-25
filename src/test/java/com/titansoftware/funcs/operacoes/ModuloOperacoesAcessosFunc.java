package com.titansoftware.funcs.operacoes;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.operacoes.ModuloOperacoesAcessosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModuloOperacoesAcessosFunc extends BaseTeste {
    ModuloOperacoesAcessosPage moduloOperacoesAcessosPage = new ModuloOperacoesAcessosPage();
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

    public void acessarModuloOpercaoes() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        while (!isElementVisible(driver, moduloOperacoesAcessosPage.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(moduloOperacoesAcessosPage.getAcessarModuloOperacoes()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(moduloOperacoesAcessosPage.getAcessarModuloOperacoes()));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloOperacoesAcessosPage.getAcessarModuloOperacoes()))).click();

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void acessarMenuTransacoes() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloOperacoesAcessosPage.getAcessarMenuTransacoes()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloOperacoesAcessosPage.getAcessarMenuTransacoes()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloOperacoesAcessosPage.getAcessarMenuTransacoes()))).click();
    }

    public void acessarSubMenuCargaXML() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloOperacoesAcessosPage.getAcessarSubMenuCargaXML()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloOperacoesAcessosPage.getAcessarSubMenuCargaXML()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloOperacoesAcessosPage.getAcessarSubMenuCargaXML()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }


}
