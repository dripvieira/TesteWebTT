package com.titansoftware.funcs.financeiro.contatasAPagar.manutencaoDeTitulos;

import com.titansoftware.common.BaseTeste;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModuloFinanceiroAcessosFuncs extends BaseTeste {

    Actions actions = new Actions(driver);

    public void acessarModuloFinanceiro() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }
}
