package com.titansoftware.steps.clientesSteps;

import com.titansoftware.funcs.clientesFuncs.CadastroDeClienteFunc;
import com.titansoftware.funcs.clientesFuncs.ModuloClientesAcessosFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.util.List;
import java.util.Map;

public class CadastroDeClienteStep {
    ModuloClientesAcessosFunc moduloClientesAcessosFunc = new ModuloClientesAcessosFunc();

    CadastroDeClienteFunc cadastroDeClienteFunc = new CadastroDeClienteFunc();

    @Quando("estiver na tela de manutenção de clientes")
    public void acessarClientes() throws InterruptedException {
        moduloClientesAcessosFunc.acessarModuloClientes();
        moduloClientesAcessosFunc.acessarMenuCliente();
        moduloClientesAcessosFunc.acessarSubMenuCliente();
    }

    @E("inserir os dados do cliente")
    public void cadastroCliente(DataTable dataTable) {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String vendedor = usuario.get(0).get("Vendedor");
        String nome = usuario.get(0).get("Nome");
        String nome_alt = usuario.get(0).get("Nome_Alternativo");
        String tel_fixo = usuario.get(0).get("Telefone_fixo");
        String tel_movel = usuario.get(0).get("Telefone_móvel");
        String convenio = usuario.get(0).get("Cod_Convenio");
        String cond_pagto = usuario.get(0).get("Condição_Pagto");
        String rede = usuario.get(0).get("Rede_SubRede");
        String forma_pagto = usuario.get(0).get("Forma_Pagto");
        String limite = usuario.get(0).get("Limite");
        String limite_dispo = usuario.get(0).get("Limite_Disponivel");
        String desc_porce = usuario.get(0).get("Desconto_financeiro%");
        String desc_valor = usuario.get(0).get("Desconto_financeiro$");
        String saldo = usuario.get(0).get("Saldo_PrePago");
        String web = usuario.get(0).get("Web");
        String transp = usuario.get(0).get("Transportadora");
        String email = usuario.get(0).get("Email");
        String data = usuario.get(0).get("Data_nasc");
        String coment = usuario.get(0).get("Comentario");
        String mensagem = usuario.get(0).get("Mensagem");
        String tipo = usuario.get(0).get("Tipo");
        String cep = usuario.get(0).get("CEP");
        String numero = usuario.get(0).get("NUMERO");
        cadastroDeClienteFunc.cadastraCliente(vendedor, nome, nome_alt, tel_fixo, tel_movel, convenio, cond_pagto, rede, forma_pagto, limite, limite_dispo, desc_porce, desc_valor, saldo, web, transp, email, data, coment, mensagem, tipo, cep, numero);
    }

    @Então("após pesquisar o cliente pelo código gerado, deve visualizar o nome do cliente")
    public void filtroCliente(DataTable dataTable) {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String nome = usuario.get(0).get("Nome");
        cadastroDeClienteFunc.filtraCliente();
        cadastroDeClienteFunc.assercaoClienteFiltrado(nome);
    }
}
