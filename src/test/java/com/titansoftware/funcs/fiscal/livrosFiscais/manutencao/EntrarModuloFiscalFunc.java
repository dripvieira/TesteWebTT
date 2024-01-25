package com.titansoftware.funcs.fiscal.livrosFiscais.manutencao;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.fiscal.livrosFiscais.manutencao.EntrarManutencaoLivroFiscalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EntrarModuloFiscalFunc extends BaseTeste {


    EntrarManutencaoLivroFiscalPage entrarManutencaoLivroFiscalPage = new EntrarManutencaoLivroFiscalPage();
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

    public void acessarModuloFiscal() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        driver.switchTo().defaultContent();

        while (!isElementVisible(driver, entrarManutencaoLivroFiscalPage.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(entrarManutencaoLivroFiscalPage.getAcessarModuloFiscal()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(entrarManutencaoLivroFiscalPage.getAcessarModuloFiscal()));
                actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entrarManutencaoLivroFiscalPage.getAcessarModuloFiscal())))).click().perform();

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void acessarMenuLivroFiscal() {
        wait.until(ExpectedConditions.presenceOfElementLocated(entrarManutencaoLivroFiscalPage.getAcessarLivroFiscal()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(entrarManutencaoLivroFiscalPage.getAcessarLivroFiscal()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entrarManutencaoLivroFiscalPage.getAcessarLivroFiscal()))).click();
    }

    public void acessarSubMenuManutencaoLivroFiscal() {
        wait.until(ExpectedConditions.presenceOfElementLocated(entrarManutencaoLivroFiscalPage.getManutencaoLivroFiscal()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(entrarManutencaoLivroFiscalPage.getManutencaoLivroFiscal()));
        driver.findElement(entrarManutencaoLivroFiscalPage.getManutencaoLivroFiscal()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }
}
