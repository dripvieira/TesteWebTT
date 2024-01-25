package com.titansoftware.funcs.ProdutosFuncs;

import com.github.javafaker.Faker;
import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.produtosPages.CadastroDeOfertaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CadastroDeOfertasFunc extends BaseTeste {
    CadastroDeOfertaPage cadastroDeOfertaPage = new CadastroDeOfertaPage();
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    Faker faker = new Faker();

    public void inserirDadosOferta() {
        driver.findElement(cadastroDeOfertaPage.getIncluirOferta()).click();
        Select loja = new Select(driver.findElement(cadastroDeOfertaPage.getSelecionarLoja()));
        loja.selectByValue("1");
        actions.moveToElement(driver.findElement(cadastroDeOfertaPage.getClicarLoja())).click().perform();
        driver.findElement(cadastroDeOfertaPage.getNomeOferta()).sendKeys("Ivan");
        Select tipoPreco = new Select(driver.findElement(cadastroDeOfertaPage.getTipoPreco()));
        tipoPreco.selectByValue("1");
        driver.findElement(cadastroDeOfertaPage.getInputCodPLU()).sendKeys("20000");
        driver.findElement(cadastroDeOfertaPage.getInputCodPLU()).sendKeys(Keys.TAB);
        driver.findElement(cadastroDeOfertaPage.getPrecoNovo()).sendKeys(faker.number().digits(4));
        driver.findElement(cadastroDeOfertaPage.getPrecoNovo()).sendKeys(Keys.TAB);
        driver.findElement(cadastroDeOfertaPage.getIncluirProduto()).click();
        try {
            driver.findElement(cadastroDeOfertaPage.getSelecionarTodos()).click();
            driver.findElement(cadastroDeOfertaPage.getMsg()).click();
        } catch (Exception e) {
        }
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(cadastroDeOfertaPage.getBotaoIncluir()).click();
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("carregando_loadObject")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cadastroDeOfertaPage.getClicarValidar()))).click();
        driver.switchTo().alert().accept();
    }
}
