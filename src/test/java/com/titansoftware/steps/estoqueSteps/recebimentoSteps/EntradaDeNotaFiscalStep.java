package com.titansoftware.steps.estoqueSteps.recebimentoSteps;

import com.titansoftware.funcs.EstoqueFuncs.ModuloEstoqueAcessosFunc;
import com.titansoftware.funcs.EstoqueFuncs.RecebimentoFuncs.NotaFiscalFuncs.EntradaDeNotaFiscalFunc;
import com.titansoftware.funcs.faturamentoFuncs.GerarFaturaFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class EntradaDeNotaFiscalStep {

    EntradaDeNotaFiscalFunc entradaDeNotaFiscalFunc = new EntradaDeNotaFiscalFunc();
    ModuloEstoqueAcessosFunc moduloEstoqueAcessosFunc = new ModuloEstoqueAcessosFunc();
    GerarFaturaFunc gerarFaturaFunc = new GerarFaturaFunc();


    /**
     * Acessa a pagina de entrada manual de NotaFiscal para recebimento de mercadorias
     */
    @Quando("estiver na tela de Gerenciamento de Notas Fiscais")
    public void telaGerencimantoDeNF() throws InterruptedException {
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRecebimento();
        moduloEstoqueAcessosFunc.acessarSubMenuNotaFiscal2();
        entradaDeNotaFiscalFunc.inserirNF();
    }

    /**
     * Acessa a pagina de importação de NotaFiscal para recebimento de mercadorias
     */
    @E("estiver na tela de importação de Notas Fiscais")
    public void telaImportacaoDeNF() throws InterruptedException {
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRecebimento();
        moduloEstoqueAcessosFunc.acessarSubMenuNotaFiscal2();
    }

    @E("realizar a importação do XMl")
    public void importarXML() throws InterruptedException {
        entradaDeNotaFiscalFunc.acessarImportacaoNFE();
        entradaDeNotaFiscalFunc.processoImportarNFE();
        entradaDeNotaFiscalFunc.importarNF();
    }


    /**
     * Acessa a pagina de gerencimento de Nota Fiscal
     */
    @E("acessar a tela de Gerenciamento de Notas Fiscais")
    public void acessarGerenciamentoNF() throws InterruptedException {
        moduloEstoqueAcessosFunc.acessarModuloEstoque();
        moduloEstoqueAcessosFunc.acessarMenuRecebimento();
        moduloEstoqueAcessosFunc.acessarSubMenuNotaFiscal2();
    }

    /**
     * Insere os dados da Nota fiscal recebida
     *
     * @param dataTable recebe os dados a ser inseridos no recebimento de Nota Fiscal
     */
    @E("inserir os dados da Nota Fiscal")
    public void inserirDadosNF(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String emitente = usuario.get(0).get("Emitente");
        String naturezaDaOperacao = usuario.get(0).get("Natureza_da_Operação");
        String serieNF = usuario.get(0).get("Série_NF");
        String modeloDocumentoFiscal = usuario.get(0).get("Modelo_Documento_Fiscal");
        String chaveNFE = usuario.get(0).get("Chave_NFE");
        String valorTotal = usuario.get(0).get("Valor_Total");
        String codigoProduto = usuario.get(0).get("Código_Produto");
        String quantidadeproduto = usuario.get(0).get("Quantidade_produto");
        String precoUnitario = usuario.get(0).get("Preço_produto");
        entradaDeNotaFiscalFunc.InserirDadosNotaFiscal(emitente, naturezaDaOperacao, serieNF, modeloDocumentoFiscal, chaveNFE, valorTotal, codigoProduto, quantidadeproduto, precoUnitario);

    }

    /**
     * Insere os dados de Romaneio
     *
     * @param dataTable recebe os dados a ser inseridos no Romaneio
     */
    @E("inserir os dados do romaneio")
    public void inserirDadosRomaneio(DataTable dataTable) {
        List<Map<String, String>> romaneio = dataTable.asMaps();
        entradaDeNotaFiscalFunc.inserirDadosRomaneio(romaneio);

    }

    @E("criticar a entrada de NF")
    public void criticarEntradaDeNF() {
        entradaDeNotaFiscalFunc.CriticarEntradaNf();
    }

    @E("validar a entrada de NF")
    public void validarEntradaDeNF() {
        entradaDeNotaFiscalFunc.validarEntradaNF();
    }

    @E("gerar NF de devolução automatica")
    public void gerarNFDevolucaoAutomatica() {
        entradaDeNotaFiscalFunc.gerarNFDevolucaoAutomatica();
    }

    @Entao("validar a devolução autmomatica no recebimento")
    public void validacaoNoRecebimento() {
        entradaDeNotaFiscalFunc.pesquisarNF();
        entradaDeNotaFiscalFunc.CriticarEntradaNf();
        Assert.assertEquals(gerarFaturaFunc.resgatarSerieNf, EntradaDeNotaFiscalFunc.numNfDevAutomatica);
        Assert.assertEquals("Validado", EntradaDeNotaFiscalFunc.statusNfDevAutomatica);
        Assert.assertEquals(EntradaDeNotaFiscalFunc.nfDevAutomatica, EntradaDeNotaFiscalFunc.codNFDevAutomatica);
    }


    @Então("deve visualizar o extrato de validação com o calculo dos tributos")
    public void validacaoTributos(DataTable dataTable) {

        int cont = 1;
        List<String> tipoTributacao = dataTable.asList();
        for (String tributacao : tipoTributacao) {
            tributacao = tributacao.replace(" ", "").toUpperCase();
            switch (tributacao) {
                case "TI":
                    Assert.assertEquals("700562", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("LINHA COSTURA DRIM", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.102", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("8.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("8.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-8", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("86,27", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("62,761", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("18,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("318", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("690,16", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "ICMS-STA=0":
                    Assert.assertEquals("167097", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("GEL MASSAGEADOR AP", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.403", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("7.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("7.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-7", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("6,89", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("6,253", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("130", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("48,23", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;
                case "FCP-ST":
                    Assert.assertEquals("819342", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("CERVEJA SKOL BEATS", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.403", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("3.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("3.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-3", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("2,39", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("2,777", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,67", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("20,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("1973", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("7,17", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "PAUTA":
                    Assert.assertEquals("100526", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("REFRIG H2OH 500ML", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.403", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("2.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("2.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-2", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("10,00", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("7,759", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("18,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("6", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("3,88", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("20,00", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "RBC-ICMS-N":
                    Assert.assertEquals("21933", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("PACOQUITA ORIGINAL", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.102", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("5.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("5.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-5", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("2,50", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("2,200", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,10", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("18,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("185", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("12,50", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "RBC-ICMS-ST":
                    Assert.assertEquals("100185", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("HEINEKEN", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.403", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("10.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("10.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-10", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("5,28", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("6,570", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("1,96", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("18,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("195", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("52,80", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "C-IPI":
                    Assert.assertEquals("915338", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("SANDALIA IPANEMA C", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.403", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("5.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("5.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-5", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("27,88", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("31,681", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("7,03", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("18,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("319", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("139,40", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "S-IPI":
                    Assert.assertEquals("101885", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("ENXAGUANTE BUCAL L", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.403", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("10.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("10.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-10", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("35,00", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("31,763", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("1599", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("350,00", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "C-PIS/COFINS-N":
                    Assert.assertEquals("466661", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("FARINHA LINHACA SA", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.102", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("5.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("5.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-5", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("38,55", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("28,045", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("18,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("825", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("192,75", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "C-PIS/COFINS-I":
                    Assert.assertEquals("4018", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("CEBOLA", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.102", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("15.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("15.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-15", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("15,00", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("15,000", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("2", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("225,00", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "ICMS - I":
                    Assert.assertEquals("4015", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("ORÉGANO", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.102", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("15.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("15.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-15", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("27,00", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("24,503", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("2", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("405,00", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "ICMS - NT":
                    Assert.assertEquals("197665", entradaDeNotaFiscalFunc.resgatarPLUValidacao(cont));
                    Assert.assertEquals("TABUADA BAHIA DECO", entradaDeNotaFiscalFunc.resgatarDescricaoValidacao(cont));
                    Assert.assertEquals("1.102", entradaDeNotaFiscalFunc.resgatarCFOPValidacao(cont));
                    Assert.assertEquals("FF", entradaDeNotaFiscalFunc.resgatarNatFornValidacao(cont));
                    Assert.assertEquals("UN", entradaDeNotaFiscalFunc.resgatarEmbValidacao(cont));
                    Assert.assertEquals("3.000", entradaDeNotaFiscalFunc.resgatarQuanteFatValidacao(cont));
                    Assert.assertEquals("3.000", entradaDeNotaFiscalFunc.resgatarQuanteRecValidacao(cont));
                    Assert.assertEquals("", entradaDeNotaFiscalFunc.resgatarCustoPedido(cont));
                    Assert.assertEquals("0", entradaDeNotaFiscalFunc.resgatarDifNFValidacao(cont));
                    Assert.assertEquals("-3", entradaDeNotaFiscalFunc.resgatarDifPedValidacao(cont));
                    Assert.assertEquals("1,19", entradaDeNotaFiscalFunc.resgatarCBrEmbValidacao(cont));
                    Assert.assertEquals("1,190", entradaDeNotaFiscalFunc.resgatarCLiqUnValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVerbaValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarVDescValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarDAValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSSubValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPisConfinsValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarIPIValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarICMSValidacao(cont));
                    Assert.assertEquals("1547", entradaDeNotaFiscalFunc.resgatarFgFValidacao(cont));
                    Assert.assertEquals("0,00", entradaDeNotaFiscalFunc.resgatarPautaValidacao(cont));
                    Assert.assertEquals("3,57", entradaDeNotaFiscalFunc.resgatarTotalValidacao(cont));
                    break;

                case "ICMS-ST AC ":
                    break;

            }
            cont = cont + 2;
        }
    }

}
