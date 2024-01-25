package com.titansoftware.funcs.financeiro;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.financeiro.ModuloFinanceiroAcessoPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModuloFinanceiroAcessosFuncs extends BaseTeste {
    ModuloFinanceiroAcessoPages moduloFinanceiroAcessosPages = new ModuloFinanceiroAcessoPages();
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

    public void acessarModuloFinanceiro() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        Thread.sleep(5000);
        driver.switchTo().defaultContent();


        while (!isElementVisible(driver, moduloFinanceiroAcessosPages.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(moduloFinanceiroAcessosPages.getAcessarModuloFinanceiro()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(moduloFinanceiroAcessosPages.getAcessarModuloFinanceiro()));
                driver.findElement(moduloFinanceiroAcessosPages.getAcessarModuloFinanceiro()).click();

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void acessarMenuContasAPagar() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloFinanceiroAcessosPages.getAcessarContasAPagar()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloFinanceiroAcessosPages.getAcessarContasAPagar()));
        driver.findElement(moduloFinanceiroAcessosPages.getAcessarContasAPagar()).click();
    }

    public void acessarSubMenuManutencaoDeTitulo() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloFinanceiroAcessosPages.getAcessarManutencaoDeTitulos()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloFinanceiroAcessosPages.getAcessarManutencaoDeTitulos()));
        driver.findElement(moduloFinanceiroAcessosPages.getAcessarManutencaoDeTitulos()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }

}
