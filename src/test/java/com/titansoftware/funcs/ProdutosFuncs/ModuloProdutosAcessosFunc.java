package com.titansoftware.funcs.ProdutosFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.produtosPages.AssercaoProdutosEstoquePage;
import com.titansoftware.pages.produtosPages.ModuloProdutosAcessosPages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModuloProdutosAcessosFunc extends BaseTeste {
    AssercaoProdutosEstoquePage assercaoProdutosEstoquePage = new AssercaoProdutosEstoquePage();
    ModuloProdutosAcessosPages moduloProdutosAcessosPages = new ModuloProdutosAcessosPages();
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

    public void acessarModuloProdutos() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        Thread.sleep(5000);
        driver.switchTo().defaultContent();

        while (!isElementVisible(driver, assercaoProdutosEstoquePage.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(assercaoProdutosEstoquePage.getAcessarModuloProdutos()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(assercaoProdutosEstoquePage.getAcessarModuloProdutos()));
                actions.moveToElement(driver.findElement(assercaoProdutosEstoquePage.getAcessarModuloProdutos())).build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(assercaoProdutosEstoquePage.getAcessarModuloProdutos()))).click();

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void acessarMenuProdutos() {
        wait.until(ExpectedConditions.presenceOfElementLocated(assercaoProdutosEstoquePage.getAcessarMenuProdutos()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assercaoProdutosEstoquePage.getAcessarMenuProdutos())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(assercaoProdutosEstoquePage.getAcessarMenuProdutos()))).click();
    }

    public void acessarSubMenuProdutos() {
        wait.until(ExpectedConditions.presenceOfElementLocated(assercaoProdutosEstoquePage.getAcessarSubMenuProdutos()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assercaoProdutosEstoquePage.getAcessarSubMenuProdutos())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(assercaoProdutosEstoquePage.getAcessarSubMenuProdutos()))).click();
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

    public void acessarMenuPrecoVenda() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloProdutosAcessosPages.getAcessarMenuPrecoVenda()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloProdutosAcessosPages.getAcessarMenuPrecoVenda()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloProdutosAcessosPages.getAcessarMenuPrecoVenda()))).click();
    }

    public void acessarSubMenuLinkHistoricoDePreco() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloProdutosAcessosPages.getAcessarSubMenuLinkHistoricoDePreco()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloProdutosAcessosPages.getAcessarSubMenuLinkHistoricoDePreco()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloProdutosAcessosPages.getAcessarSubMenuLinkHistoricoDePreco()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }

    public void acessarSubMenuOfertas() {
        wait.until(ExpectedConditions.presenceOfElementLocated(moduloProdutosAcessosPages.getAcessarSubMenuOfertas()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moduloProdutosAcessosPages.getAcessarSubMenuOfertas()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(moduloProdutosAcessosPages.getAcessarSubMenuOfertas()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }

}
