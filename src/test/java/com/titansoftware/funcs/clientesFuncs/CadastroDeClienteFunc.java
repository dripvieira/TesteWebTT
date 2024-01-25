package com.titansoftware.funcs.clientesFuncs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.GeraCpfCnpj;
import com.titansoftware.pages.clientesPages.CadastroDeClientePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CadastroDeClienteFunc extends BaseTeste {

    CadastroDeClientePage cadastroDeClientePage = new CadastroDeClientePage();
    GeraCpfCnpj gerador = new GeraCpfCnpj();

    String nCliente;
    String nClienteFinal;
    String nomeFinal;
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    /**
     * @param vendedor
     * @param nome
     * @param nome_alt
     * @param tel_fixo
     * @param tel_movel
     * @param convenio
     * @param cond_pagto
     * @param rede
     * @param forma_pagto
     * @param limite
     * @param limite_dispo
     * @param desc_porce
     * @param desc_valor
     * @param saldo
     * @param web
     * @param transp
     * @param email
     * @param data
     * @param coment
     * @param mensagem
     * @param tipo
     * @param cep
     * @param numero
     */
    public void cadastraCliente(String vendedor, String nome, String nome_alt, String tel_fixo, String tel_movel, String convenio, String cond_pagto, String rede, String forma_pagto, String limite, String limite_dispo, String desc_porce, String desc_valor, String saldo, String web, String transp, String email, String data, String coment, String mensagem, String tipo, String cep, String numero) {
        wait.until(ExpectedConditions.presenceOfElementLocated(cadastroDeClientePage.getBtnIncluir()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cadastroDeClientePage.getBtnIncluir()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cadastroDeClientePage.getBtnIncluir()))).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        switch (tipo) {
            case "Fisica" -> {
                Select cat_fiscalF = new Select(driver.findElement(cadastroDeClientePage.getSelectCategoria()));
                cat_fiscalF.selectByValue("1");
                String cpf = gerador.cpf(false);
                driver.findElement(cadastroDeClientePage.getDocumento()).sendKeys(cpf);
            }
            case "Juridica" -> {
                Select cat_fiscalJ = new Select(driver.findElement(cadastroDeClientePage.getSelectCategoria()));
                cat_fiscalJ.selectByValue("2");
                String cnpj = gerador.cnpj(false);
                driver.findElement(cadastroDeClientePage.getDocumento()).sendKeys(cnpj);
            }
        }
        Select tipo_cliente = new Select(driver.findElement(cadastroDeClientePage.getSelectTipoCliente()));
        tipo_cliente.selectByValue("1");
        driver.findElement(cadastroDeClientePage.getVendedor()).sendKeys(vendedor);
        driver.findElement(cadastroDeClientePage.getNome()).sendKeys(nome);
        driver.findElement(cadastroDeClientePage.getNomeAlt()).sendKeys(nome_alt);
        driver.findElement(cadastroDeClientePage.getTelefoneFixo()).sendKeys(tel_fixo);
        driver.findElement(cadastroDeClientePage.getTelefoneMovel()).sendKeys(tel_movel);
        driver.findElement(cadastroDeClientePage.getConvenio()).sendKeys(convenio);
        driver.findElement(cadastroDeClientePage.getCondPagto()).sendKeys(cond_pagto);
        driver.findElement(cadastroDeClientePage.getFormaPagto()).sendKeys(forma_pagto);
        driver.findElement(cadastroDeClientePage.getLimite()).sendKeys(limite);
        Select status_select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(cadastroDeClientePage.getStatus())));
        status_select.selectByIndex(1);
        driver.findElement(cadastroDeClientePage.getLimiteDispo()).sendKeys(limite_dispo);
        driver.findElement(cadastroDeClientePage.getDescPorcento()).sendKeys(desc_porce);
        driver.findElement(cadastroDeClientePage.getSaldo()).sendKeys(saldo);
        driver.findElement(cadastroDeClientePage.getDescValor()).sendKeys(desc_valor);
        driver.findElement(cadastroDeClientePage.getEndWeb()).sendKeys(web);
        driver.findElement(cadastroDeClientePage.getTransp()).sendKeys(transp);
        driver.findElement(cadastroDeClientePage.getEmail()).sendKeys(email);
        Select natureza = new Select(driver.findElement(cadastroDeClientePage.getStatus()));
        natureza.selectByValue("CL");
        driver.findElement(cadastroDeClientePage.getData_nasc()).sendKeys(data);
        driver.findElement(cadastroDeClientePage.getData_nasc()).sendKeys(Keys.TAB);
        actions.moveToElement(driver.findElement(cadastroDeClientePage.getContribuicao())).click().perform();
        driver.findElement(cadastroDeClientePage.getContribuicao()).click();
        driver.findElement(cadastroDeClientePage.getComentario()).sendKeys(coment);
        driver.findElement(cadastroDeClientePage.getMnsg()).sendKeys(mensagem);
        switch (tipo) {
            case "Fisica" -> {
                driver.findElement(cadastroDeClientePage.getCepResidencial()).sendKeys(cep);
                driver.findElement(cadastroDeClientePage.getCepResidencial()).sendKeys(Keys.TAB);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cadastroDeClientePage.getNumResidencial()))).sendKeys(numero);
            }
            case "Juridica" -> {
                driver.findElement(cadastroDeClientePage.getLabelComercial()).click();
                driver.findElement(cadastroDeClientePage.getCepComercial()).sendKeys(cep);
                driver.findElement(cadastroDeClientePage.getCepComercial()).sendKeys(Keys.TAB);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
                driver.findElement(cadastroDeClientePage.getNumComercial()).sendKeys(Keys.HOME);
                driver.findElement(cadastroDeClientePage.getNumComercial()).sendKeys(numero);
            }
        }
        driver.findElement(cadastroDeClientePage.getBtnSalvar()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("carregando_loadObject")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
        nCliente = wait.until(ExpectedConditions.visibilityOf(driver.findElement(cadastroDeClientePage.getNumCliente()))).getText();
        driver.findElement(cadastroDeClientePage.getBtnVoltar()).click();
    }

    public void filtraCliente() {
        js.executeScript("document.getElementById('tudo').style.display='none';");
        Select condicao = new Select(driver.findElement(cadastroDeClientePage.getSelectCondicao()));
        condicao.selectByValue("=");
        driver.findElement(cadastroDeClientePage.getCampoFiltro()).sendKeys(nCliente);
        driver.findElement(cadastroDeClientePage.getBtnFiltrar()).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject")));
    }

    public void assercaoClienteFiltrado(String nome) {
        nClienteFinal = wait.until(ExpectedConditions.visibilityOf(driver.findElement(cadastroDeClientePage.getResgatarNumCliente()))).getText();
        nomeFinal = driver.findElement(cadastroDeClientePage.getNomeFiltrado()).getText();
        Assert.assertEquals(nCliente, nClienteFinal);
        Assert.assertEquals(nome, nomeFinal);
    }
}
