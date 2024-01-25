package com.titansoftware.funcs.vendasAssistidasFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.vendasAssistidasPages.VendasAssistidaAcessosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VendasAssistidaAcessosFunc extends BaseTeste {
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    VendasAssistidaAcessosPage vendasAssistidaAcessosPage = new VendasAssistidaAcessosPage();

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
     * Acessa módulo Vendas Assistidas
     */
    public void acessarModuloVendasAssistida() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        driver.switchTo().defaultContent();


        while (!isElementVisible(driver, vendasAssistidaAcessosPage.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(vendasAssistidaAcessosPage.getEntrarVendasAssistidas()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(vendasAssistidaAcessosPage.getEntrarVendasAssistidas()));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(vendasAssistidaAcessosPage.getEntrarVendasAssistidas()))).click();

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Acessa Menu Vendas Assistidas
     */

    public void acessarMenuVendasAssistidas() {
        wait.until(ExpectedConditions.presenceOfElementLocated(vendasAssistidaAcessosPage.getSubMenuVendasAssistidas()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(vendasAssistidaAcessosPage.getSubMenuVendasAssistidas())));
        driver.findElement(vendasAssistidaAcessosPage.getSubMenuVendasAssistidas()).click();
    }

    /**
     * Acessar submenu Vendas
     */
    public void acessarSubMenuVendas() {
        wait.until(ExpectedConditions.presenceOfElementLocated(vendasAssistidaAcessosPage.getEntrarVendas()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(vendasAssistidaAcessosPage.getEntrarVendas())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(vendasAssistidaAcessosPage.getEntrarVendas()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }


}
