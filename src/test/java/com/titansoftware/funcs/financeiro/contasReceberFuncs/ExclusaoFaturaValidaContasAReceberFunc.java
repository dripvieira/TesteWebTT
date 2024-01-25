package com.titansoftware.funcs.financeiro.contasReceberFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.financeiro.contasReceberPages.ExclusaoFaturaValidaContasAReceberPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ExclusaoFaturaValidaContasAReceberFunc extends BaseTeste {
    public static String statusContasAReceber;
    ExclusaoFaturaValidaContasAReceberPage exclusaoFaturaValidaContasAReceberPage = new ExclusaoFaturaValidaContasAReceberPage();

    public void validarStatusContasAReceber(String expected) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(exclusaoFaturaValidaContasAReceberPage.getWaitDivTudo()));
        wait.until(ExpectedConditions.elementToBeClickable(exclusaoFaturaValidaContasAReceberPage.getChckExcluido())).click();
        wait.until(ExpectedConditions.elementToBeClickable(exclusaoFaturaValidaContasAReceberPage.getBtnFiltrar())).click();
        statusContasAReceber = driver.findElement(exclusaoFaturaValidaContasAReceberPage.getStatusContasReceber()).getText();
        Assert.assertEquals(expected, statusContasAReceber);
    }
}
