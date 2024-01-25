package com.titansoftware.funcs.ContabilFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.faturamentoFuncs.EmitirVendaAssistidaFunc;
import com.titansoftware.pages.ContabilPages.AssercaoLancamentoContabilVendasAssistidasPages;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AssercaoLancamentoContabilVendasAssistidasFuncs extends BaseTeste {

    String numTitulo = EmitirVendaAssistidaFunc.numNFEmitida;
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formatteDate = currentDate.format(formatter);

    AssercaoLancamentoContabilVendasAssistidasPages assercaoLancamentoContabilVendasAssistidasPages = new AssercaoLancamentoContabilVendasAssistidasPages();

    public void filtrarLancamentos() throws InterruptedException {
        Select loja = new Select(driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getFiltroLoja()));
        loja.selectByValue("1");
        Select operacao = new Select(driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getFiltroOperacao()));
        operacao.selectByValue("Número da Fatura");
        Select condicao = new Select(driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getFiltroCondicao()));
        condicao.selectByValue("c");
        Thread.sleep(5000);
        driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getInserirDados()).sendKeys(numTitulo.substring(0, 5));
        driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getDataInicial()).sendKeys(formatteDate);
        driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getDataFinal()).sendKeys(formatteDate);
        driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getBotaoFiltrar()).click();
    }

    public String assercaoContabilNumFatura() {
        return driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getNumFatura()).getText();

    }

    public String assercaoContabilStatus() {
        return driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getStatus()).getText();
    }

    public String assercaoContabilValorFatura() {
        return driver.findElement(assercaoLancamentoContabilVendasAssistidasPages.getValorFatura()).getText();
    }

}
