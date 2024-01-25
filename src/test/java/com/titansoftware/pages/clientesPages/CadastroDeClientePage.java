package com.titansoftware.pages.clientesPages;

import org.openqa.selenium.By;

public class CadastroDeClientePage {
    By btnIncluir = By.xpath("//img[@src='../../img/DoInsert.gif' and parent::a]");
    By selectCategoria = By.xpath("//select[@id='type_people']");
    By documento = By.xpath("//input[@id='SKU']");
    By selectTipoCliente = By.xpath("//select[@id='campoCliente']");
    By vendedor = By.xpath("//input[@id='vendedor']");
    By nome = By.xpath("//input[@id='tbrow[4]']");
    By nomeAlt = By.xpath("/html/body/form/table[2]/tbody/tr[4]/td[4]/input");
    By telefoneFixo = By.xpath("//input[@id='telefoneCliente']");
    By telefoneMovel = By.xpath("/html/body/form/table[2]/tbody/tr[5]/td[4]/input");
    By convenio = By.xpath("//input[@id='codConvenio']");
    By condPagto = By.xpath("//input[@id='sltCondicaoPagamento']");
    By formaPagto = By.xpath("//input[@id='idForm']");
    By limite = By.xpath("//input[@id='strow[2]']");
    By status = By.xpath("//select[@name='natu_key']");
    By limiteDispo = By.xpath("//input[@id='saldo']");
    By descPorcento = By.xpath("//input[@id='tbrow[94]']");
    By saldo = By.xpath("//input[@id='saldo_pre']");
    By descValor = By.xpath("//input[@id='tbrow[93]']");
    By endWeb = By.xpath("//input[@id='end_web']");
    By transp = By.xpath("//input[@id='transportadora']");
    By natureza = By.xpath("//select[@id='natu_key']");
    By email = By.xpath("//input[@id='email']");
    By contribuicao = By.xpath("/html/body/form/table[2]/tbody/tr[13]/td[1]/input[2]");
    By data_nasc = By.xpath("//input[@id='data_nascimento']");
    By comentario = By.xpath("//textarea[@id='strow[5]']");
    By mnsg = By.xpath("//textarea[@id='strow[6]']");
    By cepResidencial = By.xpath("//input[@name='residencial_address_cep']");
    By numResidencial = By.xpath("//input[@name='residencial_address_numero']");
    By labelComercial = By.xpath("/html/body/form/table[2]/tbody/tr[14]/td[2]/div/table/tbody/tr[2]/td/a");
    By cepComercial = By.xpath("//input[@name='comercial_address_cep']");
    By numComercial = By.xpath("//input[@name='comercial_address_numero']");
    By btnSalvar = By.xpath("(//input[@id='act1' and parent::form])[2]");
    By numCliente = By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[2]");
    By btnVoltar = By.xpath("(//input[@value='Voltar' and parent::form])[2]");
    By selectCondicao = By.xpath("//select[@id='condicao']");
    By campoFiltro = By.xpath("//input[@id='dadoCod']");
    By btnFiltrar = By.xpath("//input[@id='filtrar']");
    By nomeFiltrado = By.xpath("/html/body/table/tbody/tr/td[4]");
    By resgatarNumCleinte = By.xpath("/html/body/table/tbody/tr/td[2]");
    By endereco = By.xpath("//input[@name='residencial_address_endereco']");

    public By getBtnIncluir() {
        return btnIncluir;
    }

    public By getSelectCategoria() {
        return selectCategoria;
    }

    public By getDocumento() {
        return documento;
    }

    public By getSelectTipoCliente() {
        return selectTipoCliente;
    }

    public By getVendedor() {
        return vendedor;
    }

    public By getNome() {
        return nome;
    }

    public By getNomeAlt() {
        return nomeAlt;
    }

    public By getTelefoneFixo() {
        return telefoneFixo;
    }

    public By getTelefoneMovel() {
        return telefoneMovel;
    }

    public By getConvenio() {
        return convenio;
    }

    public By getCondPagto() {
        return condPagto;
    }


    public By getFormaPagto() {
        return formaPagto;
    }

    public By getLimite() {
        return limite;
    }

    public By getStatus() {
        return status;
    }

    public By getLimiteDispo() {
        return limiteDispo;
    }

    public By getDescPorcento() {
        return descPorcento;
    }

    public By getSaldo() {
        return saldo;
    }

    public By getDescValor() {
        return descValor;
    }

    public By getEndWeb() {
        return endWeb;
    }

    public By getTransp() {
        return transp;
    }

    public By getNatureza() {
        return natureza;
    }

    public By getEmail() {
        return email;
    }

    public By getContribuicao() {
        return contribuicao;
    }

    public By getData_nasc() {
        return data_nasc;
    }

    public By getComentario() {
        return comentario;
    }

    public By getMnsg() {
        return mnsg;
    }

    public By getCepResidencial() {
        return cepResidencial;
    }

    public By getEndereco() {
        return endereco;
    }

    public By getNumResidencial() {
        return numResidencial;
    }

    public By getLabelComercial() {
        return labelComercial;
    }

    public By getCepComercial() {
        return cepComercial;
    }

    public By getNumComercial() {
        return numComercial;
    }

    public By getBtnSalvar() {
        return btnSalvar;
    }

    public By getNumCliente() {
        return numCliente;
    }

    public By getResgatarNumCliente() {
        return resgatarNumCleinte;
    }

    public By getBtnVoltar() {
        return btnVoltar;
    }

    public By getSelectCondicao() {
        return selectCondicao;
    }

    public By getCampoFiltro() {
        return campoFiltro;
    }

    public By getBtnFiltrar() {
        return btnFiltrar;
    }

    public By getNomeFiltrado() {
        return nomeFiltrado;
    }
}
