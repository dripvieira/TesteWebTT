package com.titansoftware.steps.vendasAssistidasSteps;

import com.titansoftware.funcs.faturamentoFuncs.EmitirVendaAssistidaFunc;
import com.titansoftware.funcs.faturamentoFuncs.ModuloFaturamentoAcessosFunc;
import com.titansoftware.funcs.vendasAssistidasFuncs.PedidoVendasFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PedidoVendasStep {
    public static String quantidadePedido;
    String numPedidoVenda;
    PedidoVendasFunc pedidoVendasFunc = new PedidoVendasFunc();
    EmitirVendaAssistidaFunc emitirVendaAssistidaFunc = new EmitirVendaAssistidaFunc();
    ModuloFaturamentoAcessosFunc moduloFaturamentoAcessosFunc = new ModuloFaturamentoAcessosFunc();

    @E("criar uma nova venda no vendas assistida")
    public void gerarVendaAssistidas(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> usuario = dataTable.asMaps();
        String destinatario = usuario.get(0).get("Destinatário");
        String produto = usuario.get(0).get("Produto");
        String quantidade = usuario.get(0).get("Quantidade");
        String frete = usuario.get(0).get("Frete");
        quantidadePedido = quantidade;
        pedidoVendasFunc.pedidoVendasAssistidas(destinatario, produto, quantidade, frete);
    }

    @E("enviar nota ao faturamento")
    public void enviarNotaFaturamento() throws InterruptedException {
        pedidoVendasFunc.enviarFaturamento();
    }

    @E("emitir nota de vendas assistidas no faturamento")
    public void emitirVenda() throws InterruptedException {
        moduloFaturamentoAcessosFunc.acessarModuloFaturamento();
        moduloFaturamentoAcessosFunc.acessarMenuFaturamento();
        moduloFaturamentoAcessosFunc.acessarSubMenuEmissaoDeFaturas();
        emitirVendaAssistidaFunc.emitirVenda();
    }

    @Então("deve visualizar a NF emitida no faturamento")
    public void AsserçaoNFFaturamento() {
        emitirVendaAssistidaFunc.NFFaturamento();
        String numPedido = PedidoVendasFunc.numeroOrcamento;
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numPedido);
        StringBuilder pedido = new StringBuilder();
        while (matcher.find()) {
            pedido.append(matcher.group());
            numPedidoVenda = String.valueOf(pedido);
        }
        Assert.assertEquals(numPedidoVenda, EmitirVendaAssistidaFunc.resgatarPedido);
        Assert.assertEquals("Emitida", EmitirVendaAssistidaFunc.regatarStatus);
        Assert.assertEquals(PedidoVendasFunc.valorVendasAssistidas, EmitirVendaAssistidaFunc.resgatarValor);
    }
}