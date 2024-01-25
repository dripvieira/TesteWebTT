package com.titansoftware.funcs.clientesFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.clientesPages.AcessosModuloClientesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ModuloClientesAcessosFunc extends BaseTeste {

    AcessosModuloClientesPage acessosModuloClientesPage = new AcessosModuloClientesPage();
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
     * Acessa módulo clientes
     */
    public void acessarModuloClientes() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        while (!isElementVisible(driver, acessosModuloClientesPage.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(acessosModuloClientesPage.getAcessarModuloClientes()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(acessosModuloClientesPage.getAcessarModuloClientes()));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(acessosModuloClientesPage.getAcessarModuloClientes()))).click();
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Acessa Menu Cliente
     */
    public void acessarMenuCliente() {
        wait.until(ExpectedConditions.presenceOfElementLocated(acessosModuloClientesPage.getAcessarMenuCliente()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(acessosModuloClientesPage.getAcessarMenuCliente()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(acessosModuloClientesPage.getAcessarMenuCliente()))).click();
    }

    /**
     * Acessa submenu cliente
     */
    public void acessarSubMenuCliente() {
        wait.until(ExpectedConditions.presenceOfElementLocated(acessosModuloClientesPage.getAcessarSubMenuManutencaoClientes()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(acessosModuloClientesPage.getAcessarSubMenuManutencaoClientes()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(acessosModuloClientesPage.getAcessarSubMenuManutencaoClientes()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");

//        wait.until((ExpectedCondition<Boolean>) driver -> {
//            WebElement element = driver.findElement(By.cssSelector("#tudo"));
//            return !element.isEnabled() && !element.isDisplayed();
//        });
    }
}

