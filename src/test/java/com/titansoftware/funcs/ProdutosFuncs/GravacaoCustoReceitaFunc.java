package com.titansoftware.funcs.ProdutosFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.produtosPages.GravacaoCustoReceitaPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GravacaoCustoReceitaFunc extends BaseTeste {
    GravacaoCustoReceitaPages gravacaoCustoReceitaPages = new GravacaoCustoReceitaPages();
    public static String pluReceita = CadastrarProdutoFunc.pluvalor;
    public static String receita;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void acessarTelaReceita() {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(gravacaoCustoReceitaPages.getAcessarModuloProdutos()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(gravacaoCustoReceitaPages.getAcessarModuloProdutos()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gravacaoCustoReceitaPages.getAcessarModuloProdutos()))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(gravacaoCustoReceitaPages.getAcessarSubMenuProdutos()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(gravacaoCustoReceitaPages.getAcessarSubMenuProdutos())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gravacaoCustoReceitaPages.getAcessarSubMenuProdutos()))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(gravacaoCustoReceitaPages.getAcessarEntidadeReceita()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(gravacaoCustoReceitaPages.getAcessarEntidadeReceita())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gravacaoCustoReceitaPages.getAcessarEntidadeReceita()))).click();
    }

    public void incluirReceita() throws InterruptedException {
        Thread.sleep(10000);
        driver.switchTo().frame("Dir");
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gravacaoCustoReceitaPages.getIncluirReceita()))).click();
    }


    public void inserirDadosReceita(String quantidade, String caloria, String proteina, String gordura, String gordurasSaturadas, String colesterol, String fibraAlimentar, String calcio, String ferro, String sodio, String gorduraTrans, String pLUCaFe, String quantCafe, String pLUAgua, String quantAgua, String pLUAcucar, String quantAcucar) throws InterruptedException {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pluReceita);
        StringBuilder codigoReceita = new StringBuilder();
        while (matcher.find()) {
            codigoReceita.append(matcher.group());
            receita = String.valueOf(codigoReceita);
        }
        driver.findElement(gravacaoCustoReceitaPages.getAdicionarPlu()).sendKeys(codigoReceita);
        Thread.sleep(13000);
        driver.findElement(gravacaoCustoReceitaPages.getNutriQuantidade()).sendKeys(quantidade);
        Thread.sleep(5000);
        driver.findElement(gravacaoCustoReceitaPages.getNutriCalorias()).sendKeys(caloria);
        driver.findElement(gravacaoCustoReceitaPages.getNutriProteina()).sendKeys(proteina);
        driver.findElement(gravacaoCustoReceitaPages.getNutriGordurasTotais()).sendKeys(gordura);
        driver.findElement(gravacaoCustoReceitaPages.getNutriGorsdurasSaturadas()).sendKeys(gordurasSaturadas);
        driver.findElement(gravacaoCustoReceitaPages.getNutriColesterol()).sendKeys(colesterol);
        driver.findElement(gravacaoCustoReceitaPages.getNutriFibra()).sendKeys(fibraAlimentar);
        driver.findElement(gravacaoCustoReceitaPages.getNutriCalcio()).sendKeys(calcio);
        driver.findElement(gravacaoCustoReceitaPages.getNutriFerro()).sendKeys(ferro);
        driver.findElement(gravacaoCustoReceitaPages.getNutriSodio()).sendKeys(sodio);
        driver.findElement(gravacaoCustoReceitaPages.getNutriGordurasTrans()).sendKeys(gorduraTrans);
        driver.findElement(gravacaoCustoReceitaPages.getAdicionarPluReceita()).click();
        Thread.sleep(6000);
        driver.findElement(gravacaoCustoReceitaPages.getCodPluCafe()).sendKeys(pLUCaFe);
        driver.findElement(gravacaoCustoReceitaPages.getQntddCafe()).sendKeys(quantCafe);
        driver.findElement(gravacaoCustoReceitaPages.getAdicionarPluReceita()).click();
        Thread.sleep(8000);
        driver.findElement(gravacaoCustoReceitaPages.getCodPluAcucar()).sendKeys(pLUAcucar);
        driver.findElement(gravacaoCustoReceitaPages.getQntddAcucar()).sendKeys(quantAcucar);
        driver.findElement(gravacaoCustoReceitaPages.getAdicionarPluReceita()).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(gravacaoCustoReceitaPages.getCodPluAgua()));
        driver.findElement(gravacaoCustoReceitaPages.getCodPluAgua()).sendKeys(pLUAgua);
        driver.findElement(gravacaoCustoReceitaPages.getQntddAgua()).sendKeys(quantAgua);
        driver.findElement(gravacaoCustoReceitaPages.getSalvarReceita()).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public String filtrarReceita() throws InterruptedException {
        Thread.sleep(4000);
        driver.switchTo().frame("Dir");
        driver.findElement(gravacaoCustoReceitaPages.getFiltrarPor()).sendKeys(receita);
        Thread.sleep(2000);
        driver.findElement(gravacaoCustoReceitaPages.getBotaoFiltrar()).click();
        Thread.sleep(2000);
        return driver.findElement(gravacaoCustoReceitaPages.getResgatarPLU()).getText();
    }

}
