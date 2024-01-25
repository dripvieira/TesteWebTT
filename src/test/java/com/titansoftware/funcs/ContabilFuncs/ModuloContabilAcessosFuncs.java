package com.titansoftware.funcs.ContabilFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.ContabilPages.ModuloContabilAcessosPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModuloContabilAcessosFuncs extends BaseTeste {

    ModuloContabilAcessosPages moduloContábilAcessosPages = new ModuloContabilAcessosPages();
    Actions actions = new Actions(driver);
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
     * Acessa módulo contábil
     */
    public void acessarModuloContabil() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        Thread.sleep(5000);
        driver.switchTo().defaultContent();


        while (!isElementVisible(driver, moduloContábilAcessosPages.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(moduloContábilAcessosPages.getAcessarModuloContabil()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(moduloContábilAcessosPages.getAcessarModuloContabil()));
                actions.moveToElement(driver.findElement(moduloContábilAcessosPages.getAcessarModuloContabil())).click().perform();
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Acessa o menu contabilidade no módulo contábil
     *
     * @throws InterruptedException aplicação não possui elementos com parâmetros passiveis de serem utilizados para esperas aninhadas
     */
    public void AcessarMenuContabilidade() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloContábilAcessosPages.getAcessarMenuContabilidade()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloContábilAcessosPages.getAcessarMenuContabilidade()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloContábilAcessosPages.getAcessarMenuContabilidade()))).click();
    }

    /**
     * Acessa o submenu lançamento contábil no módulo contábil
     *
     * @throws InterruptedException
     */
    public void acessarSubMenuLancamentoContabil() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloContábilAcessosPages.getAcessarSubMenuLancamentoContabil()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloContábilAcessosPages.getAcessarSubMenuLancamentoContabil()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloContábilAcessosPages.getAcessarSubMenuLancamentoContabil()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }
}
