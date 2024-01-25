package com.titansoftware.funcs.faturamentoFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.pages.faturamentoPages.GerarFaturaPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GerarFaturaFunc extends BaseTeste {
    public static String codDevAut;
    public static String resgatarStatusNF;
    public static String resgatarValorNf;
    public static String resgatarSerieNf;
    public static String xMLNFe;
    String numFatura;

    GerarFaturaPage gerarFaturaPage = new GerarFaturaPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void incluirFatura() {

        driver.findElement(gerarFaturaPage.getIncluirFatura()).click();
    }

    public void tipoDeFatura(String codigo) {
        Select tipoCliente = new Select(driver.findElement(gerarFaturaPage.getTipoCliente()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(gerarFaturaPage.getTudo()));
        tipoCliente.selectByVisibleText("[F] Fornecedor");
        Select tipoEndereco = new Select(driver.findElement(gerarFaturaPage.getTipoEndereco()));
        tipoEndereco.selectByVisibleText("[1] Faturamento");
        driver.findElement(gerarFaturaPage.getInputCodigo()).sendKeys(codigo);
        Select tipoNF = new Select(driver.findElement(gerarFaturaPage.getTipoNF()));
        tipoNF.selectByVisibleText("101 - Venda não Conjugada");
        Select serie = new Select(driver.findElement(gerarFaturaPage.getSerie()));
        serie.selectByVisibleText("2");
    }

    private static boolean isElementVisible(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException |
                 org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void tipoProduto(List<Map<String, String>> data) {
        for (int i = 0; i < data.size(); i++) {
            Map<String, String> row = data.get(i);
            WebElement totalItens = driver.findElement(gerarFaturaPage.getTotalItens());
            String totalItensInicial = totalItens.getText();
            driver.findElement(gerarFaturaPage.getInputPLU()).sendKeys(row.get("Produto"));
            driver.findElement(gerarFaturaPage.getInputPLU()).sendKeys(Keys.TAB);
            while (!isElementVisible(driver, By.id("plu_unit_" + (i + 1)))) {
                try {
                    driver.findElement(By.id("plu_descv_" + (i - 1))).click();
                    driver.findElement(By.id("plu_descv_" + (i - 1))).sendKeys(Keys.TAB);
                    driver.findElement(gerarFaturaPage.getInputPLU()).sendKeys(Keys.CLEAR);
                    driver.findElement(gerarFaturaPage.getInputPLU()).sendKeys(row.get("Produto"));
                    driver.findElement(gerarFaturaPage.getInputPLU()).sendKeys(Keys.TAB);
                } catch (org.openqa.selenium.StaleElementReferenceException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
            Select unidade = new Select(driver.findElement(By.id("plu_unit_" + (i + 1))));
            unidade.selectByVisibleText("UN");
            driver.findElement(By.id("plu_unit_" + (i + 1))).sendKeys(Keys.TAB);
            driver.findElement(By.id("plu_qtde_" + (i + 1))).sendKeys(row.get("Quantidade"));
            driver.findElement(By.id("plu_qtde_" + (i + 1))).sendKeys((Keys.TAB));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
            wait.until(driver -> {
                String totalItensFinal = totalItens.getText();
                return !totalItensFinal.equals(totalItensInicial);
            });
        }

    }

    public void validarFatura() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getBotaoSalvar()))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(gerarFaturaPage.getBotaoMSG()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(gerarFaturaPage.getLoad()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getBotaoMSG()))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(gerarFaturaPage.getLoadObjeto()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(gerarFaturaPage.getEmitirNF()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(gerarFaturaPage.getLoadObjeto()));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getOkAlerta()))).click();
        } catch (Exception e) {
        }
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getEmitirNF()))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(gerarFaturaPage.getBotaoMSG()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(gerarFaturaPage.getBotaoMSG()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getBotaoMSG()))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(gerarFaturaPage.getLoad()));
        wait.until(ExpectedConditions.presenceOfElementLocated(gerarFaturaPage.getSelecionarImpressora()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getSelecionarImpressora()))).click();
        driver.findElement(gerarFaturaPage.getOk2()).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
        numFatura = driver.findElement(gerarFaturaPage.getResgatarTexto()).getText();
        driver.findElement(gerarFaturaPage.getOk2()).click();
    }

    public void filtrarFatura() {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numFatura);
        StringBuilder pedido = new StringBuilder();
        while (matcher.find()) {
            pedido.append(matcher.group());
            numFatura = String.valueOf(pedido);
        }
        driver.findElement(gerarFaturaPage.getInputnumeroFatura()).sendKeys(numFatura.substring(0, 5));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        driver.findElement(gerarFaturaPage.getBotaoFiltrar()).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
    }

    public void baixarAnexo() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getConsultarAnexo()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(gerarFaturaPage.getCodXMLNFE()));
        xMLNFe = driver.findElement(gerarFaturaPage.getCodXMLNFE()).getText();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(gerarFaturaPage.getTudo()));
        driver.findElement(gerarFaturaPage.getDownloadXML()).click();
    }


    public void validarNotaDevolucaoAutomatica() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
        try {
            driver.switchTo().alert().accept();
        } catch (Exception ignored) {
        }
        Select filtrarPor = new Select(driver.findElement(gerarFaturaPage.getFiltrarPor()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        filtrarPor.selectByValue("CODIGO_NOTA");
        driver.findElement(gerarFaturaPage.getFiltrarNumeroDaNota()).sendKeys(EntradaDeNotaFiscalFunc.nfDevAutomatica);
        driver.findElement(gerarFaturaPage.getBotaoFiltrar()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(gerarFaturaPage.getBotaoAlterar()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getBotaoAlterar()))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(gerarFaturaPage.getMsgOk()))).click();
        Select serie = new Select(driver.findElement(gerarFaturaPage.getSelesctSerie()));
        serie.selectByValue("2");
        driver.findElement(gerarFaturaPage.getEmitirNota()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(gerarFaturaPage.getOk2()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(gerarFaturaPage.getOk2()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getOk2()))).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        try {
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (Exception ignored) {
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(gerarFaturaPage.getSelecionarImpressora()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(gerarFaturaPage.getSelecionarImpressora()))).click();
        driver.findElement(gerarFaturaPage.getOk2()).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
        driver.findElement(gerarFaturaPage.getOk2()).click();
    }

    public void assercaoDevolucaoAutomatica() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(gerarFaturaPage.getResgatarCodDevAut()));
        codDevAut = driver.findElement(gerarFaturaPage.getResgatarCodDevAut()).getText();
        resgatarSerieNf = driver.findElement(gerarFaturaPage.getResgatarSerieNf()).getText();
        resgatarStatusNF = driver.findElement(gerarFaturaPage.getResgatarStatusNF()).getText();
        resgatarValorNf = driver.findElement(gerarFaturaPage.getResgatarValorNf()).getText();
    }
}
