package com.titansoftware.funcs.EstoqueFuncs;

import com.github.javafaker.Faker;
import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.EstoquePages.MovimentacaoDeEstoqueAutomaticaPage;
import com.titansoftware.pages.EstoquePages.ValidarQuebraDeEstoquePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovimentacaoDeEstoqueAutomaticaFunc extends BaseTeste {
    static Faker faker = new Faker();
    public static String qtdContada = String.valueOf(faker.number().numberBetween(100, 999));
    public String qntdEstoqueFinal;
    MovimentacaoDeEstoqueAutomaticaPage movimentacaoDeEstoqueAutomaticaPage = new MovimentacaoDeEstoqueAutomaticaPage();
    ValidarQuebraDeEstoquePage validarQuebraDeEstoquePage = new ValidarQuebraDeEstoquePage();
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formatteDate = currentDate.format(formatter);
    String nInventario;
    String invent;

    public void gerarInventario(String prod, String max, String desc, String loja) {
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getIncluirInventario()).click();
        Select tipo = new Select(driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getSelecionaTipo()));
        tipo.selectByValue("P");
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getDescricao()).sendKeys(desc);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCampoData()).click();
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCampoData()).sendKeys(formatteDate);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getMaxItens()).sendKeys(max);
        Select lojaS = new Select(driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getLoja()));
        lojaS.selectByValue(loja);
        Select motivo = new Select(driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getSelecionaMotivo()));
        motivo.selectByValue("99");
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getFlagForaDeLinha()).click();
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getFlagNaoParaVenda()).click();
        Select custoBruto = new Select(driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getSelecionaCustoBruto()));
        custoBruto.selectByValue("B");
        Select custoLivro = new Select(driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getSelecionaCustoLivro()));
        custoLivro.selectByValue("B");
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getBtnSalvar()).click();
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getConfirmaMovimentacao()).click();
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getDefineProd()).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifrmPopUpObj"));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCampoProd()).sendKeys(prod);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCampoProd()).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.presenceOfElementLocated(movimentacaoDeEstoqueAutomaticaPage.getDescricaoProduto()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getSalvarProd()))).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getFecharProd()).click();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Dir"));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCongelaEstoque()).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getConfirmaMovimentacao()))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(movimentacaoDeEstoqueAutomaticaPage.getCongelar()),
                ExpectedConditions.presenceOfElementLocated(movimentacaoDeEstoqueAutomaticaPage.getForcaCongelamento())
        ));
        if (driver.findElements(movimentacaoDeEstoqueAutomaticaPage.getCongelar()).size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCongelar()))).click();
        } else {
            driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCongelar()).click();
            wait.until(ExpectedConditions.elementToBeClickable(movimentacaoDeEstoqueAutomaticaPage.getConfirmaMovimentacao())).click();
        }
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void contaEstoque(String prod, String contador, String qntdd) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getBtnAcompanhamento()).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifrmPopUpObj"));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getBtnAlteraContador()).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifrmPopUpObj"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']")));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getContador()).sendKeys(contador);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCampoPlu()).sendKeys(prod);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCampoQuantidade()).sendKeys(qtdContada);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getCampoQuantidade()).sendKeys(Keys.TAB);
        Select embalagem = new Select(driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getEmbalagem()));
        embalagem.selectByIndex(1);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getBtnSalvaConta()).click();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Dir"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifrmPopUpObj"));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getFecharContagem()).click();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Dir"));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getBtnValidar()).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifrmPopUpObj"));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getValidar()).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        try {
            driver.switchTo().alert().accept();
        } catch (Exception ignored) {
        }
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Dir"));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getBtnFechar()).click();
        nInventario = wait.until(ExpectedConditions.elementToBeClickable(movimentacaoDeEstoqueAutomaticaPage.getNumInventario())).getText();
        String numInvent = nInventario;
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numInvent);
        StringBuilder inventario = new StringBuilder();
        while (matcher.find()) {
            inventario.append(matcher.group());
            invent = String.valueOf(inventario);
        }
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getBtnVoltarInv()).click();
    }

    public void movimentaEstoque(String operacao) {
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getFiltro()).sendKeys(invent);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getDataDe()).sendKeys(formatteDate);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getDataAte()).sendKeys(formatteDate);
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getFiltrar()).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("tudo")));
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getBtnRelatorios()).click();
        switch (operacao) {
            case "-":
                wait.until(ExpectedConditions.elementToBeClickable(movimentacaoDeEstoqueAutomaticaPage.getGeraQuebra())).click();
            case "+":
                wait.until(ExpectedConditions.elementToBeClickable(movimentacaoDeEstoqueAutomaticaPage.getGeraSobra())).click();
        }
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getConfirmaMovimentacao()).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        driver.findElement(movimentacaoDeEstoqueAutomaticaPage.getBtnVoltar()).click();
    }

    public void resgataEstoqueFinal(String produto, String loja) {
        Select lojaS = new Select(driver.findElement(validarQuebraDeEstoquePage.getSelectLoja()));
        lojaS.selectByValue(loja);
        driver.findElement(validarQuebraDeEstoquePage.getCampoProduto()).sendKeys(produto);
        driver.findElement(validarQuebraDeEstoquePage.getCampoProduto()).sendKeys(Keys.TAB);
        driver.findElement(validarQuebraDeEstoquePage.getBtnFiltragem()).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(validarQuebraDeEstoquePage.getPageLoader()));
        qntdEstoqueFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(validarQuebraDeEstoquePage.getQntddEstoque())).getText();
    }
}