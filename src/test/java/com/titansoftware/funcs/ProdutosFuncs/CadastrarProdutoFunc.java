package com.titansoftware.funcs.ProdutosFuncs;

import com.github.javafaker.Faker;
import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.produtosPages.CadastrarProdutoPages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class CadastrarProdutoFunc extends BaseTeste {

    CadastrarProdutoPages cadastrarProdutoPages = new CadastrarProdutoPages();

    public static String eanValor;
    public static String pluvalor;
    Faker faker = new Faker();
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    private static boolean isElementVisible(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException |
                 org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void acessarModuloProdutos() throws InterruptedException {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Dir")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        Thread.sleep(5000);
        driver.switchTo().defaultContent();

        while (!isElementVisible(driver, cadastrarProdutoPages.getElementoTermino())) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(cadastrarProdutoPages.getSelecionarModuloProdutos()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(cadastrarProdutoPages.getSelecionarModuloProdutos()));
                actions.moveToElement(driver.findElement(cadastrarProdutoPages.getSelecionarModuloProdutos())).build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cadastrarProdutoPages.getSelecionarModuloProdutos()))).click();

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void acessarMenuProdutos() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cadastrarProdutoPages.getSelecionarSubmenuProdutos()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cadastrarProdutoPages.getSelecionarSubmenuProdutos()));
        driver.findElement(cadastrarProdutoPages.getSelecionarSubmenuProdutos()).click();
    }

    public void acessarSubMenuProdutos() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cadastrarProdutoPages.getSelecionarManutencaoDeProdutos()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cadastrarProdutoPages.getSelecionarManutencaoDeProdutos()));
        driver.findElement(cadastrarProdutoPages.getSelecionarManutencaoDeProdutos()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(invisibilityOfElementLocated(By.xpath("//div[@class='nprogress-custom-parent']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
    }

    public void acessarManutencaoDeProdutos() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cadastrarProdutoPages.getIncluirProduto()))).click();

    }

    public String inserirDadosDoProduto(String tipoPLU, String tipoProduto, String curta, String comercial, String descriçãoTecnica, String referencia, String classificaçãoMercadologica, String fornecedorPrincipal, String divisao, String etiqueta, String etiquetaFacing, String mixDeProdutos, String prazoDeEntrega, String volume, String pesoBruto, String pesoLiquido) {
        Select TipoPLU = new Select(driver.findElement(cadastrarProdutoPages.getTypePLU()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        switch (tipoPLU) {
            case "Pesado" -> TipoPLU.selectByIndex(2);
            case "Normal" -> TipoPLU.selectByIndex(3);
        }
        Select TipoProduto = new Select(driver.findElement(cadastrarProdutoPages.getTipoProduto()));
        switch (tipoProduto) {
            case "00-Mercadoria para Revenda" -> {
                TipoProduto.selectByValue("00");
            }
            case "04-Produto Acabado" -> {
                TipoProduto.selectByValue("04");
            }
        }
        try {
            driver.findElement(cadastrarProdutoPages.getEan()).sendKeys(faker.code().ean13());
        } catch (Exception e) {

        }
        driver.findElement(cadastrarProdutoPages.getDescricaoCurta()).sendKeys(curta);
        driver.findElement(cadastrarProdutoPages.getDescricaoCurta()).sendKeys(Keys.ESCAPE);
        driver.findElement(cadastrarProdutoPages.getDescricaoComercial()).sendKeys(comercial);
        driver.findElement(cadastrarProdutoPages.getDescricaoComercial()).sendKeys(Keys.ESCAPE);
        driver.findElement(cadastrarProdutoPages.getDescricaoTecnica()).sendKeys(descriçãoTecnica);
        driver.findElement(cadastrarProdutoPages.getDescricaoTecnica()).sendKeys(Keys.ESCAPE);
        driver.findElement(cadastrarProdutoPages.getReferencia()).sendKeys(referencia);
        String valorInicialClass = driver.findElement(cadastrarProdutoPages.getResgatarClassificacaoMercadologiga()).getText();
        driver.findElement(cadastrarProdutoPages.getClassificacaoMercadologica()).sendKeys(classificaçãoMercadologica);
        wait.until(driver -> {
            String valorAtualClass = driver.findElement(cadastrarProdutoPages.getResgatarClassificacaoMercadologiga()).getText();
            return !valorAtualClass.equals(valorInicialClass);
        });
        driver.findElement(cadastrarProdutoPages.getDescricaoTecnica()).sendKeys(Keys.ESCAPE);
        try {
            driver.findElement(cadastrarProdutoPages.getSelecionarNBM()).click();
            driver.findElement(cadastrarProdutoPages.getConfirmarNCM()).click();
        } catch (Exception e) {

        }
        driver.findElement(cadastrarProdutoPages.getFornecedorPrincipal()).sendKeys(fornecedorPrincipal);
        driver.findElement(cadastrarProdutoPages.getDivisao()).sendKeys(divisao);
        driver.findElement(cadastrarProdutoPages.getEtiqueta()).sendKeys(etiqueta);
        driver.findElement(cadastrarProdutoPages.getEtiquetaFacing()).sendKeys(etiquetaFacing);
        Select mixProduto = new Select(driver.findElement(cadastrarProdutoPages.getMixDeProduto()));
        switch (mixDeProdutos) {
            case "CARGA IFOOD" -> mixProduto.selectByValue("5");
            case "Padrão" -> mixProduto.selectByValue("1");
        }
        driver.findElement(cadastrarProdutoPages.getPrazoDeEntrega()).sendKeys(prazoDeEntrega);
        Select unidadeDeVolume = new Select(driver.findElement(cadastrarProdutoPages.getSelectUnidadeDeVolume()));
        unidadeDeVolume.selectByVisibleText("Mililitro");
        driver.findElement(cadastrarProdutoPages.getVolume()).sendKeys(volume);
        driver.findElement(cadastrarProdutoPages.getPesoBruto()).sendKeys(pesoBruto);
        driver.findElement(cadastrarProdutoPages.getPesoLiquido()).sendKeys(pesoLiquido);
        return null;
    }

    public String eanCadastrado() {
        eanValor = driver.findElement(cadastrarProdutoPages.getEan13()).getAttribute("value");
        return eanValor;
    }

    public void inserirProduto() {
        driver.findElement(cadastrarProdutoPages.getIncluirPLU()).click();
        pluvalor = wait.until(ExpectedConditions.alertIsPresent()).getText();
        driver.switchTo().alert().accept();
        wait.until(invisibilityOfElementLocated(By.id("carregando_loadObject")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tudo")));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cadastrarProdutoPages.getBotãoVoltar()))).click();
    }

    public void filtrarProduto() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cadastrarProdutoPages.getFiltrarProdutoPor()));
        Select filtrarProdutoPor = new Select(driver.findElement(cadastrarProdutoPages.getFiltrarProdutoPor()));
        js.executeScript("document.getElementById('tudo').style.display='none';");
        filtrarProdutoPor.selectByVisibleText("EAN");
        driver.findElement(cadastrarProdutoPages.getInserirEAN()).sendKeys(eanValor);
        driver.findElement(cadastrarProdutoPages.getFiltrarProduto()).click();
    }

    public String vizualizaEANProduto() {
        return driver.findElement(cadastrarProdutoPages.getVizualizarNumeroEAN()).getText();
    }


}
