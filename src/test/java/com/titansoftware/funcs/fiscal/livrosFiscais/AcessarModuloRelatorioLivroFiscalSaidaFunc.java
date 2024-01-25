package com.titansoftware.funcs.fiscal.livrosFiscais;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.fiscal.RelatoriosPages.AcessarModuloRelatorioLivroFiscalSaidaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AcessarModuloRelatorioLivroFiscalSaidaFunc extends BaseTeste {

    AcessarModuloRelatorioLivroFiscalSaidaPage acessarModuloRelatorioLivroFiscalSaidaPage = new AcessarModuloRelatorioLivroFiscalSaidaPage();
    Actions actions = new Actions(driver);

    public void acessarRelatorioSaidaFiscal() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        driver.switchTo().defaultContent();
        actions.moveToElement(driver.findElement(acessarModuloRelatorioLivroFiscalSaidaPage.getAcessarFiscal())).click().perform();
        driver.findElement(acessarModuloRelatorioLivroFiscalSaidaPage.getAcessarRelatorios()).click();
        driver.findElement(acessarModuloRelatorioLivroFiscalSaidaPage.getSaidaLivroFiscal()).click();
    }
}
