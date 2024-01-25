package com.titansoftware.pages.EstoquePages.RecebimentoPages.NotaFiscalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EntradaDeNotaFiscalPage extends By {


    By selecionarModuloEstoque = By.xpath("//a[@href=\"javascript:openMenu('stock')\"]");
    By incluirNF = By.xpath("//img[@title='Adicionar novo']");
    By tipoDocNotaFiscal = By.xpath("//td[@class='text-center' and child::img[@title='Notas Fiscal Eletronica']]");
    By modeloNota = By.id("modelo_nota");
    By salvarEntrada = By.xpath("//input[@value='Salvar']");
    By chaveNFE = By.xpath("//input[@name='chave']");
    By emitente = By.xpath("//input[@name='forn_key']");
    By inserirDatas = By.xpath("//input[@name='nf_emissao_dt']");
    By clicarRomaneio = By.xpath("//input[@value='Romaneio >>']");
    By naturezaDaOperacao = By.id("tdoc_key");
    By preencherNumeroNF = By.id("nf_id");
    By serieNF = By.id("nf_serie");
    By filtrar = By.xpath("//input[@value='Filtrar']");
    By cancelarInclusao = By.xpath("//img[@title='Cancelar Inclusão']");
    By incluirEntradaProduto = By.xpath("//img[@id='doAddProduto']");
    By incluirCodigoProduto = By.xpath("//input[@id='doPlu' and ancestor::div[@class='popover fade right in']]");
    By botaoAlterar = By.xpath("//img[@title='Editar/Excluir']");
    By quantidadeProduto = By.xpath("//input[@name='item[qtd_fat][]']");
    By PrecoUnitario = By.xpath("//input[@name='item[nfp_unidade_valor][]']");
    By emissaoNF = By.id("extrato[tnfe_dt_emi]");
    By dataVencimento = By.id("extrato_duplicata[tnfedup_dt_venc][]");
    By resgatarCodDevAutomatica = By.xpath("/html/body/form/table[4]/tbody/tr[3]/td[1]");
    By resgatarNfDevAutomatica = By.xpath("/html/body/form/table[4]/tbody/tr[3]/td[2]");
    By clicarMsg = By.id("btDialogBox_0");
    By resgatarStatusDevAutomatica = By.xpath("/html/body/form/table[4]/tbody/tr[3]/td[4]");
    By resgatarValoNfDevAutomatica = By.xpath("/html/body/form/table[4]/tbody/tr[3]/td[5]");
    By botaoFechar = By.xpath("//input[@onclick='window.close()']");
    By valorTotalDaNota = By.id("imp_valor_total");
    By nfDevAutomatica = By.xpath("/html/body/form/table[4]/tbody/tr[3]/td[1]");
    By NfDevolucaoAutomatica = By.xpath("//input[@name='dados']");
    By desativarParipassus = By.xpath("//input[@value='paripassus']");
    By Filtrarpor = By.xpath("//select[@id='filtrarPor']");
    By inserirDadosPedidos = By.xpath("//input[@id='dado']");
    By fecharValidacao = By.xpath("/html/body/div[6]/input[2]");
    By totalNF = By.id("spnTotal");
    By calendario = By.xpath("//span[@class='ui-datepicker-month']");
    By cfop = By.xpath("//input[@name='nf_cfop']");
    By IncricaoEstadual = By.xpath(" /html/body/form/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[4]/div[@id='ie']");
    By duplicata = By.xpath("//input[@name='duplicata[nfd_key][]']");
    By Carregamento = By.xpath("//div[@class='ui-progressbar-value ui-widget-header ui-corner-left ui-corner-right']");

    By salvarRomaneio = By.id("save");

    public By getSelecionarModuloEstoque() {
        return selecionarModuloEstoque;
    }

    By pedidoClick = By.id("openPedidos");


    public By getIncluirNF() {
        return incluirNF;
    }

    public By getTipoDocNotaFiscal() {
        return tipoDocNotaFiscal;
    }
    public By getModeloNota() {
        return modeloNota;
    }
    By descricaoModeloNota = By.id("modelo_descr");

    public By getDescricaoModeloNota() {
        return descricaoModeloNota;
    }

    public By getPrecoUnitario() {
        return PrecoUnitario;
    }

    public By getTotalNF() {
        return totalNF;
    }

    By escolherPedido = By.id("pddo_0");

    public By getChaveNFE() {
        return chaveNFE;
    }

    public By getEmitente() {
        return emitente;
    }

    public By getValorTotalDaNota() {
        return valorTotalDaNota;
    }

    public By getInserirDatas() {
        return inserirDatas;
    }

    public By getCalendario() {
        return calendario;
    }

    By selecionaPLU = By.id("pdit_0");

    public By getPreencherNumeroNF() {
        return preencherNumeroNF;
    }

    By inserirQuantidade = By.xpath("//input[@size='5']");

    public By getSerieNF() {
        return serieNF;
    }

    By importarSelecionadosClick = By.xpath("//input[@value=' Importar Selecionados ']");


    By criticarEntradaNF = By.id("criticar");

    public By getNaturezaDaOperacao() {
        return naturezaDaOperacao;
    }

    public By getCfop() {
        return cfop;
    }

    By botaoOk = By.xpath("//input[@class='btOkMsgBox']");

    public By getIncluirEntradaProduto() {
        return incluirEntradaProduto;
    }

    By resgatarNumeroNF = By.xpath("/html/body/form/div[1]/table/tbody/tr[1]/td[2]");

    public By getIncluirCodigoProduto() {
        return incluirCodigoProduto;
    }

    public By getCancelarInclusao() {
        return cancelarInclusao;
    }

    By resgatarValorNF = By.xpath("//*[@id=\"conference\"]/tbody/tr[3]/td[3]");

    public By getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public By getSalvarEntrada() {
        return salvarEntrada;
    }

    public By getCarregamento() {
        return Carregamento;
    }

    By custoBrutoEmbalagem = By.id("extrato_itens[tnfei_c_br_emb][]");

    public By getClicarMsg() {
        return clicarMsg;
    }

    By custoLiquido = By.id("extrato_itens[tnfei_c_liq_un][]");

    By qProduto = By.id("extrato_itens[tnfei_qtde_rec][]");

    public By getClicarRomaneio() {
        return clicarRomaneio;
    }


    public By getSalvarRomaneio() {
        return salvarRomaneio;
    }

    public By getPedidoClick() {
        return pedidoClick;
    }

    public By getFiltrar() {
        return filtrar;
    }

    public By getBotaoAlterar() {
        return botaoAlterar;
    }

    public By getEscolherPedido() {
        return escolherPedido;
    }

    public By getSelecionaPLU() {
        return selecionaPLU;
    }

    public By getInserirQuantidade() {
        return inserirQuantidade;
    }

    public By getImportarSelecionadosClick() {
        return importarSelecionadosClick;
    }

    By numPedido = By.xpath("//table[@id=\"lista\"]/tbody/tr[1]/td[2]");

    public By getCriticarEntradaNF() {
        return criticarEntradaNF;
    }

    public By getBotaoOk() {
        return botaoOk;
    }

    public By getResgatarNumeroNF() {
        return resgatarNumeroNF;
    }

    public By getEmissaoNF() {
        return emissaoNF;
    }

    public By getResgatarValorNF() {
        return resgatarValorNF;
    }

    public By getCustoBrutoEmbalagem() {
        return custoBrutoEmbalagem;
    }

    public By getqProduto() {
        return qProduto;
    }

    public By getResgatarCodDevAutomatica() {
        return resgatarCodDevAutomatica;
    }

    public By getResgatarNfDevAutomatica() {
        return resgatarNfDevAutomatica;
    }

    public By getResgatarStatusDevAutomatica() {
        return resgatarStatusDevAutomatica;
    }

    public By getResgatarValoNfDevAutomatica() {
        return resgatarValoNfDevAutomatica;
    }

    public By getCustoLiquido() {
        return custoLiquido;
    }


    By botaoValidate = By.id("validateButton");

    public By getNumPedido() {
        return numPedido;
    }

    public By getCodNfDevAutomatica() {
        return nfDevAutomatica;
    }


    @Override
    public List<WebElement> findElements(SearchContext context) {
        return null;
    }

    public By getBotaoFechar() {
        return botaoFechar;
    }

    public By getNfDevolucaoAutomatica() {
        return NfDevolucaoAutomatica;
    }

    public By getDesativarParipassus() {
        return desativarParipassus;
    }

    public By getBotaoValidate() {
        return botaoValidate;
    }

    public By getDataVencimento() {
        return dataVencimento;
    }

    public By getFiltrarpor() {
        return Filtrarpor;
    }

    public By getInserirDadosPedidos() {
        return inserirDadosPedidos;
    }

    public By getFecharValidacao() {
        return fecharValidacao;
    }

    public By getIncricaoEstadual() {
        return IncricaoEstadual;
    }


    public By getDuplicata() {
        return duplicata;
    }

    By selectTipoDoc = By.xpath("//select[@name='tdoc_importacao']");

    public By getSelectTipoDoc() {
        return selectTipoDoc;
    }

    By tipoImportcao = By.xpath("//input[@value='file']");

    public By getTipoImportcao() {
        return tipoImportcao;
    }
    By importarXML = By.xpath("//input[@name='file_import']");

    public By getImportarXML() {
        return importarXML;
    }

    By incluir = By.xpath("//input[@value='Importar']");

    public By getImportar() {
        return incluir;
    }


}


