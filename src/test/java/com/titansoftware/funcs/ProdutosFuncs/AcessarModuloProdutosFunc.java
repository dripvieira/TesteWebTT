package com.titansoftware.funcs.ProdutosFuncs;


import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.produtosPages.AcessarModuloProdutosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AcessarModuloProdutosFunc extends BaseTeste {

    AcessarModuloProdutosPage acessarModuloProdutosPage = new AcessarModuloProdutosPage();
    Actions actions = new Actions(driver);

    public void acessarModuloProdutos() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        driver.switchTo().defaultContent();
        actions.moveToElement(driver.findElement(acessarModuloProdutosPage.getSelecionarModuloProdutos())).click().perform();
    }
}
