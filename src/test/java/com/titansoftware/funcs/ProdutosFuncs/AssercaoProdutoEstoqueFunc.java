package com.titansoftware.funcs.ProdutosFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.produtosPages.AssercaoProdutosEstoquePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AssercaoProdutoEstoqueFunc extends BaseTeste {

    AssercaoProdutosEstoquePage assercaoProdutosEstoquePage = new AssercaoProdutosEstoquePage();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public String consultarProdutoEstoqueInicial() {
        try {
            System.out.println("Texto do alerta: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
        }
        driver.findElement(assercaoProdutosEstoquePage.getCampoDescricaoProduto()).clear();
        driver.findElement(assercaoProdutosEstoquePage.getCampoDescricaoProduto()).sendKeys("20000");
        driver.findElement(assercaoProdutosEstoquePage.getCampoDescricaoProduto()).sendKeys(Keys.RETURN);
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(assercaoProdutosEstoquePage.getConsultarProdutoEscolhido()).click();
        return null;
    }

    public String estoqueInicial() {
        wait.until(ExpectedConditions.presenceOfElementLocated(assercaoProdutosEstoquePage.getSelecionarCampoTabela()));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(assercaoProdutosEstoquePage.getSelecionarCampoTabela()))).getText();
    }

    public String consultarProdutoEstoqueFinal() {
        driver.switchTo().defaultContent();
        driver.findElement(assercaoProdutosEstoquePage.getAcessarModuloProdutos()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(assercaoProdutosEstoquePage.getAcessarMenuProdutos()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(assercaoProdutosEstoquePage.getAcessarMenuProdutos()))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(assercaoProdutosEstoquePage.getAcessarSubMenuProdutos()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(assercaoProdutosEstoquePage.getAcessarSubMenuProdutos()))).click();
        driver.switchTo().frame("Dir");
        driver.findElement(assercaoProdutosEstoquePage.getCampoDescricaoProduto()).clear();
        driver.findElement(assercaoProdutosEstoquePage.getCampoDescricaoProduto()).sendKeys("20000");
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(assercaoProdutosEstoquePage.getBotaoFiltrarProdutos()).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(assercaoProdutosEstoquePage.getConsultarProdutoEscolhido()).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(assercaoProdutosEstoquePage.getSelecionarCampoTabela())).getText();
    }

    public String estoqueFinal() {
        wait.until(ExpectedConditions.presenceOfElementLocated(assercaoProdutosEstoquePage.getSelecionarCampoTabela()));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(assercaoProdutosEstoquePage.getSelecionarCampoTabela()))).getText();
    }
}
