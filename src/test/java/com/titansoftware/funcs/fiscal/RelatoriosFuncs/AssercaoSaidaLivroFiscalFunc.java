package com.titansoftware.funcs.fiscal.RelatoriosFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.fiscal.RelatoriosPages.AssercaoSaidaLivroFiscalPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AssercaoSaidaLivroFiscalFunc extends BaseTeste {

    public static String serie;
    AssercaoSaidaLivroFiscalPage assercaoSaidaLivroFiscalPage = new AssercaoSaidaLivroFiscalPage();
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formatteDate = currentDate.format(formatter);

    public void assercaoRelatorioFiscalSaida() {
        driver.switchTo().frame("Dir");
        driver.findElement(assercaoSaidaLivroFiscalPage.getPeriodoDe()).click();
        driver.findElement(assercaoSaidaLivroFiscalPage.getPeriodoDe()).sendKeys(formatteDate);
        driver.findElement(assercaoSaidaLivroFiscalPage.getPeriodoDe()).click();
        driver.findElement(assercaoSaidaLivroFiscalPage.getPeriodoAte()).sendKeys(formatteDate);
        driver.findElement(assercaoSaidaLivroFiscalPage.getFiltrar()).click();
        serie = driver.findElement(assercaoSaidaLivroFiscalPage.getSerieNF()).getText();
    }
}
