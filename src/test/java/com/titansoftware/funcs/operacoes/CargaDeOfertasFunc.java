package com.titansoftware.funcs.operacoes;

import com.github.javafaker.Faker;
import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.operacoes.CargaDeOfertaPages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CargaDeOfertasFunc extends BaseTeste {
    public static String msgCarga;
    Faker faker = new Faker();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    CargaDeOfertaPages cargaDeOfertaPages = new CargaDeOfertaPages();
    Date dataFutura = faker.date().future(3, TimeUnit.DAYS);
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatada = formatoData.format(dataFutura);

    public void cargaDeProdutos() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cargaDeOfertaPages.getSelecionarCargaDeProduto()))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cargaDeOfertaPages.getSelecionarOferta()))).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cargaDeOfertaPages.getSelecionarOferta()))).sendKeys(Keys.TAB);
        driver.findElement(cargaDeOfertaPages.getSelecionarData()).sendKeys(dataFormatada);
        driver.findElement(cargaDeOfertaPages.getSelecionarData()).sendKeys(Keys.TAB);
        driver.findElement(cargaDeOfertaPages.getGerarCarga()).click();
        msgCarga = wait.until(ExpectedConditions.alertIsPresent()).getText();
        driver.switchTo().alert().accept();
    }

}
