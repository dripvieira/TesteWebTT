package com.titansoftware.pages.EstoquePages;

import org.openqa.selenium.By;

public class MovimentacaoDeEstoqueAutomaticaPage {


    By incluirInventario = By.xpath("/html/body/div[2]/table/thead/tr/th[1]/a");
    By selecionaTipo = By.xpath("//select[@id='iType']");
    By descricao = By.xpath("//input[@id='iName']");
    By campoData = By.xpath("//input[@id='iDtRef']");
    By maxItens = By.xpath("//input[@id='maxItems']");
    By loja = By.xpath("//select[@id='iStore']");
    By selecionaMotivo = By.xpath("//select[@id='MOT_INVEN']");
    By flagForaDeLinha = By.xpath("//input[@id='iParamOutLine']");
    By flagNaoParaVenda = By.xpath("//input[@id='iParamNotForSale']");
    By selecionaCustoBruto = By.xpath("//select[@id='iRepCost']");
    By selecionaCustoLivro = By.xpath("//select[@id='iLFCost']");
    By btnSalvar = By.xpath("//input[@id='iFormBtn']");
    By defineProd = By.xpath("//input[@id='defineProdBtn']");
    By campoProd = By.xpath("//input[@id='pluSrch']");
    By descricaoProduto = By.xpath("//div[@class='itemDiv']");
    By salvarProd = By.xpath("//input[@id='btnSalvar']");
    By fecharProd = By.xpath("//input[@id='btnFechar']");
    By congelaEstoque = By.xpath("//input[@value='Congelar Estoque']");
    By congelar = By.xpath("//input[@value=' Congelar ']");
    By forcaCongelamento = By.xpath("//input[@value=' Forçar Congelamento ']");
    By btnAcompanhamento = By.xpath("//input[@id='ListaAcompanhamento']");
    By btnAlteraContador = By.xpath("/html/body/div[4]/div[3]/span[2]/div/table/thead/tr[3]/td[1]/a[1]/img");
    By contador = By.id("iCounter");
    By campoPlu = By.xpath("//input[@id='sPlu']");
    By campoQuantidade = By.xpath("//input[@id='sQtd']");
    By embalagem = By.xpath("//select[@id='sUnit']");
    By btnSalvaConta = By.xpath("/html/body/form/div[2]/input[1]");
    By fecharContagem = By.xpath("//body/input[@value='Voltar ']");
    By btnValidar = By.xpath("//input[@value='Validar']");
    By validar = By.xpath("//input[@id='validar']");
    By btnFechar = By.xpath("//img[@id='btPopUpGenClose']");

    By numInventario = By.xpath("/html/body/h1");
    By btnVoltarInv = By.xpath("//input[@id='VolrarBT']");
    By filtro = By.xpath("//input[@id='fText']");
    By dataDe = By.xpath("//input[@name='dti']");
    By dataAte = By.xpath("//input[@name='dtf']");
    By filtrar = By.xpath("/html/body/form/div/div/div[1]/div[8]/input[1]");
    By btnRelatorios = By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]/a[2]/img");
    By geraSobra = By.xpath("/html/body/table/tbody/tr[3]/td/a");

    By geraQuebra = By.xpath("/html/body/table/tbody/tr[2]/td/a");
    By confirmaMovimentacao = By.id("btDialogBox_0");
    By btnVoltar = By.xpath("//input[@class='load-on-click']");

    public By getIncluirInventario() {
        return incluirInventario;
    }

    public By getSelecionaTipo() {
        return selecionaTipo;
    }

    public By getDescricao() {
        return descricao;
    }

    public By getCampoData() {
        return campoData;
    }

    public By getMaxItens() {
        return maxItens;
    }

    public By getLoja() {
        return loja;
    }

    public By getSelecionaMotivo() {
        return selecionaMotivo;
    }

    public By getFlagForaDeLinha() {
        return flagForaDeLinha;
    }

    public By getFlagNaoParaVenda() {
        return flagNaoParaVenda;
    }

    public By getSelecionaCustoBruto() {
        return selecionaCustoBruto;
    }

    public By getSelecionaCustoLivro() {
        return selecionaCustoLivro;
    }

    public By getBtnSalvar() {
        return btnSalvar;
    }

    public By getDefineProd() {
        return defineProd;
    }

    public By getCampoProd() {
        return campoProd;
    }

    public By getDescricaoProduto() {
        return descricaoProduto;
    }

    public By getSalvarProd() {
        return salvarProd;
    }

    public By getFecharProd() {
        return fecharProd;
    }

    public By getCongelaEstoque() {
        return congelaEstoque;
    }

    public By getCongelar() {
        return congelar;
    }

    public By getForcaCongelamento() {
        return forcaCongelamento;
    }

    public By getBtnAcompanhamento() {
        return btnAcompanhamento;
    }

    public By getBtnAlteraContador() {
        return btnAlteraContador;
    }

    public By getContador() {
        return contador;
    }

    public By getCampoPlu() {
        return campoPlu;
    }

    public By getCampoQuantidade() {
        return campoQuantidade;
    }

    public By getEmbalagem() {
        return embalagem;
    }

    public By getBtnSalvaConta() {
        return btnSalvaConta;
    }

    public By getFecharContagem() {
        return fecharContagem;
    }

    public By getBtnValidar() {
        return btnValidar;
    }

    public By getValidar() {
        return validar;
    }

    public By getBtnFechar() {
        return btnFechar;
    }

    public By getNumInventario() {
        return numInventario;
    }

    public By getBtnVoltarInv() {
        return btnVoltarInv;
    }

    public By getFiltro() {
        return filtro;
    }

    public By getDataDe() {
        return dataDe;
    }

    public By getDataAte() {
        return dataAte;
    }

    public By getFiltrar() {
        return filtrar;
    }

    public By getBtnRelatorios() {
        return btnRelatorios;
    }

    public By getGeraSobra() {
        return geraSobra;
    }

    public By getGeraQuebra() {
        return geraQuebra;
    }

    //aceitar alerta

    public By getConfirmaMovimentacao() {
        return confirmaMovimentacao;
    }

    public By getBtnVoltar() {
        return btnVoltar;
    }

}
