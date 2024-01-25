package com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs;

import com.github.javafaker.Faker;
import com.titansoftware.common.BaseTeste;
import com.titansoftware.funcs.comprasFuncs.PedidoDeComprasItemAItemFunc;
import com.titansoftware.funcs.faturamentoFuncs.GerarFaturaFunc;
import com.titansoftware.pages.EstoquePages.RecebimentoPages.NotaFiscalPages.EntradaDeNotaFiscalPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntradaDeNotaFiscalFunc extends BaseTeste {

    public static String nF;
    public static String valorNF;
    public static String emissaoNF;
    public static String custoBruto;
    public static String custoLiquido;
    public static String dataVencimento;
    public static String numPedido;
    public static String quantidadeProduto;
    public static String codigoNFRural;
    public static String nfDevAutomatica;
    public static String codNFDevAutomatica;
    public static String numNfDevAutomatica;
    public static String statusNfDevAutomatica;
    public static String valorNfDevAutomatica;
    String numPedidoCompra;
    String janelaPaiHandle = driver.getWindowHandle();
    Faker faker = new Faker();
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formatteDate = currentDate.format(formatter);
    EntradaDeNotaFiscalPage entradaDeNotaFiscalPage = new EntradaDeNotaFiscalPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void inserirNF() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(entradaDeNotaFiscalPage.getIncluirNF()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(entradaDeNotaFiscalPage.getIncluirNF()));
        driver.findElement(entradaDeNotaFiscalPage.getIncluirNF()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(entradaDeNotaFiscalPage.getTipoDocNotaFiscal()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getTipoDocNotaFiscal())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getTipoDocNotaFiscal()))).click();
    }

    public void acessarImportacaoNFE() {
        wait.until(ExpectedConditions.presenceOfElementLocated(entradaDeNotaFiscalPage.getIncluirNF()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(entradaDeNotaFiscalPage.getIncluirNF()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getIncluirNF()))).click();
    }

    public void processoImportarNFE() {
        Select tipoDocumento = new Select(driver.findElement(entradaDeNotaFiscalPage.getSelectTipoDoc()));
        tipoDocumento.selectByVisibleText("1 - Compra Mercad. Adquirida p/ Revenda-Produto Normal");
        driver.findElement(entradaDeNotaFiscalPage.getTipoImportcao()).click();
        driver.findElement(entradaDeNotaFiscalPage.getImportarXML()).sendKeys("C:\\Users\\Titan Suporte\\Downloads\\" + GerarFaturaFunc.xMLNFe);
        driver.findElement(entradaDeNotaFiscalPage.getImportar()).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("ifrmPopUpObj")));
        driver.findElement(entradaDeNotaFiscalPage.getSalvarEntrada()).click();
        driver.switchTo().alert().accept();
        driver.findElement(entradaDeNotaFiscalPage.getCriticarEntradaNF()).click();
        driver.switchTo().alert().accept();
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

    public void importarNF() throws InterruptedException {
        driver.findElement(entradaDeNotaFiscalPage.getImportar()).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        driver.switchTo().parentFrame();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getClicarMsg()))).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Dir");
    }

    public void InserirDadosNotaFiscal(String emitente, String naturezaDaOperacao, String serieNF, String modeloDocumentoFiscal, String chaveNFE, String valorTotal, String codigoProduto, String quantidadeproduto, String precoUnitario) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        wait.until(ExpectedConditions.presenceOfElementLocated(entradaDeNotaFiscalPage.getEmitente()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(entradaDeNotaFiscalPage.getEmitente()));
        wait.until(ExpectedConditions.elementToBeClickable(entradaDeNotaFiscalPage.getEmitente()));
        WebElement enderecoCampo = driver.findElement(entradaDeNotaFiscalPage.getIncricaoEstadual());
        String valorInicialEndereco = enderecoCampo.getText();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getEmitente()))).sendKeys(emitente);
        driver.findElement(entradaDeNotaFiscalPage.getEmitente()).sendKeys(Keys.TAB);
        wait.until(driver -> {
            String valorAtualEndereco = enderecoCampo.getText();
            return !valorAtualEndereco.equals(valorInicialEndereco);
        });
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getInserirDatas()))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getInserirDatas()))).sendKeys(formatteDate);
        wait.until(ExpectedConditions.presenceOfElementLocated(entradaDeNotaFiscalPage.getCalendario()));
        driver.findElement(entradaDeNotaFiscalPage.getInserirDatas()).sendKeys(Keys.ESCAPE);
        driver.findElement(entradaDeNotaFiscalPage.getInserirDatas()).sendKeys(Keys.TAB);
        String valorInicial = (String) js.executeScript("return arguments[0].value;", driver.findElement(entradaDeNotaFiscalPage.getCfop()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getNaturezaDaOperacao()))).sendKeys(naturezaDaOperacao);
        driver.findElement(entradaDeNotaFiscalPage.getNaturezaDaOperacao()).sendKeys(Keys.RETURN);
        driver.findElement(entradaDeNotaFiscalPage.getNaturezaDaOperacao()).sendKeys(Keys.TAB);
        wait.until(driver -> {
            String valorAtual = (String) js.executeScript("return arguments[0].value;", driver.findElement(entradaDeNotaFiscalPage.getCfop()));
            return !valorAtual.equals(valorInicial);
        });
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getPreencherNumeroNF()))).click();
        driver.findElement(entradaDeNotaFiscalPage.getPreencherNumeroNF()).sendKeys(faker.code().ean8());
        driver.findElement(entradaDeNotaFiscalPage.getPreencherNumeroNF()).sendKeys(Keys.RETURN);
        driver.findElement(entradaDeNotaFiscalPage.getSerieNF()).sendKeys(serieNF);
        driver.findElement(entradaDeNotaFiscalPage.getSerieNF()).sendKeys(Keys.TAB);
        WebElement modeloNF = driver.findElement(entradaDeNotaFiscalPage.getDescricaoModeloNota());
        String valorInicialDocumento = modeloNF.getText();
        driver.findElement(entradaDeNotaFiscalPage.getModeloNota()).sendKeys(modeloDocumentoFiscal);
        driver.findElement(entradaDeNotaFiscalPage.getModeloNota()).sendKeys(Keys.TAB);
        try {
            driver.findElement((entradaDeNotaFiscalPage.getChaveNFE())).sendKeys(chaveNFE);
            driver.findElement((entradaDeNotaFiscalPage.getChaveNFE())).sendKeys(Keys.TAB);
            wait.until(driver -> {
                String valorAtualDocumento = modeloNF.getText();
                return !valorAtualDocumento.equals(valorInicialDocumento);
            });
        } catch (Exception ignored) {

        }
        try {
            driver.switchTo().alert().accept();
        } catch (Exception ignored) {

        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(entradaDeNotaFiscalPage.getValorTotalDaNota()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getValorTotalDaNota()))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getValorTotalDaNota()))).sendKeys(valorTotal);
        driver.findElement(entradaDeNotaFiscalPage.getValorTotalDaNota()).sendKeys(Keys.RETURN);
        driver.findElement(entradaDeNotaFiscalPage.getValorTotalDaNota()).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.presenceOfElementLocated(entradaDeNotaFiscalPage.getDuplicata()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getDuplicata()))).getAttribute("value");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(entradaDeNotaFiscalPage.getIncluirEntradaProduto()));
        while (!isElementVisible(driver, entradaDeNotaFiscalPage.getIncluirCodigoProduto())) {
            try {
                driver.findElement(entradaDeNotaFiscalPage.getIncluirEntradaProduto()).click();
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        js.executeScript("window.scroll(0,200);");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getIncluirCodigoProduto()))).sendKeys(codigoProduto);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getCancelarInclusao()))).click();
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getCancelarInclusao()))).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(entradaDeNotaFiscalPage.getTotalNF()));
        String totalInicial = driver.findElement(entradaDeNotaFiscalPage.getTotalNF()).getText();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getQuantidadeProduto()))).sendKeys(quantidadeproduto);
        driver.findElement(entradaDeNotaFiscalPage.getQuantidadeProduto()).sendKeys(Keys.TAB);
        driver.findElement(entradaDeNotaFiscalPage.getPrecoUnitario()).sendKeys(precoUnitario);
        driver.findElement(entradaDeNotaFiscalPage.getPrecoUnitario()).sendKeys(Keys.ESCAPE);
        driver.findElement(entradaDeNotaFiscalPage.getPrecoUnitario()).sendKeys(Keys.TAB);
        wait.until(driver -> {
            String totalAtual = driver.findElement(entradaDeNotaFiscalPage.getTotalNF()).getText();
            return !totalInicial.equals(totalAtual);
        });
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getSalvarEntrada())));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(entradaDeNotaFiscalPage.getSalvarEntrada()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getSalvarEntrada()))).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.invisibilityOfElementLocated(entradaDeNotaFiscalPage.getCarregamento()),
                ExpectedConditions.alertIsPresent()
        ));
        try {
            driver.switchTo().alert().accept();
        } catch (Exception ignored) {
        }
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.presenceOfElementLocated(entradaDeNotaFiscalPage.getClicarMsg()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(entradaDeNotaFiscalPage.getClicarMsg()));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getClicarMsg()))).click();
        js.executeScript("window.scroll(0,220);");
    }

    public String inserirDadosRomaneio(List<Map<String, String>> dadosRomaneio) {
        wait.until(ExpectedConditions.presenceOfElementLocated(entradaDeNotaFiscalPage.getClicarRomaneio()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getClicarRomaneio())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getClicarRomaneio()))).click();
        try {
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (Exception ignored) {
        }
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                //for (Map<String, String> romaneioData : dadosRomaneio) {
                System.out.println("Total de linhas no DataTable: " + dadosRomaneio.size());
                for (int i = 0; i < dadosRomaneio.size(); i++) {
                    Map<String, String> romaneioData = dadosRomaneio.get(i);
                    String quantidadeRomaneio = romaneioData.get("Quantidade_Romaneio");
                    String validadeRomaneio = romaneioData.get("Validade_Romaneio");
                    System.out.println("Quantidade_Romaneio: " + quantidadeRomaneio);
                    System.out.println("Validade_Romaneio: " + validadeRomaneio);
                    driver.findElement(By.id("qtde_" + (i + 1))).clear();
                    driver.findElement(By.id("qtde_" + (i + 1))).sendKeys(quantidadeRomaneio);
                    driver.findElement(By.id("valid_" + (i + 1))).sendKeys(validadeRomaneio);
                }
                driver.findElement(entradaDeNotaFiscalPage.getSalvarRomaneio()).click();
                wait.until(ExpectedConditions.alertIsPresent()).accept();
                driver.switchTo().window(mainWindowHandle);
            }
        }
        return mainWindowHandle;
    }


    public void inserirDadosPedido(String quantidadePedido) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Dir")));
        driver.findElement(entradaDeNotaFiscalPage.getPedidoClick()).click();
        String mainWindowHandle2 = driver.getWindowHandle();
        Set<String> allWindowHandles2 = driver.getWindowHandles();
        Iterator<String> iterator2 = allWindowHandles2.iterator();
        while (iterator2.hasNext()) {
            String ChildWindow = iterator2.next();
            if (!mainWindowHandle2.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                Select filtrarPor = new Select(driver.findElement((entradaDeNotaFiscalPage.getFiltrarpor())));
                filtrarPor.selectByValue("ped");
                driver.findElement(entradaDeNotaFiscalPage.getInserirDadosPedidos()).clear();
                String numeroPedido = PedidoDeComprasItemAItemFunc.numeroPedido;
                String regex = "\\d+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(numeroPedido);
                StringBuilder pedido = new StringBuilder();
                while (matcher.find()) {
                    pedido.append(matcher.group());
                    numPedidoCompra = String.valueOf(pedido);
                }
                driver.findElement(entradaDeNotaFiscalPage.getInserirDadosPedidos()).sendKeys(numPedidoCompra);
                driver.findElement(entradaDeNotaFiscalPage.getFiltrar()).click();
                driver.findElement(entradaDeNotaFiscalPage.getEscolherPedido()).click();
                numPedido = driver.findElement(entradaDeNotaFiscalPage.getNumPedido()).getText();
                driver.findElement(entradaDeNotaFiscalPage.getSelecionaPLU()).click();
                driver.findElement(entradaDeNotaFiscalPage.getInserirQuantidade()).sendKeys(quantidadePedido);
                driver.findElement(entradaDeNotaFiscalPage.getImportarSelecionadosClick()).click();
                wait.until(ExpectedConditions.alertIsPresent()).accept();
                driver.switchTo().window(mainWindowHandle2);
            }
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Dir");
        try {
            driver.findElement(entradaDeNotaFiscalPage.getBotaoOk()).click();
        } catch (Exception ignored) {

        }
    }

    public <List> void CriticarEntradaNf() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Dir");
        js.executeScript("document.getElementById('tudo').style.display='none';");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getCriticarEntradaNF()))).click();
        try {
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (Exception ignored) {
        }
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String janelaPai = driver.getWindowHandle();
        Set<String> janelasFilhas = driver.getWindowHandles();
        Iterator<String> interacao = janelasFilhas.iterator();
        while (interacao.hasNext()) {
            String ChildWindow = interacao.next();
            if (!janelaPai.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                nF = wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getResgatarNumeroNF()))).getText();
                emissaoNF = driver.findElement(entradaDeNotaFiscalPage.getEmissaoNF()).getAttribute("value");
                dataVencimento = driver.findElement(entradaDeNotaFiscalPage.getDataVencimento()).getAttribute("value");
                valorNF = driver.findElement(entradaDeNotaFiscalPage.getResgatarValorNF()).getText();
                custoBruto = driver.findElement(entradaDeNotaFiscalPage.getCustoBrutoEmbalagem()).getAttribute("value");
                custoLiquido = driver.findElement(entradaDeNotaFiscalPage.getCustoLiquido()).getAttribute("value");
                quantidadeProduto = driver.findElement(entradaDeNotaFiscalPage.getqProduto()).getAttribute("value");
                try {
                    codNFDevAutomatica = driver.findElement(entradaDeNotaFiscalPage.getResgatarCodDevAutomatica()).getText();
                    numNfDevAutomatica = driver.findElement(entradaDeNotaFiscalPage.getResgatarNfDevAutomatica()).getText();
                    statusNfDevAutomatica = driver.findElement(entradaDeNotaFiscalPage.getResgatarStatusDevAutomatica()).getText();
                    valorNfDevAutomatica = driver.findElement(entradaDeNotaFiscalPage.getResgatarValoNfDevAutomatica()).getText();
                } catch (Exception ignored) {

                }
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scroll(0,400);");
                driver.findElement(entradaDeNotaFiscalPage.getBotaoValidate()).click();
                try {
                    driver.switchTo().alert().accept();
                } catch (Exception ignored) {
                }
                try {
                    wait.until(ExpectedConditions.alertIsPresent());
                    codigoNFRural = driver.switchTo().alert().getText();
                    driver.switchTo().alert().accept();
                } catch (Exception ignored) {
                }
                try {
                    driver.switchTo().alert().accept();
                } catch (Exception ignored) {
                }
                try {
                    List handles = (List) new ArrayList<>(driver.getWindowHandles());
                    if (((ArrayList<?>) handles).size() >= 3) {
                        String childWindow = (String) ((ArrayList<?>) handles).get(2);
                        driver.switchTo().window(childWindow);
                    } else if (((ArrayList<?>) handles).size() >= 2) {
                        String childWindow = (String) ((ArrayList<?>) handles).get(1);
                        driver.switchTo().window(childWindow);
                    } else {
                        System.out.println("Não há janelas suficientes para alternar.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public <List> void validarEntradaNF() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception ignored) {
        }
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
        } catch (Exception ignored) {
        }
        try {
            List handles = (List) new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window((String) ((ArrayList<?>) handles).get(1));

        } catch (Exception ignored) {

        }
        try {
            driver.findElement(entradaDeNotaFiscalPage.getFecharValidacao()).click();
        } catch (Exception ignored) {
        }
        try {
            driver.findElement(entradaDeNotaFiscalPage.getBotaoFechar()).click();
        } catch (Exception ignored) {
        }
        driver.switchTo().window(janelaPaiHandle);
    }

    public <List> void gerarNFDevolucaoAutomatica() {
        List handles = (List) new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window((String) ((ArrayList<?>) handles).get(1));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,180);");
        nfDevAutomatica = driver.findElement(entradaDeNotaFiscalPage.getCodNfDevAutomatica()).getText();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("PageLoaderMain")));
        driver.findElement(entradaDeNotaFiscalPage.getBotaoFechar()).click();
        driver.switchTo().window(janelaPaiHandle);
    }

    public void pesquisarNF() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getNfDevolucaoAutomatica()))).click();
        driver.findElement(entradaDeNotaFiscalPage.getNfDevolucaoAutomatica()).sendKeys(EntradaDeNotaFiscalFunc.nF.substring(0, 8));
        driver.findElement(entradaDeNotaFiscalPage.getDesativarParipassus()).click();
        driver.findElement(entradaDeNotaFiscalPage.getFiltrar()).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(entradaDeNotaFiscalPage.getCarregamento()));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(entradaDeNotaFiscalPage.getBotaoAlterar())));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(entradaDeNotaFiscalPage.getBotaoAlterar()))).click();
    }

    public String resgatarPLUValidacao(int cont) {
        try {
            List<String> handles = (List<String>) new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window((String) ((ArrayList<?>) handles).get(1));

        } catch (Exception ignored) {

        }
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[1]")))).getText();
    }

    public String resgatarDescricaoValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[2]")).getText();
    }

    public String resgatarCFOPValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[3]")).getText();
    }

    public String resgatarNatFornValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[4]")).getText();
    }

    public String resgatarEmbValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[5]")).getText();
    }

    public String resgatarQuanteFatValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[6]")).getText();
    }

    public String resgatarQuanteRecValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[7]")).getText();
    }


    public String resgatarCustoPedido(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[8]")).getText();
    }

    public String resgatarDifNFValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[9]")).getText();
    }

    public String resgatarDifPedValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[10]")).getText();
    }

    public String resgatarCBrEmbValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[11]")).getText();
    }

    public String resgatarCLiqUnValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[12]")).getText();
    }

    public String resgatarVerbaValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[13]")).getText();
    }

    public String resgatarDescValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[14]")).getText();
    }

    public String resgatarVDescValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[15]")).getText();
    }

    public String resgatarDAValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[16]")).getText();
    }

    public String resgatarICMSSubValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[17]")).getText();
    }

    public String resgatarPisConfinsValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[18]")).getText();
    }

    public String resgatarIPIValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[19]")).getText();
    }

    public String resgatarICMSValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[20]")).getText();
    }

    public String resgatarFgFValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[21]")).getText();
    }

    public String resgatarPautaValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[22]")).getText();
    }

    public String resgatarTotalValidacao(int cont) {
        return driver.findElement(By.xpath("/html/body/table[1]/tbody[1]/tr[" + (cont) + "]/td[23]")).getText();
    }


}

