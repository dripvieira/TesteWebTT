package com.titansoftware.funcs.ProdutosFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.produtosPages.AssercaoValorLiquidoMedioBrutoPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AssercaoValorLiquidoMedioBrutoFunc extends BaseTeste {

    AssercaoValorLiquidoMedioBrutoPage assercaoValorLiquidoMedioBrutoPage = new AssercaoValorLiquidoMedioBrutoPage();
    public AssercaoValorLiquidoMedioBrutoFunc() {
    }


    public void pesquisarProduto() {
        wait.until(ExpectedConditions.presenceOfElementLocated(assercaoValorLiquidoMedioBrutoPage.getInserirCodigoProduto()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(assercaoValorLiquidoMedioBrutoPage.getInserirCodigoProduto()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(assercaoValorLiquidoMedioBrutoPage.getInserirCodigoProduto()))).sendKeys("20000");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(assercaoValorLiquidoMedioBrutoPage.getInserirCodigoProduto()))).sendKeys(Keys.ESCAPE);
        driver.findElement(assercaoValorLiquidoMedioBrutoPage.getFiltrarCodigoProduto()).click();

    }

    public String resgatarValorBruto() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(assercaoValorLiquidoMedioBrutoPage.getResgatarValorbruto()));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(assercaoValorLiquidoMedioBrutoPage.getResgatarValorbruto()))).getText();
    }

    public String resgatarValorLiquido() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(assercaoValorLiquidoMedioBrutoPage.getResgatarValorLiquido()));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(assercaoValorLiquidoMedioBrutoPage.getResgatarValorLiquido()))).getText();
    }

    public String resgatarValorMedio() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(assercaoValorLiquidoMedioBrutoPage.getResgatarValorMedio()));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(assercaoValorLiquidoMedioBrutoPage.getResgatarValorMedio()))).getText();
    }


}
