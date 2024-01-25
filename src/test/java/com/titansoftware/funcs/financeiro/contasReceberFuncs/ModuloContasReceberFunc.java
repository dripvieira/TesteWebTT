package com.titansoftware.funcs.financeiro.contasReceberFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.financeiro.contasReceberPages.ModuloContasReceberAcessoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModuloContasReceberFunc extends BaseTeste {

    ModuloContasReceberAcessoPage moduloContasReceberAcessoPage = new ModuloContasReceberAcessoPage();
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

    public void acessarModuloContasReceber() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        Thread.sleep(5000);
        driver.switchTo().defaultContent();

        while (!isElementVisible(driver, moduloContasReceberAcessoPage.getElementoTermino())) {
            try {
                driver.findElement(moduloContasReceberAcessoPage.getEntrarFinanceiro()).click();
                driver.findElement(moduloContasReceberAcessoPage.getEntrarContasReceber()).click();
                driver.findElement(moduloContasReceberAcessoPage.getManutencaoTitulos()).click();

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void acessarModuloFinanceiro() {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.switchTo().defaultContent();
        actions.moveToElement(driver.findElement(moduloContasReceberAcessoPage.getEntrarFinanceiro())).click().perform();
    }

    public void acessarMenuContasAReceber() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloContasReceberAcessoPage.getEntrarContasReceber()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloContasReceberAcessoPage.getEntrarContasReceber()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloContasReceberAcessoPage.getEntrarContasReceber()))).click();
    }

    public void acessarSubMenuManutencaoTitulos() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloContasReceberAcessoPage.getManutencaoTitulos()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloContasReceberAcessoPage.getManutencaoTitulos()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloContasReceberAcessoPage.getManutencaoTitulos()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }

}
