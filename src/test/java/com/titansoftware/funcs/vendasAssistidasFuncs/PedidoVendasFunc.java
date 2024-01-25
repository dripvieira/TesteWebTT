package com.titansoftware.funcs.vendasAssistidasFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.vendasAssistidasPages.PedidoVendasPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PedidoVendasFunc extends BaseTeste {

    public static String valorVendasAssistidas;
    public static String numeroOrcamento;
    PedidoVendasPage pedidoVendasPage = new PedidoVendasPage();
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void pedidoVendasAssistidas(String destinatario, String produto, String quantidade, String frete) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(pedidoVendasPage.getIncluirVenda())));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(pedidoVendasPage.getIncluirVenda())))).click().perform();
        String valorDescricaoinicial = driver.findElement(pedidoVendasPage.getDescricaoDestinatario()).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("carregando_loadObject")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
        wait.until(ExpectedConditions.presenceOfElementLocated(pedidoVendasPage.getDestinatario()));
        Select tipoDestinatario = new Select(driver.findElement(pedidoVendasPage.getDestinatario()));
        tipoDestinatario.selectByValue("C");
        wait.until(driver -> {
            String valorDescricaoAtual = driver.findElement(pedidoVendasPage.getDescricaoDestinatario()).getText();
            return !valorDescricaoAtual.equals(valorDescricaoinicial);
        });
        js.executeScript("document.getElementById('tudo').style.display='none';");
        actions.moveToElement(driver.findElement(pedidoVendasPage.getNumeroFornecedor())).click().perform();
        driver.findElement(pedidoVendasPage.getNumeroFornecedor()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(pedidoVendasPage.getNumeroFornecedor()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(pedidoVendasPage.getNumeroFornecedor()).sendKeys(Keys.BACK_SPACE);
        driver.findElement(pedidoVendasPage.getNumeroFornecedor()).sendKeys(destinatario);
        js.executeScript("document.getElementById('tudo').style.display='none';");
        Select serie = new Select(driver.findElement(pedidoVendasPage.getSerieNF()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        serie.selectByValue("V");
        driver.findElement(pedidoVendasPage.getAdicionarPLU()).sendKeys(produto);
        driver.findElement(pedidoVendasPage.getAdicionarPLU()).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(pedidoVendasPage.getAdicionarQuantidade())));
        driver.findElement(pedidoVendasPage.getAdicionarQuantidade()).click();
        driver.findElement(pedidoVendasPage.getAdicionarQuantidade()).sendKeys(Keys.HOME);
        driver.findElement(pedidoVendasPage.getAdicionarQuantidade()).sendKeys(Keys.DELETE);
        driver.findElement(pedidoVendasPage.getAdicionarQuantidade()).sendKeys(quantidade);
        String totalInicial = driver.findElement(pedidoVendasPage.getRecuperarValorVenda()).getText();
        driver.findElement(pedidoVendasPage.getFrete()).sendKeys(frete);
        driver.findElement(pedidoVendasPage.getFrete()).sendKeys(Keys.TAB);
        wait.until(driver1 -> {
            String totalAtual = driver.findElement(pedidoVendasPage.getRecuperarValorVenda()).getText();
            return !totalAtual.equals(totalInicial);
        });
        valorVendasAssistidas = driver.findElement(pedidoVendasPage.getRecuperarValorVenda()).getText();
        driver.findElement(pedidoVendasPage.getBtnSalvar()).click();
        try {
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (Exception e) {
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("PageLoaderMessage")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));

    }

    public void enviarFaturamento() {
        js.executeScript("document.getElementById('tudo').style.display='none';");
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(pedidoVendasPage.getRecuperaNumeroNF()));
        if (elemento != null && !elemento.getText().isEmpty()) {
            numeroOrcamento = elemento.getText();
        } else {
            numeroOrcamento = "Texto não encontrado";
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(pedidoVendasPage.getEnviarFaturamento()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pedidoVendasPage.getEnviarFaturamento()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(pedidoVendasPage.getEnviarFaturamento()));
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(pedidoVendasPage.getEnviarFaturamento())))).click().perform();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
