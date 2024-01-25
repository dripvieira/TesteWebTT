package com.titansoftware.funcs.ProdutosFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.produtosPages.DescontoProdutoPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DescontoProdutoFunc extends BaseTeste {
    DescontoProdutoPage descontoProdutoPage = new DescontoProdutoPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void inserirDesconto(String plu, String desconto) {
        driver.findElement(descontoProdutoPage.getCampoDados()).sendKeys(plu);
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(descontoProdutoPage.getFiltraPlu()))).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(descontoProdutoPage.getBtnAlterar()))).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(descontoProdutoPage.getCampoDesconto()))).click();
        driver.findElement(descontoProdutoPage.getCampoDesconto()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(descontoProdutoPage.getCampoDesconto()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(descontoProdutoPage.getCampoDesconto()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(descontoProdutoPage.getCampoDesconto()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(descontoProdutoPage.getCampoDesconto()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(descontoProdutoPage.getCampoDesconto()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(descontoProdutoPage.getCampoDesconto()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(descontoProdutoPage.getCampoDesconto()).sendKeys(desconto);
        driver.findElement(descontoProdutoPage.getBtnSalva()).click();
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tudo")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(descontoProdutoPage.getBtnVoltar()))).click();
    }

    public String subTotalPLU() {
        js.executeScript("document.getElementById('tudo').style.display='none';");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[1]/div[2]/div[2]/div[13]/div[3]/div/div/div/div[3]/input[5]"))).getAttribute("value");
    }

    public String valorTotalPLU() {
        js.executeScript("document.getElementById('tudo').style.display='none';");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[1]/div[2]/div[2]/div[13]/div[3]/div/div/div/div[3]/input[6]"))).getAttribute("value");
    }

    public void assercaoDesconto(String porcentagemDesconto) {
        float desc = Float.parseFloat(porcentagemDesconto);
        float subTotal = Float.parseFloat(subTotalPLU().replace(",", "."));
        float vlrTotal = Float.parseFloat(valorTotalPLU().replace(",", "."));

        float descontoPorcentagem = 100 - desc;
        float calcPorcentagem = descontoPorcentagem / 100;
        float totalDesc = subTotal * calcPorcentagem;
        float delta = 0.01f;


        Assert.assertEquals(totalDesc, vlrTotal, delta);
    }
}
