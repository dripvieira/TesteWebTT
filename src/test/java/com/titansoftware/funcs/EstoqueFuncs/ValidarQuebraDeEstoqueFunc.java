package com.titansoftware.funcs.EstoqueFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.EstoquePages.ValidarAjusteSobraManualPage;
import com.titansoftware.pages.EstoquePages.ValidarQuebraDeEstoquePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarQuebraDeEstoqueFunc extends BaseTeste {
    ValidarAjusteSobraManualPage validarAjusteSobraManualPage = new ValidarAjusteSobraManualPage();
    ValidarQuebraDeEstoquePage validarQuebraDeEstoquePage = new ValidarQuebraDeEstoquePage();
    String alert;
    String numDoc;
    float qProduto;
    Float init;
    Float fin;
    Float delta;
    public static Float conta;
    public static String qntdEstoqueInicial;
    public String qntdEstoque;
    String operacao;

    public void resgataEstoqueInicial(String produto, String loja) {
        driver.findElement(validarQuebraDeEstoquePage.getCampoProduto()).sendKeys(produto);
        driver.findElement(validarQuebraDeEstoquePage.getCampoProduto()).sendKeys(Keys.TAB);
        driver.findElement(validarQuebraDeEstoquePage.getBtnFiltragem()).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getPageLoader()));
        qntdEstoqueInicial = wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getQntddEstoque())).getText();
    }

    public void realizarQuebra(String processo, String quantidade, String produto, String operacoes) throws InterruptedException {
        processo = processo.replace(" ", "").toUpperCase();
        switch (processo) {
            case "QUEBRA" -> {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                driver.findElement(validarQuebraDeEstoquePage.getIncluirMovimentacao()).click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                driver.switchTo().frame("ifrmPopUpObj");
                driver.findElement(validarQuebraDeEstoquePage.getSelecionaQuebra()).click();
                Select loja = new Select(driver.findElement(validarQuebraDeEstoquePage.getSelectLoja()));
                loja.selectByValue("1");
                driver.findElement(validarQuebraDeEstoquePage.getIncluiPLU()).click();
                driver.findElement(validarQuebraDeEstoquePage.getInputPLU()).sendKeys(produto);
                driver.findElement(validarQuebraDeEstoquePage.getInputPLU()).sendKeys(Keys.TAB);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                driver.findElement(validarQuebraDeEstoquePage.getBtnEnviar()).click();
                Select motivo = new Select(driver.findElement(validarQuebraDeEstoquePage.getMotivoQuebra()));
                motivo.selectByIndex(1);
                wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getEmbalagem()));
                Select embalagem = new Select(driver.findElement(validarQuebraDeEstoquePage.getEmbalagem()));
                embalagem.selectByIndex(1);
                wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getQntdQuebra()));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(validarQuebraDeEstoquePage.getQntdQuebra()))).sendKeys(quantidade);
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(validarQuebraDeEstoquePage.getIncluiQuebra()))).click();
                wait.until(ExpectedConditions.alertIsPresent());
                alert = driver.switchTo().alert().getText();
                String nDocumento = alert;
                String regex = "\\d+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(nDocumento);
                StringBuilder numero = new StringBuilder();
                while (matcher.find()) {
                    numero.append(matcher.group());
                    numDoc = String.valueOf(numero);
                }
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                driver.switchTo().frame("Dir");
                Select filtrarPor = new Select(driver.findElement(validarQuebraDeEstoquePage.getSelectFiltro()));
                filtrarPor.selectByValue("doc");
                wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getCampoDados())).sendKeys(numDoc);
                wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getCampoFiltro())).sendKeys(produto);
                wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnFiltrar())).click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnAlterar())).click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("ifrmPopUpObj")));
                wait.until(ExpectedConditions.presenceOfElementLocated(validarQuebraDeEstoquePage.getBtnValidar()));
                wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnValidar())).click();
                wait.until(ExpectedConditions.alertIsPresent()).accept();
                driver.switchTo().defaultContent();
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(validarQuebraDeEstoquePage.getIncluirMovimentacao())));
                wait.until(ExpectedConditions.presenceOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(validarQuebraDeEstoquePage.getIncluirMovimentacao())));
                return;
            }
            case "AJUSTE" -> {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                driver.findElement(validarQuebraDeEstoquePage.getIncluirMovimentacao()).click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                driver.switchTo().frame("ifrmPopUpObj");
                wait.until(ExpectedConditions.elementToBeClickable(validarAjusteSobraManualPage.getBtnAjuste())).click();
                Select loja1 = new Select(driver.findElement(validarQuebraDeEstoquePage.getSelectLoja()));
                loja1.selectByValue("1");
                driver.findElement(validarQuebraDeEstoquePage.getIncluiPLU()).click();
                driver.findElement(validarQuebraDeEstoquePage.getInputPLU()).sendKeys(produto);
                driver.findElement(validarQuebraDeEstoquePage.getInputPLU()).sendKeys(Keys.TAB);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                driver.findElement(validarQuebraDeEstoquePage.getBtnEnviar()).click();
                Select motivo1 = new Select(driver.findElement(validarQuebraDeEstoquePage.getMotivoQuebra()));
                motivo1.selectByIndex(1);
                wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getEmbalagem()));
                Select embalagem1 = new Select(driver.findElement(validarQuebraDeEstoquePage.getEmbalagem()));
                embalagem1.selectByIndex(1);
                Select operacao = new Select(driver.findElement(validarAjusteSobraManualPage.getFiltroOperacao()));
                operacao.selectByValue(operacoes);
                wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getQntdQuebra())).sendKeys(quantidade);
                wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getIncluiQuebra())).click();
                wait.until(ExpectedConditions.alertIsPresent());
                alert = driver.switchTo().alert().getText();
                String nDocumento1 = alert;
                String regex1 = "\\d+";
                Pattern pattern1 = Pattern.compile(regex1);
                Matcher matcher1 = pattern1.matcher(nDocumento1);
                StringBuilder numero1 = new StringBuilder();
                while (matcher1.find()) {
                    numero1.append(matcher1.group());
                    numDoc = String.valueOf(numero1);
                }
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                driver.switchTo().frame("Dir");
                Select filtrarPorAJ = new Select(driver.findElement(validarQuebraDeEstoquePage.getSelectFiltro()));
                filtrarPorAJ.selectByValue("doc");
                driver.findElement(validarQuebraDeEstoquePage.getSelectFiltro()).sendKeys(Keys.TAB);
                wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getCampoDados())).sendKeys(numDoc);
                wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getCampoFiltro())).sendKeys(produto);
                wait.until(ExpectedConditions.elementToBeClickable(validarAjusteSobraManualPage.getCheckAjuste())).click();
                wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnFiltrar())).click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnAlterar())).click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("ifrmPopUpObj")));
                wait.until(ExpectedConditions.presenceOfElementLocated(validarQuebraDeEstoquePage.getBtnValidar()));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(validarQuebraDeEstoquePage.getBtnValidar()))).click();
                wait.until(ExpectedConditions.alertIsPresent()).accept();
                driver.switchTo().defaultContent();
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(validarQuebraDeEstoquePage.getIncluirMovimentacao())));
                wait.until(ExpectedConditions.presenceOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getLoadPage()));
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(validarQuebraDeEstoquePage.getIncluirMovimentacao())));
                return;
            }
        }

    }


    public void filtrarQuebra(String produtos) {
        wait.until(ExpectedConditions.presenceOfElementLocated(validarQuebraDeEstoquePage.getFiltroLoja()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getFiltroLoja())).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getCampoProduto())).sendKeys(produtos);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getCampoProduto())).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(validarQuebraDeEstoquePage.getBtnFiltragem())).click();
        qntdEstoque = wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getQntddEstoque())).getText();
    }

    public void assercaoMovimentacaoDeEstoque(String qtd, String processo, String operacao) {
        processo = processo.replace(" ", "").toUpperCase();
        init = Float.parseFloat(qntdEstoqueInicial);
        fin = Float.parseFloat(qntdEstoque);
        qProduto = Float.parseFloat(qtd);
        delta = 0.01f;
        conta = 0f;
        switch (processo) {
            case "QUEBRA" -> {
                if (!operacao.equals("-")) {
                    throw new AssertionError("Erro: operação de quebra deve ser subtração.");
                } else {
                    conta = init - qProduto;
                }
            }
            case "AJUSTE" -> {
                switch (operacao) {
                    case "+":
                        conta = init + qProduto;
                        break;
                    case "-":
                        conta = init - qProduto;
                        break;
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + processo);
        }
    }

    public String analisaOperacao(Float qntd_contada) {
        init = Float.valueOf(qntdEstoqueInicial);
        if (init > qntd_contada) {
            operacao = "+";
        } else if (init < qntd_contada) {
            operacao = "-";
        } else {
            operacao = "=";
        }
        return operacao;
    }
}
